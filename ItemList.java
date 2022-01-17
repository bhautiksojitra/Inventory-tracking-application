public class ItemList {

    private ItemNode top;
    private int list_size;

    public ItemList() {
        top = null;
        list_size = 0;
    }

    public boolean sorted_add(Item to_add) {

        ItemNode n_node = new ItemNode(to_add, null);

        if (top != null) {

            ItemNode prev = null;
            ItemNode curr = top;

            while (curr != null && curr.data.get_name().compareTo(to_add.get_name()) < 0) {
                prev = curr;
                curr = curr.next_ptr;
            }

            if (prev == null) {
                n_node.next_ptr = top;
                top = top.next_ptr;

            } else if (curr == null) {
                prev.next_ptr = n_node;

            } else if (curr.data.get_name().compareTo(to_add.get_name()) == 0) {
                System.out.println("Failure : Insertion Failed , Duplicate Item found !");
                return false;
            } else if (curr.data.get_name().compareTo(to_add.get_name()) > 0) {
                prev.next_ptr = n_node;
                n_node.next_ptr = curr;
            } else {
                System.out.println("Failure ! Check the code again , forgot to add edge cases");
                return false;
            }

        } else {
            top = n_node;
        }

        list_size++;
        System.out.println("Success : Item  " + to_add.get_name() + " has been inserted !");

        return true;
    }

    public boolean remove(String to_remove) {
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

    public int get_size() {
        return list_size;
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
