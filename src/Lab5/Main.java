//9132 % 17 = 3 =>В усіх питальних реченнях заданого тексту знайти та надрукувати
//                без повторень слова заданої довжини.
package Lab5;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Text text = new Text("Why why why so serious? Why why why are we so serious? When did we get like this? " +
                "I still remember we were not grown up like this. Someone tell me. Did we forget about living with no regrets?");
        System.out.println("Entrance text:");
        text.print();

        Scanner scanner  = new Scanner(System.in);
        System.out.println("\nEnter word length to find from questions:");
        try {
            int a = scanner.nextInt();
            Client client = new Client(text, a);
            client.startLiveInTheSystem();
        }
        catch (Exception exception) {
            System.out.println("\nАn error occurred: " + exception);
        }



        System.out.println("Done! :)");
    }
}