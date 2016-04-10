package vdd.autre;

public class LanceThread {
    public static void main(String[] args) {
        LanceThread lanceThread = new LanceThread();
        lanceThread.init();
    }
    private void init() {
        // ...
        MaClasse maClasse=new MaClasse();
        // ...
        Thread unThread=new Thread(maClasse);
        unThread.start();
        // ...
    }
}
