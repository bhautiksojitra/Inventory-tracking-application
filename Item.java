
public class Item {
    private String item_name;
    private int value;

    public Item(String item_name, int value) {
        this.item_name = item_name;
        this.value = value;
    }

    public String get_name() {
        return item_name;
    }

    public int get_Value() {
        return value;
    }
}