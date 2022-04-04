package org.example.menu;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String food_name;
    private int price;
    private int maketime;
    private String garson_name;

    public Menu() {
    }

    public Menu(String food_name, int price, int maketime, String garson_name) {
        this.food_name = food_name;
        this.price = price;
        this.maketime = maketime;
        this.garson_name = garson_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaketime() {
        return maketime;
    }

    public void setMaketime(int maketime) {
        this.maketime = maketime;
    }

    public String getGarson_name() {
        return garson_name;
    }

    public void setGarson_name(String garson_name) {
        this.garson_name = garson_name;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", food_name='" + food_name + '\'' +
                ", price=" + price +
                ", maketime=" + maketime +
                ", garson_name='" + garson_name + '\'' +
                '}';
    }
}
