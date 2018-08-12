package org.softuni.mostwanted.domain.dtos;

import ch.qos.logback.core.joran.action.IncludeAction;
import com.google.gson.JsonSerializationContext;
import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ExportRacersDto {

    @Expose
    private String name;

    @Expose
    private Integer age;

    @Expose
    private List<String> cars;

    public ExportRacersDto() {
    }

    public ExportRacersDto(String name, Integer age, List<String> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public Integer carsCount(){
        return this.cars.size();
    }
}
