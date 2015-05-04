package org.mycalculator.com.mycalculator;

/**
 * Created by vishakha14 on 5/2/2015.
 */
public class Operations {
    private double Operater;
    private double Value2;
    private String Operatoration;

    // operator types
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    public static final String CLEAR = "C" ;

    // constructor
    public Operations() {
        Operater = 0;
        Value2 = 0;
        Operatoration = "";

    }

    public void setOperand(double Operater) {
        Operater = Operater;
    }

    public double getResult() {
        return Operater;
    }

    public String toString() {
        return Double.toString(Operater);
    }

    protected double Operation(String operator) {

        if (operator.equals(CLEAR)) {
            Operater = 0;
            Operatoration = "";
            Value2 = 0;

        } else {
            BasicOperation();
            Operatoration = operator;
            Value2 = Operater;
        }

        return Operater;
    }

    protected void BasicOperation() {

        if (Operatoration.equals(ADD)) {
            Operater = Value2 + Operater;
        } else if (Operatoration.equals(SUBTRACT)) {
            Operater = Value2 - Operater;
        } else if (Operatoration.equals(MULTIPLY)) {
            Operater = Value2 * Operater;
        } else if (Operatoration.equals(DIVIDE)) {
            if (Operater != 0) {
                Operater = Value2 / Operater;
            }
        }

    }
}
