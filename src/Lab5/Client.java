package Lab5;

import java.util.Scanner;

public class Client
{
    private Text text;
    private Integer a;


    public Client(Text text, Integer a)
    {
        this.text = text;
        this.a = a;
    }

    public void startLiveInTheSystem() {
        System.out.println("Finded words: " + text.findWordsGivenLength(a));
    }

}
