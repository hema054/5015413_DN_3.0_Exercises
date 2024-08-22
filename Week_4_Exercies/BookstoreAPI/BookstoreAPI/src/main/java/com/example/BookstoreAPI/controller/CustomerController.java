package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.entity.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();
    private int customerIdCounter = 1;

    // Constructor to add some initial data (optional)
    public CustomerController() {
        customers.add(new Customer(customerIdCounter++, "John Doe", "john.doe@example.com", "password123"));
    }

    // POST method to create a new customer with JSON request body
    @PostMapping("/json")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customer.setId(customerIdCounter++);
        customers.add(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "CustomerCreated");

        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }

    // POST method to create a new customer with form data
    @PostMapping("/form")
    public ResponseEntity<Customer> createCustomerFromForm(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {

        Customer customer = new Customer(customerIdCounter++, name, email, password);
        customers.add(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "CustomerCreatedFromForm");

        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }

    // GET method to retrieve all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "CustomersListFetched");

        return new ResponseEntity<>(customers, headers, HttpStatus.OK);
    }

    // GET method to retrieve a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .map(customer -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Custom-Header", "CustomerFound");
                    return new ResponseEntity<>(customer, headers, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}