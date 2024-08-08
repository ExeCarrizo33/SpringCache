package com.springboot.backend.usersapp.springcache.controller;

import com.springboot.backend.usersapp.springcache.models.Customer;
import com.springboot.backend.usersapp.springcache.models.dto.CustomerDTO;
import com.springboot.backend.usersapp.springcache.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Object> findAll(){
        return ResponseEntity.ok(this.customerService.findAll());
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody CustomerDTO request){
        this.customerService.save(request);
        return ResponseEntity.ok().build();
    }
}
