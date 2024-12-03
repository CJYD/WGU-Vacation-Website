package com.d288.backendprogramming.BootStrap;

import com.d288.backendprogramming.dao.*;
import com.d288.backendprogramming.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    //    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
//        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = new Customer();
        customer1.setFirstName("Shelby");
        customer1.setLastName("Smith");
        customer1.setAddress("123 Main St");
        customer1.setPhone("123-123-1111");
        customer1.setPostal_code("11111");


        Customer customer2 = new Customer();
        customer2.setFirstName("Jess");
        customer2.setLastName("London");
        customer2.setAddress("456 Elm St");
        customer2.setPhone("222-222-2222");
        customer2.setPostal_code("22222");

        Customer customer3 = new Customer();
        customer3.setFirstName("Cayden");
        customer3.setLastName("Detroit");
        customer3.setAddress("537 Ave");
        customer3.setPhone("333-333-3333");
        customer3.setPostal_code("33333");

        Customer customer4 = new Customer();
        customer4.setFirstName("Sammy");
        customer4.setLastName("West");
        customer4.setAddress("987 Blvd AVe");
        customer4.setPhone("444-444-4444");
        customer4.setPostal_code("88888");

        Customer customer5 = new Customer();
        customer5.setFirstName("Christian");
        customer5.setLastName("Billings");
        customer5.setAddress("658384724 Ave");
        customer5.setPhone("777-777-7777");
        customer5.setPostal_code("99999");

        boolean initRun = true;
        List<Customer> customerList = (List<Customer>) customerRepository.findAll();

        for(Customer customer:customerList){
            if (!customerRepository.existsByFirstNameAndLastName(customer.getFirstName(), customer.getLastName())) {
                customerRepository.save(customer);
            }
        }

        if (initRun == true) {
            this.customerRepository.save(customer1);
            this.customerRepository.save(customer2);
            this.customerRepository.save(customer3);
            this.customerRepository.save(customer4);
            this.customerRepository.save(customer5);
        }
    }
}
