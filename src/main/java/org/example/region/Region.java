package org.example.region;

import javax.persistence.*;

@Entity
@Table(name = "regoins")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String region_name;
    private int region_population;
    private String mayor_name;
    private String country;

    public Region() {
    }

    public Region(String region_name, int region_population, String mayor_name, String country) {
        this.region_name = region_name;
        this.region_population = region_population;
        this.mayor_name = mayor_name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public int getRegion_population() {
        return region_population;
    }

    public void setRegion_population(int region_population) {
        this.region_population = region_population;
    }

    public String getMayor_name() {
        return mayor_name;
    }

    public void setMayor_name(String mayor_name) {
        this.mayor_name = mayor_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", region_name='" + region_name + '\'' +
                ", region_population=" + region_population +
                ", mayor_name='" + mayor_name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
