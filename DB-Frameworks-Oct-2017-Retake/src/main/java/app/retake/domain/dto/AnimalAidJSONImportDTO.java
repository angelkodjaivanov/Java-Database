package app.retake.domain.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class AnimalAidJSONImportDTO implements Serializable {

    @Expose
    @Size(min = 3)
    private String name;

    @Expose
    @Min(value = 0)
    private Double price;

    public AnimalAidJSONImportDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
