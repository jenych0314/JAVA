public class ThreadBST {
    boolean LT, RT;
    ThreadBST left, right;
    int data;
    ThreadBST root;

    public ThreadBST() {
        this.root = new ThreadBST();
        this.root.LT = this.root.RT = true;
        this.root.left = this.root.right = this.root;
    }

    public boolean isEmpty() {
        return this.root.LT;
    }

    public ThreadBST insuccessor(ThreadBST node) {
        ThreadBST p = node.right;
        if (!node.RT) {
            while (!p.LT) {
                p = p.left;
            }
        }
        return p;
    }

    public void inorder() {
        ThreadBST p = this.left;
        while (!p.LT) {
            p = p.left;
        }

        while (true) {
            System.out.print(p.data + " ");
            p = insuccessor(p);
            if (p == this)
                break;
        }
    }

    protected void add(ThreadBST pos, ThreadBST insert) {
        ThreadBST curr = pos;
        while (true) {
            int compare = curr.data - insert.data;
            if (compare == 0)
                return;
            else if (compare > 0) {
                if (curr.LT) {
                    this.addLeft(curr, insert);
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.RT) {
                    this.addRight(curr, insert);
                } else {
                    curr = curr.right;
                }
            }
        }
    }

    private void addLeft(ThreadBST pos, ThreadBST insert) {
        insert.left = pos.left;
        insert.LT = pos.LT;
        insert.right = pos;
        insert.RT = true;
        pos.left = insert;
        pos.LT = false;

        if (!insert.LT) {
            ThreadBST tmp = insuccessor(insert);
            tmp.right = insert;
        }
    }

    private void addRight(ThreadBST pos, ThreadBST insert) {
        insert.right = pos.right;
        insert.RT = pos.RT;
        insert.left = pos;
        insert.LT = true;
        pos.right = insert;
        pos.RT = false;

        if (!insert.RT) {
            ThreadBST tmp = insuccessor(insert);
            tmp.left = insert;
        }
    }

    public static void main(String[] args) {
    }
}
