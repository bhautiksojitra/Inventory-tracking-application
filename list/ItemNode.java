package list;

public class ItemNode {

    private Item data;
    private ItemNode next_ptr;

    public ItemNode(Item data, ItemNode next_ptr) {
        this.data = data;
        this.next_ptr = next_ptr;
    }

    protected Item getData() {
        return this.data;
    }

    protected ItemNode getNext() {
        return this.next_ptr;
    }

    protected void setNext(ItemNode new_next_ptr) {
        next_ptr = new_next_ptr;
    }

}