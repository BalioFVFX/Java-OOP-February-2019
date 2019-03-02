import money.Cash;
import money.Gem;
import money.Gold;


import java.util.LinkedHashMap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long input = Long.parseLong(scanner.nextLine());
        String[] save = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(input);

        for (int i = 0; i < save.length; i += 2) {
            String name = save[i];
            long broika = Long.parseLong(save[i + 1]);


            if (name.length() == 3) {
                bag.addCash(new Cash(name, broika));
            } else if (name.toLowerCase().endsWith("gem")) {
                bag.addGems(new Gem(name, broika));
            } else if (name.toLowerCase().equals("gold")) {
                bag.addGold(new Gold(broika));
            }

        }

        System.out.print(bag);
    }
}