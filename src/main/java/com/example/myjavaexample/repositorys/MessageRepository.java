package com.example.myjavaexample.repositorys;

import org.springframework.data.repository.CrudRepository;
import com.example.myjavaexample.models.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    
}