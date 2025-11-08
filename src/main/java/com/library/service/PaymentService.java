package com.library.service;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private Map<String, Double> memberPayments = new HashMap<>();

    public void recordPayment(String memberId, double amount) {
        memberPayments.put(memberId, memberPayments.getOrDefault(memberId, 0.0) + amount);
        System.out.println("Payment recorded for member: " + memberId + " | Total: " + memberPayments.get(memberId));
        System.out.println("Thank you for your payment!");
    }

    public double getTotalPaid(String memberId) {
        return memberPayments.getOrDefault(memberId, 0.0);
    }

    public void refundPayment(String memberId, double amount) {
        if (memberPayments.containsKey(memberId)) {
            double current = memberPayments.get(memberId);
            double newAmount = Math.max(0, current - amount);
            memberPayments.put(memberId, newAmount);
            System.out.println("Refunded " + amount + " for member: " + memberId + " | New Total: " + newAmount);
        } else {
            System.out.println("No payment found for member: " + memberId);
        }
    }
}
