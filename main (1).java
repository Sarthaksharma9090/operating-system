import java.util.*;
import java.util.concurrent.Semaphore;
public class main{
    static int rc=0;
    static Semaphore s = new Semaphore(1);
    static Semaphore wrt = new Semaphore(1);
    static class Reader implements Runnable
    {
        public void run(){
            try{
                s.acquire();
                rc=rc+1;
                if(rc==1)
                {
                    wrt.acquire();
                }
                s.release();
                System.out.println(Thread.currentThread().getName()+" Readeris reading");
                Thread.sleep(1000);
                s.acquire();
                rc=rc-1;
                if(rc==0)
                wrt.release();
                s.release();
            }
            catch(Exception e)
            {
                System.out.println(".............Exception");
            }
        }
    }
    static class Writer implements Runnable
    {
        public void run(){
            try{
                
                wrt.acquire();
                System.out.println(Thread.currentThread().getName()+"Writer is writing");
                Thread.sleep(100);
                wrt.release();
                s.release();
            }
            catch(Exception e)
            {
                System.out.println(".............Exception");
            }
        }
    }
    public static void main(String[]args){
        Thread t1 = new Thread(new Reader());
        t1.setName("reader1");
        Thread t2 = new Thread(new Reader());
        t2.setName("reader2");
        Thread t3 = new Thread(new Writer());
        t3.setName("writer1");
        Thread t4 = new Thread(new Reader());
        t4.setName("reader3");
        t4.start();
        t1.start();
        t3.start();
        t2.start();
    }
}