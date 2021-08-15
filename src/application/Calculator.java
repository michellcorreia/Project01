package application;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.*;

public class Calculator {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("##.#####");
        List<Operations> list = new ArrayList<>();
        InputCreation ic = new InputCreation();
        Check chk = new Check();
        Double result = 0.00;

        System.out.println("|| Calculator ||");
        System.out.println();

        while (!chk.powerOffCheck(ic.getInput())) {

            // Coleta dos inputs, criação da variável e coleta da operação
            ic.inputCreation(sc, result);

            // instanciação dinâmica, dependendo da operação
            Operations operation = chk.opInstanceCheck(ic.getOp(), ic.getNumber());

            // implementação da variável e operação na lista, reset do número
            list.add(operation);
            ic.setNumber("");

            // Exibição do resultado / limpeza da lista / O resultado é a nova variável
            // inicial do próximo loop
            if (chk.resultCheck(list.get(list.size() - 1).getOperation())) {

                Result res = new Result();
                res.result(list, result);
                // O print exibe formato do número baseado na quantidade de casas decimais.
                // (DecimalFormat)
                System.out.println(df.format(res.getResult()));
                list.clear();
                result = res.getResult();
                ic.setNumber(Double.toString(result));
            }
        }
        System.out.println("Turned Off.");
        sc.close();
    }
}
