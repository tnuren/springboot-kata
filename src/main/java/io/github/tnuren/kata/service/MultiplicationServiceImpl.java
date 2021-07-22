package io.github.tnuren.kata.service;

import io.github.tnuren.kata.domain.Multiplication;
import io.github.tnuren.kata.domain.MultiplicationResultAttempt;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private final RandomGeneratorService randomGeneratorService;

    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Override
    public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
        Multiplication multiplication = resultAttempt.getMultiplication();

        return  resultAttempt.getResultAttempt() == multiplication.getFactorA() * multiplication.getFactorB();
    }
}
