package db_advaanced.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import db_advaanced.demo.dtos.UserDto;
import db_advaanced.demo.model.Product;
import db_advaanced.demo.model.User;
import db_advaanced.demo.repository.UserRepository;
import db_advaanced.demo.service.ProductService;
import db_advaanced.demo.service.UserService;
import db_advaanced.demo.service.UserServiceImpl;
import org.hibernate.annotations.Cache;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@Component
class ConsoleRunner implements CommandLineRunner{

    @Autowired
	private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserRepository userRepository;

	private static final String USER_JSON_ADDRESS = "/users.json";
	private static final String PRODUCT_JSON_ADDRESS = "/products.json";

	Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation()
			.setPrettyPrinting()
			.create();

	@Override
	public void run(String... args) throws Exception {
		InputStream userStream = this.loadData(USER_JSON_ADDRESS);
		InputStream productStream = this.loadData(PRODUCT_JSON_ADDRESS);


		String loaded = readAllData(userStream);
        UserDto[] userDtos = this.gson.fromJson(loaded, UserDto[].class);

        for (UserDto userDto:userDtos) {

            PropertyMap<UserDto, User> userPropertyMap = new PropertyMap<UserDto, User>() {
                @Override
                protected void configure() {
                    map().setFirstName(source.getFirstName());
                    map().setLastName(source.getLastName());
                    map().setAge(source.getAge());
                }
            };

            ModelMapper modelMapper = new ModelMapper();
            User user = new User();
            modelMapper.addMappings(userPropertyMap).map(userDto, user);
            this.userService.save(user);
        }


        String loadedProducts = readAllData(productStream);
        Product[] products = this.gson.fromJson(loadedProducts, Product[].class);

        for (Product product: products) {

            List<User> allUsers = this.userRepository.findAll();

            Random random = new Random();
            Integer randomIndexB = random.nextInt(allUsers.size());
            Integer randomIndexS = random.nextInt(allUsers.size());

            product.setBuyer(allUsers.get(randomIndexB));
            product.setSeller(allUsers.get(randomIndexS));

            this.productService.save(product);
        }

    }


	private InputStream loadData(String fileLocation){
		return ConsoleRunner.class.getResourceAsStream(fileLocation);
	}

	private String readAllData(InputStream stream){
		try{
			return StreamUtils.copyToString(stream, Charset.defaultCharset());
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
