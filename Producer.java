public class Producer implements Runnable{
    private final CustomBlockingQueue<Message> queue;

    public Producer(CustomBlockingQueue<Message> q){
        this.queue=q;
    }
    @Override
    public void run() {
        for(int i=0; i<30; i++){
            Message msg = new Message(""+ (i+1));
            try {
                Thread.sleep(10);
                queue.enqueue(msg);
                System.out.println("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Message msg = new Message("exit");
        try {
            queue.enqueue(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
