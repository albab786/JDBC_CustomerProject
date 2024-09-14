package com.jdbc_crud.controller;

import com.jdbc_crud.dao.CustomerDao;
import com.jdbc_crud.dto.Customer;
import com.jdbc_crud.service.CustomerService;

import java.util.Scanner;

public class CustomerController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerDao dao = new CustomerDao();
        CustomerService service = new CustomerService();
        while (true) {
            System.out.println("1.REGISTER\n2.LOGIN\n3EXIT_THE_APP");
            System.out.println("enter your option");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: {
                    System.out.println("enter user id");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("enter user name");
                    String name = scanner.nextLine();
                    System.out.println("enter user email");
                    String email = scanner.nextLine();
                    System.out.println("enter user password");
                    String password = scanner.nextLine();
                    System.out.println("enter user phone_no");
                    String phone_no = scanner.next();

                    Customer customer = new Customer(id, name, email, password, phone_no);
                    Customer saveCustomer = service.saveUserService(customer);
                    if (saveCustomer != null) {
                        System.out.println("user data inserted");
                    } else {
                        System.out.println("user data not inserted ....something went wrong");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Now you have entered into login console base page");
                    System.out.println("enter user id");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("enter password");
                    String password = scanner.nextLine();

                    Customer userToAuthenticate = dao.getUsertoAutenticate(id);
                    if (userToAuthenticate != null && password.equals(userToAuthenticate.getPassword())) {
                        System.out.println("1.DELETE\n2.UPDATE\n3.DISPLAYBYNAME\n4.DISPLAYALL\n5.LOGOUT");
                        System.out.println("enter your option");

                        int option2 = scanner.nextInt();
                        while (true) {
                            switch (option2) {
                                case 1: {
                                    System.out.println("enter id to delete");
                                    int idOfCustomer = scanner.nextInt();
                                    boolean b = dao.deleteUserById(idOfCustomer);
                                    if (b) {
                                        System.out.println("data deleted successfully");
                                    } else {
                                        System.out.println("data not found");
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.println("enter id to delete");
                                    int idOfCustomer = scanner.nextInt();
                                    System.out.println("Enter new name: ");
                                    String updatedName=scanner.nextLine();
                                    boolean b = dao.deleteUserById(idOfCustomer);
                                    if (b) {
                                        System.out.println("data deleted successfully");
                                    } else {
                                        System.out.println("data not found");
                                    }
                                    break;
                                }
                                case 3: {

                                    break;
                                }
                                case 4: {

                                    break;
                                }
                                case 5: {
                                    System.out.println("Now you are logining out from the app");
                                    return;
                                }

                                default:
                                    System.out.println("you have entered wrong option");
                            }
                        }
                    } else {
                        System.out.println("Invalid credentials");
                    }
                    break;

                }
                case 3:{
                    return;
                }
                default:
                    System.out.println("Invalid option. Please choose 1 or 2.");
            }
        }
    }
}
