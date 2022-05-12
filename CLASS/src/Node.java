public class Node {
    Object data;
    Node link;

    public Node() {
        this(null, null);
    }

    public Node(Object data) {
        this(data, null);
    }

    public Node(Object data, Node link) {
        this.data = data;
        this.link = link;
    }
}