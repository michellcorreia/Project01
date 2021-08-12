package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.*;

public class Calculator {
    public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Operations> list = new ArrayList<>();
		Check check = new Check();
		Double result = 0.00;
     

        System.out.println("|| Calculator ||");
        System.out.println();

        while(!check.powerOffCheck(check.getInput())) {

            // Coleta dos inputs, criação da variável e coleta da operação
            check.inputCreation(sc,result);

            // instanciação dinâmica, dependendo da operação
            Operations operation = check.opInstanceCheck(check.getOp(), check.getNumber());	
            // implementação da variável e operação na lista, reset do number
            list.add(operation);					
            check.setNumber("");

            // Exibição do resultado / limpeza da lista / O resultado é a nova variável inicial.
            if(check.resultCheck(list.get(list.size()-1).getOperation())) {
        
                Result res = new Result();
                res.result(list, result);
                list.clear();
                result = res.getResult();
                check.setNumber(Double.toString(result));
            }    
        }  
        System.out.println("Turned Off.");
        sc.close();
    }
}

