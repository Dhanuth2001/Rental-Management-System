package edu.icet.crm.service;

import edu.icet.crm.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);

    Customer getCustomerById(Long id);

    void deleteCustomer(Long id);

    void updateCustomer(Customer customer);
}
