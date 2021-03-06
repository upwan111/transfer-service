package com.java.example.transfer.interaction;

import com.java.example.transfer.application.TransferService;
import com.java.example.transfer.command.CompleteTransferCommand;
import com.java.example.transfer.domain.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TransferController {

    private static final Logger logger = LoggerFactory.getLogger(TransferController.class);

    @Autowired
    private TransferService transferService;

    /**
     * Performs transfer from one account to another
     * @param cmd Input command for transfer
     * @return ResponseEntity
     */
    @PostMapping("/transfer")
    public ResponseEntity<Transaction> doTransfer(@Valid @RequestBody CompleteTransferCommand cmd) {
        if(cmd.getSourceAccountNumber().equals(cmd.getDestinationAccountNumber())) {
            String errorMsg = "source and destination accountNumber can not be same";
            logger.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
        Transaction transaction = transferService.handle(cmd);
        return new ResponseEntity<>(transaction,HttpStatus.CREATED);
    }

}
