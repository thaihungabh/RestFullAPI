package edu.iviettech.asgrestfulapi.service;

import edu.iviettech.asgrestfulapi.model.CreditCard;

import java.util.Optional;

public interface CreditCardService {
    CreditCard insertCreditCard(CreditCard creditCard) throws IllegalArgumentException;
    Optional<CreditCard> getCreditCardById(Long id);
}
