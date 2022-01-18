package list;

public class ItemList {

    private ItemNode top;
    private int list_size;

    public ItemList() {
        top = null;
        list_size = 0;
    }

    protected boolean sorted_add(Item to_add) {

        // creates a new node with the data that we want to insert in the table.
        ItemNode newNode = new ItemNode(to_add, null);

        // if the table is empty already, the node will be added at the front
        if (top == null) {
            newNode.next_ptr = top;
            top = newNode;

        } else {
            /*
             * if the list is not empty then
             * traverse through the all the elements and gets its right place
             * in table with the help of two node "Previous" and "Current".
             */
            ItemNode current = top;
            ItemNode previous = null;

            // Loop runs until value is greater than the item or table has no more value to
            // scan.
            while (current.data.get_name().compareTo(to_add.get_name()) < 0 && current.next_ptr != null) {
                previous = current;
                current = current.next_ptr;

            }

            if (current.data.get_name().compareTo(to_add.get_name()) == 0) {

                System.out.println("Failure : Duplicate Item Found !");
                return false;
            }
            /*
             * Here are Three cases of a item to insert in the list
             * 
             * 1. item can be inserted in between.
             * 2. item can be inserted in the beginning.
             * 3. item can be inserted at the end.
             * 
             */

            // if loop stops before the list ends. then 1 and 2 cases can happen.
            if (current.data.get_name().compareTo(to_add.get_name()) > 0) {
                newNode.next_ptr = current;

                // if previous isn't null then 1 else 2.
                if (previous != null) {
                    previous.next_ptr = newNode;
                } else {
                    top = newNode;
                }

            }
            // the loop goes till the end then will insert the item at the end.
            else if (current.next_ptr == null) {
                newNode.next_ptr = null;
                current.next_ptr = newNode;

            }

        }

        list_size++;
        return true;

    }

    protected boolean remove(String to_remove) {
        if (top != null) {
            ItemNode prev = null;
            ItemNode curr = top;

            while (curr != null && curr.data.get_name().compareTo(to_remove) != 0) {
                prev = curr;
                curr = curr.next_ptr;
            }

            if (prev == null) {

                System.out.println("Success : Item  " + to_remove + " has been removed !");
                top = top.next_ptr;
                list_size--;

                return true;
            }

            else if (curr == null) {
                System.out.println("Failure : Deletion Failed , Item not found !");

            } else if (curr.data.get_name().compareTo(to_remove) == 0) {
                System.out.println("Success : Item  " + to_remove + " has been removed !");
                prev.next_ptr = curr.next_ptr;
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

        while (curr != null && curr.data.get_name().compareTo(to_find) != 0) {
            curr = curr.next_ptr;
        }

        if (curr == null) {
            System.out.println("Failure : Item  " + to_find + "not found !");
            return null;
        }

        return curr.data;
    }

    protected int get_size() {
        return list_size;
    }

    protected void print_list() {
        ItemNode curr = top;

        if (curr != null) {
            while (curr != null) {
                System.out.println("Item name : " + curr.data.get_name() +
                        " Item price : " + curr.data.get_Value() +
                        " Item_count : " + curr.data.get_Inventory());

                curr = curr.next_ptr;
            }
        } else {
            System.out.println("No Item Found in the List !");
        }
    }

    private class ItemNode {

        private Item data;
        private ItemNode next_ptr;

        public ItemNode(Item data, ItemNode next_ptr) {
            this.data = data;
            this.next_ptr = next_ptr;
        }

    }

}
