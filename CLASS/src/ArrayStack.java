public class ArrayStack {
    int top = -1;
    int maxSize = 0;
    Object[] elements;

    public ArrayStack(int maxStackSize) {
        top = -1;
        elements = new Object[maxStackSize];
    }

    public boolean isFull() {
        return top >= elements.length - 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public ArrayStack push(Object item) {
        if (isFull()) {
            throw new RuntimeException("Full Error");
        }
        top++;
        elements[top] = item;
        return this;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Error");
        }
        return elements[top--];
    }

    public void clear() {
        this.top = -1;
    }
}
