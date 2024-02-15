public class Consumer implements Runnable {
    private final CustomBlockingQueue<Message> queue;

    public Consumer(CustomBlockingQueue<Message> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            Message msg;
            while (!(msg = (Message) queue.dequeue()).getMsg().equals("exit")) {
                Thread.sleep(10);
                System.out.println("Consumed " + msg.getMsg());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
