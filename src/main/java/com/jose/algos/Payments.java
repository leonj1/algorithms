package com.jose.algos;

import com.jose.algos.models.Account;
import com.jose.algos.models.LargestAccountFirstComparator;
import com.jose.algos.models.SmallestAccountFirstComparator;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * This class exists to test a theory that paying off credit cards by largest vs smallest balances is better.
 * Its not. Paying by smallest balances is better since as time goes on your payments become larger and pay off the larger cards faster.
 * 
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2018
 **/
public class Payments {
    public static void main(String[] args) {
        Queue<Account> q = new PriorityQueue<>(5, new SmallestAccountFirstComparator());
//        Queue<Account> q = new PriorityQueue<>(5, new LargestAccountFirstComparator());
        q.add(new Account("sapphire", 8800, 24.24f));
        q.add(new Account("lasik", 3700, 24.99f));
        q.add(new Account("amazon", 2500, 23.49f));
        q.add(new Account("Capital One", 49.60f, 23.49f));
        q.add(new Account("Credit One", 135.94f, 23.49f));

        float paycheck;
        int minimumPayment = 100;
        int numOfPayPeriods = 0;
        float totalInterestPaid = 0f;

        Stack<Account> paidAccounts = new Stack<>();
        Iterator qit;
        Iterator it;
        qit = q.iterator();

        while(qit.hasNext()) {
            numOfPayPeriods++;
            paycheck = 800f;
            while (paycheck > 0 && q.size() > 0) {
                Account account = q.remove();
//                System.out.println(String.format("Account: %s Balance: %.2f", account.name(), account.balance()));
                int minPaymentSetAsideForMinPaymentAccounts = q.size() * minimumPayment;
                float amountToPay = paycheck - minPaymentSetAsideForMinPaymentAccounts;
                paycheck -= amountToPay;
                paycheck += account.payment(amountToPay);
                if (account.balance() == 0) {
                    System.out.println(String.format("PAID OFF: %s Interest paid: %.2f Num payments: %d", account.name(), account.interestPaid(), account.numPayments()));
                    totalInterestPaid += account.interestPaid();
                } else {
//                    System.out.println(String.format("Account: %s Balance: %d Interest paid: %f Num payments: %d", account.name(), account.balance(), account.interestPaid(), account.numPayments()));
                    paidAccounts.push(account);
                }
            }
//            System.out.println("Exhausted paycheck");
//            System.out.println("******************");
            if (paidAccounts.size() == 0) {
                break;
            }
            it = paidAccounts.iterator();
            while (it.hasNext()) {
                Account account = (Account) it.next();
                account.calculateInterest();
                q.add(account);
            }
            paidAccounts.clear();
        }
        System.out.println(String.format("Num pay periods: %d Total interest paid: %.2f", numOfPayPeriods, totalInterestPaid));
    }
}
