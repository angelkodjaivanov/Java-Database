package db_advaanced.demo.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User buyer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User seller;

    @ManyToMany(mappedBy = "products", targetEntity = Category.class)
    private Set<Category> categories;

    public Product() {
    }

    public Product(String name, BigDecimal price, User buyer, User seller) {
        this.name = name;
        this.price = price;
        this.buyer = buyer;
        this.seller = seller;
        this.categories = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
