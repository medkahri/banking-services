package com.enetcom.banking.mappers;

import com.enetcom.banking.dtos.CustomerDTO;
import com.enetcom.banking.models.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public CustomerDTO fromCustomer (Customer customer){

        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        return customerDTO ;

    }
    public Customer fromCustomerDTO(CustomerDTO customerDTO){

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return customer;


    }




}
