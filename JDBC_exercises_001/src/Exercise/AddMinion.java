package Exercise;

import java.sql.*;
import java.util.Scanner;

public class AddMinion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Taking the input

        String[] minionArgs = scanner.nextLine().split("\\s+");
        Minion minion = new Minion(minionArgs[1], Integer.parseInt(minionArgs[2]), minionArgs[3]);

        String villainName = scanner.nextLine().split("\\s+")[1];

        // Declaring the connection properties
        String URL = "jdbc:mysql://localhost:3306/MinionsDB?createDatabaseIfNotExist=true";
        String USER = "root";
        String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Adding a town of it doesn't exist
            PreparedStatement getTown = connection.prepareStatement(
                    "SELECT name FROM towns WHERE name = ?;"
            );

            getTown.setString(1, minion.getTownName());

            ResultSet hasATown = getTown.executeQuery();

            boolean hasTown = false;
            while (hasATown.next()){
                hasTown = true;
            }

            PreparedStatement addTownIfNotExists = connection.prepareStatement(
                    "INSERT INTO towns(id, name, country )" +
                            "VALUES((SELECT (count(t.id) + 1) FROM towns AS t)," +
                            "?, 'Bulgaria');"
            );

            if(!hasTown){
                addTownIfNotExists.setString(1, minion.getTownName());
                addTownIfNotExists.executeUpdate();
                System.out.println("Town " + minion.getTownName() + " was added to the database.");
            }

            // Adding a villain if it doesn't exist

            PreparedStatement getVillain = connection.prepareStatement(
                    "SELECT name FROM villains WHERE name = ?;"
            );

            getVillain.setString(1, villainName);
            boolean hasVillain = false;

            ResultSet hasAVillain = getVillain.executeQuery();

            while(hasAVillain.next()){
                hasVillain = true;
            }

            PreparedStatement addVillain = connection.prepareStatement(
                    "INSERT INTO villains(id, name, evilness_factor)" +
                            "VALUES ((SELECT (count(v.id) + 1) FROM villains AS v), ?, 'evil');"
            );

            if(!hasVillain){
                addVillain.setString(1, villainName);
                addVillain.executeUpdate();
                System.out.println("Villain " + villainName + " was added to the database.");
            }

            //Adding minion in the database
            PreparedStatement addMinion = connection.prepareStatement(
                    "INSERT INTO minions(id, name, age, town_id )" +
                            "VALUES ((SELECT (count(m.id) + 1) FROM minions AS m), ?, ?, " +
                            "(SELECT t.id FROM towns AS t WHERE t.name = ?));"
            );

            addMinion.setString(1, minion.getName());
            addMinion.setInt(2, minion.getAge());
            addMinion.setString(3, minion.getTownName());

            addMinion.executeUpdate();

            PreparedStatement addRelation = connection.prepareStatement(
                    "INSERT INTO minions_villains(minion_id, villain_id)" +
                            "VALUES ((SELECT m.id FROM minions AS m WHERE m.name = ? AND m.age = ?)," +
                            "(SELECT v.id FROM villains AS v WHERE v.name = ?))"
            );

            addRelation.setString(1, minion.getName());
            addRelation.setInt(2, minion.getAge());
            addRelation.setString(3, villainName);

            addRelation.executeUpdate();

            System.out.println("Successfully added " + minion.getName() + " to be minion of " + villainName);

        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
