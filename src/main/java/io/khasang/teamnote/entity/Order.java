package io.khasang.teamnote.entity;

import javax.persistence.*;
import java.sql.Date;

//import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "person")
    private String person;

    @Column(name = "product")
    private String product;

    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "price")
    private double price;

    @Column(name = "date")
    private Date orderDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;

    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    //    private Date c01_order_date;
//    private String c02_order_person;
//    private String c03_product;
//    private String c04_seller;
//    private String c05_order_number;
//    private Double c06_order_price;
//    private Date c07_delivery_date;
//    private Double c08_delivery_price;
//    private String c09_courier;
//    private String c10_delivery_method;
//    private String c11_notes;

//    public Date getC01_order_date() {
//        return c01_order_date;
//    }
//
//    public void setC01_order_date(Date c01_order_date) {
//        this.c01_order_date = c01_order_date;
//    }
//
//    public String getC02_order_person() {
//        return c02_order_person;
//    }
//
//    public void setC02_order_person(String c02_order_person) {
//        this.c02_order_person = c02_order_person;
//    }
//
//    public String getC03_product() {
//        return c03_product;
//    }
//
//    public void setC03_product(String c03_product) {
//        this.c03_product = c03_product;
//    }
//
//    public String getC04_seller() {
//        return c04_seller;
//    }
//
//    public void setC04_seller(String c04_seller) {
//        this.c04_seller = c04_seller;
//    }
//
//    public String getC05_order_number() {
//        return c05_order_number;
//    }
//
//    public void setC05_order_number(String c05_order_number) {
//        this.c05_order_number = c05_order_number;
//    }
//
//    public Double getC06_order_price() {
//        return c06_order_price;
//    }
//
//    public void setC06_order_price(Double c06_order_price) {
//        this.c06_order_price = c06_order_price;
//    }
//
//    public Date getC07_delivery_date() {
//        return c07_delivery_date;
//    }
//
//    public void setC07_delivery_date(Date c07_delivery_date) {
//        this.c07_delivery_date = c07_delivery_date;
//    }
//
//    public Double getC08_delivery_price() {
//        return c08_delivery_price;
//    }
//
//    public void setC08_delivery_price(Double c08_delivery_price) {
//        this.c08_delivery_price = c08_delivery_price;
//    }
//
//    public String getC09_courier() {
//        return c09_courier;
//    }
//
//    public void setC09_courier(String c09_courier) {
//        this.c09_courier = c09_courier;
//    }
//
//    public String getC10_delivery_method() {
//        return c10_delivery_method;
//    }
//
//    public void setC10_delivery_method(String c10_delivery_method) {
//        this.c10_delivery_method = c10_delivery_method;
//    }
//
//    public String getC11_notes() {
//        return c11_notes;
//    }
//
//    public void setC11_notes(String c11_notes) {
//        this.c11_notes = c11_notes;
//    }
}
