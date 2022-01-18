package list;

public class ItemList {

    private ItemNode top;
    private int list_size;

    public ItemList() {
        top = null;
        list_size = 0;
    }

    protected boolean sorted_add(Item to_add) {

        ItemNode newNode = new ItemNode(to_add, null);

        if (top == null) {
            newNode.setNext(top);
            top = newNode;

        } else {

            ItemNode current = top;
            ItemNode previous = null;

            while (current.getData().get_name().compareTo(to_add.get_name()) < 0 && current.getNext() != null) {
                previous = current;
                current = current.getNext();

            }

            if (current.getData().get_name().compareTo(to_add.get_name()) == 0) {

                System.out.println("Failure : Duplicate Item Found !");
                return false;
            }

            if (current.getData().get_name().compareTo(to_add.get_name()) > 0) {
                newNode.setNext(current);

                if (previous != null) {
                    previous.setNext(newNode);
                } else {
                    top = newNode;
                }

            }

            else if (current.getNext() == null) {
                newNode.setNext(null);
                current.setNext(newNode);

            }

        }

        list_size++;
        return true;

    }

    protected boolean remove(String to_remove) {
        if (top != null) {
            ItemNode prev = null;
            ItemNode curr = top;

            while (curr != null && curr.getData().get_name().compareTo(to_remove) != 0) {
                prev = curr;
                curr = curr.getNext();
            }

            if (prev == null) {

                System.out.println("Success : Item  " + to_remove + " has been removed !");
                top = top.getNext();
                list_size--;

                return true;
            }

            else if (curr == null) {
                System.out.println("Failure : Deletion Failed , Item " + to_remove + " not in the List !");

            } else if (curr.getData().get_name().compareTo(to_remove) == 0) {
                System.out.println("Success : Item  " + to_remove + " has been removed !");
                prev.setNext(curr.getNext());
                list_size--;
                return true;
            } else {
                System.out.println("Failure ! Check the code again , forgot to add edge cases");
            }

            return false;

        } else {
            System.out.println("Failure : Deletion Failed , List is Empty !");
            return false;
        }
    }

    protected Item search(String to_find) {
        ItemNode curr = top;

        while (curr != null && curr.getData().get_name().compareTo(to_find) != 0) {
            curr = curr.getNext();
        }

        if (curr == null) {
            System.out.println("Failure : Item  " + to_find + " not found !");
            return null;
        }

        return curr.getData();
    }

    protected int get_size() {
        return list_size;
    }

    protected void print_list() {

        System.out.println("Printing the list of all the items... ");
        ItemNode curr = top;

        if (curr != null) {
            while (curr != null) {
                System.out.println("Item name : " + curr.getData().get_name() +
                        " | Price :  $" + curr.getData().get_Value() +
                        " | Inventory Count : " + curr.getData().get_Inventory());

                curr = curr.getNext();
            }
        } else {
            System.out.println("No Item Found in the List !");
        }
    }

    protected void filterByPrefix(String tag) {

        System.out.println("Filtering the list by Name Tag : " + tag);

        ItemNode curr = top;

        if (curr != null) {

            while (curr != null) {
                boolean condition = curr.getData().get_name().startsWith(tag);
                if (condition) {
                    System.out.println("Item name : " + curr.getData().get_name() +
                            " | Price :  $" + curr.getData().get_Value() +
                            " | Inventory Count : " + curr.getData().get_Inventory());
                }

                curr = curr.getNext();

            }
        }

        System.out.println("End of Printing...");

    }

    protected void filterByPrice(String more_less, double price) {

        System.out.println("Filtering the list by Price : " + more_less + " " + price);

        ItemNode curr = top;

        if (curr != null) {

            while (curr != null) {

                boolean condition = false;
                if (more_less.equals("MORE_THAN"))
                    condition = curr.getData().get_Value() > price;
                else if (more_less.equals("LESS_THAN"))
                    condition = curr.getData().get_Value() < price;
                else if (more_less.equals("EXACT"))
                    condition = curr.getData().get_Value() == price;
                else {
                    System.out.println("FILTER_BY_PRICE command has some errors !");
                    return;
                }

                if (condition) {

                    System.out.println("Item name : " + curr.getData().get_name() +
                            " | Price :  $" + curr.getData().get_Value() +
                            " | Inventory Count : " + curr.getData().get_Inventory());
                }

                curr = curr.getNext();

            }
        }

        System.out.println("End of Printing...");

    }

    protected void filterByStock(String more_less, int count) {

        System.out.println("Filtering the list by Inventory : " + more_less + " " + count);

        ItemNode curr = top;

        if (curr != null) {

            while (curr != null) {

                boolean condition = false;
                if (more_less.equals("MORE_THAN"))
                    condition = curr.getData().get_Inventory() > count;
                else if (more_less.equals("LESS_THAN"))
                    condition = curr.getData().get_Inventory() < count;
                else if (more_less.equals("EXACT"))
                    condition = curr.getData().get_Inventory() == count;
                else {
                    System.out.println("FILTER_BY_STOCK command has some errors !");
                    return;
                }

                if (condition) {

                    System.out.println("Item name : " + curr.getData().get_name() +
                            " | Price :  $" + curr.getData().get_Value() +
                            " | Inventory Count : " + curr.getData().get_Inventory());
                }

                curr = curr.getNext();

            }
        }

        System.out.println("End of Printing...");

    }

}
