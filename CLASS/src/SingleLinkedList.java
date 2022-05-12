public class SingleLinkedList extends Node {
    Node begin;
    Node end;

    public SingleLinkedList() {
        begin = new Node();
        end = new Node();
        begin.link = end;
    }

    public boolean isEmpty() {
        return begin.link == end;
    }

    @FunctionalInterface
    public interface Visitor {
        void visit(Node n);
    }

    public void traverseRecursive(Node L, Visitor visitor) {
        if (L != end) {
            System.out.println("(data: " + L.data + ") -> ");
            traverseRecursive(L.link, visitor);
        } else {
            System.out.println("null");
        }
    }

    public void traverseIterative(Node L, Visitor visitor) {
        for (Node p = L; p != end; p = p.link) {
            System.out.print("(data: " + p.data + ") -> ");
        }
        System.out.println("null");
    }

    // public void traverseIterative(Node L, Visitor visitor) {
    // for (Node p = L; p != end; p = p.link) {
    // visitor.visit(p);
    // }
    // visitor.visit(end);
    // }

    public void traverseIterative(Visitor visitor) {
        this.traverseIterative(begin.link, visitor);
    }

    @FunctionalInterface
    interface ItemComparator {
        int compare(Object left, Object right);
    }

    public Node search(Node L, Object data, ItemComparator comparator) {
        Node p = L;
        Node found = L;

        while (p != end && comparator.compare(p.data, data) <= 0) {
            found = p;
            p = p.link;
        }

        return found;
    }

    public Node search(Object data, ItemComparator comparator) {
        return this.search(begin.link, data, comparator);
    }

    public Node add(Object data, ItemComparator comparator) {
        Node insert = new Node(data);

        if (isEmpty()) {
            begin.link = insert;
            insert.link = end;
        } else {
            Node pos = search(begin.link, data, comparator);
            insert.link = pos.link;
            pos.link = insert;
        }

        return insert;
    }

    public Node deleteSearch(Node L, Object data, ItemComparator comparator) {
        Node p = L;
        Node found = L;

        while (p != end && comparator.compare(p.data, data) != 0) {
            found = p;
            p = p.link;
        }

        if (p == end)
            return end;
        if (found == p)
            return begin;
        return found;
    }

    public Node deleteSearch(Object data, ItemComparator comparator) {
        return deleteSearch(begin.link, data, comparator);
    }

    public Node delete(Object data, ItemComparator comparator) {
        Node pos = null;
        Node deleting = null;
        pos = deleteSearch(data, comparator);

        if (pos == end)
            return null;

        deleting = pos.link;
        pos.link = deleting.link;

        return pos;
    }

    public Node invert() {
        Node curr = this.begin;
        Node prev = null;

        while (curr != null) {
            Node next = curr.link;

            curr.link = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public Node concatenate(Node other) {
        Node temp = this.begin.link;
        while (temp.link != end) {
            temp = temp.link;
        }
        temp.link = other;
        if (other.link == null) {
            other.link = end;
        }
        return other;
    }

    public static void main(String[] args) {
        SingleLinkedList lst = new SingleLinkedList();
        ItemComparator c = (left, right) -> {
            int i1 = (Integer) left;
            int i2 = (Integer) right;
            return i1 - i2;
        };

        Visitor v = (n) -> {
            if (n.link == null) {
                System.out.print("null");
            } else {
                System.out.print(n.data + ", ");
            }
        };

        lst.add(1, c);
        lst.add(3, c);
        lst.add(5, c);
        lst.add(2, c);
        lst.add(4, c);
        lst.traverseIterative(v);

        System.out.println(lst.delete(3, c));
        lst.traverseIterative(v);

        Node p = new Node(6);
        lst.concatenate(p);
        lst.traverseIterative(v);
    }
}