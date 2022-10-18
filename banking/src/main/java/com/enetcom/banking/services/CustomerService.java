package com.enetcom.banking.services;

import com.enetcom.banking.dtos.CustomerDTO;
import com.enetcom.banking.mappers.CustomerMapper;
import com.enetcom.banking.models.Customer;
import com.enetcom.banking.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class CustomerService {


    private CustomerRepository customerRepository ;
    private CustomerMapper customerMapper;




    public void saveCustomer(CustomerDTO customerDTO){

        Customer customer = new Customer();
        customer = customerMapper.fromCustomerDTO(customerDTO);
        customerRepository.save(customer);

    }
    public CustomerDTO getCustomer(Long id)  {
        return customerMapper.fromCustomer( customerRepository.findById(id).orElse(null));


    }

    public List<CustomerDTO> listCustomers() {


        List<Customer> customers= customerRepository.findAll();
        List<CustomerDTO> customersDTO = customers.stream().map(customer -> customerMapper.fromCustomer(customer)).collect(Collectors.toList());
        return customersDTO ;

    }

}
