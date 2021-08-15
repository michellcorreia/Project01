package entities;

import java.util.List;
import java.util.Objects;

public class Result extends Operations {

    private Double result;

    public Result() {
        super();
    }

    public Result(String variable, String operation) {
        super(variable, operation);
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Double operationRes(String variable) {
        return Double.valueOf(variable);
    }

    public void result(List<Operations> list, Double result) {

        // Precedência das operações
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getOperation(), "*") || Objects.equals(list.get(i).getOperation(), "/")) {
                list.get(i + 1).setVariable(Double.toString(list.get(i).opApply(list.get(i).getVariable(), list.get(i + 1).getVariable())));
                list.remove(i);
            }
        }
        // Cálculo das operações restantes
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                result = Double.valueOf(list.get(i).getVariable());
            }
            else {
                result = list.get(i - 1).opApply(Double.toString(result), list.get(i).getVariable());
            }
        }

        this.result = result;
    }

    @Override
    public Double opApply(String variable1, String variable2) {
        return null;
    }
}