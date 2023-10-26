package org.example;

import java.util.Comparator;

public class DealComparator implements Comparator<Deal> {
    public int compare(Deal d1, Deal d2) {
        int numTicketsComparison = Integer.compare(d1.getMinTicket(), d2.getMinTicket());
        if (numTicketsComparison != 0) {
            return numTicketsComparison;
        }
        return Float.compare(d2.getDiscount(), d1.getDiscount());
    }
}
