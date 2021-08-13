package entities;
import java.util.Objects;
import java.util.Scanner;

public class Check {

	private String input;
	private Boolean opCheck = false;
	private String op = null;
	private String number = "";


	public Check(){
	}

	public Check(String input, Boolean opCheck, String op, String number){
		this.input = input;
		this.opCheck = opCheck;
		this.op = op;
		this.number = number;
	}

	public String getInput(){
		return input;
	}
	
	public void setInput(String input){
		this.input = input;
	}

	public Boolean getOpCheck(){
		return opCheck;
	}

	public void setOpCheck(Boolean opCheck){
		this.opCheck = opCheck;
	}

	public String getOp(){
		return op;
	}

	public void setOp(String op){
		this.op = op;
	}

	public String getNumber(){
		return number;
	}

	public void setNumber(String number){
		this.number = number;
	}


	public void inputCreation(Scanner sc, Double result){
       
		if(result == 0) {						
			System.out.println("0");
		}
		while(!opCheck) {		
            input = sc.nextLine();

			if(result != 0 && !allCheck(input)){
				result = 0.0;
				number = "";
				number = number.concat(input);
				System.out.println(number);	
			}
			
			else if(number == "" && allCheck(input)){
				number = number.concat("0");
				opCheck = opCheck(input);
				op = input;
			}

            else if(opCheck(this.input)) {					
                opCheck = opCheck(input);
                op = input;
            }

            else if(resultCheck(input)) {
                opCheck = resultCheck(input);
                op = input;
            }
        
            else if(powerOffCheck(input)) {
                opCheck = powerOffCheck(input);	
            }
        
            else {							
                number = number.concat(input);
                System.out.println(number);
            }
        }
		opCheck = false;
    }
    
	public Boolean allCheck(String input){
		if(opCheck(input) || powerOffCheck(input) || resultCheck(input)){
			return true;
		}
		else{
			return false;
		}
	}

    public Boolean opCheck(String operation) {	
		if(Objects.equals(operation, "+")) {
			return true;
		}
		else if(Objects.equals(operation, "-")) {
			return true;
		}
		else if(Objects.equals(operation, "*")) {
			return true;
		}
		else if(Objects.equals(operation, "/")) {
			return true;
		}
		else {
			return false;
		} 
    }
    
    public Boolean resultCheck(String operation){
        if(Objects.equals(operation, "=")){
            return true;
        }
        else{
            return false;
        }
	}

    public Boolean powerOffCheck(String input){
        if(Objects.equals(input, "pwr")){
            return true;
        }
        else{
            return false;
        }
    }

    public Operations opInstanceCheck(String operation, String number){
        if(Objects.equals(operation, "+")) {
			return new Sum(number, operation);
		}
		else if(Objects.equals(operation, "-")) {
			return new Subtraction(number, operation);
		}
		else if(Objects.equals(operation, "*")) {
			return new Multiplication(number, operation);
		}
		else if(Objects.equals(operation, "/")) {
			return new Division(number, operation);
		}
        else{   // if(Objects.equals(operation, "="))
            return new Result(number, operation);
        }
    }
}
