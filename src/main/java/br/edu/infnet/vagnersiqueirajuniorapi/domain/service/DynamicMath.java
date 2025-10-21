package br.edu.infnet.vagnersiqueirajuniorapi.domain.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;

import java.util.Map;
import java.util.function.IntBinaryOperator;

public class DynamicMath {
    private static final Map<String, IntBinaryOperator> OPERATORS = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b
    );

    public static int applyOperator(String operator, int a, int b) throws InvalidFieldException {
        IntBinaryOperator op = OPERATORS.get(operator);
        if (op == null) {
            throw new InvalidFieldException("Invalid operator: " + operator);
        }
        return op.applyAsInt(a, b);
    }
}
