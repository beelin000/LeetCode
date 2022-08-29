/**
 * @author LC
 */
public class DLinkNode {
    int key;
    int value;
    DLinkNode prev;
    DLinkNode next;

    DLinkNode(int key, int v) {
        this.key = key;
        this.value = v;
    }

    public void setNext(DLinkNode next) {
        this.next = next;
    }

    public void setPrev(DLinkNode prev) {
        this.prev = prev;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
