package com.d288.cduque10.BootStrap;

import com.d288.cduque10.dao.*;
import com.d288.cduque10.entities.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class BootStrapData {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @PostConstruct
    public void loadSampleData() {

        if (customerRepository.count() == 1) {

            List<Customer> customers = Arrays.asList(
                    createCustomer("Alice", "Billings", "12345", "123 Main St", "(123)123-1234", 26),
                    createCustomer("Chris", "Dill", "67891", "456 Ave", "(456)456-5678", 27),
                    createCustomer("Eric", "Fleming", "23456", "789 Blvd", "(789)789-9012", 28),
                    createCustomer("Greg", "Hood", "78912", "012 East St", "(012)012-3456", 29),
                    createCustomer("Ian", "Jones", "34567", "345 Highway", "(345)345-7890", 30)
            );

            customerRepository.saveAll(customers);
        }
    }

    private Customer createCustomer(String firstName, String lastName, String postalCode, String address, String phone, int division) {

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPostal_code(postalCode);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setDivision(divisionRepository.findAll().get(division));
        customer.setCreate_date(new Date());
        customer.setLast_update(new Date());
        return customer;
    }
}
