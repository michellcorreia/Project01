package entities;

public class Subtraction extends Operations {

    public Subtraction() {
        super();
    }

    public Subtraction(String variable, String operation) {
        super(variable, operation);
    }

    public Double operationSub(String variable1, String variable2) {
        return Double.valueOf(variable1) - Double.valueOf(variable2);
    }

    @Override
    public Double opApply(String variable1, String variable2) {
        return operationSub(variable1, variable2);
    }
}
