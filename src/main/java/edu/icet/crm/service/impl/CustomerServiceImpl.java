package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.model.Customer;
import edu.icet.crm.repository.CustomerRepository;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;

    final ObjectMapper mapper;
    public List<Customer> getAllCustomers() {
        Iterable<CustomerEntity> all = customerRepository.findAll();
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        all.forEach(customerEntity -> {
            Customer customer = convertToModel(customerEntity);
            customerArrayList.add(customer);
        });
        return customerArrayList;
    }

    @Override
    public void addCustomer(Customer customer) {
        if (!customer.equals(null)){
            CustomerEntity customerEntity = convertToEntity(customer);
            customerRepository.save(customerEntity);
        }
    }


    private CustomerEntity convertToEntity(Customer customer) {
        return mapper.convertValue(customer, CustomerEntity.class);
    }

    private Customer convertToModel(CustomerEntity customerEntity) {
        return mapper.convertValue(customerEntity, Customer.class);
    }
}
