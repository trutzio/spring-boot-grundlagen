package com.example.demo.todo;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    Long id;

    @JsonProperty
    String title;

    @JsonProperty
    String description;

}
