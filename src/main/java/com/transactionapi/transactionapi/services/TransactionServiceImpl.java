package com.transactionapi.transactionapi.services;

import com.transactionapi.transactionapi.domain.dtos.TransactionDTO;
import com.transactionapi.transactionapi.domain.entities.Transaction;
import com.transactionapi.transactionapi.repositories.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionDTO, transaction);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findByID(UUID id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public Transaction update(UUID id, TransactionDTO transactionDTO) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (!transaction.isPresent()){
            throw new RuntimeException("Transaction not found");
        }
        BeanUtils.copyProperties(transactionDTO, transaction.get());
        return transactionRepository.save(transaction.get());
    }

}
