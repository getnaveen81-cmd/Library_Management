package com.library.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LateFeeCalculator {

    private static final double DAILY_LATE_FEE = 20.0; // ₹5 per day late

    public double calculateLateFee(LocalDate dueDate, LocalDate returnDate) {
        if (returnDate.isBefore(dueDate) || returnDate.isEqual(dueDate)) {
            return 0.0;
        }
        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        return daysLate * DAILY_LATE_FEE;
    }
}
