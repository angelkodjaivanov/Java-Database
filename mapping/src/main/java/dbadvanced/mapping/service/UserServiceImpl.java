package dbadvanced.mapping.service;

import dbadvanced.mapping.Dtos.UserRegisterDto;
import dbadvanced.mapping.enums.Role;
import dbadvanced.mapping.model.User;
import dbadvanced.mapping.repository.UserRepository;
import jdk.nashorn.internal.objects.NativeRegExpExecResult;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void RegisterUser(String input) throws IOException {
        String[] prop = input.split("\\|");
        UserRegisterDto userRegisterDto = new UserRegisterDto(prop[1], prop[3], prop[4]);
        if(!userRegisterDto.getPassword().equals(prop[2])){
            System.out.println("Passwords don't match");
        }
        else {
            ModelMapper mapper = new ModelMapper();
            PropertyMap<UserRegisterDto, User> userMap = new PropertyMap<UserRegisterDto, User>() {
                @Override
                protected void configure() {
                    map().setEmail(source.getEmail());
                    map().setPassword(source.getPassword());
                    map().setFullName(source.getFullName());
                }
            };

            User user = new User();
            mapper.addMappings(userMap).map(userRegisterDto, user);

            this.userRepository.saveAndFlush(user);
            System.out.println(prop[4] + " was registered");
        }
    }

    public void RegisterPesho(){
        User user = new User("pesho@abv.bg", "Pesho1234", "Pesho", Role.ADMINISTRATOR);
        this.userRepository.save(user);
    }

    @Override
    public void LoginUser(String input) {
        String[] prop = input.split("\\|");
        List<User> users = this.userRepository.findAll();

        boolean hasUser = false;
        for (User user:users) {
            if(prop[1].equals(user.getEmail()) && prop[2].equals(user.getPassword())){
                user.setLoggedIn(true);
                System.out.println("Successfully logged in " + user.getFullName());
                hasUser = true;
            }
        }

        if(!hasUser){
            System.out.println("Incorrect username / password");
        }
    }

    @Override
    public void Logout() {
        List<User> users = this.userRepository.findAll();
        boolean isLoggedOut = false;
        for (User user:users) {
            if(user.isLoggedIn()){
                isLoggedOut = true;
                user.setLoggedIn(false);
                System.out.println("User " + user.getFullName() +" successfully logged out");
            }

        }

        if(!isLoggedOut){
            System.out.println("Cannot log out. No user was logged in.");
        }
    }
}
