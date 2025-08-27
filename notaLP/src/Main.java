import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer p1,e1,e2,sub,x,api;
        Double media;

        System.out.println("Descubra sua média de Linguagem de Programação I");
        System.out.print("Digite a nota da P1: ");
        p1 = input.nextInt();
        System.out.print("Digite a nota da E1: ");
        e1 = input.nextInt();
        System.out.print("Digite a nota da E2: ");
        e2 = input.nextInt();

        double p1d = p1;
        double e1d = e1;
        double e2d = e1;
        media = (p1d+e1d+e2d)/3;
        if (media < 6){
            System.out.println("Digite o valor da SUB: ");
            sub = input.nextInt();
        } else{
            sub = 0;
        }

        System.out.print("Digite a nota da X: ");
        x = input.nextInt();
        System.out.print("Digite a nota da API: ");
        api = input.nextInt();

        double subd = sub;
        double xd = x;
        double apid = api;

        System.out.printf("Suas notas são: %d | %d | %d | %d | %d\n", p1, e1, e2, sub, x);

        double soma = p1d*0.5 + e1d*0.2 + e2d*0.3 + xd + subd*0.15;
        double calc1 = (soma)*0.5;
        double calc2 = (Math.max((soma) - 5.9, 0) / ((soma) - 5.9))*apid*0.5;

        double result = calc1 + calc2;

        System.out.println("Resultado: " + result);

    }
}