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
        DecimalFormat nf = new DecimalFormat("##.#####");
		List<Operations> list = new ArrayList<>();
		Check check = new Check();
		Double result = 0.00;
     

        System.out.println("|| Calculator ||");
        System.out.println();

        while(!check.powerOffCheck(check.getInput())) {

            // Coleta dos inputs, criação da variável e coleta da operação
            check.inputCreation(sc, result);

            // instanciação dinâmica, dependendo da operação
            Operations operation = check.opInstanceCheck(check.getOp(), check.getNumber());	
            
            // implementação da variável e operação na lista, reset do número
            list.add(operation);					
            check.setNumber("");

            // Exibição do resultado / limpeza da lista / O resultado é a nova variável inicial do próximo loop.
            if(check.resultCheck(list.get(list.size()-1).getOperation())) {
        
                Result res = new Result();
                res.result(list, result);
                // O print exibe formato do número baseado na quantidade de casas decimais. ("nf")
                System.out.println(nf.format(res.getResult()));
                list.clear();
                result = res.getResult();
                check.setNumber(Double.toString(result));
            }    
        }  
        System.out.println("Turned Off.");
        sc.close();
    }
}

