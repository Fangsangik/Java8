package com.example.java.Java8to11.StreamPack;

public class OnlineClass {
    private Integer id;

    private String title;

    private boolean closed;

    public OnlineClass(Integer id, String tilte, boolean closed){
        this.id = id;
        this.title = tilte;
        this.closed =closed;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id =id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setClosed(boolean closed){
        this.closed=closed;
    }

    public boolean isClosed() {
        return closed;
    }
}
