package Exercise;

import java.sql.*;
import java.util.Scanner;

public class GetVillainsNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String URL = "jdbc:mysql://localhost:3306/MinionsDB?createDatabaseIfNotExist=true";
        String USER = "root";
        String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT v.name, count(m.id) FROM villains AS v LEFT JOIN minions_villains AS mv" +
                            " ON v.id = mv.villain_id LEFT JOIN minions AS m ON m.id = mv.minion_id GROUP BY v.id" +
                            " HAVING count(m.id) >= ? ORDER BY count(m.id) DESC;");

            preparedStatement.setDouble(1, n);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.printf("%s %d \n",
                        resultSet.getString("name"),
                        resultSet.getInt("count(m.id)"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
