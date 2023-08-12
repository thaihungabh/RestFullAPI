package edu.iviettech.asgrestfulapi.validator;

import java.time.LocalDate;

public class ValidationMonthNumber {
    public static Boolean checkInvalidMonth(String month){
        Integer currentMonth = LocalDate.now().getMonthValue();
        return Integer.valueOf(month) >= currentMonth ? true:false;
    }
}
