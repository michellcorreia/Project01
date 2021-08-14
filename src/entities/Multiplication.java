package entities;

public class Multiplication extends Operations {

    public Multiplication() {
        super();
    }

    public Multiplication(String variable, String operation) {
        super(variable, operation);
    }

    public Double operationMult(String variable1, String variable2) {
        return Double.valueOf(variable1) * Double.valueOf(variable2);
    }

    @Override
    public Double opApply(String variable1, String variable2) {
        return operationMult(variable1, variable2);
    }
}