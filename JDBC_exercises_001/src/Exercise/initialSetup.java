package Exercise;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class initialSetup {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/MinionsDB?createDatabaseIfNotExist=true";
        String USER = "root";
        String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String createTableTowns = "CREATE TABLE IF NOT EXISTS towns  (" +
                    " id INT(11) PRIMARY KEY, " +
                    "`name` VARCHAR(50)," +
                    " country VARCHAR(50) NOT NULL" +
                    ");";

            String createTableMinions = "CREATE TABLE IF NOT EXISTS minions  (" +
                    " id INT(11) PRIMARY KEY, " +
                    " `name` VARCHAR(30) NOT NULL, " +
                    " age INT NOT NULL, " +
                    " town_id INT(11), " +
                    " CONSTRAINT fk_minions_towns FOREIGN KEY(town_id) REFERENCES towns(id) " +
                    ");";

            String createTableVillains = "CREATE TABLE IF NOT EXISTS villains (" +
                    "id INT(11) PRIMARY KEY, " +
                    "`name` VARCHAR(30) NOT NULL, " +
                    "evilness_factor VARCHAR(10) NOT NULL" +
                    ");";

            String createTableMinions_Villains = "CREATE TABLE IF NOT EXISTS minions_villains(" +
                    "minion_id INT(11), " +
                    "villain_id INT(11), " +
                    "CONSTRAINT pk_minions_villains PRIMARY KEY(minion_id, villain_id), " +
                    "CONSTRAINT fk_minion_id_minions FOREIGN KEY(minion_id) REFERENCES minions(id), " +
                    "CONSTRAINT fk_villain_id_villains FOREIGN KEY(villain_id) REFERENCES villains(id)" +
                    ");";

            statement.executeUpdate(createTableTowns);
            statement.executeUpdate(createTableMinions);
            statement.executeUpdate(createTableVillains);
            statement.executeUpdate(createTableMinions_Villains);

            String insertsIntoTheTownsTable = "INSERT INTO towns(id, name, country)" +
                    "VALUES(1, 'Sofia', 'Bulgaria'), (2, 'London', 'England'), (3, 'Berlin', 'Germany'), " +
                    "(4, 'Madrid', 'Spain'), (5, 'Plovdiv', 'Bulgaria')";

            String insertsIntoTheMinionsTable = "INSERT INTO minions(id, name, age , town_id)" +
                    "VALUES(1, 'Bob', 16 ,2), (2, 'John', 21 , 3), (3, 'Pesho', 30, 5), (4, 'Angel', 16, 1), (5, 'Rachel', 5 , 4)";

            String insertsIntoTheVillainTable = "INSERT INTO villains(id, name, evilness_factor)" +
                    "VALUES(1, 'Valery', 'good'), (2, 'Lucifer', 'super evil'), (3, 'Maria', 'bad')," +
                    "(4, 'Lucy', 'evil'), (5, 'Denis', 'evil')";

            String insertsIntoTheMinions_VillainsTable = "INSERT INTO minions_villains(minion_id, villain_id)" +
                    "VALUES(1, 2), (2, 3), (3, 1), (5, 4), (4, 1)";

            statement.executeUpdate(insertsIntoTheTownsTable);
            statement.executeUpdate(insertsIntoTheMinionsTable);
            statement.executeUpdate(insertsIntoTheVillainTable);
            statement.executeUpdate(insertsIntoTheMinions_VillainsTable);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
