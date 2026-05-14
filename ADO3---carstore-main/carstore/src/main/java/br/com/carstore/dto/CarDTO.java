package br.com.carstore.dto;

import jakarta.validation.constraints.NotBlank;

public class CarDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    private String name;

    @NotBlank(message = "A cor é obrigatória.")
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}