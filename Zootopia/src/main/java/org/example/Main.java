package org.example;


import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Coupon minorCoupon = new Coupon("Minor10", 10, "minor");
        Coupon seniorCoupon = new Coupon("Senior20", 20, "senior");
        Deal customDeal1 = new Deal(2, 15);
        Deal customDeal2 = new Deal(3, 30);
        Reptile r1 = new Reptile("Snake","hiss","This is a snake");
        Reptile r2 = new Reptile("Tortoise","Grunt","This is tortoise");
        Amphibian a1 = new Amphibian("Frog","Croack","This is a frog");
        Amphibian a2 = new Amphibian("Salamander","astos","This is astos's salamander");
        Mammal m1 = new Mammal("Lion","Roar","This is a lion");
        Mammal m2 = new Mammal("Elephant","trumpet","Hathi mera sathi #BroCode #Trending");
        admin.addMammal(m1);
        admin.addMammal(m2);
        admin.addAmphibian(a1);
        admin.addAmphibian(a2);
        admin.addReptile(r1);
        admin.addReptile(r2);
        admin.addCoupon(seniorCoupon);
        admin.addCoupon(minorCoupon);
        admin.addDeal(customDeal2);
        admin.addDeal(customDeal1);
        System.out.printf("Welcome to ZOOtopia!\n");
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            System.out.printf(
                    "1. Enter as Admin\n" + //
                            "2. Enter as a Visitor\n" + //
                            "3. View Special Deals\n" + //
                            "4. Exit Zootopia!\n");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.printf("Enter admin username: ");
                    String loginName = sc.nextLine();
                    System.out.printf("Enter admin password: ");
                    String loginPassword = sc.nextLine();
                    if (admin.login(loginName, loginPassword)) {
                        System.out.printf("Login Successful!\n");
                        while (true) {
                            System.out.printf("Admin Menu:\n" + //
                                    "1. Manage Attractions\n" + //
                                    "2. Manage Animals\n" + //
                                    "3. Schedule Events\n" + //
                                    "4. Set Discounts\n" + //
                                    "5. Set Special Deal\n" + //
                                    "6. View Visitor Stats\n" + //
                                    "7. View Feedback\n" + //
                                    "8. Exit\n");
                            int adminChoice = sc.nextInt();
                            sc.nextLine();
                            switch (adminChoice) {
                                case 1:
                                    while (true) {
                                        System.out.printf("Manage Attractions:\n" + //
                                                "1. Add Attraction\n" + //
                                                "2. View Attractions\n" + //
                                                "3. Modify Attraction\n" + //
                                                "4. Remove Attraction\n" + //
                                                "5. Exit\n");
                                        int manageAttractionChoice = sc.nextInt();
                                        sc.nextLine();
                                        switch (manageAttractionChoice) {
                                            case 1:
                                                System.out.printf("Enter Attraction Name: ");
                                                String attractionName = sc.nextLine();
                                                System.out.printf("Enter Attraction Description: ");
                                                String attractionDSC = sc.nextLine();
                                                System.out.printf("Enter Price: ");
                                                int attractionPrice = sc.nextInt();
                                                Attraction att = new Attraction(attractionName, attractionDSC,
                                                        attractionPrice);
                                                admin.addAttraction(att);
                                                System.out.printf("Attraction Added Successfully!\n");
                                                break;
                                            case 2:
                                                System.out.printf("Attractions:\n");
                                                for (Attraction a : admin.getAttraction()) {
                                                    System.out.println(a.getName() + " " + a.getDESCR());
                                                }
                                                break;

                                            case 3:
                                                admin.viewAttractions();
                                                System.out.printf("Select Attraction number to modify: ");
                                                int attractionNo = sc.nextInt();
                                                sc.nextLine();
                                                if (attractionNo <= admin.getAttraction().size()) {
                                                    admin.modifyAttraction(admin.getAttraction().get(attractionNo - 1));
                                                } else {
                                                    System.out.printf("Invalid number selected\n");
                                                }
                                                break;
                                            case 4:
                                                admin.viewAttractions();
                                                System.out.printf("Select Attraction number to remove: ");
                                                int attractionNo2 = sc.nextInt();
                                                sc.nextLine();
                                                if (attractionNo2 <= admin.getAttraction().size()) {
                                                    int res = admin.removeAttraction(
                                                            admin.getAttraction().get(attractionNo2 - 1));
                                                    if (res == 1) {
                                                        System.out.printf("Attraction Removed!\n");
                                                    } else {
                                                        System.out.println("Cant remove as tickets sold\n");
                                                    }
                                                } else {
                                                    System.out.printf("Invalid number selected\n");
                                                }
                                                break;
                                            case 5:
                                                break;
                                            default:
                                                System.out.printf("Invalid Command!\n");
                                                break;
                                        }
                                        if (manageAttractionChoice == 5) {
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    while (true) {
                                        System.out.printf("Manage Animals:\n" + //
                                                "1. Add Animal\n" + //
                                                "2. Update Animal Details\n" + //
                                                "3. Remove Animal\n" + //
                                                "4. Exit\n");
                                        int manageAnimalChoice = sc.nextInt();
                                        sc.nextLine();
                                        switch (manageAnimalChoice) {
                                            case 1:
                                                System.out.printf("Enter Animal Name: ");
                                                String animalName = sc.nextLine();
                                                System.out.printf("Enter Animal Type: ");
                                                String animalType = sc.nextLine();
                                                System.out.printf("Enter Sound: ");
                                                String animalSound = sc.nextLine();
                                                System.out.printf("Enter Animal Description: ");
                                                String animalDESCR = sc.nextLine();
                                                int check = admin.addAnimal(animalName, animalDESCR, animalType,
                                                        animalSound);
                                                if (check != -1) {
                                                    System.out.printf("Animal Added Successfully!\n");
                                                }
                                                break;
                                            case 2:
                                                while (true) {
                                                    System.out.printf("Choose Update Options\n");
                                                    System.out.printf("1. Update Animal Name\n" + //
                                                            "2. Update Animal Sound\n" + //
                                                            "3. Update Animal Description\n" + //
                                                            "4. Update animal Type\n" + //
                                                            "5. Exit\n");
                                                    int updateAnimalChoice = sc.nextInt();
                                                    sc.nextLine();
                                                    if (updateAnimalChoice < 5) {
                                                        System.out.printf(
                                                                "Select Animal Type no. to modify:\n1.Mammal\n2.Reptile\n3.Amphibian\n");
                                                        int animalTypeNo = sc.nextInt();
                                                        sc.nextLine();
                                                        switch (animalTypeNo) {
                                                            case 1:
                                                                admin.viewMammals();
                                                                System.out.printf(
                                                                        "Select Animal number to modify: ");
                                                                int animalNo = sc.nextInt();
                                                                sc.nextLine();
                                                                if (animalNo <= admin.getMammals().size()) {
                                                                    if (updateAnimalChoice == 1) {
                                                                        System.out.printf("Enter new Name: ");
                                                                        String newName = sc.nextLine();
                                                                        admin.getMammals().get(animalNo - 1)
                                                                                .setName(newName);
                                                                        System.out.printf("Animal name Modified!\n");
                                                                    } else if (updateAnimalChoice == 2) {
                                                                        System.out.printf("Enter new Sound: ");
                                                                        String newSound = sc.nextLine();
                                                                        admin.getMammals().get(animalNo - 1)
                                                                                .setSound(newSound);
                                                                        System.out.printf("Animal sound Modified!\n");
                                                                    } else if (updateAnimalChoice == 3) {
                                                                        System.out.printf("Enter new Description: ");
                                                                        String newDESCR = sc.nextLine();
                                                                        admin.getMammals().get(animalNo - 1)
                                                                                .setDESCR(newDESCR);
                                                                        System.out.printf(
                                                                                "Animal description Modified!\n");
                                                                    } else if (updateAnimalChoice == 4) {
                                                                        System.out.printf("Enter new Animal type: ");
                                                                        String newType = sc.nextLine();
                                                                        String a = admin.getMammals().get(animalNo - 1)
                                                                                .getName();
                                                                        String b = admin.getMammals().get(animalNo - 1)
                                                                                .getSound();
                                                                        String c = admin.getMammals().get(animalNo - 1)
                                                                                .getDESCR();
                                                                        if (newType.equals("Mammal")) {
                                                                            System.out.printf("Updated!\n");

                                                                            break;
                                                                        } else if (newType.equals("Amphibian")) {
                                                                            Amphibian x = new Amphibian(a, b, c);
                                                                            admin.removeMammal(
                                                                                    admin.getMammals()
                                                                                            .get(animalNo - 1));
                                                                            admin.addAmphibian(x);
                                                                            System.out.printf("Updated!\n");
                                                                        } else if (newType.equals("Reptile")) {
                                                                            Reptile x = new Reptile(a, b, c);
                                                                            admin.removeMammal(
                                                                                    admin.getMammals()
                                                                                            .get(animalNo - 1));
                                                                            admin.addReptile(x);
                                                                            System.out.printf("Updated!\n");

                                                                        } else {
                                                                            System.out.printf("Invalid type\n");
                                                                        }

                                                                    }
                                                                } else {
                                                                    System.out.printf("Invalid number selected\n");
                                                                }
                                                                break;
                                                            case 2:
                                                                admin.viewReptiles();
                                                                System.out.printf(
                                                                        "Select Animal number to modify: ");
                                                                int animalNo2 = sc.nextInt();
                                                                sc.nextLine();
                                                                if (animalNo2 <= admin.getReptiles().size()) {
                                                                    if (updateAnimalChoice == 1) {
                                                                        System.out.printf("Enter new Name: ");
                                                                        String newName = sc.nextLine();
                                                                        admin.getReptiles().get(animalNo2 - 1)
                                                                                .setName(newName);
                                                                        System.out.printf("Animal Modified!\n");
                                                                    } else if (updateAnimalChoice == 2) {
                                                                        System.out.printf("Enter new Sound: ");
                                                                        String newSound2 = sc.nextLine();
                                                                        admin.getReptiles().get(animalNo2 - 1)
                                                                                .setSound(newSound2);
                                                                        System.out.printf("Animal sound Modified!\n");
                                                                    } else if (updateAnimalChoice == 3) {
                                                                        System.out.printf("Enter new Description: ");
                                                                        String newDESCR2 = sc.nextLine();
                                                                        admin.getReptiles().get(animalNo2 - 1)
                                                                                .setDESCR(newDESCR2);
                                                                        System.out.printf(
                                                                                "Animal description Modified!\n");
                                                                    } else if (updateAnimalChoice == 4) {
                                                                        System.out.printf("Enter new Animal type: ");
                                                                        String newType = sc.nextLine();
                                                                        String a = admin.getReptiles()
                                                                                .get(animalNo2 - 1).getName();
                                                                        String b = admin.getReptiles()
                                                                                .get(animalNo2 - 1).getSound();
                                                                        String c = admin.getReptiles()
                                                                                .get(animalNo2 - 1).getDESCR();
                                                                        if (newType.equals("Reptile")) {
                                                                            System.out.printf("Updated!\n");

                                                                            break;
                                                                        } else if (newType.equals("Amphibian")) {
                                                                            Amphibian x = new Amphibian(a, b, c);
                                                                            admin.removeReptile(
                                                                                    admin.getReptiles()
                                                                                            .get(animalNo2 - 1));
                                                                            admin.addAmphibian(x);
                                                                            System.out.printf("Updated!\n");

                                                                        } else if (newType.equals("Mammal")) {
                                                                            Mammal x = new Mammal(a, b, c);
                                                                            admin.removeReptile(
                                                                                    admin.getReptiles()
                                                                                            .get(animalNo2 - 1));
                                                                            admin.addMammal(x);
                                                                            System.out.printf("Updated!\n");

                                                                        } else {
                                                                            System.out.printf("Invalid type\n");
                                                                        }

                                                                    }
                                                                } else {
                                                                    System.out.printf("Invalid number selected\n");
                                                                }
                                                                break;
                                                            case 3:
                                                                admin.viewAmphibians();
                                                                System.out.printf(
                                                                        "Select Animal number to modify: ");
                                                                int animalNo3 = sc.nextInt();
                                                                sc.nextLine();
                                                                if (animalNo3 <= admin.getAmphibians().size()) {
                                                                    if (updateAnimalChoice == 1) {
                                                                        System.out.printf("Enter new name: ");
                                                                        String newName = sc.nextLine();
                                                                        admin.getAmphibians().get(animalNo3 - 1)
                                                                                .setName(newName);
                                                                        System.out.printf("Animal Modified!\n");
                                                                    } else if (updateAnimalChoice == 2) {
                                                                        System.out.printf("Enter new Sound: ");
                                                                        String newSound3 = sc.nextLine();
                                                                        admin.getAmphibians().get(animalNo3 - 1)
                                                                                .setSound(newSound3);
                                                                        System.out.printf("Animal sound Modified!\n");
                                                                    } else if (updateAnimalChoice == 3) {
                                                                        System.out.printf("Enter new Description: ");
                                                                        String newDESCR3 = sc.nextLine();
                                                                        admin.getAmphibians().get(animalNo3 - 1)
                                                                                .setDESCR(newDESCR3);
                                                                        System.out.printf(
                                                                                "Animal description Modified!\n");
                                                                    } else if (updateAnimalChoice == 4) {
                                                                        System.out.printf("Enter new Animal type: ");
                                                                        String newType = sc.nextLine();
                                                                        String a = admin.getAmphibians()
                                                                                .get(animalNo3 - 1).getName();
                                                                        String b = admin.getAmphibians()
                                                                                .get(animalNo3 - 1).getSound();
                                                                        String c = admin.getAmphibians()
                                                                                .get(animalNo3 - 1).getDESCR();
                                                                        if (newType.equals("Amphibian")) {
                                                                            System.out.printf("Updated!\n");

                                                                            break;
                                                                        } else if (newType.equals("Reptile")) {
                                                                            Reptile x = new Reptile(a, b, c);
                                                                            admin.removeAmphibian(
                                                                                    admin.getAmphibians()
                                                                                            .get(animalNo3 - 1));
                                                                            admin.addReptile(x);
                                                                            System.out.printf("Updated!\n");

                                                                        } else if (newType.equals("Mammal")) {
                                                                            Mammal x = new Mammal(a, b, c);
                                                                            admin.removeAmphibian(
                                                                                    admin.getAmphibians()
                                                                                            .get(animalNo3 - 1));
                                                                            admin.addMammal(x);
                                                                            System.out.printf("Updated!\n");
                                                                        } else {
                                                                            System.out.printf("Invalid type\n");
                                                                        }

                                                                    }
                                                                } else {
                                                                    System.out.printf("Invalid number selected\n");
                                                                }
                                                                break;
                                                            default:
                                                                System.out.printf("Invalid Command!\n");
                                                                break;
                                                        }
                                                    } else if (updateAnimalChoice == 5) {
                                                        break;
                                                    } else {
                                                        System.out.printf("Invalid Command!\n");
                                                    }
                                                }
                                            case 3:
                                                System.out.printf(
                                                        "Select Animal Type no. to remove:\n1.Mammal\n2.Reptile\n3.Amphibian\n");
                                                int animalTypeNo = sc.nextInt();
                                                sc.nextLine();
                                                switch (animalTypeNo) {
                                                    case 1:
                                                        admin.viewMammals();
                                                        System.out.printf("Select Animal number to remove: ");
                                                        int animalNo = sc.nextInt();
                                                        sc.nextLine();
                                                        if (animalNo <= admin.getMammals().size()) {
                                                            admin.removeMammal(
                                                                    admin.getMammals().get(animalNo - 1));
                                                            System.out.printf("Animal Removed!\n");
                                                        } else {
                                                            System.out.printf("Invalid number selected\n");
                                                        }
                                                        break;
                                                    case 2:
                                                        admin.viewReptiles();
                                                        System.out.printf("Select Animal number to remove: ");
                                                        int animalNo2 = sc.nextInt();
                                                        sc.nextLine();
                                                        if (animalNo2 <= admin.getReptiles().size()) {
                                                            admin.removeReptile(
                                                                    admin.getReptiles().get(animalNo2 - 1));
                                                            System.out.printf("Animal Removed!\n");
                                                        } else {
                                                            System.out.printf("Invalid number selected\n");
                                                        }
                                                        break;
                                                    case 3:
                                                        admin.viewAmphibians();
                                                        System.out.printf("Select Animal number to remove: ");
                                                        int animalNo3 = sc.nextInt();
                                                        sc.nextLine();
                                                        if (animalNo3 <= admin.getAmphibians().size()) {
                                                            admin.removeAmphibian(
                                                                    admin.getAmphibians().get(animalNo3 - 1));
                                                            System.out.printf("Animal Removed!\n");
                                                        } else {
                                                            System.out.printf("Invalid number selected\n");
                                                        }
                                                        break;
                                                    default:
                                                        System.out.printf("Invalid Command!\n");
                                                        break;
                                                }
                                                break;
                                            case 4:
                                                break;
                                            default:
                                                System.out.printf("Invalid Command!\n");
                                                break;
                                        }
                                        if (manageAnimalChoice == 4) {
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    while (true) {
                                        System.out.printf("Schedule Events:\n" + //
                                                "1. Modify Event (open/close)\n" + //
                                                "2. Change Price\n" + //
                                                "3. Exit\n");
                                        int scheduleEventChoice = sc.nextInt();
                                        sc.nextLine();
                                        switch (scheduleEventChoice) {
                                            case 1:
                                                admin.viewAttractions();
                                                System.out.printf("Enter attraction no. to modify: ");
                                                int attractionNo = sc.nextInt();
                                                sc.nextLine();
                                                if (attractionNo <= admin.getAttraction().size()) {
                                                    System.out.printf("Enter Modified status: ");
                                                    String status = sc.nextLine();
                                                    admin.getAttraction().get(attractionNo - 1).setStatus(status);
                                                    System.out.printf("Attraction Modified!\n");
                                                } else {
                                                    System.out.printf("Invalid number selected\n");
                                                }
                                                break;
                                            case 2:
                                                admin.viewAttractions();
                                                System.out.printf("Enter attraction no. to change price: ");
                                                int attractionNo2 = sc.nextInt();
                                                sc.nextLine();
                                                if (attractionNo2 <= admin.getAttraction().size()) {
                                                    System.out.printf("Enter new price: ");
                                                    int p = sc.nextInt();
                                                    sc.nextLine();
                                                    admin.getAttraction().get(attractionNo2 - 1).setPrice(p);
                                                    System.out.printf("Attraction price changed\n");
                                                } else {
                                                    System.out.printf("Invalid number selected\n");
                                                }
                                                break;
                                            case 3:
                                                break;
                                            default:
                                                System.out.printf("Invalid Command!\n");
                                                break;
                                        }
                                        if (scheduleEventChoice == 3) {
                                            break;
                                        }
                                    }
                                    break;
                                case 4:
                                    while (true) {
                                        System.out.printf("Set Discounts:\n" + //
                                                "1. Add Discount\n" + //
                                                "2. Modify Discount\n" + //
                                                "3. Remove Discount\n" + //
                                                "4. Exit\n");
                                        int setDiscountChoice = sc.nextInt();
                                        sc.nextLine();
                                        switch (setDiscountChoice) {
                                            case 1:
                                                System.out.printf("Enter Discount Category: ");
                                                String category = sc.nextLine();
                                                System.out.printf("Enter Discount Percentage :");
                                                int percentage = sc.nextInt();
                                                sc.nextLine();
                                                Coupon cNew = new Coupon(category + percentage, percentage, category);
                                                admin.addCoupon(cNew);
                                                break;
                                            case 2:
                                                admin.viewCoupons();
                                                System.out.printf("Select Discount number to modify: ");
                                                int discountNo = sc.nextInt();
                                                sc.nextLine();
                                                if (discountNo <= admin.getCoupons().size()) {
                                                    System.out.printf(
                                                            "Modify Discount:\n1.Change Category\n2.Change Percentage3.Back\n");
                                                    int modifyDiscountChoice = sc.nextInt();
                                                    sc.nextLine();
                                                    switch (modifyDiscountChoice) {
                                                        case 1:
                                                            System.out.printf("Enter new category: ");
                                                            String newCategory = sc.nextLine();
                                                            admin.getCoupons().get(discountNo - 1)
                                                                    .setName(newCategory
                                                                            + admin.getCoupons().get(discountNo - 1)
                                                                            .getDiscount());
                                                            admin.getCoupons().get(discountNo - 1)
                                                                    .setCategory(newCategory);
                                                            System.out.printf("Discount Modified!\n");
                                                            break;
                                                        case 2:
                                                            System.out.printf("Enter new percentage: ");
                                                            int newPercentage = sc.nextInt();
                                                            sc.nextLine();
                                                            admin.getCoupons().get(discountNo - 1)
                                                                    .setName(admin.getCoupons().get(discountNo - 1)
                                                                            .getCategory()
                                                                            + newPercentage);
                                                            admin.getCoupons().get(discountNo - 1)
                                                                    .setDiscount(newPercentage);
                                                            System.out.printf("Discount Modified!\n");
                                                            break;
                                                        case 3:
                                                            break;
                                                        default:
                                                            System.out.printf("Invalid Command!\n");
                                                            break;
                                                    }
                                                } else {
                                                    System.out.printf("Invalid number selected\n");
                                                }
                                                break;
                                            case 3:
                                                admin.viewCoupons();
                                                System.out.printf("Select Discount number to remove: ");
                                                int discountNo2 = sc.nextInt();
                                                sc.nextLine();
                                                if (discountNo2 <= admin.getCoupons().size()) {
                                                    admin.removeCoupon(admin.getCoupons().get(discountNo2 - 1));
                                                    System.out.printf("Discount Removed!\n");
                                                } else {
                                                    System.out.printf("Invalid number selected\n");
                                                }
                                                break;
                                            case 4:
                                                break;
                                        }
                                        if (setDiscountChoice == 4) {
                                            break;
                                        }
                                    }
                                    break;
                                case 5:
                                    System.out.printf("Set Special Deals\n1.Add Deal\n2.Remove Deal");
                                    int dealChoice = sc.nextInt();
                                    sc.nextLine();
                                    switch (dealChoice) {
                                        case 1:
                                            System.out.printf("Enter Deal Discount: ");
                                            int dealDiscount = sc.nextInt();
                                            sc.nextLine();
                                            System.out.printf("Minimum tickets/attractions required: ");
                                            int dealTickets = sc.nextInt();
                                            sc.nextLine();
                                            Deal d = new Deal(dealTickets, dealDiscount);
                                            admin.addDeal(d);
                                            System.out.printf("Deal Added Successfully!\n");
                                            break;
                                        case 2:
                                            admin.viewDeals();
                                            System.out.printf("Select Deal number to remove: ");
                                            int dealNo = sc.nextInt();
                                            sc.nextLine();
                                            if (dealNo <= admin.getDeals().size()) {
                                                admin.removeDeal(admin.getDeals().get(dealNo - 1));
                                                System.out.printf("Deal Removed!\n");
                                            } else {
                                                System.out.printf("Invalid number selected\n");
                                            }
                                            break;
                                        default:
                                            System.out.printf("Invalid Command!\n");
                                            break;
                                    }
                                    break;
                                case 6:
                                    System.out.print("Visitor Stats:\n");
                                    System.out.println("Total Visitors: " + admin.getVisitors().size());
                                    System.out.println("Total Revenue: " + admin.getRevenue());
                                    System.out.println("Popular Attractions :");
                                    admin.viewAttractions();
                                    break;
                                case 7:
                                    admin.viewFeedbacks();
                                    break;
                                case 8:
                                    break;
                                default:
                                    System.out.printf("Invalid Command!\n");
                                    break;
                            }
                            if (adminChoice == 8) {
                                break;
                            }
                        }
                    } else {
                        System.out.printf("Login Failed!\n");
                        break;
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.printf("1.Register\n2.Login\n3.Back\n");
                        int visitorChoice = sc.nextInt();
                        sc.nextLine();
                        switch (visitorChoice) {
                            case 1:
                                System.out.printf("Enter Visitor Name: ");
                                String name = sc.nextLine();
                                System.out.printf("Enter Visitor Age: ");
                                int age = sc.nextInt();
                                sc.nextLine();
                                System.out.printf("Enter Visitor Phone Number: ");
                                String phone = sc.nextLine();
                                System.out.printf("Enter Visitor Balance: ");
                                float balance = sc.nextFloat();
                                sc.nextLine();
                                System.out.printf("Enter Visitor Email: ");
                                String email = sc.nextLine();
                                System.out.printf("Enter Visitor Password: ");
                                String password = sc.nextLine();
                                Visitor v = new Visitor(name, age, phone, balance, email, password);
                                admin.addVisitor(v);
                                System.out.printf("Registration is Successful!\n");
                                break;
                            case 2:
                                System.out.printf("Enter Below Details for logging in\n");
                                System.out.printf("Enter Visitor email: ");
                                String loginEmail = sc.nextLine();
                                System.out.printf("Enter Visitor password: ");
                                String loginPass = sc.nextLine();
                                int found = 0;
                                for (Visitor x : admin.getVisitors()) {
                                    if (x.getEmail().equals(loginEmail) && x.getPass().equals(loginPass)) {
                                        found = 1;
                                        System.out.printf("Login Successful!\n");
                                        while (true) {
                                            System.out.printf("1. Explore the Zoo\n" + //
                                                    "2. Buy Membership\n" + //
                                                    "3. Buy Tickets\n" + //
                                                    "4. View Discounts\n" + //
                                                    "5. View Special Deals\n" + //
                                                    "6. Visit Animals\n" + //
                                                    "7. Visit Attractions\n" + //
                                                    "8. Leave Feedback\n" + //
                                                    "9. Log Out\n");
                                            int visitorMenuChoice = sc.nextInt();
                                            sc.nextLine();
                                            switch (visitorMenuChoice) {
                                                case 1:
                                                    while (true) {
                                                        System.out.printf("Explore the Zoo:\r\n" + //
                                                                "1. View Attractions\r\n" + //
                                                                "2. View Animals\r\n" + //
                                                                "3. Exit\r\n" + //
                                                                "");
                                                        int exploreChoice = sc.nextInt();
                                                        sc.nextLine();
                                                        switch (exploreChoice) {
                                                            case 1:
                                                                System.out.printf("Attractions:\n");
                                                                int count = 1;
                                                                for (Attraction a : admin.getAttraction()) {
                                                                    System.out
                                                                            .println(count + ". " + a.getName() + " " + a.getDESCR());
                                                                    count++;
                                                                }
                                                                break;
                                                            case 2:
                                                                admin.viewAnimals();
                                                                break;
                                                            case 3:
                                                                break;
                                                            default:
                                                                System.out.printf("Invalid Command!\n");
                                                                break;
                                                        }
                                                        if (exploreChoice == 3) {
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.printf("Buy Membership:\n");
                                                    System.out.printf("1.Basic\n2.Premium\n");
                                                    int membershipChoice = sc.nextInt();
                                                    sc.nextLine();
                                                    float rev = -1;
                                                    if (!x.getMembership().equals("NONE")) {
                                                        System.out.printf("You already have a membership!\n");
                                                        break;
                                                    } else if (membershipChoice == 1) {
                                                        rev = x.buyMembership("Basic");
                                                        if (rev != -1) {
                                                            admin.addRevenue(rev);
                                                        }
                                                    } else if (membershipChoice == 2) {
                                                        rev = x.buyMembership("Premium");
                                                        if (rev != -1) {
                                                            admin.addRevenue(rev);
                                                        }
                                                    } else {
                                                        System.out.printf("Invalid Command!\n");
                                                    }
                                                    break;
                                                case 3:
                                                    if (x.getMembership().equals("Premium")) {
                                                        System.out.printf(
                                                                "You have premium , you dont need to buy tickets!\n");
                                                        break;
                                                    } else if (x.getMembership().equals("NONE")) {
                                                        System.out.printf(
                                                                "You dont have membership, you need to buy one either basic or premium!\n");
                                                        break;
                                                    } else if (x.getMembership().equals("Basic")) {
                                                        System.out.printf("Buy Tickets:\n");
                                                        admin.viewAttractions();
                                                        System.out.printf("Select which attraction to buy\n");
                                                        int attractionNo = sc.nextInt();
                                                        sc.nextLine();
                                                        if (attractionNo <= admin.getAttraction().size()) {
                                                            System.out.printf("Enter no. of tickets to buy: ");
                                                            int tickets = sc.nextInt();
                                                            sc.nextLine();
                                                            float revenue = -1;
                                                            Deal dummy = new Deal(-1, 0);
                                                            int tester = -1;
                                                            admin.sortDeals();
                                                            for (Deal d : admin.getDeals()) {
                                                                if (d.getMinTicket() <= tickets) {
                                                                    System.out.println("You get " + d.getDiscount()
                                                                            + "% off on this deal\n");
                                                                    revenue = x.buyTickets(
                                                                            admin.getAttraction().get(attractionNo - 1),
                                                                            tickets, d);
                                                                    tester = 1;
                                                                    break;
                                                                }
                                                            }
                                                            if (tester == -1) {
                                                                revenue = x.buyTickets(
                                                                        admin.getAttraction().get(attractionNo - 1),
                                                                        tickets, dummy);
                                                            }
                                                            if (revenue != -1) {
                                                                admin.addRevenue(revenue);
                                                            }
                                                        } else {
                                                            System.out.printf("Invalid number selected\n");
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.printf("Discounts you can enjoy: ");
                                                    for (Coupon c : x.getCoupons()) {
                                                        System.out.println(c.getName() + "-> " + c.getDiscount() + "%");
                                                    }
                                                    break;
                                                case 5:
                                                    System.out.printf("Special Deals you can enjoy: ");
                                                    for (Deal d : admin.getDeals()) {
                                                        System.out.println(d.getDiscount() + "% off on "
                                                                + d.getMinTicket() + " tickets/attractions");
                                                    }
                                                    break;
                                                case 6:
                                                    while (true) {
                                                        System.out.printf(" Select One\n" + //
                                                                "1. Feed Animals\n" + //
                                                                "2. Read Animals\n" + //
                                                                "3. Exit\n");
                                                        int visitAnimalChoice = sc.nextInt();
                                                        sc.nextLine();
                                                        switch (visitAnimalChoice) {
                                                            case 1:
                                                                admin.viewAnimals();
                                                                System.out.printf("Select Animal number to feed: ");
                                                                int animalNo = sc.nextInt();
                                                                sc.nextLine();
                                                                if (animalNo <= admin.getTotalAnimals()) {
                                                                    int count = 1;
                                                                    for (Mammal m : admin.getMammals()) {
                                                                        if (count == animalNo) {
                                                                            System.out.println("Name: " + m.getName()
                                                                                    + "-> " + m.getSound() + "!" + " Thanks for feeding");
                                                                            count = -100;
                                                                            break;
                                                                        }
                                                                        count++;
                                                                    }
                                                                    for (Reptile m : admin.getReptiles()) {
                                                                        if (count == animalNo) {
                                                                            System.out.println("Name: " + m.getName()
                                                                                    + "-> " + m.getSound() + "!" + " Thanks for feeding");
                                                                            count = -100;
                                                                            break;
                                                                        }
                                                                        count++;
                                                                    }
                                                                    for (Amphibian m : admin.getAmphibians()) {
                                                                        if (count == animalNo) {
                                                                            System.out.println("Name: " + m.getName()
                                                                                    + "-> " + m.getSound() + "!" + " Thanks for feeding");
                                                                            break;

                                                                        }
                                                                        count++;
                                                                    }
                                                                } else {
                                                                    System.out.printf("Invalid number selected\n");
                                                                }
                                                                break;
                                                            case 2:
                                                                admin.viewAnimals();
                                                                System.out.printf("Select Animal number to read: ");
                                                                int animalNo2 = sc.nextInt();
                                                                sc.nextLine();
                                                                if (animalNo2 <= admin.getTotalAnimals()) {
                                                                    int count = 1;
                                                                    for (Mammal m : admin.getMammals()) {
                                                                        if (count == animalNo2) {
                                                                            System.out.println("Name: " + m.getName()
                                                                                    + "-> " + m.getDESCR());
                                                                            count = -10;
                                                                            break;
                                                                        }
                                                                        count++;
                                                                    }
                                                                    for (Reptile m : admin.getReptiles()) {
                                                                        if (count == animalNo2) {
                                                                            System.out.println("Name: " + m.getName()
                                                                                    + "-> " + m.getDESCR());
                                                                            count = -10;
                                                                            break;
                                                                        }
                                                                        count++;
                                                                    }
                                                                    for (Amphibian m : admin.getAmphibians()) {
                                                                        if (count == animalNo2) {
                                                                            System.out.println("Name: " + m.getName()
                                                                                    + "-> " + m.getDESCR());
                                                                            count = -10;
                                                                            break;
                                                                        }
                                                                        count++;
                                                                    }
                                                                } else {
                                                                    System.out.printf("Invalid number selected\n");
                                                                }
                                                                break;
                                                            case 3:
                                                                break;
                                                            default:
                                                                System.out.printf("Invalid Command!\n");
                                                                break;
                                                        }
                                                        if (visitAnimalChoice == 3) {
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case 7:
                                                    System.out.printf("Attractions: \n");
                                                    admin.viewAttractions();
                                                    System.out.printf("Which attraction number to visit: ");
                                                    int attractionNo = sc.nextInt();
                                                    sc.nextLine();
                                                    if (attractionNo <= admin.getAttraction().size()) {
                                                        int check = x.visitAttraction(
                                                                admin.getAttraction().get(attractionNo - 1));
                                                        if (check == -1) {
                                                            System.out.printf(
                                                                    "You dont have tickets for this attraction\n");
                                                        } else {

                                                        }
                                                    } else {
                                                        System.out.printf("Invalid number selected\n");
                                                    }
                                                    break;
                                                case 8:
                                                    System.out.printf("Write Feedback : ");
                                                    String feedback = sc.nextLine();
                                                    x.giveFeedback(feedback);
                                                    break;
                                                case 9:
                                                    break;
                                                default:
                                                    System.out.printf("Invalid Command!\n");
                                                    break;
                                            }
                                            if (visitorMenuChoice == 9) {
                                                break;
                                            }
                                        }
                                    } else {
                                        System.out.printf("Login Failed!\n");
                                    }
                                }
                                break;
                            case 3:
                                break;
                        }
                        if (visitorChoice == 3) {
                            break;
                        }
                    }
                    break;
                case 3:
                    admin.viewDeals();
                    break;
                case 4:
                    break;
                default:
                    System.out.printf("Invalid Command!\n");
                    break;
            }
            if (choice == 4) {
                System.out.printf("Exiting!\n");
                break;
            }
        }
        sc.close();
    }
}
