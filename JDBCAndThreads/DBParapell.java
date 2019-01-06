package main.com.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBParapell {
    private int dbnum = Pool.getConfig().getDbnum();
    private int dbsplit = Pool.getConfig().getDbsplit();
    private Map<Integer, List<Integer>> tabInfo = new HashMap<>();

    public DBParapell(){
        int step = dbnum/dbsplit;
        for(int i=0;i<=dbsplit;i++){
            int begin = i*step + 1;
            int end = (i+1) * step;
            if(end>dbnum){
                end = dbnum;
            }
            List<Integer> _tmp = new ArrayList<>();
            _tmp.add(begin);
            _tmp.add(end);
           tabInfo.put(i,_tmp);
        }
    }
    public Map<Integer, List<Integer>> getTabInfo() {
        return tabInfo;
    }
    public synchronized List<Integer> getTabInfoByKey(int key){
        return tabInfo.get(key);
    }
    public static void main(String[] args) {
        DBParapell dbParapell = new DBParapell();
        List<Integer> t = dbParapell.getTabInfoByKey(10);
        for(Integer key: dbParapell.getTabInfo().keySet()){
            System.out.println(key);
        }
    }
}
