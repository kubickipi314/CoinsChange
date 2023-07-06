import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CashRegister register = new CashRegister();

        register.fill();
        register.print();
        System.out.println("Podaj wartosc reszty lub zakoncz program wpisując K");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("K")) {
                System.out.println("Kociec programu");
                break;
            }
            input = input.replace(".", "");
            register.calculate(Integer.parseInt(input));
        }

    }
}