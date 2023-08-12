package edu.iviettech.asgrestfulapi.repository;

import edu.iviettech.asgrestfulapi.entity.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
    Boolean existsByCardNumber(String cardNumber);
    Optional<CreditCardEntity> findByCardNumber(String cardNumber);

    @Modifying
    @Query("Update CreditCardEntity c Set c.amount = (c.amount - ?2) Where c.id = ?1")
    void setAmountAfterPayment(Long creditCardId, Double amountPayment);
}
