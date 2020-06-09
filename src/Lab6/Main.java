/*Визначити ієрархію амуніції лицаря. Екіпірувати лицаря. Порахувати вартість амуніції.
Провести сортування амуніції за вагою. Знайти елементи амуніції, що відповідає заданому діапазону цін.*/

package Lab6;

public class Main {
    public static void main(String[] args) {

        Ammunition armor = new Armor("Armor",100, 20.3);
        Ammunition shield = new Shield("Shield",275, 56.7);
        Ammunition sword = new Sword("Sword", 175, 10.9);
        Ammunition helmet = new Helmet("Helmet",90, 5.7);
        
        Knight knight = new Knight(new Ammunition[]{armor, shield, sword,helmet});

        Ammunition[] ammunitions = {armor, shield, sword, helmet};

        knight.ammunitionPrice(ammunitions);

        System.out.println("Ammunitions price:\n"+ knight.ammunitionPrice(ammunitions));


        knight.sortByWeight();



        int minPrice = 50; int maxPrice = 150;
        System.out.println("\nАmmunition from a selected price range: " + minPrice + "-" +maxPrice);

        for(Ammunition ammunition: ammunitions){
            if (((ammunition.getPrice()>=minPrice && (ammunition.getPrice()<= maxPrice)))){
                System.out.println(ammunition.getInformation());
            }
        }

        System.out.println("\nDone!:)");
    }
}
