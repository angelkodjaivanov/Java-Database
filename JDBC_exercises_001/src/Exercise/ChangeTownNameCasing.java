package Exercise;

import java.sql.*;
import java.util.Scanner;

public class ChangeTownNameCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        String URL = "jdbc:mysql://localhost:3306/MinionsDB?createDatabaseIfNotExist=true";
        String USER = "root";
        String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE towns" +
                            "SET name = UPPER(name)" +
                            "WHERE country = ?;"
            );

            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();

            int rows = resultSet.getFetchSize();

            System.out.println(rows + " town names were affected.");

            System.out.println("[");
            int n = 0;
            while (resultSet.next()){
                n++;
                if(n == rows){
                    System.out.println(resultSet.getString("name"));
                }
                else {
                    System.out.println(resultSet.getString("name") + ", ");
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
