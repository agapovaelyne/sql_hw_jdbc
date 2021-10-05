package com.example.jdbcHW.controller;

import com.example.jdbcHW.service.JdbcHwAppService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class JdbcHwAppController {

    JdbcHwAppService service;

    public JdbcHwAppController(JdbcHwAppService service) {
        this.service = service;
    }

    @GetMapping(value = "/products/fetch-product")
    public String getProductName(@RequestParam("name") String name) {
        return service.getProductName(name);
    }
}
