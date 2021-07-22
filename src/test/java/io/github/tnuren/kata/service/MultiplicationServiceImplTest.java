package io.github.tnuren.kata.service;

import io.github.tnuren.kata.domain.Multiplication;
import io.github.tnuren.kata.domain.MultiplicationResultAttempt;
import io.github.tnuren.kata.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class MultiplicationServiceImplTest {

    private MultiplicationServiceImpl multiplicationServiceImpl;

    @Mock
    private RandomGeneratorService randomGeneratorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
    }

    @Test
    void createRandomMultiplicationTest() {
        //given
        given(randomGeneratorService.generateRandomFactor()).willReturn(30, 40);

        //when
        Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();

        //then
        assertThat(multiplication.getFactorA()).isEqualTo(30);
        assertThat(multiplication.getFactorB()).isEqualTo(40);
        assertThat(multiplication.getResult()).isEqualTo(1200);
    }

    @Test
    void checkCorrectAttemptTest() {
        //given
        Multiplication multiplication = new Multiplication(30, 40);
        User user = new User("coffee");

        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 1200);

        //when
        boolean result = multiplicationServiceImpl.checkAttempt(attempt);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void checkWrongAttemptTest() {
        //given
        Multiplication multiplication = new Multiplication(30, 40);
        User user = new User("coffee");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 1500);

        //when
        boolean result = multiplicationServiceImpl.checkAttempt(attempt);

        //then
        assertThat(result).isFalse();
    }
}