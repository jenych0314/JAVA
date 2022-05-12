public class DoubleLinkedList {
    BidirectNode begin;

    public DoubleLinkedList() {
        begin = new BidirectNode();
        begin.next = begin;
    }

    @FunctionalInterface
    interface Visitor {
        void visit(BidirectNode n);
    }

    @FunctionalInterface
    interface ItemComparator {
        int compare(Object lhs, Object rhs);
    }

    public boolean isEmpty() {
        return begin.next == begin;
    }

    public void traverse(BidirectNode L, Visitor visitor) {
        BidirectNode p;

        for (p = L; p.next != L; p = p.next) {
            visitor.visit(p);
        }

        if (L != begin && L != begin.next) {
            visitor.visit(L);
        } else {
            visitor.visit(p);
        }
    }

    public void traverse(Visitor visitor) {
        this.traverse(begin.next, visitor);
    }

    public BidirectNode search(BidirectNode L, Object data, ItemComparator comparator) {
        BidirectNode p = L;
        BidirectNode found = L;

        while (p.next != L && comparator.compare(p.data, data) <= 0) {
            found = p;
            p = p.next;
        }

        if (L.next != L && comparator.compare(p.data, data) <= 0) {
            found = p;
        }

        return found;
    }

    public BidirectNode search(Object data, ItemComparator comparator) {
        return this.search(begin.next, data, comparator);
    }

    public BidirectNode deleteSearch(BidirectNode L, Object data, ItemComparator comparator) {
        BidirectNode p = L;

        if (comparator.compare(p.data, data) == 0)
            return p;

        while (p.next != L && comparator.compare(p.data, data) != 0) {
            p = p.next; // Move Next node
        }

        if (comparator.compare(p.data, data) != 0)
            return begin;

        return p;
    }

    public BidirectNode deleteSearch(Object data, ItemComparator comparator) {
        return deleteSearch(begin.next, data, comparator);
    }

    public BidirectNode add(Object data, ItemComparator comparator) {
        BidirectNode insert = new BidirectNode();
        insert.data = data;

        if (isEmpty()) {
            begin.next = insert;
            insert.next = insert;
            insert.prev = insert;
        } else {
            BidirectNode pos = search(begin.next, data, comparator);
            insertAfter(pos, insert);

            if (comparator.compare(pos.data, insert.data) > 0) {
                Object tmp = insert.data;
                insert.data = insert.prev.data;
                insert.prev.data = tmp;
            }
        }

        return insert;
    }

    public Object remove(Object data, ItemComparator comparator) {
        if (isEmpty())
            return null; // isEmpty

        BidirectNode pos = deleteSearch(begin.next, data, comparator);

        if (pos == begin)
            return null; // Not Found

        delete(pos);

        if (pos == begin.next) {
            if (pos.next == pos) { // Last One
                begin.next = begin;
            } else { // Remove First
                begin.next = pos.next;
            }
        }

        return pos.data;
    }

    void insertAfter(BidirectNode pos, BidirectNode insert) {
        insert.prev = pos;
        pos.next.prev = insert;
        insert.next = pos.next;
        pos.next = insert;
    }

    void delete(BidirectNode delete) {
        delete.prev.next = delete.next;
        delete.next.prev = delete.prev;
    }

    public Object removeFirst() {
        BidirectNode p = this.begin.next;

        this.begin.next = p.next;
        delete(p);

        if (p == begin.next) {
            if (p.next == p) { // Last One
                begin.next = begin;
            } else { // Remove First
                begin.next = p.next;
            }
        }

        return p.data;
    }
}
