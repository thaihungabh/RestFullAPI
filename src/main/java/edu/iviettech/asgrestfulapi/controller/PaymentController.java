package edu.iviettech.asgrestfulapi.controller;

import edu.iviettech.asgrestfulapi.model.Payment;
import edu.iviettech.asgrestfulapi.model.TransactionLog;
import edu.iviettech.asgrestfulapi.service.UsePaymentGateWayService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("payment")
public class PaymentController {
    private final UsePaymentGateWayService usePaymentGateWayService;

    public PaymentController(UsePaymentGateWayService usePaymentGateWayService) {
        this.usePaymentGateWayService = usePaymentGateWayService;
    }

    @GetMapping("")
    public String getFormPayment(@ModelAttribute Payment payment,
                                 Model model){
        model.addAttribute("payment_information", payment);
        return "paymentGateWay/paymentForm";
    }
    @PostMapping("letPayment")
    public String letPayment(@ModelAttribute @Valid Payment payment,
                             Model model){
        TransactionLog log = usePaymentGateWayService.payment(payment);
        model.addAttribute("paymentInfor",log);
        return "paymentGateWay/thank";
    }
}
