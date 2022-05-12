public class CircularQueue {
    int front = 0;
    int rear = 0;
    Object[] elements;

    public CircularQueue(int maxQueueSize) {
        this.front = this.rear = 0;
        elements = new Object[maxQueueSize];
    }

    public boolean isFull() {
        return front == (rear + 1) % elements.length;
    }

    public CircularQueue add(Object item) {
        if (this.isFull()) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = item;
        return this;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public Object delete() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        front = (front + 1) % elements.length;
        return elements[front];
    }

    public static void main(String[] args) {
        CircularQueue que = new CircularQueue(6); // 5개 원소 저장
        que.add("Q1");
        System.out.println("Q1 Front: " + que.front + ", Rear: " + que.rear);
        System.out.flush();
        que.add("Q2");
        System.out.println("Q2 Front: " + que.front + ", Rear: " + que.rear);
        System.out.flush();
        que.add("Q3");
        System.out.println("Q3 Front: " + que.front + ", Rear: " + que.rear);
        System.out.flush();
        que.add("Q4");
        System.out.println("Q4 Front: " + que.front + ", Rear: " + que.rear);
        System.out.flush();
        que.add("Q5");
        System.out.println("Q5 Front: " + que.front + ", Rear: " + que.rear);
        System.out.flush();
        que.add("Q6");
        System.out.println("Q6 Front: " + que.front + ", Rear: " + que.rear);
        System.out.flush();
    }
}
