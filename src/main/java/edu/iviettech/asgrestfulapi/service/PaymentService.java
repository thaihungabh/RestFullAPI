package edu.iviettech.asgrestfulapi.service;

import edu.iviettech.asgrestfulapi.model.Payment;
import edu.iviettech.asgrestfulapi.model.TransactionLog;

public interface PaymentService {
    TransactionLog addAPayment(Payment paymentInfor) throws IllegalAccessException;
}
