/*list
Масив із початковою кількістю елементів 15 та збільшенням кількості елементів на 30%*/
package Lab7;

import Lab6.*;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MyList myList = new MyList(new Ammunition("Shield", 45, 10.8));
        myList.add(new Ammunition("Armor",98, 15.5));
        myList.add(new Ammunition("Sword",150, 23.7 ));
        Ammunition helmet = new Helmet("Helmet",250, 7.9);

        MyList emptyList = new MyList();
        myList.add(new Ammunition("Armor",98, 15.5));
        myList.add(new Ammunition("Sword",150, 23.7 ));
        myList.add(new Ammunition("Shield", 45, 10.8));
        myList.add(helmet);



        ArrayList<Ammunition> arrayList = new ArrayList<Ammunition>();
        arrayList.add(new Armor("Armor",98, 15.5));
        arrayList.add(new Sword("Sword",150, 23.7));
        arrayList.add(new Shield("Shield", 45, 10.8));
        arrayList.add(helmet);
        System.out.println(arrayList);
        MyList list2 = new MyList(arrayList);


        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("++++++++++++");

        ListIterator listIterator = list2.listIterator();
        System.out.println(listIterator.next());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.next());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());

        System.out.println(listIterator.nextIndex());



        System.out.println(list2.contains(helmet));
    }
}
