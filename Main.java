import list.Manager;

public class Main {

    public static void main(String[] args) {
        Manager me = new Manager();

        me.create("Oats", 3, 10);
        me.create("Soup", 4, 1);
        me.create("Milk", 1, 100);

        me.print_list();
        me.create("Juice", 6, 40);
        me.create("Cereal", 2, 13);

        me.print_list();

        me.edit_inventory("Oats", 100);
        me.edit_price("Milk", 2);
        me.remove("Juice");
        me.remove("HBC");

        me.print_list();

    }

}
