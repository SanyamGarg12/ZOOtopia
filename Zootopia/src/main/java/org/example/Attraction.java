package org.example;

public class Attraction {
    private String name;
    private String DESCR;
    private boolean open;
    private int price;

    public Attraction(String name, String DESCR, int price) {
        this.name = name;
        this.DESCR = DESCR;
        this.open = true;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        if (this.open) {
            return "open";
        } else {
            return "closed";
        }
    }

    public void setStatus(String x) {
        if (x.equals("open")) {
            this.open = true;
        } else if (x.equals("closed")) {
            this.open = false;
        }
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int x) {
        this.price = x;
    }

    public String getDESCR() {
        return this.DESCR;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDESCR(String descr) {
        this.DESCR = descr;
    }

    public void view(int index) {
        System.out.println(
                index + ". Name: " + this.name + " Price: " + this.price + " Description: " + this.DESCR);
    }
}