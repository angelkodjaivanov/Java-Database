package db_advaanced.demo.service;

import db_advaanced.demo.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ProductService {
    void save(Product product);
}
