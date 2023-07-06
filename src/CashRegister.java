import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CashRegister {

    private final List<Denomination> register;
    private Integer sum;

    CashRegister() {
        register = new ArrayList<>();
        sum = 0;
    }

    public void fill() {
        List<Integer> values = Arrays.asList(500, 200, 100, 50, 20, 10, 5, 2, 1);
        List<Integer> amounts = Arrays.asList(1, 3, 5, 10, 20, 200, 100, 100, 10000);

        for (int i = 0; i < values.size(); i++) {
            register.add(new Denomination(values.get(i), amounts.get(i)));
            sum += values.get(i) * amounts.get(i);
        }
    }

    public void print() {
        System.out.println("Stan kasy (laczna wartosc: " + String.format("%.2f", Double.valueOf(sum) / 100) + " zl):");
        for (Denomination d : register) {
            if (d.value >= 100) {
                System.out.println(d.value / 100 + " zl: " + d.amount + " szt.");
            } else {
                System.out.println(d.value + " gr: " + d.amount + " szt.");
            }
        }
    }

    public void calculate(int change) {

        if (change > sum) {
            System.out.println("niewystarczajaca laczna wartosc monet");
            return;
        }

        for (Denomination d : register) {
            if (d.amount.equals(0)) continue;
            int number = d.value * d.amount < change ? d.amount : change / d.value;
            if (number == 0) continue;

            change -= number * d.value;
            sum -= number * d.value;
            d.amount -= number;

            if (d.value >= 100) {
                System.out.println("Wydaj " + number + " monet " + d.value / 100 + " zl");
            } else {
                System.out.println("Wydaj " + number + " monet " + d.value + " gr");
            }

            if (change == 0) return;
        }
    }
}
