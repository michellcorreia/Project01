package entities;

import java.util.Objects;

public class Check {
        
    public Check() {
    }
    // Verificador geral de funcionalidades/operações
    public Boolean allCheck(char input) {
        if (opCheck(input) || powerOffCheck(input) || resultCheck(input)) {
            return true;
        } else {
            return false;
        }
    }
    // Verificador de operações
    public Boolean opCheck(char input) {
        if (Objects.equals(input, "+".charAt(0))) {
            return true;
        } else if (Objects.equals(input, "-".charAt(0))) {
            return true;
        } else if (Objects.equals(input, "*".charAt(0))) {
            return true;
        } else if (Objects.equals(input, "/".charAt(0))) {
            return true;
        } else {
            return false;
        }
    }
    // Verifica se o input foi solicitando o resultado ("=")
    public Boolean resultCheck(char input) {
        if (Objects.equals(input, "=".charAt(0))) {
            return true;
        } else {
            return false;
        }
    }

    // Sobrecarga
    public Boolean resultCheck(String input) {
        if (Objects.equals(input, "=")) {
            return true;
        } else {
            return false;
        }
    }
    // Verifica se o input foi solicitando o desligamento ("p")
    public Boolean powerOffCheck(char input) {
        if (Objects.equals(input, "p".charAt(0))) {
            return true;
        } else {
            return false;
        }
    }
    // Método responsável por devolver a instanciação dinâmica, baseado na operação colhida.
    public Operations opInstanceCheck(String operation, String number) {
        if (Objects.equals(operation, "+")) {
            return new Sum(number, operation);
        } else if (Objects.equals(operation, "-")) {
            return new Subtraction(number, operation);
        } else if (Objects.equals(operation, "*")) {
            return new Multiplication(number, operation);
        } else if (Objects.equals(operation, "/")) {
            return new Division(number, operation);
        } else { // if(Objects.equals(operation, "="))
            return new Result(number, operation);
        }
    }
}
