package io.github.tnuren.kata.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Multiplication {

    private int factorA;
    private int factorB;

    private int result;

    public Multiplication(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
        this.result = factorA * factorB;
    }

    @Override
    public String toString() {
        return "Multiplication{" +
                "factorA=" + factorA +
                ", factorB=" + factorB +
                ", result(A*B)=" + result +
                '}';
    }
}
