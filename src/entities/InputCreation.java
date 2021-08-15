package entities;

import java.util.Scanner;

public class InputCreation {

    private char input;
    private Boolean opCheck = false;
    private String op = null;
    private String number = "";
    Check chk = new Check();

    public InputCreation() {

    }

    public InputCreation(char input, Boolean opCheck, String op, String number) {
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

            if (result != 0 && !chk.allCheck(input)) {
                result = 0.0;
                number = "";
                number = number.concat(Character.toString(input));
                System.out.println(number);
            }

            else if (number == "" && chk.allCheck(input) && !chk.powerOffCheck(input)) {
                number = number.concat("0");
                opCheck = chk.allCheck(input);
                op = Character.toString(input);
            }

            else if (chk.opCheck(input)) {
                opCheck = chk.opCheck(input);
                op = Character.toString(input);
            }

            else if (chk.resultCheck(input)) {
                opCheck = chk.resultCheck(input);
                op = Character.toString(input);
            }

            else if (chk.powerOffCheck(input)) {
                opCheck = chk.powerOffCheck(input);
            }

            else {
                number = number.concat(Character.toString(input));
                System.out.println(number);
            }
        }
        setOpCheck(false);
    }
}