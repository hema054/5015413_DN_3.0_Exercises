package com.dependencyinjection;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String customerId) {
        // For demonstration, returning a dummy customer
        // In a real application, this would query a database
        if ("123".equals(customerId)) {
            return new Customer("123", "John Doe", "john.doe@example.com");
        } else {
            return null;
        }
    }
}
