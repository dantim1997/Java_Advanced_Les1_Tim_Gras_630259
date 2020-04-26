package nl.inholland.BeerApi.model;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
    @SequenceGenerator(name = "stock_seq", initialValue =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
    private long id;
    private int quantity;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Beer beer;

    public Stock(){
    }

    public Stock(Beer beer, int quantity){
        this.beer = beer;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    @Override
    public String toString() {
        return  "Stock{" +
                "id="+id+
                ", quantity="+quantity+
                ", beer="+beer+
                "}";
    }
}
