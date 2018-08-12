package com.company;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    String URL = "jdbc:mysql://localhost:3306/soft_uni?createDatabaseIfNotExist=true";
	    String USER = "root";
	    String PASSWORD = "";

	    Connection connection = null;

	    try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            if(connection != null){
                System.out.println("Connection is opened!");
            }
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  employees WHERE salary > ?");
            double salary = Double.parseDouble(scanner.nextLine());
            preparedStatement.setDouble(1, salary);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                System.out.printf("%s %s %f \n",
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDouble("salary"));
            }

            if(preparedStatement != null) {
                preparedStatement.close();
                preparedStatement = null;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if(connection != null){
                try {
                    connection.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
                connection = null;
                System.out.println("The connection is closed!");
            }
        }


    }
}
