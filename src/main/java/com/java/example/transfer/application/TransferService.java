package com.java.example.transfer.application;

import com.java.example.transfer.command.CompleteTransferCommand;
import com.java.example.transfer.domain.Transaction;

public interface TransferService {
    /**
     * Handle the command to return a successful transaction
     * @param cmd Command to complete the transfers
     * @return transaction
     */
    Transaction handle(CompleteTransferCommand cmd);
}
