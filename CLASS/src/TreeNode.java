public class TreeNode<T> {
    T data;
    TreeNode<T> llink;
    TreeNode<T> rlink;

    int depth = 0;

    TreeNode() {
        this(null, null, null);
    }

    TreeNode(T data) {
        this(data, null, null);
    }

    TreeNode(T data, TreeNode<T> llink, TreeNode<T> rlink) {
        this.data = data;
        this.llink = llink;
        this.rlink = rlink;
    }

    public void preorder() {
        TreeNode<T> p = this;
        System.out.print(p.data + " ");
        if (p.llink != null)
            p.llink.preorder();
        if (p.rlink != null)
            p.rlink.preorder();
    }

    public void inorder() {
        TreeNode<T> p = this;
        if (p.llink != null)
            p.llink.inorder();
        System.out.print(p.data + " ");
        if (p.rlink != null)
            p.rlink.inorder();
    }

    public void postorder() {
        TreeNode<T> p = this;
        if (p.llink != null)
            p.llink.postorder();
        if (p.rlink != null)
            p.rlink.postorder();
        System.out.print(p.data + " ");
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isEmpty() {
        return this.llink == null && this.rlink == null;
    }

    public void findDepth(TreeNode<T> node, int depth) {
        if (node == null)
            return;

        if (this.depth < depth)
            this.depth = depth;

        if (node.llink != null)
            findDepth(node.llink, depth + 1);
        if (node.rlink != null)
            findDepth(node.rlink, depth + 1);
    }

    public int getDepth() {
        findDepth(this, 0);
        return this.depth;
    }

    @FunctionalInterface
    interface ItemComparator {
        int compare(Object left, Object right);
    }

    public boolean add(T data, ItemComparator comp) {
        TreeNode<T> p = this;
        if (isEmpty()) {
            p.data = data;
            return true;
        } else {
            while (true) {
                if (comp.compare(p.data, data) < 0) { // data > p.data
                    if (p.rlink != null) {
                        p = p.rlink;
                    } else {
                        TreeNode<T> insert = new TreeNode<>(data);
                        p.rlink = insert;
                        return true;
                    }
                } else if (comp.compare(p.data, data) > 0) { // data < p.data
                    if (p.llink != null) {
                        p = p.llink;
                    } else {
                        TreeNode<T> insert = new TreeNode<>(data);
                        p.llink = insert;
                        return true;
                    }
                } else // data == p.data
                    return false;
            }
        }
    }

    static <T> TreeNode<T> build(T data, TreeNode<T> L, TreeNode<T> R) {
        TreeNode<T> tree = new TreeNode<>(data, L, R);
        return tree;
    }

    static TreeNode<String> create() {
        TreeNode<String> n11 = TreeNode.build("C", null, null);
        TreeNode<String> n10 = TreeNode.build("B", null, null);
        TreeNode<String> n7 = TreeNode.build("E", null, null);
        TreeNode<String> n6 = TreeNode.build("D", null, null);
        TreeNode<String> n5 = TreeNode.build("/", n10, n11);
        TreeNode<String> n4 = TreeNode.build("A", null, null);
        TreeNode<String> n3 = TreeNode.build("-", n6, n7);
        TreeNode<String> n2 = TreeNode.build("+", n4, n5);
        TreeNode<String> n1 = TreeNode.build("*", n2, n3);
        return n1;
    }

    static TreeNode<Integer> createBST() {
        TreeNode<Integer> n15 = TreeNode.build(67, null, null);
        TreeNode<Integer> n7 = TreeNode.build(48, null, n15);
        TreeNode<Integer> n6 = TreeNode.build(37, null, null);
        TreeNode<Integer> n5 = TreeNode.build(24, null, null);
        TreeNode<Integer> n3 = TreeNode.build(45, n6, n7);
        TreeNode<Integer> n2 = TreeNode.build(12, null, n5);
        TreeNode<Integer> n1 = TreeNode.build(35, n2, n3);
        return n1;
    }

    public class TreeNodeTraversal {
        public static void test1() {
            TreeNode<String> tree = TreeNode.create();
            System.out.print("Preorder: ");
            tree.preorder();
            System.out.println();
            System.out.print("Inorder: ");
            tree.inorder();
            System.out.println();
            System.out.print("Postorder: ");
            tree.postorder();
            System.out.println();
        }

        public static void test2() {
            TreeNode<Integer> binTree = TreeNode.createBST();
            System.out.print("Inorder: ");
            binTree.inorder();
            System.out.println();
            System.out.print("Preorder: ");
            binTree.preorder();
            System.out.println();
            System.out.print("Postorder: ");
            binTree.postorder();
            System.out.println();
        }

        public static void test3() {
            ItemComparator comp = (left, right) -> {
                int i1 = (Integer) left;
                int i2 = (Integer) right;
                return i1 - i2;
            };

            TreeNode<Integer> tree = new TreeNode<>();
            int[] nums = { 23, 39, 7, 20, 14, 15, 46, 66, 75, 49, 32 };
            for (int val : nums) {
                tree.add(val, comp);
            }

            System.out.print("Preorder: ");
            tree.preorder();
            System.out.println();

            System.out.print("Inorder: ");
            tree.inorder();
            System.out.println();

            System.out.print("Postorder: ");
            tree.postorder();
            System.out.println();

            System.out.print("Depth: ");
            System.out.println(tree.getDepth());
        }

        public static void main(String[] args) {
            TreeNodeTraversal.test3();
        }
    }
}
