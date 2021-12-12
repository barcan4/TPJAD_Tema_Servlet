package domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Instrument {
    private int id = 0;
    public static final AtomicInteger count = new AtomicInteger(0);
    private String name;
    private String type;
    private double price;


    public Instrument(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.id = count.incrementAndGet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "domain.Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
