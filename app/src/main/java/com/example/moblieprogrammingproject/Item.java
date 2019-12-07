package com.example.moblieprogrammingproject;

public class Item {

    private String name;
    private String surname;
    private String marks;
    private String timestamp;

    public Item(String name, String surname, String marks,String timestamp) {
        this.name = name;
        this.surname = surname;
        this.marks=marks;
        this.timestamp= timestamp;
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
