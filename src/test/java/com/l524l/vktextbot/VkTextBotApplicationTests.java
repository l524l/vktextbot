package com.l524l.vktextbot;

import com.l524l.vktextbot.commands.CommandParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VkTextBotApplicationTests {

	@Test
	void contextLoads() {
	}
   	@Test
	void test () {
		CommandParser parser = new CommandParser();
		parser.parse(null, null);
	}
}
