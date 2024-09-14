package com.jdbc_crud.dao;

import com.jdbc_crud.connection.CustomerConnection;
import com.jdbc_crud.dto.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {
    Connection connection = CustomerConnection.getUserConnection();
    public final String INSERTUSERQUERY = "insert into customer(id,name,email,password,phone_no) values(?,?,?,?,?)";
    public final String SELECTUSERBYID = "select * from customer where id=?";
    public final String DELETEUSERBYIDQUERY="delete from customer where id=?";
    public final String UPDATEBYUSERID="update customer set name =? where id=?";

    public Customer saveUserDao(Customer customer) {

        try {
            PreparedStatement ps = connection.prepareStatement(INSERTUSERQUERY);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPassword());
            ps.setObject(5, customer.getPhone_no());

            ps.execute();

            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Customer getUsertoAutenticate(int userId) {
        try {
            PreparedStatement ps = connection.prepareStatement(SELECTUSERBYID);
            ps.setInt(1, userId);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                return new Customer(set.getInt("Id"), set.getString("name"),
                        set.getString("email"), set.getString("password"), set.getString("phone_no"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    public boolean deleteUserById(int userId){
        try{
            PreparedStatement ps = connection.prepareStatement(DELETEUSERBYIDQUERY);
            ps.setInt(1,userId);
            int a=ps.executeUpdate();
            if(a!=0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateById(int userId,String name){
        try{
            PreparedStatement ps = connection.prepareStatement(UPDATEBYUSERID);
            ps.setString(1,name);
            ps.setInt(2,userId);
            int a=ps.executeUpdate();
            if(a!=0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
