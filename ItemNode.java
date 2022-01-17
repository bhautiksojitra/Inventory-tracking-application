public class ItemNode {

    private Item data;
    private ItemNode next_ptr;

    public ItemNode(Item data, ItemNode next_ptr) {
        this.data = data;
        this.next_ptr = next_ptr;
    }

    public Item get_data() {
        return data;
    }

    public ItemNode get_next() {
        return next_ptr;
    }

}
