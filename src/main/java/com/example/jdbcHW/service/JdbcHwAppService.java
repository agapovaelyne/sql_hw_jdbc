package com.example.jdbcHW.service;

import com.example.jdbcHW.repository.JdbcHwAppRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdbcHwAppService {
    JdbcHwAppRepository repository;

    public JdbcHwAppService(JdbcHwAppRepository repository) {
        this.repository = repository;
    }

    public String getProductName(String name) {
        List<String> products = repository.getProductName(name);
        StringBuilder response = new StringBuilder();
        for (String product : products) {
            response.append(String.format("{\"product_name\" : \"%s\"},", product));
        }
        String productNames = response.toString();
        return productNames.substring(0, productNames.length() - 1);
    }
}
