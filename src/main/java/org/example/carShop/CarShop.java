package org.example.carShop;

import javax.persistence.*;

@Entity
@Table(name = "carShop")
public class CarShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int totalMarks;
    private int price;
    private String shopmanName;
    private String markName;

    public CarShop() {
    }

    public CarShop(int totalMarks, int price, String shopmanName, String markName) {
        this.totalMarks = totalMarks;
        this.price = price;
        this.shopmanName = shopmanName;
        this.markName = markName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getShopmanName() {
        return shopmanName;
    }

    public void setShopmanName(String shopmanName) {
        this.shopmanName = shopmanName;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    @Override
    public String toString() {
        return "CarShop{" +
                "id=" + id +
                ", totalMarks=" + totalMarks +
                ", price=" + price +
                ", shopmanName='" + shopmanName + '\'' +
                ", markName='" + markName + '\'' +
                '}';
    }
}
