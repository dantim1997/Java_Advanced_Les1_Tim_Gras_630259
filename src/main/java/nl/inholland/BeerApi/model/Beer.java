package nl.inholland.BeerApi.model;

import javax.persistence.*;

@Entity
@Table
public class Beer {

    @Id
    @SequenceGenerator(name = "beer_seq", initialValue =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beer_seq")
    private long id;
    private String brand;
    private String type;
    private double price;
    private String location;

    public Beer(){
    }

    public Beer(String brand, String type, double price, String location ) {
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Beer{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", price=").append(price);
        sb.append(", location='").append(location).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
