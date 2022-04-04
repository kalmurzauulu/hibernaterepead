package org.example.order;



import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customer_name;
    private int price;
    private String order_size;
    private String date_of_receiving;

    public Order() {
    }

    public Order(String customer_name, int price, String order_size, String date_of_receiving) {
        this.customer_name = customer_name;
        this.price = price;
        this.order_size = order_size;
        this.date_of_receiving = date_of_receiving;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrder_size() {
        return order_size;
    }

    public void setOrder_size(String order_size) {
        this.order_size = order_size;
    }

    public String getDate_of_receiving() {
        return date_of_receiving;
    }

    public void setDate_of_receiving(String date_of_receiving) {
        this.date_of_receiving = date_of_receiving;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer_name='" + customer_name + '\'' +
                ", price=" + price +
                ", order_size='" + order_size + '\'' +
                ", date_of_receiving=" + date_of_receiving +
                '}';
    }
}
