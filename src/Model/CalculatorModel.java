package Model;

import OperatorsPackage.Operators;

public class CalculatorModel {
    private float plus(float num1, float num2) { return num1 + num2;}
    private float minus(float num1, float num2) { return num1 - num2;}
    private float mul(float num1, float num2) { return num1 * num2;}
    private float div(float num1, float num2) { return num1 / num2;}

    public float calculate(float num1, float num2, Operators op) {
        switch (op) {
            case PLUS:
                return plus(num1, num2);
            case MINUS:
                return minus(num1, num2);
            case MUL:
                return mul(num1, num2);
            case DIV:
                return div(num1, num2);
            default:
                return 0;
        }
    }
}
