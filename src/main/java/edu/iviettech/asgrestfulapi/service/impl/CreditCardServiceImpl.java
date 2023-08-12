package edu.iviettech.asgrestfulapi.service.impl;


import edu.iviettech.asgrestfulapi.entity.CreditCardEntity;
import edu.iviettech.asgrestfulapi.model.CreditCard;
import edu.iviettech.asgrestfulapi.repository.CreditCardRepository;
import edu.iviettech.asgrestfulapi.service.CreditCardService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    private final ModelMapper modelMapper;

    private final CreditCardRepository creditCardRepository;

    public CreditCardServiceImpl(ModelMapper modelMapper, CreditCardRepository creditCardRepository) {
        this.modelMapper = modelMapper;
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public CreditCard insertCreditCard(CreditCard creditCard) throws IllegalArgumentException {
        if(creditCardRepository.existsByCardNumber(creditCard.getCardNumber())){
            throw new IllegalArgumentException("CardNumber's Already Exists");
        }
        CreditCardEntity creditCardEntity = modelMapper.map(creditCard, CreditCardEntity.class);
        CreditCardEntity savedCard = creditCardRepository.save(creditCardEntity);
        return modelMapper.map(savedCard,CreditCard.class);
    }

    @Override
    public Optional<CreditCard> getCreditCardById(Long id) {
        CreditCardEntity cardEntity = creditCardRepository.findById(id)
                                    .orElse(null);
        CreditCard creditCard = modelMapper.map(cardEntity,CreditCard.class);
        return Optional.ofNullable(creditCard);
    }
}
