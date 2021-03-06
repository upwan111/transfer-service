package com.java.example.transfer.application.impl;

import com.java.example.transfer.application.TransferService;
import com.java.example.transfer.command.CompleteTransferCommand;
import com.java.example.transfer.domain.Account;
import com.java.example.transfer.domain.Transaction;
import com.java.example.transfer.events.DomainEvent;
import com.java.example.transfer.infrastructure.AccountRepository;
import com.java.example.transfer.infrastructure.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    private static final Logger logger = LoggerFactory.getLogger(TransferServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction handle(CompleteTransferCommand cmd) {
        Account sourceAccount = accountRepository.findByAccountNumber_value(cmd.getSourceAccountNumber());
        Account destinationAccount = accountRepository.findByAccountNumber_value(cmd.getDestinationAccountNumber());
        cmd.updateAccountBalanceDetails(sourceAccount,destinationAccount);

        Transaction transaction = new Transaction(cmd);

        accountRepository.save(transaction.getSource());
        accountRepository.save(transaction.getDestination());
        transactionRepository.save(transaction);
        logger.info("Transaction with id {} saved successfully",transaction.getId());

        publishEvent(transaction.event());
        return transaction;
    }

    private void publishEvent(DomainEvent event) {
        logger.info("Event {} with eventId {} published successfully",event.getEventName(),event.getEventId());
    }
}
