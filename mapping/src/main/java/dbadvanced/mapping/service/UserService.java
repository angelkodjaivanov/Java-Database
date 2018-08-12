package dbadvanced.mapping.service;

import java.io.IOException;

public interface UserService {
    void RegisterUser(String input) throws IOException;

    void RegisterPesho();

    void LoginUser(String input);

    void Logout();
}
