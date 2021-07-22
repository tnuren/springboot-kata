package io.github.tnuren.kata.service;

import io.github.tnuren.kata.domain.Multiplication;
import io.github.tnuren.kata.domain.MultiplicationResultAttempt;

public interface MultiplicationService {

    Multiplication createRandomMultiplication();

    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}
