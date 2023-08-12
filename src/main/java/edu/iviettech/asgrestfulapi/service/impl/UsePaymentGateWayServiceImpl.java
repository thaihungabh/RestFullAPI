package edu.iviettech.asgrestfulapi.service.impl;

import edu.iviettech.asgrestfulapi.model.Payment;
import edu.iviettech.asgrestfulapi.model.TransactionLog;
import edu.iviettech.asgrestfulapi.service.UsePaymentGateWayService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsePaymentGateWayServiceImpl implements UsePaymentGateWayService {
    private final RestTemplate restTemplate;

    public UsePaymentGateWayServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public TransactionLog payment(Payment payment) {
        return restTemplate.postForObject("/payment", payment, TransactionLog.class);
    }
}
