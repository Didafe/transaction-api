package com.transactionapi.transactionapi.controllers;

import com.transactionapi.transactionapi.domain.dtos.TransactionDTO;
import com.transactionapi.transactionapi.domain.entities.Transaction;
import com.transactionapi.transactionapi.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> save(@RequestBody TransactionDTO transactionDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.save(transactionDTO));
    }

    @GetMapping
    public ResponseEntity<List> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable("id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.findByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable("id") UUID id, @RequestBody TransactionDTO transactionDTO){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.update(id, transactionDTO));
    }

}
