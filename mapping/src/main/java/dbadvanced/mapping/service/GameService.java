package dbadvanced.mapping.service;

import java.text.ParseException;

public interface GameService {
    void addGame(String input) throws ParseException;

    void editGame(String input);

    void deleteGame(Integer id);

    void allGames();

    void detailGame(String title);

    void ownedGame();
}
