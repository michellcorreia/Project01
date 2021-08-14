package entities;

public abstract class Operations {

    Check check = new Check();

    private String variable;
    private String operation;

    public Operations() {
    }

    public Operations(String variable, String operation) {
        this.variable = variable;
        this.operation = operation;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public abstract Double opApply(String variable1, String variable2);
}
