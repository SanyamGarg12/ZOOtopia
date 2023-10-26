package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Admin {
    private final String name = "sanyam";
    private final String password = "448";
    private ArrayList<Mammal> mammals = new ArrayList<Mammal>();
    private ArrayList<Reptile> reptiles = new ArrayList<Reptile>();
    private ArrayList<Amphibian> amphibians = new ArrayList<Amphibian>();
    private ArrayList<Coupon> discounts = new ArrayList<Coupon>();
    private ArrayList<Visitor> visiors = new ArrayList<Visitor>();
    private ArrayList<Attraction> Attractions = new ArrayList<Attraction>();
    private ArrayList<Coupon> coupons = new ArrayList<Coupon>();
    private ArrayList<Deal> deals = new ArrayList<Deal>();
    private float revenue = 0;

    public ArrayList<Deal> getDeals() {
        return this.deals;
    }

    public void addDeal(Deal deal) {
        this.deals.add(deal);
    }

    public void removeDeal(Deal deal) {
        this.deals.remove(deal);
    }

    public void viewDeals() {
        int ind = 1;
        for (Deal d : this.deals) {
            d.view(ind);
            ind++;
        }
    }

    public float getRevenue() {
        return this.revenue;
    }

    public void addRevenue(float r) {
        this.revenue += r;
    }

    public ArrayList<Coupon> getCoupons() {
        return this.coupons;
    }

    public void addCoupon(Coupon coupon) {
        this.coupons.add(coupon);
        for (Visitor v : this.visiors) {
            v.addCoupon(coupon);
        }
    }

    public void removeCoupon(Coupon coupon) {
        this.coupons.remove(coupon);
        for (Visitor v : this.visiors) {
            v.removeCoupon(coupon);
        }
    }

    public void viewCoupons() {
        int zz = 1;
        for (Coupon c : this.coupons) {
            c.view(zz);
            zz++;
        }
    }

    ArrayList<Visitor> getVisitors() {
        return this.visiors;
    }

    void addVisitor(Visitor v) {
        for (Coupon c : this.coupons) {
            if (v.eligible(c)) {
                v.addCoupon(c);
            }
        }
        this.visiors.add(v);
    }

    private Scanner scanner = new Scanner(System.in);

    boolean login(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public ArrayList<Attraction> getAttraction() {
        return this.Attractions;
    }

    public void addAttraction(Attraction attraction) {
        this.Attractions.add(attraction);
    }

    public void removeAttraction(Attraction attraction) {
        this.Attractions.remove(attraction);
    }

    public void viewAttractions() {
        int zz = 1;
        for (Attraction a : this.Attractions) {
            a.view(zz);
            zz++;
        }
    }

    public void modifyAttraction(Attraction attraction) {
        System.out.println("What do u want to update: ");
        System.out.println(
                "1.Update Attarction name\n2.Update Attraction Description\n");
        int choice1 = scanner.nextInt();
        if (choice1 == 1) {
            System.out.println("Enter current Attraction name: ");
            String currentName = scanner.next();
            int z = -1;
            for (Attraction a : Attractions) {
                if (a.getName().equals(currentName)) {
                    z = 1;
                    System.out.println("Enter New Attraction Name: ");
                    String newName = scanner.next();
                    a.setName(newName);
                    System.out.println("Attraction name updated Successfully!\n");
                    break;
                }
            }
            if (z == -1) {
                System.out.println("Attraction Not Found\n");
            }

        } else if (choice1 == 2) {
            System.out.println("Enter Attraction name: ");
            String currentName = scanner.next();
            int z = -1;
            for (Attraction a : Attractions) {
                if (a.getName().equals(currentName)) {
                    z = 1;
                    System.out.println("Enter New Attraction Description: ");
                    String newDescr = scanner.next();
                    a.setDESCR(newDescr);
                    System.out.println("Attraction discription updated Successfully!\n");
                    break;
                }
            }
            if (z == -1) {
                System.out.println("Attraction Not Found\n");
            }
        } else {
            System.out.println("Invalide choice");
        }
    }

    public ArrayList<Mammal> getMammals() {
        return this.mammals;
    }

    public void addMammal(Mammal mammal) {
        this.mammals.add(mammal);
    }

    public void removeMammal() {
        System.out.println("Enter Animal name: ");
        String s = scanner.next();
        System.out.println("Enter Description: ");
        String ss = scanner.next();
        int zz = -1;
        for (Mammal x : mammals) {
            if (x.getName().equals(s) && x.getDESCR().equals(ss)) {
                zz = 1;
                this.mammals.remove(x);
                System.out.println("Animal removed Successfully!\n");
                break;
            }
        }
        if (zz == -1) {
            System.out.println("Animal Not Found\n");
        }
    }

    public ArrayList<Reptile> getReptiles() {
        return this.reptiles;
    }

    public void addReptile(Reptile reptile) {
        this.reptiles.add(reptile);
    }

    public void removeReptile() {
        System.out.println("Enter Animal name: ");
        String s = scanner.next();
        System.out.println("Enter Description: ");
        String ss = scanner.next();
        int zz = -1;
        for (Reptile x : reptiles) {
            if (x.getName().equals(s) && x.getDESCR().equals(ss)) {
                zz = 1;
                this.reptiles.remove(x);
                System.out.println("Animal removed Successfully!\n");
                break;
            }
        }
        if (zz == -1) {
            System.out.println("Animal Not Found\n");
        }
    }

    public ArrayList<Amphibian> getAmphibians() {
        return this.amphibians;
    }

    public void addAmphibian(Amphibian amphibian) {
        this.amphibians.add(amphibian);
    }

    public void removeAmphibian() {
        System.out.println("Enter Animal name: ");
        String s = scanner.next();
        System.out.println("Enter Description: ");
        String ss = scanner.next();
        int zz = -1;
        for (Amphibian x : amphibians) {
            if (x.getName().equals(s) && x.getDESCR().equals(ss)) {
                zz = 1;
                this.amphibians.remove(x);
                System.out.println("Animal removed Successfully!\n");
                break;
            }
        }
        if (zz == -1) {
            System.out.println("Animal Not Found\n");
        }
    }

    public void viewAnimals() {
        System.out.println("Viewing Animals -->\n");
        for (Mammal m : mammals) {
            m.view();
        }
        for (Reptile r : reptiles) {
            r.view();
        }
        for (Amphibian a : amphibians) {
            a.view();
        }
    }

    public void addDiscount(Coupon d) {
        this.discounts.add(d);
    }

    public int addAnimal(String animalName, String DESCR, String animalType, String animalSound) {
        int check = -1;
        switch (animalType) {
            case "Mammal":
                Mammal mammal = new Mammal(animalName, animalSound, DESCR);
                this.mammals.add(mammal);
                check = 1;
                break;
            case "Reptile":
                Reptile reptile = new Reptile(animalName, animalSound, DESCR);
                this.reptiles.add(reptile);
                check = 1;

                break;
            case "Amphibian":
                Amphibian amphibian = new Amphibian(animalName, animalSound, DESCR);
                this.amphibians.add(amphibian);
                check = 1;
                break;
            default:
                System.out.println("Invalid Animal Type!\n");
                break;
        }
        return check;
    }

    public void removeReptile(Reptile x) {
        this.reptiles.remove((Reptile) x);
    }

    public void removeMammal(Mammal x) {
        this.mammals.remove((Mammal) x);
    }

    public void removeAmphibian(Amphibian x) {
        this.amphibians.remove((Amphibian) x);
    }

    public void viewFeedbacks() {
        int index = 1;
        for (Visitor v : this.visiors) {
            System.out.println(index + ". Name: " + v.getName() + " Feedback: " + v.getFeedback() + "\n");
            index++;
        }
    }

    public void viewMammals() {
        int index = 1;
        for (Mammal m : this.mammals) {
            System.out.println(index + ". Name: " + m.getName() + " Sound: " + m.getSound() + " Description: "
                    + m.getDESCR() + "\n");
            index++;
        }
    }

    public void viewReptiles() {
        int index = 1;
        for (Reptile m : this.reptiles) {
            System.out.println(index + ". Name: " + m.getName() + " Sound: " + m.getSound() + " Description: "
                    + m.getDESCR() + "\n");
            index++;
        }
    }

    public void viewAmphibians() {
        int index = 1;
        for (Amphibian m : this.amphibians) {
            System.out.println(index + ". Name: " + m.getName() + " Sound: " + m.getSound() + " Description: "
                    + m.getDESCR() + "\n");
            index++;
        }
    }

    public int getTotalAnimals() {
        return this.reptiles.size() + this.amphibians.size() + this.mammals.size();
    }
}