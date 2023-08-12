package edu.iviettech.asgrestfulapi.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionLog {
    private Long id;
    private LocalDateTime paymentDate;
    private Double amount;
    private String description;
    private Long creditCardId;
}
