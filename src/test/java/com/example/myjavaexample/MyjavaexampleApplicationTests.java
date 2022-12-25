package com.example.myjavaexample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.myjavaexample.controllers.MessageController;

@SpringBootTest
class MyjavaexampleApplicationTests {

	@Autowired
	private MessageController messageController;

	@Test
	void contextLoads() {
		assertThat(messageController).isNotNull();
	}

}
