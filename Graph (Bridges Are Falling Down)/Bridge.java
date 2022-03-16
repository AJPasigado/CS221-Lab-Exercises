/*  Bridges Are Falling Down
 *  Anton John B. Pasigado
 *  09/25/2016
 *  References: Bridges Are Falling Down (PDF)
 */

import java.util.ArrayList;

public class Bridge {
    myGraph graph = new myGraph ();
    
    public Bridge(){
        for (int i=0; i<26; i++){   
            String a = Character.toString((char)('A' + i));
            graph.addNode (a);
        }
    }
    
    public void addAnEdge(String a, String b){
        graph.addEdge(a , b);
    }
    
    public String getSpan(){
        ArrayList<Integer> ANeighbors = graph.getNodes().get(0).getNeighbors(); //get neighbors of A
        int ret =325, temp =0;
        for (int i =0 ; i<ANeighbors.size(); i++){
            temp = getNumPath(graph.getNodes().get(ANeighbors.get(i)));
            if (temp<ret){
                ret = temp;
            }
        }
        if (ret == 325) return "IMPOSSIBLE";
        else return Integer.toString(ret+1);
    }
    
    public int getNumPath (Node a){
        int ret = 325, temp = 0;
        ArrayList<Integer> neighbors = a.getNeighbors();
        if (a.data.equals("Z")) return 0;
        else if (neighbors.size() == 0) return 325;
        else    for (int i=0; i<neighbors.size(); i++){
                    temp =  getNumPath(graph.getNodes().get(neighbors.get(i))) + 1;
                    if (temp < ret) ret = temp;
                }
        return ret;
    }
}