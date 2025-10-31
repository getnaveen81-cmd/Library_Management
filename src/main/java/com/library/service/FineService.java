package com.library.service;

import com.library.model.Member;

import java.util.HashMap;
import java.util.Map;

public class FineService {
    private Map<String, Double> fines = new HashMap<>();

    public void addFine(Member member, double amount) {
        fines.put(member.getMemberId(), fines.getOrDefault(member.getMemberId(), 0.0) + amount);
        System.out.println("Fine added for " + member.getName() + ": ₹" + amount);
    }

    public void payFine(Member member, double amount) {
        double currentFine = fines.getOrDefault(member.getMemberId(), 0.0);
        if (amount >= currentFine) {
            fines.remove(member.getMemberId());
            System.out.println(member.getName() + " cleared all fines!");
        } else {
            fines.put(member.getMemberId(), currentFine - amount);
            System.out.println(member.getName() + " paid ₹" + amount + ". Remaining fine: ₹" + (currentFine - amount));
        }
    }

    public void showAllFines() {
        System.out.println("\n💰 Fines Summary:");
        fines.forEach((memberId, fine) -> System.out.println("Member ID: " + memberId + " → ₹" + fine));
    }
}
