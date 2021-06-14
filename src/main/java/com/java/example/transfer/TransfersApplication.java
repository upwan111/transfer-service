package com.java.example.transfer;

import com.java.example.transfer.infrastructure.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TransfersApplication implements ApplicationRunner {

    private AccountRepository accountRepository;

    private MongoTemplate mongoTemplate;

    @Autowired
    public TransfersApplication(AccountRepository accountRepository, MongoTemplate mongoTemplate) {
        this.accountRepository = accountRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(TransfersApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        accountRepository.loadSampleAccounts(mongoTemplate);
    }
}
