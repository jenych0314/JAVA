public class MaxHeap {
    int top = -1;
    int size;
    Object[] heap;

    MaxHeap() {
        this(0);
    }

    MaxHeap(int size) {
        this.top = -1;
        this.size = size;
        this.heap = new Object[size];
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFull() {
        return this.top >= this.size;
    }

    public boolean isEmpty() {
        return this.top < 0;
    }

    @FunctionalInterface
    interface ItemComparator {
        int compare(Object left, Object right);
    }

    public void insert(Object value, ItemComparator comp) {
        if (isFull())
            throw new RuntimeException("Full");

        int ptr = ++this.top;
        if (isEmpty()) {
            this.heap[ptr] = value;
        } else {
            while ((ptr != 0) && (comp.compare(value, this.heap[ptr / 2]) > 0)) {
                this.heap[ptr] = this.heap[ptr / 2];
                ptr /= 2;
            }
            this.heap[ptr] = value;
        }
    }

    public Object remove(ItemComparator comp) {
        int parent, child;
        Object value, temp;

        if (isEmpty())
            throw new RuntimeException("Empty");

        value = this.heap[0];
        temp = this.heap[this.top--];

        parent = 0;
        child = 1;

        while (child <= this.top) {
            if (child < this.top && (comp.compare(this.heap[child], this.heap[child + 1]) < 0)) {
                child++;
            }

            if (comp.compare(temp, this.heap[child]) >= 0)
                break;

            this.heap[parent] = this.heap[child];
            parent = child;
            child *= 2;
        }

        this.heap[parent] = temp;

        return value;
    }

    public void print() {
        System.out.print("Elements: ");
        if (isEmpty())
            System.out.println("null");
        else {
            for (int n = 0; n <= this.top; n++) {
                System.out.print(this.heap[n] + " ");
            }
            System.out.println();
        }
    }

    public void printTree() {
        System.out.println("Elements: ");
        if (isEmpty())
            System.out.println("null");
        else {
            int n = 0;
            for (int i = 0; i < (int) MathFunction.baseLog(2, this.top + 1) + 1; i++) {
                for (int j = 0; j < (int) Math.pow(2, i); j++) {
                    System.out.print(this.heap[n++] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ItemComparator comp = (left, right) -> {
            int i1 = (Integer) left;
            int i2 = (Integer) right;
            return i1 - i2;
        };

        int maxSize = 7;
        MaxHeap maxHeap = new MaxHeap(maxSize);

        int[] arr = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            int randInt = (int) (Math.random() * 100);
            arr[i] = randInt;
            System.out.print(randInt + " ");
        }
        System.out.println();

        System.out.println("---Insert---");
        for (int val : arr) {
            maxHeap.insert(val, comp);
            maxHeap.print();
        }

        maxHeap.printTree();

        System.out.println("---Remove---");
        for (int i = 0; i < maxSize; i++) {
            System.out.println("Removed: " + maxHeap.remove(comp));
            maxHeap.print();
        }
    }
}
