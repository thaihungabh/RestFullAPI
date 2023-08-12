package edu.iviettech.asgrestfulapi.model;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;


@Data
public class CreditCard {
    private Long id;
    @Pattern(regexp = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14})$",
            message = "13 digits with fist number:[4] Or 16 digits with first number: [5] & second number:[1-5]")
    private String cardNumber;

    @Pattern(regexp = "^(0?[1-9]|1[012])$",
            message = "0-12")
    private String validMonthNumber;

    @Pattern(regexp = "^(?:19|20)\\d{2}$",
            message = "1900 - 2099")
    private String validYearNumber;

    @Pattern(regexp = "^[0-9]{6}$",
            message = "Must have 6 digits")
    private String securityCode;
    private Double amount;
    private List<TransactionLog> transactionLogs;
}
