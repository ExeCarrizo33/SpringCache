package com.springboot.backend.usersapp.springcache.service;

import com.springboot.backend.usersapp.springcache.models.Customer;
import com.springboot.backend.usersapp.springcache.models.dto.CustomerDTO;
import com.springboot.backend.usersapp.springcache.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Cacheable("customers")
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();

        customers.forEach(customer -> {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setName(customer.getName());
            customerDTOList.add(customerDTO);
        });

        return customerDTOList;
    }

    @Caching(evict = {@CacheEvict(value = "customers", allEntries = true)})
    public void save(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customerRepository.save(customer);
    }

}
