package objectTdd.legacyRefactoring.legacy;

public class Order {

    private String id;
    private double total;

    public Order(String id, double total) {
        this.id = id;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

}