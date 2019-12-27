package com.example.moblieprogrammingproject;

public class Item {

    private String id;
    private String name;
    private String surname;
    private String marks;
    private String timestamp;

    public Item(String id,String name, String surname, String marks,String timestamp) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.marks=marks;
        this.timestamp= timestamp;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getMarks() {
        return marks;
    }
    public String getTimestamp() {
        return timestamp;
    }


}
