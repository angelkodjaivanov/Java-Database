package dbadvanced.mapping.service;

import dbadvanced.mapping.Dtos.GameAddDto;
import dbadvanced.mapping.Dtos.ViewGameDto;
import dbadvanced.mapping.model.Game;
import dbadvanced.mapping.model.User;
import dbadvanced.mapping.repository.GameRepository;
import dbadvanced.mapping.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    private UserRepository userRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addGame(String input) throws ParseException {
        String[] prop = input.split("\\|");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = simpleDateFormat.parse(prop[7]);
        GameAddDto gameAddDto = new GameAddDto(prop[1], BigDecimal.valueOf(Double.parseDouble(prop[2])),
                Long.parseLong(prop[3]), prop[4], prop[5], prop[6], date);

        ModelMapper mapper = new ModelMapper();
        PropertyMap<GameAddDto, Game> gameAddMap = new PropertyMap<GameAddDto, Game>() {
            @Override
            protected void configure() {
                map().setTitle(source.getTitle());
                map().setPrice(source.getPrice());
                map().setSize(source.getSize());
                map().setDescription(source.getDescription());
                map().setDate(source.getDate());
                map().setImageThumbnail(source.getImageThumbnail());
                map().setTrailer(source.getTrailer());
            }
        };

        Game game = new Game();
        mapper.addMappings(gameAddMap).map(gameAddDto, game);

        List<User> users = this.userRepository.findAll();
        Random random = new Random();
        int buyer_id = random.nextInt(users.size());

        game.setBuyer(users.get(buyer_id));

        this.gameRepository.save(game);
    }

    @Override
    public void editGame(String input) {
        String[] props = input.split("\\|");
        Game game = this.gameRepository.getOne(Integer.parseInt(props[1]));

        for(int i = 2; i < props.length; i++){
            String[] newProps = props[i].split("=");
            String field = newProps[0];
            String value = newProps[1];

            switch (field){
                case "title":
                    game.setTitle(value);
                    break;
                case "price":
                    game.setPrice(BigDecimal.valueOf(Double.parseDouble(value)));
                    break;
                case "size":
                    game.setSize(Long.parseLong(value));
                    break;
                case "trailer":
                    game.setTrailer(value);
                    break;
                case "thubnailURLcase":
                    game.setImageThumbnail(value);
                    break;
                case "description":
                    game.setDescription(value);
                    break;
            }

        }
    }

    @Override
    public void deleteGame(Integer id) {
        this.gameRepository.deleteById(id);
    }

    @Override
    public void allGames() {
        ModelMapper mapper = new ModelMapper();
        List<Game> games = this.gameRepository.findAll();

        for (Game game:games) {
            ViewGameDto viewGameDto = mapper.map(game, ViewGameDto.class);
            System.out.println(viewGameDto.getTitle() + " " + viewGameDto.getPrice());
        }
    }

    @Override
    public void detailGame(String title) {

    }

    @Override
    public void ownedGame() {

    }
}
