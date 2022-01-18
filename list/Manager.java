package list;

public class Manager {

    private ItemList main_list;

    public Manager() {
        main_list = new ItemList();
    }

    public void create(String item_name, double price, int count) {
        main_list.sorted_add(new Item(item_name, price, count));
    }

    public void remove(String to_delete) {
        main_list.remove(to_delete);
    }

    public void edit_inventory(String item_name, int new_count) {
        Item to_edit = main_list.search(item_name);

        if (to_edit != null) {
            to_edit.set_Inventory(new_count);
        }
    }

    public void rename(String item_name, String new_name) {
        Item to_edit = main_list.search(item_name);

        if (to_edit != null) {
            to_edit.set_name(new_name);
        }
    }

    public void price_change(String item_name, double new_price) {
        Item to_edit = main_list.search(item_name);
        if (to_edit != null) {
            to_edit.set_price(new_price);
        }
    }

    public void filterByPrefix(String tag) {
        main_list.filterByPrefix(tag);

    }

    public void filterByPrice(String more_less, double price) {
        main_list.filterByPrice(more_less, price);
    }

    public void filterByStock(String more_less, int count) {
        main_list.filterByStock(more_less, count);
    }

    public void print_list() {
        main_list.print_list();
    }

}