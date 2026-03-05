package com.varshneypushkar01.chatbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.InputStream;
import java.util.Map;

@Service
public class ChatService {

    private Map<String,String> data;

    @PostConstruct
    public void loadData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("data.json");
        data = mapper.readValue(is, Map.class);
    }

    public String getResponse(String message){
        message = message.toLowerCase();
        if(message.contains("hello") || message.contains("hi")){
            return "Hello! I am your College AI Assistant. How can I help you?";
        }
        if(message.contains("help")){
            return "You can ask about: fees, courses, placement, hostel.";
        }
        for(String key : data.keySet()){
            if(message.contains(key)){
                return data.get(key);
            }
        }
        return "Sorry, I couldn't find that information. Try asking about fees, courses, placement or hostel.";
    }
}