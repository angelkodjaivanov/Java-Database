package dbadvanced.mapping;

import dbadvanced.mapping.service.GameService;
import dbadvanced.mapping.service.UserService;
import dbadvanced.mapping.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class MappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	}
}


@Component
class ConsoleRunner implements CommandLineRunner{

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

	@Override
	public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] prop = input.split("\\|");

        switch (prop[0]){
            case "RegisterUser": this.userService.RegisterUser(input);break;
            case "LoginUser":this.userService.LoginUser(input); break;
            case "Logout": this.userService.Logout();break;
            case "AddGame": this.gameService.addGame(input); break;
            case "EditGame": this.gameService.editGame(input); break;
            case "DeleteGame": this.gameService.deleteGame(Integer.parseInt(prop[1])); break;
            case "AllGame": this.gameService.allGames();break;
        }
	}
}