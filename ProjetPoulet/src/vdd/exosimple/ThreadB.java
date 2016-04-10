package vdd.exosimple;
class ThreadB extends Thread{
    int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
            	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                total += i;
            }
            notify();
        }
    }
}