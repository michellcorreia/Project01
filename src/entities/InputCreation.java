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

    // Método de criação/formulação do input
    public void inputCreation(Scanner sc, Double result) {
        // Evita exibir "0" na tela após uma coleta de resultado.
        if (result == 0) {
            System.out.println("0");
        }
        // Enquanto opCheck for falso, continue coletando o input.
        while (!opCheck) {
            input = sc.next().charAt(0);

            // depois de ter o result, checa o primeiro input
            if (result != 0 && !chk.allCheck(input)) {
                result = 0.0;
                setNumber("");
                number = number.concat(Character.toString(input));
                System.out.println(number);
            }
            // Se number "" & input operacional (exceto powerOff): primeira variavel "0",
            else if (number == "" && chk.allCheck(input) && !chk.powerOffCheck(input)) {
                number = number.concat("0");
                opCheck = chk.allCheck(input);
                op = Character.toString(input);
            }
            // Se input operacional, condiciona oopCheck a sair do while
            else if (chk.allCheck(input)) {
                opCheck = chk.allCheck(input);
                // Se o input for "p", não faz mais nada.
                if (chk.powerOffCheck(input)) {
                }
                // Caso contrário, coleta a operação inputada.
                else {
                    op = Character.toString(input);
                }
            }
            // (variável é pontuação ou numérica) concatena com number
            else {
                number = number.concat(Character.toString(input));
                System.out.println(number);
            }
        }
        setOpCheck(false);
    }
}