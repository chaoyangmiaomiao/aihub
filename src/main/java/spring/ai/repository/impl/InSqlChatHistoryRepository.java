package spring.ai.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.ai.entity.po.Aisession;
import spring.ai.mapper.AisessionMapper;
import spring.ai.repository.ChatHistoryRepository;

import java.util.List;

@Component
public class InSqlChatHistoryRepository implements ChatHistoryRepository {
    @Autowired
    private AisessionMapper aiMapper;

    @Override
    public void save(String type, String chatId) {
        aiMapper.addChatHistory(new Aisession(type, chatId));
    }

    @Override
    public List<String> getChatIds(String type) {
        return aiMapper.selectChatIds(type);
    }
}
