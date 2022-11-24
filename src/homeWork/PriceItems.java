package homeWork;


import java.util.Objects;

public class PriceItems {

    private int id;
    private double price;

    public PriceItems() {

    }

    public PriceItems(int id, double price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceItems{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceItems that = (PriceItems) o;
        return id == that.id && Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
