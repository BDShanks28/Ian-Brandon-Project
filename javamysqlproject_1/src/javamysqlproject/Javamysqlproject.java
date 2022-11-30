/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javamysqlproject;

import java.sql.*;
import java.util.*;
import java.util.Date;


/**
 *
 * @author Ian Duncan
 */



public class Javamysqlproject {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws SQLException
    {
    Connection dbconn=null;
    Statement st= null;
    ResultSet rs = null;
    final  String username ="root";
    final String  password="mingBANDIT02!";
    String url="jdbc:mysql://127.0.0.1:3306/movie_rental";
    
    Scanner input = new Scanner(System.in);
    int menu; 
    
        
    dbconn = DriverManager.getConnection(url, username, password);

    System.out.println("Database connection was successful!");
    System.out.println(" ");
    System.out.println("Movie Rental Management System");
    System.out.println("------------------------------");
    System.out.println("1) Customers");
    System.out.println("2) Rent");
    System.out.println("3) Payment");
    System.out.println("4) Movies");
    System.out.println("5) Stores");
    System.out.println("6) Inventory");
    System.out.println("7) Exit");
    System.out.println("Type a number to choose an option ");
    
    menu = input.nextInt();
    
    while (true)
        
        if (menu == 7){
            System.out.println(" ");
            System.out.println("Exiting the database...");
            break;
        }
        
        else if (menu == 1){
            
            
            System.out.println("Select an option: ");
            System.out.println(" ");
            System.out.println("1) Add customer");
            System.out.println("2) Remove customer");
            System.out.println("3) Display Customers");
            System.out.println("4) Exit");
            
            Scanner inputMenu = new Scanner(System.in);
            Scanner input3 = new Scanner(System.in);
            int customer_menu;
            
           do{
           
            customer_menu = inputMenu.nextInt();
               
               
            if (customer_menu == 1){
                int id;
                String fname, minit, lname, address;
                
                System.out.println("Enter customer 's ID: ");
                id = input3.nextInt();
                System.out.print("Enter customer's first name: ");
                fname = input3.next();
                System.out.print("Enter customer's middle initial: ");
                minit = input3.next();
                System.out.print("Enter customer's last name: ");
                lname = input3.next();
                System.out.print("Enter customer's address: ");
                address = input3.next();
                
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
            
            else if (customer_menu == 2){
                int id;
                
                System.out.println("Enter the customer's ID that is being deleted: ");
                id = input3.nextInt();
                
                
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
            
            else if (customer_menu == 3){
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
            else if (customer_menu == 4){
                break;
            }
            }while(true);
           System.out.println(" ");
           break;

        }
        
        else if (menu == 2){
            System.out.println("Select an option: ");
            System.out.println(" ");
            System.out.println("1) Add rent");
            System.out.println("2) Remove rent");
            System.out.println("3) Display rents");
            System.out.println("4) Exit");
            
            int rent_menu = input.nextInt();
           
            
            if (rent_menu == 1){
                java.util.Date dt = new java.util.Date();

                java.text.SimpleDateFormat sdf = 
                    new java.text.SimpleDateFormat("yyyy-MM-dd");

                String sTime, eTime = sdf.format(dt);
                    
                int id;
                double overdue; 
                
                
                
                System.out.println("Enter rent ID: ");
                id = input.nextInt();
                System.out.print("Enter the rent's start date: ");
                sTime = input.next();
                System.out.print("Enter the rent's end date: ");
                eTime = input.next();
                System.out.print("Enter the amount overdue: ");
                overdue = input.nextDouble();
                
                try
                    {
                        String insertr = "insert into rent(rent_ID, start_Date, end_Date, overdue) values ('"+id+"','"+sTime+"','"+eTime+"','"+overdue+"')"; 
                        PreparedStatement insertst = dbconn.prepareStatement(insertr);
                        insertst.executeUpdate();
                    }
                 catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                System.out.println("Customer has been added.");
                break;
                }
            
            if (rent_menu == 2){
                int id;
                
                System.out.println("Enter the rent's ID that is being deleted: ");
                id = input.nextInt();
                
                
                try
                    {
                       String deleter= "delete from rent where rent_ID = '"+id+"'"; 
                       PreparedStatement deletest = dbconn.prepareStatement(deleter);
                       deletest.executeUpdate();
                    }
                 catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                System.out.println("Rent has been deleted.");
                break;
                }
            
            else if (rent_menu == 3){
                try
                    {
                        st = dbconn.createStatement();

                        rs = st.executeQuery("select * from rent");

                        while (rs.next()) {
                            System.out.println(rs.getString("rent_ID") + " " + rs.getString("start_Date")+  " "+rs.getString("end_Date")+ " "+rs.getString("overdue"));
        
                            }

                    }
                 catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            else if (rent_menu == 4){
                break;
            }
        }
        
        else if (menu == 3){
            System.out.println("Select an option: ");
            System.out.println(" ");
            System.out.println("1) Add payment");
            System.out.println("2) Remove payment");
            System.out.println("3) Display payments");
            System.out.println("4) Exit");
            
            int pay_menu = input.nextInt();
           
            
            if (pay_menu == 1){
                java.util.Date dt = new java.util.Date();

                java.text.SimpleDateFormat sdf = 
                    new java.text.SimpleDateFormat("yyyy-MM-dd");

                String sTime, eTime = sdf.format(dt);
                    
                int id;
                double paid; 
                String payType;
                
                
                System.out.println("Enter payment ID: ");
                id = input.nextInt();
                System.out.print("Enter the rent's start date: ");
                sTime = input.next();
                System.out.print("Enter the rent's end date: ");
                eTime = input.next();
                System.out.print("Enter the pay type: ");
                payType = input.next();
                System.out.print("Enter the amount paid: ");
                paid = input.nextDouble();
                
                try
                    {
                        String insertp = "insert into payment(payment_ID, start_Date, end_Date, payment_Method, paid) values ('"+id+"','"+sTime+"','"+eTime+"','"+payType+"','"+paid+"')"; 
                        PreparedStatement insertst = dbconn.prepareStatement(insertp);
                        insertst.executeUpdate();
                    }
                 catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                System.out.println("Customer has been added.");
                break;
                }
            
            if (pay_menu == 2){
                int id;
                
                System.out.println("Enter the payment's ID that is being deleted: ");
                id = input.nextInt();
                
                
                try
                    {
                       String deletep= "delete from rent where payment_ID = '"+id+"'"; 
                       PreparedStatement deletest = dbconn.prepareStatement(deletep);
                       deletest.executeUpdate();
                    }
                 catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                System.out.println("Rent has been deleted.");
                break;
                }
            
            else if (pay_menu == 3){
                try
                    {
                        st = dbconn.createStatement();

                        rs = st.executeQuery("select * from payment");

                        while (rs.next()) {
                            System.out.println(rs.getString("payment_ID") + " " + rs.getString("start_Date")+  " "+rs.getString("end_Date")+ " "+rs.getString("paid")+ " "+rs.getString("paid"));
        
                            }

                    }
                 catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            else if (pay_menu == 4){
                break;
            }
        }
        
        
        else if (menu == 4){
            System.out.println("Select an option: ");
            System.out.println(" ");
            System.out.println("1) Add movie");
            System.out.println("2) Remove movie");
            System.out.println("3) Display movies");
            System.out.println("4) Exit");
            
            int movie_menu = input.nextInt();
           
            
            if (movie_menu == 1){
                int id, release;
                Scanner inputID = new Scanner(System.in);
                Scanner input3 = new Scanner(System.in);
                Scanner input4 = new Scanner(System.in);
                Scanner input5 = new Scanner(System.in);
                Scanner input6 = new Scanner(System.in);
                String runtime, genre, rating, director, name;
                
                System.out.print("Enter movie name: ");
                name = input.next();
                System.out.println("Enter movie ID: ");
                id = inputID.nextInt();
                System.out.print("Enter movie runtime: ");
                runtime = input3.next();
                System.out.print("Enter movie genre: ");
                genre = input4.next();
                System.out.print("Enter movie rating: ");
                rating = inputID.next();
                System.out.print("Enter movie director: ");
                director = input5.next();
                System.out.print("Enter movie release date: ");
                release = input6.nextInt();
                
                try
                    {
                        String insertm = "insert into movie(movie_ID, movie_Name, movie_runtime, movie_Genre, movie_Rating, movie_Director, movie_releaseDate) values ('"+id+"','"+name+"','"+runtime+"','"+genre+"','"+rating+"','"+director+"','"+release+"')"; 
                        PreparedStatement insertst = dbconn.prepareStatement(insertm);
                        insertst.executeUpdate();
                    }
                 catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                System.out.println("Movie has been added.");
                break;
                }
            
            if (movie_menu == 2){
                int id;
                
                System.out.println("Enter the movie's ID that is being deleted: ");
                id = input.nextInt();
                
                
                try
                    {
                       String deletem= "delete from movie where movie_ID = '"+id+"'"; 
                       PreparedStatement deletest = dbconn.prepareStatement(deletem);
                       deletest.executeUpdate();
                    }
                 catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                System.out.println("Movie has been deleted.");
                break;
                }
            
            else if (movie_menu == 3){
                try
                    {
                        st = dbconn.createStatement();

                        rs = st.executeQuery("select * from movie");

                        while (rs.next()) {
                            System.out.println(rs.getString("movie_name") + " " + rs.getString("movie_Rating")+  " "+rs.getString("movie_Genre")+ " "+rs.getString("movie_Director")+ " "+rs.getString("movie_releaseDate")+ " "+rs.getString("movie_runtime")+ " "+rs.getString("movie_ID"));
        
                            }

                    }
                 catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            
            else if (movie_menu == 4){
                break;
            }
          
        }
        else if (menu == 5){
            try
                    {
                        st = dbconn.createStatement();

                        rs = st.executeQuery("select * from store");

                        while (rs.next()) {
                            System.out.println(rs.getString("store_ID") + " " + rs.getString("store_Location"));
        
                            }

                    }
                 catch (Exception e)
                    {
                        e.printStackTrace();
                    }
        }
        
        else if (menu == 6){
            try
                    {
                        st = dbconn.createStatement();

                        rs = st.executeQuery("select * from inventory");

                        while (rs.next()) {
                            System.out.println(rs.getString("num_of_movies") + " " + rs.getString("m_ID") + " " + rs.getString("inventoyr_locations"));
        
                            }

                    }
                 catch (Exception e)
                    {
                        e.printStackTrace();
                    }
        }

        
        else if (menu < 1 || menu > 7)
        {
            System.out.println("Invalid input.");
            System.out.println(" ");
            System.out.println("Movie Rental Management System");
            System.out.println("------------------------------");
            System.out.println("1) Customers");
            System.out.println("2) Rent");
            System.out.println("3) Payment");
            System.out.println("4) Movies");
            System.out.println("5) Stores");
            System.out.println("6) Inventory");
            System.out.println("7) Exit");
            System.out.println("Type a number to choose an option ");

            menu = input.nextInt();
        }
            }
    }

    
        
    
   
    
    
