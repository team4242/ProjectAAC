package com.example.projectaac;

public class SymbolListItem {
    int ID;
    String name;
    String imagePath;
    int used;
    int location;
    int backgroundcolor;

    public SymbolListItem(int ID, String name, String imagePath, int used, int location){
        this.ID = ID;
        this.name = name;
        this.imagePath = imagePath;
        this.used = used;
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

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

}
