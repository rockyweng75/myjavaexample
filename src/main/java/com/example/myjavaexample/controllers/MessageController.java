package com.example.myjavaexample.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.myjavaexample.models.Message;
import com.example.myjavaexample.repositorys.MessageRepository;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("messages")
    public List<Message> messages() {

        List<Message> result = new ArrayList<Message>();
        for (Message message : messageRepository.findAll()) {
            result.add(message);
        }

        return result;
    }

    @GetMapping("message/{id}")
    public ResponseEntity<?> getMessage(@PathVariable Integer id) {
        Optional<Message> member = messageRepository.findById(id);
        return member.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}