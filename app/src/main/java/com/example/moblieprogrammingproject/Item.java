package com.example.moblieprogrammingproject;

public class Item {

    private String id;
    private String name;
    private String surname;
    private String marks;
    private String price;

    private String timestamp;

    public Item(String id,String name, String surname, String marks,String price,String timestamp) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.marks=marks;
        this.price=price;

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
    public String getPrice() {
        return price;
    }
    public String getTimestamp() {
        return timestamp;
    }


}
