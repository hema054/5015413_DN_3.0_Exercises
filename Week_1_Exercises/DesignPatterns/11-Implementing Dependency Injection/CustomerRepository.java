package com.dependencyinjection;

public interface CustomerRepository {
    Customer findCustomerById(String customerId);
}
