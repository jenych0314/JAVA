public class CharArrayStack {
    int top = -1;
    int maxSize = 0;
    char[] elements;

    public CharArrayStack(int maxStackSize) {
        top = -1;
        elements = new char[maxStackSize];
    }

    public boolean isFull() {
        return top >= elements.length - 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public CharArrayStack push(char item) {
        if (isFull()) {
            throw new RuntimeException("Full Error");
        }
        top++;
        elements[top] = item;
        return this;
    }

    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Error");
        }
        return elements[top--];
    }

    public void clear() {
        this.top = -1;
    }
}
