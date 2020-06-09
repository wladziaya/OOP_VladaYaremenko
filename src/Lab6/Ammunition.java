package Lab6;

public class Ammunition {
    private String name;
    private int price;

    private double weight;

    public Ammunition(String name, int price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +", " +
                "weight=" + weight;
    }

    public String getInformation() {
        return "Name:" +name+" Price:"+ price +" Weight:"+ weight;
    }
}
