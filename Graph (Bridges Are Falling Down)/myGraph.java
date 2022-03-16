
/*  Bridges Are Falling Down Graph
 *  Anton John B. Pasigado
 *  09/25/2016
 *  References: Bridges Are Falling Down (PDF)
 */

import java.util.ArrayList;

public class myGraph {
    ArrayList<Node> nodes = new ArrayList<Node>();
    
    public void addNode (String a){
        nodes.add(new Node(a));
    }
    
    public void addEdge (String a, String b){
        for (int i=0; i<nodes.size(); i++){
            String temp = nodes.get(i).data;
            if (temp.equals(a)){
                nodes.get(i).addNeighbor(getIndex(b));
            }
        }                                                                                                                                                                                                                                                                                                      
    }
    
    public int getIndex(String a){
        int ret = 0;
        for (int i=0; i<nodes.size(); i++){
            Node temp = nodes.get(i);
            if (temp.data.equals(a)){
                ret = i;
                break;
            }
        }
        return ret;
    }
    
    public ArrayList<Node> getNodes(){
        return nodes;
    }
    
    public void print(){
        
        for (int i=0; i<nodes.size(); i++){
            Node tempy = nodes.get(i);
            ArrayList<Integer> temp = tempy.getNeighbors();
                System.out.print (tempy.data + " ");
            for (int j=0; j<temp.size(); j++){
                System.out.print (nodes.get(temp.get(j)).data + " ");
            }
            System.out.println ();
        }
    }
}