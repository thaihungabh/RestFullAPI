package edu.iviettech.asgrestfulapi.service;

import edu.iviettech.asgrestfulapi.model.Payment;
import edu.iviettech.asgrestfulapi.model.TransactionLog;

public interface UsePaymentGateWayService {
    TransactionLog payment(Payment payment);
}
