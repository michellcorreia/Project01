package entities;

import java.util.Objects;
import java.util.Scanner;

public class Check {

    private char input;
    private Boolean opCheck = false;
    private String op = null;
    private String number = "";
            
    public Check() {
    }

    public Check(char input, Boolean opCheck, String op, String number) {
        this.input = input;
        this.opCheck = opCheck;
        this.op = op;
        this.number = number;
    }

    public char getInput() {
        return input;
    }

    public void setInput(char input) {
        this.input = input;
    }

    public Boolean getOpCheck() {
        return opCheck;
    }

    public void setOpCheck(Boolean opCheck) {
        this.opCheck = opCheck;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void inputCreation(Scanner sc, Double result) {

        if (result == 0) {
            System.out.println("0");
        }
        while (!opCheck) {
            input = sc.next().charAt(0);

            if (result != 0 && !allCheck(input)) {
                result = 0.0;
                number = "";
                number = number.concat(Character.toString(input));
                System.out.println(number);
            }

            else if (number == "" && allCheck(input)) {
                number = number.concat("0");
                opCheck = opCheck(input);
                op = Character.toString(input);
            }

            else if (opCheck(this.input)) {
                opCheck = opCheck(input);
                op = Character.toString(input);
            }

            else if (resultCheck(input)) {
                opCheck = resultCheck(input);
                op = Character.toString(input);
            }

            else if (powerOffCheck(input)) {
                opCheck = powerOffCheck(input);
            }

            else {
                number = number.concat(Character.toString(input));
                System.out.println(number);
            }
        }
        opToFalse();
    }

    public Boolean allCheck(char input) {
        if (opCheck(input) || powerOffCheck(input) || resultCheck(input)) {
            return true;
        } 
        else {
            return false;
        }
    }

    public Boolean opCheck(char input) {
        if (Objects.equals(input, "+".charAt(0))) {
            return true;
        } 
        else if (Objects.equals(input, "-".charAt(0))) {
            return true;
        } 
        else if (Objects.equals(input, "*".charAt(0))) {
            return true;
        } 
        else if (Objects.equals(input, "/".charAt(0))) {
            return true;
        } 
        else {
            return false;
        }
    }

    public void opToFalse(){
        opCheck = false;
    }

    public Boolean resultCheck(char input) {
        if (Objects.equals(input, "=".charAt(0))) {
            return true;
        } 
        else {
            return false;
        }
    }
    //Sobrecarga
    public Boolean resultCheck(String input){
        if (Objects.equals(input, "=")) {
            return true;
        } 
        else {
            return false;
        }
    }

    public Boolean powerOffCheck(char input) {
        if (Objects.equals(input, "pwr".charAt(0))) {
            return true;
        } 
        else {
            return false;
        }
    }

    public Operations opInstanceCheck(String operation, String number) {
        if (Objects.equals(operation, "+")) {
            return new Sum(number, operation);
        } 
        else if (Objects.equals(operation, "-")) {
            return new Subtraction(number, operation);
        } 
        else if (Objects.equals(operation, "*")) {
            return new Multiplication(number, operation);
        } 
        else if (Objects.equals(operation, "/")) {
            return new Division(number, operation);
        } 
        else { // if(Objects.equals(operation, "="))
            return new Result(number, operation);
        }
    }
}
