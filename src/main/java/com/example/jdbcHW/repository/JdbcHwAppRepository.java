package com.example.jdbcHW.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class JdbcHwAppRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String REQUEST_SCRIPT_FILENAME = "get_product_name.sql";


    public List<String> getProductName(String name) {
        SqlRowSet productsRowSet2 = namedParameterJdbcTemplate.queryForRowSet(read(REQUEST_SCRIPT_FILENAME), Map.of("name", name));
        List<String> result = new ArrayList<>();
        while (productsRowSet2.next()) {
            result.add(productsRowSet2.getString("product_name"));
        }
        System.out.println();
        return result;
    }


    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
