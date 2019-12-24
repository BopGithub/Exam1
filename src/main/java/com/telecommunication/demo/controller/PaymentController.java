package com.telecommunication.demo.controller;

import com.telecommunication.demo.Exception.ResourceNotFoundException;
import com.telecommunication.demo.model.Payment;
import com.telecommunication.demo.respository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PaymentController {

    /*To identified a specific repository for each controller*/
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping(path= "/payments",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    /*This method gets all payments*/
    public List<Payment> getAllPayments(){
        /*save()--save object of type user*/
        return paymentRepository.findAll();
    }

    @PostMapping("/payments")
    public Payment addPayment(@Valid @RequestBody Payment payment){
        /*save()--save object of type user*/
        return paymentRepository.save(payment);
    }

    @DeleteMapping(path= "/payment/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    /*This method deletes a payment based on paymentId*/
    public Map<String,Boolean> deletePayment(@PathVariable(value = "id") Long paymentId) throws ResourceNotFoundException {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"+paymentId));

        paymentRepository.delete(payment);

        Map<String,Boolean> response = new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/payments/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    /*This method updates a record upon paymentId*/
    public Map<String, Boolean> updatePayment(@PathVariable(value = "id") Long paymentId, @RequestBody Payment payment ) throws ResourceNotFoundException{

        Payment payment1 = paymentRepository.findById(paymentId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"+paymentId));

        payment1.setCurrency(payment.getCurrency());
        payment1.setAmount(payment.getAmount());
        payment1.setEmployeeName(payment.getEmployeeName());
        payment1.setSenderName(payment.getSenderName());
        payment1.setSenderPhone(payment.getSenderPhone());
        payment1.setSenderId(payment.getSenderId());

        paymentRepository.save(payment1);

        Map<String,Boolean> response = new HashMap<>();
        response.put("updated",Boolean.TRUE);
        return response;
    }



}
