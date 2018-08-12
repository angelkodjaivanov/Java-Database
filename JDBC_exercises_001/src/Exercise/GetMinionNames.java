package Exercise;

import com.sun.org.apache.regexp.internal.RE;

import java.sql.*;
import java.util.Scanner;

public class GetMinionNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int villain_id = Integer.parseInt(scanner.nextLine());

        String URL = "jdbc:mysql://localhost:3306/MinionsDB?createDatabaseIfNotExist=true";
        String USER = "root";
        String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
            preparedStatement.setInt(1, villain_id);

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT m.name FROM villains AS v" +
                    " INNER JOIN minions_villains AS mv ON v.id = mv.villain_id INNER JOIN minions AS m" +
                    " ON m.id = mv.minion_id WHERE v.id = ?;");
            preparedStatement2.setInt(1, villain_id);


            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet resultSet2 = preparedStatement2.executeQuery();

            while (resultSet.next()){
                System.out.printf("Villain: %s \n",
                        resultSet.getString("name"));
            }

            int n = 1;
            while (resultSet2.next()){
                System.out.printf("%d. %s \n",
                        n,
                        resultSet2.getString("name"));
                n++;
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }
}
