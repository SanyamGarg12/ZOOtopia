package org.example;

public class Deal {
    private int minTickets;
    private float dealDiscount;

    public Deal(int dealTickets, float dealDiscount) {
        this.dealDiscount = dealDiscount;
        this.minTickets = dealTickets;
    }

    public void view() {
        System.out.println("Minimum Tickets: " + this.minTickets + " Discount: " + this.dealDiscount);
    }

    public void view(int ind) {
        System.out.println(ind + ". Minimum Tickets: " + this.minTickets + " Discount: " + this.dealDiscount);
    }

    public void setDiscount(float dealDiscount) {
        this.dealDiscount = dealDiscount;
    }

    public void setMinTicket(int minTickets) {
        this.minTickets = minTickets;
    }

    public float getDiscount() {
        return this.dealDiscount;
    }
    public int getMinTicket() {
        return this.minTickets;
    }
}
