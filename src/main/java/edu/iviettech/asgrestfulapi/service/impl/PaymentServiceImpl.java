package edu.iviettech.asgrestfulapi.service.impl;

import edu.iviettech.asgrestfulapi.entity.CreditCardEntity;
import edu.iviettech.asgrestfulapi.entity.TransactionLogEntity;
import edu.iviettech.asgrestfulapi.model.Payment;
import edu.iviettech.asgrestfulapi.model.TransactionLog;
import edu.iviettech.asgrestfulapi.repository.CreditCardRepository;
import edu.iviettech.asgrestfulapi.repository.TransactionLogRepository;
import edu.iviettech.asgrestfulapi.service.PaymentService;
import edu.iviettech.asgrestfulapi.validator.PaymentValidation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final CreditCardRepository creditCardRepository;
    private final TransactionLogRepository logRepository;
    private final ModelMapper modelMapper;
    private final PaymentValidation paymentValidation;

    public PaymentServiceImpl(CreditCardRepository creditCardRepository, TransactionLogRepository logRepository, ModelMapper modelMapper, PaymentValidation paymentValidation) {
        this.creditCardRepository = creditCardRepository;
        this.logRepository = logRepository;
        this.modelMapper = modelMapper;
        this.paymentValidation = paymentValidation;
    }

    @Transactional
    @Override
    public TransactionLog addAPayment(Payment paymentInfor) throws IllegalAccessException {
        if(!creditCardRepository.existsByCardNumber(paymentInfor.getCardNumber())){
            throw new IllegalAccessException("CardNumber Not Exists!");
        }
        if(!paymentValidation.checkValidMonthNumberAndYearNumber(paymentInfor.getValidYearNumber(),
                paymentInfor.getValidMonthNumber())){
            throw new RuntimeException("Invalid Month-YearNumber");
        }

        CreditCardEntity cardEntity = creditCardRepository.findByCardNumber(paymentInfor.getCardNumber())
                                            .orElseThrow(()->new RuntimeException("Not Found CreditCard"));

        if(!paymentValidation.checkAmountCreditCard(
                paymentInfor.getPaymentAmount(),cardEntity.getAmount())){
            throw new RuntimeException("Invalid Amount Of CreditCard");
        }

        creditCardRepository.setAmountAfterPayment(cardEntity.getId(),paymentInfor.getPaymentAmount());

        TransactionLogEntity logEntity = new TransactionLogEntity();
        logEntity.setPaymentDate(LocalDateTime.now());
        logEntity.setAmount(paymentInfor.getPaymentAmount());
        logEntity.setDescription(paymentInfor.getDescription());
        logEntity.setCreditCard(cardEntity);

        logRepository.save(logEntity);
        return modelMapper.map(logEntity,TransactionLog.class);
    }
}
