package com.example.jdbcHW.service;

import com.example.jdbcHW.repository.JdbcHwAppRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdbcHwAppService {
    private JdbcHwAppRepository repository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public JdbcHwAppService(JdbcHwAppRepository repository) {
        this.repository = repository;
    }

    public String getProductName(String name) throws JsonProcessingException {
        List<String> products = repository.getProductName(name);
        String result = objectMapper.writeValueAsString(products);
        return result;
    }
}
