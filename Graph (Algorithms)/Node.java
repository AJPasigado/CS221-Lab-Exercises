
/*  Algorithms Node
 *  Anton John B. Pasigado
 *  09/30/2016
 *  References: None
 */

import java.util.ArrayList;

public class Node {
        public String data;
        ArrayList<String> neighbors = new ArrayList<String>();
        ArrayList<Integer> weight = new ArrayList<Integer>();
        
        public Node (String a){
            data = a;
        }
        
        public void addNeighbor(String a, int b){
            neighbors.add(a);
            weight.add(b);
        }
        
        public ArrayList<String> getNeighbors(){
            return neighbors;
        }

        public int getWeight(String a){
            return weight.get(neighbors.indexOf(a));
        }
        
        public void clearNeighbors(){
            neighbors.clear();
        }
        
        public void removeNeighbor(String a){
            int index = neighbors.indexOf(a);
            if (index==-1) return;
            neighbors.remove(index);
            weight.remove(index);
        }
}