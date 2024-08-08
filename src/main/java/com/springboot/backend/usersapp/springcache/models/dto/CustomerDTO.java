package com.springboot.backend.usersapp.springcache.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "customer_name")
    private String name;

}
