package dbadvanced.mapping.Dtos;

import java.math.BigDecimal;

public class ViewGameDto {

    private String title;

    private BigDecimal price;

    public ViewGameDto() {
    }

    public ViewGameDto(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
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
}
