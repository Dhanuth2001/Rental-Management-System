package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.model.Customer;
import edu.icet.crm.repository.CustomerRepository;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Customer getCustomerById(Long id) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);
        if (optionalCustomerEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with ID " + id + " not found");
        }
        return convertToModel(optionalCustomerEntity.get());
    }

    @Override
    public void deleteCustomer(Long id) {
        if(customerRepository.existsById(id)){

            customerRepository.deleteById(id);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        if(customerRepository.existsById(customer.getCustomerID())){
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
