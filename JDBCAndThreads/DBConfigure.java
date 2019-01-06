package main.com.jdbc;

public class DBConfigure {

    private String url;
    private String pwd;
    private String username;
    private String min_pool;
    private String max_pool;
    private String dirver;
    private int dbnum;
    private int dbsplit;

    public int getDbnum() {
        return dbnum;
    }

    public void setDbnum(int dbnum) {
        this.dbnum = dbnum;
    }

    public int getDbsplit() {
        return dbsplit;
    }

    public void setDbsplit(int dbsplit) {
        this.dbsplit = dbsplit;
    }

    public String getDirver() {
        return dirver;
    }

    public void setDirver(String dirver) {
        this.dirver = dirver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMin_pool() {
        return min_pool;
    }

    public void setMin_pool(String min_pool) {
        this.min_pool = min_pool;
    }

    public String getMax_pool() {
        return max_pool;
    }

    public void setMax_pool(String max_pool) {
        this.max_pool = max_pool;
    }

}
