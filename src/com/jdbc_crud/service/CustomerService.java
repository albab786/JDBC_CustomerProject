package com.jdbc_crud.service;

import com.jdbc_crud.dao.CustomerDao;
import com.jdbc_crud.dto.Customer;
import com.jdbc_crud.exception.CustomException;

public class CustomerService {
CustomerDao dao=new CustomerDao();
    public Customer saveUserService(Customer customer){
        String password  = customer.getPassword();
        if(password.length()>=8 && password.length()<=15 && password.matches(
                "^(?=.*[a-zA-Z])(?=.*\\d).+$")){

            return dao.saveUserDao(customer);
            }
        else{
            System.out.println("pls enter alphanumeric character which should be in range of 8-15");

            return null;

        }

    }
}
