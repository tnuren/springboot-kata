package io.github.tnuren.kata.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class RandomGeneratorServiceImplTest {

    private RandomGeneratorServiceImpl randomGeneratorServiceImpl;

    @BeforeEach
    void setup() {
        randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
    }

    @Test
    void generateRandomFactorIsBetweenExpectedLimits() throws Exception {
        List<Integer> randomFactors = IntStream.range(0, 1000).map(i -> randomGeneratorServiceImpl.generateRandomFactor())
                .boxed().collect(Collectors.toList());

        assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11, 100).boxed().collect(Collectors.toList()));
    }
}