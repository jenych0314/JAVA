import java.util.ArrayList;

public class ThreadTreeNode<T> extends TreeNode<T> {
    T data;
    boolean LT;
    boolean RT;
    ThreadTreeNode<T> llink;
    ThreadTreeNode<T> rlink;

    ThreadTreeNode() {
        this(null);
    }

    ThreadTreeNode(T data) {
        this(data, null, null);
    }

    ThreadTreeNode(T data, ThreadTreeNode<T> llink, ThreadTreeNode<T> rlink) {
        this.data = data;
        this.llink = llink;
        this.rlink = rlink;
        this.LT = this.llink == null;
        this.RT = this.rlink == null;
    }

    public boolean getLT() {
        return this.LT;
    }

    public boolean getRT() {
        return this.RT;
    }

    public void setLT(boolean logicalValue) {
        this.LT = logicalValue;
    }

    public void setRT(boolean logicalValue) {
        this.RT = logicalValue;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isEmpty() {
        return this.llink == null;
    }

    public ThreadTreeNode<T> predecessor(ThreadTreeNode<T> node) {
        ThreadTreeNode<T> p = node.llink;
        if (!node.getLT()) {
            while (!p.getRT()) {
                p = p.rlink;
            }
        }
        return p;
    }

    public ThreadTreeNode<T> insuccessor(ThreadTreeNode<T> node) {
        ThreadTreeNode<T> p = node.rlink;
        if (!node.getRT()) {
            while (!p.getLT()) {
                p = p.llink;
            }
        }
        return p;
    }

    public void inorder() {
        ThreadTreeNode<T> p = this.llink; // head -> root
        while (!p.getLT())
            p = p.llink; // root -> min elem
        while (true) {
            System.out.print(p.data + " ");
            p = insuccessor(p);
            if (p == this)
                break;
        }
    }

    @FunctionalInterface
    interface ItemComparator {
        int compare(Object left, Object right);
    }

    public boolean add(T data, ItemComparator comp) {
        ThreadTreeNode<T> insert = new ThreadTreeNode<>(data);
        if (isEmpty()) {
            this.llink = insert;
            this.setLT(false);
            insert.llink = insert.rlink = this;
            return true;
        } else {
            ThreadTreeNode<T> p = this.llink;
            while (true) {
                if (comp.compare(p.data, insert.data) < 0) { // p.data < insert.data
                    if (!p.getRT())
                        p = p.rlink;
                    else {
                        insert.rlink = p.rlink;
                        insert.setRT(p.getRT());
                        insert.llink = p;
                        insert.setLT(true);
                        p.rlink = insert;
                        p.setRT(false);

                        if (!insert.getRT()) {
                            ThreadTreeNode<T> temp = insuccessor(insert);
                            temp.llink = insert;
                        }

                        return true;
                    }
                } else if (comp.compare(p.data, insert.data) > 0) { // p.data > insert.data
                    if (!p.getLT())
                        p = p.llink;
                    else {
                        insert.llink = p.llink;
                        insert.setLT(p.getLT());
                        insert.rlink = p;
                        insert.setRT(true);
                        p.llink = insert;
                        p.setLT(false);

                        if (!insert.getLT()) {
                            ThreadTreeNode<T> temp = insuccessor(insert);
                            temp.rlink = insert;
                        }

                        return true;
                    }
                } else
                    return false;
            }
        }
    }

    public ArrayList<T> higher(T data, ItemComparator comp) {
        if (isEmpty()) {
            return null;
        } else {
            ArrayList<T> arr = new ArrayList<>();

            ThreadTreeNode<T> p = this.llink; // head -> root

            while (true) { // find data's position
                if (comp.compare(p.data, data) < 0) { // p.data < insert.data
                    if (!p.getRT())
                        p = p.rlink;
                    else
                        break;
                } else if (comp.compare(p.data, data) > 0) { // p.data > insert.data
                    if (!p.getLT())
                        p = p.llink;
                    else
                        break;
                } else
                    break;
            }

            if (p.rlink == this) // data is greater than tree's element max value
                return null;

            while (true) {
                p = insuccessor(p);
                if (p == this)
                    break;
                arr.add(p.data);
            }

            return arr;
        }

    }

    public static void test3() {
        ItemComparator comp = (left, right) -> {
            int i1 = (Integer) left;
            int i2 = (Integer) right;
            return i1 - i2;
        };

        ThreadTreeNode<Integer> tree = new ThreadTreeNode<>();
        int[] nums = { 23, 39, 7, 20, 14, 15, 46, 66, 75, 49, 32 };
        for (int val : nums) {
            tree.add(val, comp);
        }

        System.out.print("Inorder: ");
        tree.inorder();
        System.out.println();

        System.out.print("higher: ");
        ArrayList<Integer> arr = tree.higher(65, comp);
        System.out.println();
        for (var val : arr)
            System.out.println(val);
    }

    public static void test4() {
        ItemComparator comp = (left, right) -> {
            int i1 = (Integer) left;
            int i2 = (Integer) right;
            return i1 - i2;
        };

        ThreadTreeNode<Integer> tree = new ThreadTreeNode<>();
        int[] nums = { 23, 39, 7, 20, 14, 15, 46, 66, 75, 49, 32 };
        for (int val : nums) {
            tree.add(val, comp);
        }

        for (int val : nums) {
            ArrayList<Integer> arr = tree.higher(val, comp);
            System.out.print(val + " higher: ");
            if (arr == null)
                System.out.print("null");
            else {
                for (var elem : arr)
                    System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ThreadTreeNode.test4();
    }
}
