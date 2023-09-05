
        public class threadexample implements Runnable{
        public void run() 
        {
            try{
                
                for(int i=0; i<10; i++){
                Thread.sleep(250);
                System.out.println(i);
                }
            }
            
            catch(Exception e){
                System.out.print(e);
            }
        }
    public static void main(String[] args) {
        Thread t1 = new Thread(new threadexample());
        t1.start();
        Thread t2 = new Thread(new threadexample());
        t2.start();
    }
}
