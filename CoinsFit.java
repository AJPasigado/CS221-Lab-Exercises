
package acm;
import java.util.*;

public class CoinsFit {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        double tray = input.nextInt();
        input.nextLine();
        double coins = input.nextInt();
        input.nextLine();
        double answer = (int)((area(tray)-area(tray-(coins*2)))/((coins*2)*(coins*2)));
        if (answer > 0){
            System.out.println ( answer + " coins of size " + coins + " will fit the inner rim of a tray of size " + tray + ".");
        } else System.out.println ("Coin cannot fit in tray.");
    }
    
    public static double area(double num){
        return Math.PI * (num*num);
    }
}
