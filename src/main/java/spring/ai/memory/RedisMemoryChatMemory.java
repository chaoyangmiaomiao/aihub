package spring.ai.memory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RedisMemoryChatMemory implements ChatMemory {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void add(String conversationId, List<Message> messages) {
        String redisKey = conversationId;
        long timestamp = System.currentTimeMillis();

        for (Message message : messages) {
            redisTemplate.opsForHash().put(redisKey, String.valueOf(timestamp) + "|" + message.getMessageType(), message.getText());
        }
    }

    @Override
    public List<Message> get(String conversationId, int lastN) {
        String redisKey = conversationId;
        Map<Object, Object> allMessages = redisTemplate.opsForHash().entries(redisKey);
        if (allMessages == null || allMessages.isEmpty()) {
            return List.of();
        }
        List<Map.Entry<Object, Object>> sortedMessages = allMessages.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    long timestamp1 = Long.parseLong(entry1.getKey().toString().split("\\|")[0]);
                    long timestamp2 = Long.parseLong(entry2.getKey().toString().split("\\|")[0]);
                    return Long.compare(timestamp1, timestamp2);
                })
                .collect(Collectors.toList());
        List<Map.Entry<Object, Object>> lastMessages = sortedMessages.stream()
                .limit(lastN)
                .collect(Collectors.toList());
        return lastMessages.stream()
                .map(entry -> {
                    switch (entry.getKey().toString().split("\\|")[1]) {
                        case "USER":
                            return new UserMessage(entry.getValue().toString());
                        case "ASSISTANT":
                            return new AssistantMessage(entry.getValue().toString());
                        case "SYSTEM":
                            return new SystemMessage(entry.getValue().toString());
                        default:
                            return null;
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public void clear(String conversationId) {
        String redisKey = conversationId;
        redisTemplate.delete(redisKey);
    }
}
