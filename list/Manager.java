package list;

public class Manager {

    private ItemList main_list;

    public Manager() {
        main_list = new ItemList();
    }

    public void create(String item_name, double price, double count) {
        main_list.sorted_add(new Item(item_name, price, count));
    }

    public void remove(String to_delete) {
        main_list.remove(to_delete);
    }

    public void edit_inventory(String item_name, double new_count) {
        Item to_edit = main_list.search(item_name);

        if (to_edit != null) {
            to_edit.set_Inventory(new_count);
        }
    }

    public void edit_name(String item_name, String new_name) {
        Item to_edit = main_list.search(item_name);

        if (to_edit != null) {
            to_edit.set_name(new_name);
        }
    }

    public void edit_price(String item_name, double new_price) {
        Item to_edit = main_list.search(item_name);
        if (to_edit != null) {
            to_edit.set_price(new_price);
        }
    }

    public void print_list() {
        main_list.print_list();
    }
}