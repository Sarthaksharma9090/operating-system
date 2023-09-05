import java.util.ArrayList;
import java.util.*;
class producer implements Runnable{
     List<Integer> Buffer=null;
     private int i=0;
     final int max=10;
     producer(List<Integer>Buffer)
     {
         this.Buffer=Buffer;
     }
     public void produce(int i)throws InterruptedException
     {
       synchronized(Buffer)
       {
           while(Buffer.size()== max)
           {
               System.out.println("Producer is Waiting due to Buffer is Full");
               Buffer.wait();
           }
       }
       Buffer.add(i);
           System.out.println("Producer Producing");
           Thread.sleep(350);
       synchronized(Buffer)
       {
           
           Buffer.notify();
       }
     }
     public void run()
     {
         try{
             while(true)
             {
                 i++;
                 produce(i);
             }
         }
         catch(Exception e)
         {
             System.out.println("Exception overcome"+e);     
         }
     }
}
class Consumer implements Runnable{
     List<Integer> Buffer=null;
     private int i=0;
     final int max=10;
     Consumer(List<Integer>Buffer)
     {
         this.Buffer=Buffer;
     }
     public void Consume(int i)throws InterruptedException
     {
       synchronized(Buffer)
       {
           while(Buffer.isEmpty())
           {
               System.out.println("consumer is Waiting due to Buffer is empty");
               Buffer.wait();
           }
       }
       Buffer.remove(i);
           System.out.println("Consumer Consuming");
           Thread.sleep(350);
       synchronized(Buffer)
       {
           
           Buffer.notify();
       }
     }
     public void run()
     {
         try{
             while(true)
             {
                Consume(i);
             }
         }
         catch(Exception e)
         {
             System.out.println("Exception overcome"+e);     
         }
     }
}
public class ProducerConsumer{
    public static void main(String[] args) {
        List<Integer> B=new ArrayList<Integer>();
        Thread p=new Thread(new producer(B));
        Thread c=new Thread(new Consumer(B));
        p.start();
        c.start();
    }
}