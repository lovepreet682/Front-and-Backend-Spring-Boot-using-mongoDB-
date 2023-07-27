package com.crud.mongodb.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "restapi")
@Data
public class Student {
    private String id;
    private String name;
    private String email;
    private String age;
    private String city;
}
