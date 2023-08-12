package edu.iviettech.asgrestfulapi.validator;

import edu.iviettech.asgrestfulapi.model.CreditCard;
import edu.iviettech.asgrestfulapi.model.Payment;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PaymentValidation {
    public Boolean checkValidMonthNumberAndYearNumber(String year,String month){
        return (ValidationMonthNumber.checkInvalidMonth(month)
                    && ValidationYearNumber.checkInvalidYearNumber(year));
    }

    public Boolean checkAmountCreditCard(Double amountPayment, Double amountCreditCard){
        return amountCreditCard >= amountPayment;
    }
}
