package spring.ai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.ai.entity.po.Aisession;
import spring.ai.mapper.AisessionMapper;

import java.util.List;

@SpringBootTest
class SpringAiApplicationTests {
	@Autowired
	private AisessionMapper aiMapper;
	@Test
	void contextLoads() {
	}

	@Test
	public void testAdd(){
		aiMapper.addChatHistory(new Aisession("nihao","asda"));
		List<String> nihao = aiMapper.selectChatIds("nihao");
		nihao.forEach(System.out::println);
	}
}
