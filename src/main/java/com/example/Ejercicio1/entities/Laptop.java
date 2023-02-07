package com.example.Ejercicio1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private Double pulgadas;
    private Double precio;
    private String OS;


    public Laptop() {
    }

    public Laptop(Long id, String marca, String modelo, Double pulgadas, Double precio, String OS) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.pulgadas = pulgadas;
        this.precio = precio;
        this.OS = OS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(Double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }
}

