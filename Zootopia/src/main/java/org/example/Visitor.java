package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Visitor {
    Scanner sc = new Scanner(System.in);
    private String name, phone, Feedback, membership;
    private int age;
    private float Balance;
    private String email, pass;
    private ArrayList<Coupon> coupons = new ArrayList<Coupon>();
    private ArrayList<Attraction> attractions = new ArrayList<Attraction>();

    public Visitor(String name, int age, String phone, float balance, String email, String pass) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.Balance = balance;
        this.age = age;
        this.pass = pass;
        this.membership = "NONE";
        this.Feedback = "NONE";
    }

    public void setMembership(String s) {
        this.membership = s;
    }

    public void addCoupon(Coupon c) {
        this.coupons.add(c);
    }

    public float buyMembership(String s) {
        float newBalance = -1;
        if (this.getCoupons().size() != 0) {
            this.viewCoupons();
            System.out.println("Enter Coupon number to apply: ");
            int couponNo = sc.nextInt();
            sc.nextLine();
            if (couponNo <= this.getCoupons().size()) {
                if (s.equals("Basic")) {
                    newBalance = ((100
                            - this.getCoupons().get(couponNo - 1)
                            .getDiscount())
                            * 20) / 100;
                    if (newBalance > this.getBalance()) {
                        System.out.println("Insufficient Balance");
                        newBalance = -1;
                    } else {
                        this.setMembership("Basic");
                        this.changeBalance(newBalance);
                        System.out.println("Basic Membership purchased for " + newBalance);
                        System.out.println("Now your balance is " + this.Balance);
                    }
                } else if (s.equals("Premium")) {
                    newBalance = ((100
                            - this.getCoupons().get(couponNo - 1)
                            .getDiscount())
                            * 50) / 100;
                    if (newBalance > this.getBalance()) {
                        System.out.println("Insufficient Balance");
                        newBalance = -1;
                    } else {
                        this.setMembership("Premium");
                        this.changeBalance(newBalance);
                        System.out.println("Premium Membership purchased for " + newBalance);
                        System.out.println("Now your balance is " + this.Balance);
                    }
                }
            } else {
                System.out.println("*No coupon Applied*");
                if(s.equals("Basic")){
                    if(this.getBalance()<20) {
                        System.out.println("Insufficient Balance");
                    }
                    else {
                        this.setMembership(s);
                        newBalance = 20;
                        this.changeBalance(20);
                        System.out.println("now your balance is : " + this.getBalance());
                    }
                }
                else{
                    if(this.getBalance()<50) {
                        System.out.println("Insufficient Balance");
                    }
                    else {
                        this.setMembership(s);
                        newBalance = 50;
                        this.changeBalance(50);
                        System.out.println("now your balance is : " + this.getBalance());
                    }
                }
            }
        }
        return newBalance;
    }

    public String getMembership() {
        return this.membership;
    }

    public void addAttraction(Attraction a) {
        this.attractions.add(a);
    }

    public ArrayList<Attraction> getAttractions() {
        return this.attractions;
    }

    public void removeCoupon(Coupon c) {
        this.coupons.remove(c);
    }

    public void viewCoupons() {
        int ind = 1;
        for (Coupon c : this.coupons) {
            c.view(ind);
            ind++;
        }
    }

    public ArrayList<Coupon> getCoupons() {
        return this.coupons;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public int getAge() {
        return this.age;
    }

    public float getBalance() {
        return this.Balance;
    }

    public String getPass() {
        return this.pass;
    }

    public void setBalance(float balance) {
        this.Balance = balance;
    }

    public void changeBalance(float x) {
        this.Balance -= x;
    }

    public void giveFeedback(String feedback) {
        this.Feedback = feedback;
    }

    public String getFeedback() {
        return this.Feedback;
    }

    public boolean eligible(Coupon c) {
        if (c.getCategory().equals("minor")) {
            if (this.age < 18) {
                return true;
            } else {
                return false;
            }
        }
        if (c.getCategory().equals("senior")) {
            if (this.age > 60) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public float buyTickets(Attraction attr, int tikets, Deal d) {
        float revenue = -1;
        revenue = attr.getPrice() * tikets * (100 - d.getDiscount()) / 100;
        this.viewCoupons();
        System.out.println("Select Coupon Number to apply:");
        int couponNo = sc.nextInt();
        sc.nextLine();
        if (couponNo <= this.getCoupons().size()) {
            revenue = revenue * (100 - this.getCoupons().get(couponNo - 1).getDiscount()) / 100;
        }
        else{
            System.out.println("No coupon applied as invalid number selcted!");
        }
        if (revenue > this.getBalance()) {
            System.out.println("Insufficient Balance");
            revenue = -1;
        } else {
            for (int i = 0; i < tikets; i++) {
                this.attractions.add(attr);
            }
            this.changeBalance(revenue);
            System.out.println("Your Updated balance is : " + this.Balance);
        }
        return revenue;
    }

    public int visitAttraction(Attraction attr) {
        if (this.membership.equals("Premium")) {
            if (attr.getStatus().equals("open")) {
                System.out.println("Attraction Visited");
                return 1;
            } else {
                System.out.println("Attraction is currently Closed!\n");
                return -2;
            }
        }
        int check = -1;
        if (this.attractions.contains(attr)) {
            if (attr.getStatus().equals("open")) {
                check = 1;
                System.out.println("Attraction Visited");
                this.attractions.remove(attr);
            } else {
                check = -2;
                System.out.println("Attraction is currently Closed!\n");
            }
        }
        return check;
    }
}
