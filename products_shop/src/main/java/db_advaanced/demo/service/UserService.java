package db_advaanced.demo.service;

import db_advaanced.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserService {
    void save(User user);
}
