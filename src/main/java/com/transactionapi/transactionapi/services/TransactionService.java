package com.transactionapi.transactionapi.services;

import com.transactionapi.transactionapi.domain.dtos.TransactionDTO;
import com.transactionapi.transactionapi.domain.entities.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {

    Transaction save(TransactionDTO transactionDTO);

    List<Transaction> findAll();

    Transaction findByID(UUID id);

    Transaction update(UUID id, TransactionDTO transactionDTO);
}
