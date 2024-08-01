package com.dependencyinjection;

public class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor-based Dependency Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String customerId) {
        return customerRepository.findCustomerById(customerId);
    }
}
