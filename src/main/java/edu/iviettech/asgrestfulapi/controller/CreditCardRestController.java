package edu.iviettech.asgrestfulapi.controller;

import edu.iviettech.asgrestfulapi.model.CreditCard;
import edu.iviettech.asgrestfulapi.model.Payment;
import edu.iviettech.asgrestfulapi.model.ResponseObject;
import edu.iviettech.asgrestfulapi.model.TransactionLog;
import edu.iviettech.asgrestfulapi.service.CreditCardService;
import edu.iviettech.asgrestfulapi.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/v1/payment-gateway")
public class CreditCardRestController {
    private final PaymentService paymentService;
    private final CreditCardService creditCardService;

    public CreditCardRestController(PaymentService paymentService, CreditCardService creditCardService) {
        this.paymentService = paymentService;
        this.creditCardService = creditCardService;
    }

    @PostMapping("payment")
    ResponseEntity<ResponseObject> addAPayment(@RequestBody @Valid Payment payment)
                        throws IllegalAccessException {
        TransactionLog log = paymentService.addAPayment(payment);
        return log != null ?
                ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Payment Successfully!",log)
                ) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("Failed", "Payment Failed!","")
                );
    }

    @GetMapping("/credit-card/{id}")
    ResponseEntity<ResponseObject> getACreditCard(@PathVariable Long id){
        Optional<CreditCard> creditCard = creditCardService.getCreditCardById(id);
        return creditCard.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Susscess!",creditCard)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("Failed","Not Found CreditCard byID: "+id,"")
                );
    }

    @PostMapping("insert-card")
    ResponseEntity<ResponseObject> insertACreditCard(@RequestBody @Valid CreditCard creditCard){
        CreditCard cardInsert = creditCardService.insertCreditCard(creditCard);
        return cardInsert != null ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","CreditCard's Inserted!",cardInsert)
                ) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new ResponseObject("Falied", "Falied","")
                );
    }

    public static void main(String[] args) {
        Set<Object> abc = new HashSet<>();
    }
}
