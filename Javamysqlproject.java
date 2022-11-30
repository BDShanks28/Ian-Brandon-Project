/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javamysqlproject;

import java.sql.*;
import java.util.*;


/**
 *
 * @author Ian Duncan
 * @coauthor Brandon Shankle
 */



public class Javamysqlproject 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws SQLException
    {
        Connection dbconn=null;
        Statement st= null;
        ResultSet rs = null;
        final  String username ="root";
        final String  password="BrownWarrior-17";
        String url="jdbc:mysql://127.0.0.1:3306/movie_rental";
        
        Scanner input = new Scanner(System.in);
        int menu; 
        
            
        dbconn = DriverManager.getConnection(url, username, password);

        System.out.println("Database connection was successful!");
        System.out.println(" ");
        System.out.println("Movie Rental Management System");
        System.out.println("------------------------------");
        System.out.println("1) Customers");
        System.out.println("2) Payment");
        System.out.println("3) Rent");
        System.out.println("4) Movies");
        System.out.println("5) Stores");
        System.out.println("6) Inventory");
        System.out.println("7) Exit");
        System.out.println("Type a number to choose an option ");
        
        menu = input.nextInt();
        
        while (menu != 7)
        {            
        //    if (menu == 7){
        //        System.out.println(" ");
        //        System.out.println("Exiting the database...");
        //        break;
        //    }

            if (menu < 1 || menu > 7)
            {
                System.out.println("Invalid input.");
                System.out.println(" ");
                System.out.println("Movie Rental Management System");
                System.out.println("------------------------------");
                System.out.println("1) Customers");
                System.out.println("2) Payment");
                System.out.println("3) Rent");
                System.out.println("4) Movies");
                System.out.println("5) Stores");
                System.out.println("6) Inventory");
                System.out.println("7) Exit");
                System.out.println("Type a number to choose an option ");

                menu = input.nextInt();
            }

            else if (menu == 1)
            {
                System.out.println("Select an option: ");
                System.out.println(" ");
                System.out.println("1) Add customer");
                System.out.println("2) Remove customer");
                System.out.println("3) Display Customers");
                System.out.println("4) Exit");
                
                int customer_menu = input.nextInt();
                while(true){
                
                    if (customer_menu == 1)
                    {
                        int id;
                        String fname, minit, lname, address;
                    
                        System.out.println("Enter customer 's ID: ");
                        id = input.nextInt();
                        System.out.print("Enter customer's first name: ");
                        fname = input.next();
                        System.out.print("Enter customer's middle initial: ");
                        minit = input.next();
                        System.out.print("Enter customer's last name: ");
                        lname = input.next();
                        System.out.print("Enter customer's address: ");
                        address = input.next();
                    
                        try
                            {
                                String insertc = "insert into customers(customer_ID, fname, minit, lname, address) values ('"+id+"','"+fname+"','"+minit+"','"+lname+"','"+address+"')"; 
                                PreparedStatement insertst = dbconn.prepareStatement(insertc);
                                insertst.executeUpdate();
                            }
                        catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        System.out.println("Customer has been added.");
                        break;
                    }
                
                    if (customer_menu == 2)
                    {
                        int id;
                    
                        System.out.println("Enter the customer's ID that is being deleted: ");
                        id = input.nextInt();
                    
                    
                        try
                            {
                                String deletec= "delete from customers where customer_ID = '"+id+"'"; 
                                PreparedStatement deletest = dbconn.prepareStatement(deletec);
                                deletest.executeUpdate();
                            }
                        catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        System.out.println("Customer has been deleted.");
                        break;
                    }
                
                    else if (customer_menu == 3)
                    {
                        try
                        {
                            st = dbconn.createStatement();

                            rs = st.executeQuery("select * from customers");

                            while (rs.next()) {
                                System.out.println(rs.getString("customer_ID") + " " + rs.getString("fname")+  " "+rs.getString("minit")+ " "+rs.getString("lname")+ " "+rs.getString("address"));
                
                                }

                        }
                        
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }

                    else
                    {
                        break;
                    }
                }
            }
        }
    }        
}

    
        
    
   
    
    
