
/*  Algorithms Egde
 *  Anton John B. Pasigado
 *  09/30/2016
 *  References: None
 */

//This class is used by the Kruskal's Algorithm onl

public class Edge {
        public String source;
        public String destination;
        public int weight;
        
        public Edge (String a, String b, int c){
            setEdge(a, b, c);
        }
        
        public void setEdge(String a, String b, int c){
            source = a; destination = b; weight = c;
        }
}