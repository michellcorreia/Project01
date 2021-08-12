package entities;

public class Division extends Operations{

    public Division(){
        super();
    }
    
    public Division(String variable, String operation){
        super(variable, operation);
    }

    public Double operationDiv(String variable1, String variable2) {
		return Double.valueOf(variable1) / Double.valueOf(variable2);
    }

    @Override
    public Double opApply(String variable1, String variable2) {
		return operationDiv(variable1, variable2);
    }
}