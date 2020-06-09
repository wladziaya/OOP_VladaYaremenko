package Lab6;

import java.util.*;

public class Knight {
    private Ammunition[] ammunitions;

    public Knight(Ammunition[] ammunitions) {
        this.ammunitions = ammunitions;
    }


    public int ammunitionPrice(Ammunition[] ammunitions) {
        int price = 0;
        for (int i = 0; i < ammunitions.length; i++) {
            price = price + ammunitions[i].getPrice();
        }
        return price;
    }


    public void sortByWeight() {
        List<Ammunition> ammunitionList = new ArrayList();
        Collections.addAll(ammunitionList, ammunitions);
        ammunitionList.sort(Comparator.comparing(Ammunition::getWeight));
        System.out.println("\nSorted by weight ammunition:\n" + ammunitionList);
    }


}