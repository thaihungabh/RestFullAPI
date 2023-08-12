package edu.iviettech.asgrestfulapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transaction_log")
public class TransactionLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;
    private Double amount;
    private String description;
    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    CreditCardEntity creditCard;
}
