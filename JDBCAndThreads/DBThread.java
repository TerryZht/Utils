package main.com.jdbc;

public class DBThread implements Runnable{
    private DBParapell dbParapell = new DBParapell();
    private int dbsplit = Pool.getConfig().getDbsplit();
    public void StartJob(){
        while (true){
            if(dbsplit<0){
                break;
            }
            DAO.exportTab(dbParapell.getTabInfoByKey(dbsplit--));
        }
    }

    @Override
    public void run() {
        StartJob();
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int parapell = Pool.getConfig().getDbsplit();
        DBThread dbThread = new DBThread();
        Thread [] threads = new Thread[parapell];
        for(int i =0;i<parapell;i++){
            threads[i] = new Thread(dbThread, "th" + i);
            threads[i].start();
        }
        for(int i=0;i<parapell;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("spand:" + (end - begin));
    }
}
