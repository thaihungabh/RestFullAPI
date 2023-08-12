package edu.iviettech.asgrestfulapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "valid_month_number")
    private String validMonthNumber;
    @Column(name = "valid_year_number")
    private String validYearNumber;
    private String securityCode;
    private Double amount;

    @OneToMany(mappedBy = "creditCard",
                fetch = FetchType.EAGER)
    List<TransactionLogEntity> transactionLogs;
}
