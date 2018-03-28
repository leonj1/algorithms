package com.jose.algos.models;

import java.util.Comparator;

/**
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2018
 **/
public class LargestAccountFirstComparator implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        if (o1.balance() < o2.balance()) {
            return 1;
        } else if (o1.balance() > o2.balance()) {
            return -1;
        }
        return 0;
    }
}
