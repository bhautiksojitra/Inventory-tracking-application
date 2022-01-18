package list;

public class Item {
    private String item_name;
    private double inventory_count;
    private double value;

    public Item(String item_name, double value, double inventory_count) {
        this.item_name = item_name;
        this.value = value;
        this.inventory_count = inventory_count;

    }

    protected String get_name() {
        return item_name;
    }

    protected double get_Value() {
        return value;
    }

    protected double get_Inventory() {
        return inventory_count;
    }

    protected void set_Inventory(double count) {
        inventory_count = count;
    }

    protected void set_price(double price) {
        value = price;
    }

    protected void set_name(String name) {
        item_name = name;
    }

}