package com.example.jdbcHW.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String surname;
    private int age;
    private String phone_number;


}
