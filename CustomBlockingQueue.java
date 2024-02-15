import java.util.ArrayList;

public class CustomBlockingQueue<E> {
    private final ArrayList<E> queue;
    private int count;

    public CustomBlockingQueue(int count) {
        this.count = count;
        this.queue = new ArrayList<>(count);
    }

    public synchronized void enqueue(E e) throws InterruptedException { // Добавление элемента в очередь
        while (queue.size() == count) {
            wait();
        }
        if (queue.size() < count) {
            notify();
        }
        queue.add(e);
        count++;
    }

    public synchronized Object dequeue() throws InterruptedException { // Извлечение элемента из очереди
        while (queue.isEmpty()) {
            wait();
        }
        notify();
        count--;
        return queue.remove(0);
    }

    public synchronized int size() {
        return queue.size();
    }
}
