public class BidirectNode {
    Object data;
    BidirectNode prev;
    BidirectNode next;

    public BidirectNode() {
        this(null, null, null);
    }

    public BidirectNode(Object data) {
        this(null, data, null);
    }

    public BidirectNode(Object data, BidirectNode next) {
        this(null, data, next);
    }

    public BidirectNode(BidirectNode prev, Object data, BidirectNode next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
