package org.softuni.mostwanted.domain.dtos;

import com.google.gson.annotations.Expose;

public class ImportTownDto {

    @Expose
    private String name;

    public ImportTownDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
