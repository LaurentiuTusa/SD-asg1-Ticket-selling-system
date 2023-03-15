package Model;

import java.sql.Date;
import java.time.*;
import java.sql.Timestamp;


public class Concert {
    private int id;
    private String name;
    private int limit;
    private Timestamp time;

    public Concert(int id, String name, int limit, Timestamp time) {
        this.id = id;
        this.name = name;
        this.limit = limit;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String toString(){
        String s = "id= " + this.getId() + ", name= " + this.getName() + ", limit= " + this.getLimit() + ", time= " + this.getTime();
        return s;
    }
}
