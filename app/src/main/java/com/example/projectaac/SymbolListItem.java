package com.example.projectaac;

public class SymbolListItem {
    int ID;
    String name;
    String imagePath;
    int count;
    int location;

    public SymbolListItem(int ID, String name, String imagePath, int count, int location){
        this.ID = ID;
        this.name = name;
        this.imagePath = imagePath;
        this.count = count;
        this.location= location;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
