package dbadvanced.mapping.Dtos;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Date;

public class GameAddDto {
    private String title;

    private BigDecimal price;

    private Long size;

    private String trailer;

    private String imageThumbnail;

    @Column(columnDefinition = "TEXT")
    private String description;

    private java.util.Date date;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, Long size,
                      String trailer, String imageThumbnail, String description, java.util.Date date) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.description = description;
        this.date = date;
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

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }
}
