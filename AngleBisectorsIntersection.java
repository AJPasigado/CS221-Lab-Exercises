
import java.util.*;

public class AngleBisectorsIntersection {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        int x1 = input.nextInt();
        int y1 = input.nextInt();
        input.nextLine();
        
        int x2 = input.nextInt();
        int y2 = input.nextInt();
        input.nextLine();
        
        int x3 = input.nextInt();
        int y3 = input.nextInt();
        input.nextLine();
        
        double a = Math.sqrt((y2*y2)+(x2*x2))/2;
        double c = Math.sqrt(((x3-x2)*(x3-x2))+(y2*y2))/2;
        double b = x3/2;
        double k = (a+b+c)/2;
        double radius = (Math.sqrt((k)*(k-a)*(k-b)*(k-c)))/k;
        System.out.println (x2 + " " +radius*2);
    }
}
