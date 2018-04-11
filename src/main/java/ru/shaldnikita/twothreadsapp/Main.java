package ru.shaldnikita.twothreadsapp;

import java.util.*;
import javax.swing.Timer;

/**
 * @author ShaldNikita
 */
public class Main {

    private Timer t;
    private List<String> numbers = new ArrayList<>();
    private NumberFactory numberFactory = new NumberFactory();
    private Integer monitor = -1;

    public static void main(String[] args) {
        new Main().run();
    }

    public Main() {
        t = new Timer(5000, (e) -> {
            System.out.println(getMinInputNumber());
        });
    }


    private void run() {
        System.out.println("Start typing...");
        Scanner in = new Scanner(System.in);

        while (true) {
            String number = in.nextLine();
            
            putNumberIfNotExists(number);

            if (!t.isRunning()) {
                t.start();
            }
        }
    }

    public String getMinInputNumber() {
        synchronized (monitor) {
            if (numbers.size() == 0)
                return "Have no any numbers";

            String min = null;
            int lastMinIndex = 0;

            //find new minimum
            for (int i = 0; i < numbers.size(); i++) {

                String current = numbers.get(i);
                String lastMin = numbers.get(lastMinIndex);

                if (isLessThanMinimum(current, lastMin)) {
                    min = current;
                    lastMinIndex = i;
                }
            }
            numbers.remove(min);

            return min;
        }
    }

    private Boolean isLessThanMinimum(String num, String min) {
        String[] current = num.split(" ");
        String[] minimum = min.split(" ");
        Integer intCurrent = numberFactory.createNumber(current);
        Integer intMin = numberFactory.createNumber(minimum);

        return intCurrent.compareTo(intMin) <= 0;
    }


    private void putNumberIfNotExists(String number) {
        synchronized (monitor) {
            if (!numbers.contains(number))
                numbers.add(number);
        }

    }
}
