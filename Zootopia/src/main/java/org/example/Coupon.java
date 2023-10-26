package org.example;

public class Coupon {
    private String name;
    private float discount;
    private String category;

    public Coupon(String name, float discount, String category) {
        this.name = name;
        this.discount = discount;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public float getDiscount() {
        return this.discount;
    }

    public String getCategory() {
        return this.category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void view(int index) {
        System.out.println(
                index + ". Name: " + this.name + " Discount: " + this.discount + " Category: " + this.category);
    }

    public void view() {
        System.out.println(
                "Name: " + this.name + " Discount: " + this.discount + " Category: " + this.category);
    }
}
