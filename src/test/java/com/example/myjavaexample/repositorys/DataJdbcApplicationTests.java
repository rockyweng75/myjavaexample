package com.example.myjavaexample.repositorys;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.myjavaexample.models.Message;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataJdbcApplicationTests {
    @Autowired
    MessageRepository messageRepository;

    @Test
    public void messageRepository() {
        Message message = messageRepository.save(
            new Message(
                "caterpillar",
                1518666769369L, 
                "JavaScript 名稱空間管理 https://openhome.cc/Gossip/ECMAScript/NameSpace.html"
            )
        );

        assertNotNull(message.getId());
    }
}