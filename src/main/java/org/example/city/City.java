package org.example.city;

import javax.persistence.*;

@Entity
@Table(name = "cityies")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String City;
    private String mayor;
    private String dominantNation;
    private int area;

    public City() {
    }

    public City(String city, String mayor, String dominantNation, int area) {
        City = city;
        this.mayor = mayor;
        this.dominantNation = dominantNation;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getMayor() {
        return mayor;
    }

    public void setMayor(String mayor) {
        this.mayor = mayor;
    }

    public String getDominantNation() {
        return dominantNation;
    }

    public void setDominantNation(String dominantNation) {
        this.dominantNation = dominantNation;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", City='" + City + '\'' +
                ", mayor='" + mayor + '\'' +
                ", dominantNation='" + dominantNation + '\'' +
                ", area=" + area +
                '}';
    }
}