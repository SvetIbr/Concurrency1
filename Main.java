public class Main {
    public static void main(String[] args) {
        CustomBlockingQueue<Message> queue = new CustomBlockingQueue<>(2);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}