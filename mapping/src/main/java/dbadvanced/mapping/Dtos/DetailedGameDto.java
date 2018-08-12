package dbadvanced.mapping.Dtos;

import java.math.BigDecimal;
import java.util.Date;

public class DetailedGameDto {

    private String title;

    private BigDecimal price;

    private String description;

    private java.util.Date releaseDate;

    public DetailedGameDto() {
    }

    public DetailedGameDto(String title, BigDecimal price, String description, Date releaseDate) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
