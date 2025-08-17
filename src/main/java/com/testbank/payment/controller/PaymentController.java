package com.testbank.payment.controller;

import com.testbank.payment.model.PaymentInfo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PaymentController {

    @PostMapping("/initiate")
    public ResponseEntity<String> initiate(@RequestHeader(value = "PAYMENT-INITIATOR", required = false) String initiator, @RequestBody Map<String, Object> body) {
        if (initiator == null || initiator.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing PAYMENT-INITIATOR header");
        }

        //Make a get Request to localhost:8081/ack
        try {
            HttpClient.newHttpClient().send(HttpRequest.newBuilder()
                    .uri(URI.create(body.get("callback").toString()))
                    .header("PAYMENT-INITIATOR", initiator)
                    .build(), null);
                    return ResponseEntity.status(HttpStatus.OK).body("Acknowledgment sent to " + initiator);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/payment")
    public ResponseEntity<String> pay(@RequestBody PaymentInfo paymentInfo) {
        return ResponseEntity.ok("Payment processed for " + paymentInfo.getId());
    }
}
