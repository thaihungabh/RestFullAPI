package edu.iviettech.asgrestfulapi.validator;

import java.time.LocalDate;

public class ValidationYearNumber {
    public static Boolean checkInvalidYearNumber(String year){
        Integer currenYear = LocalDate.now().getYear();
        return Integer.valueOf(year) >= currenYear ? true:false;
    }
}
