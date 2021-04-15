package com.example.androidfirstappcalc;

import java.math.BigDecimal;
import java.math.MathContext;

public class Logic {
    private static final int PRECISION = 5;
    public static final MathContext MATH_CONTEXT = new MathContext(PRECISION);


    public static String executeOperation(String op1, String op2, String operation) {
        BigDecimal result = new BigDecimal("0.0", MATH_CONTEXT);
        BigDecimal bdOp1 = new BigDecimal(op1, MATH_CONTEXT);
        BigDecimal bdOp2 = new BigDecimal(op2, MATH_CONTEXT);

        switch(operation) {
            case "-":
                result = bdOp1.subtract(bdOp2, MATH_CONTEXT);
                break;
            case "+":
                result = bdOp1.add(bdOp2, MATH_CONTEXT);
                break;
            case "/":
                if (bdOp2.equals(new BigDecimal(0))) {
                    result = new BigDecimal(0);
                }else {
                    result = bdOp1.divide(bdOp2, MATH_CONTEXT);
                }
                break;
            case "*":
                result = bdOp1.multiply(bdOp2, MATH_CONTEXT);
                break;
        }
        return result.toString();
    }
}
