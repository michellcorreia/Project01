package entities;

public class Sum extends Operations{

    public Sum(){
        super();
    }

    public Sum(String variable, String operation){
        super(variable, operation);
    }

    public Double operationSum(String variable1, String variable2) {
		return Double.valueOf(variable1) + Double.valueOf(variable2);
    }

    @Override
    public Double opApply(String variable1, String variable2) {
		return operationSum(variable1, variable2);
    }
}

