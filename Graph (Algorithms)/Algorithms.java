/*  Graph Algorithms
 *  Anton John B. Pasigado
 *  09/30/2016
 *  References: http://www.geeksforgeeks.org/detect-cycle-undirected-graph/ (Cycle in a graph)
 */

import java.util.ArrayList;

public class Algorithms {
    ArrayList<Node> nodes = new ArrayList<Node>();
    
    public void addNode (String a){
        nodes.add(new Node(a));}
    
    public void addEdge (String a, String b, int c){
        nodes.get(getIndex(a)).addNeighbor(b, c);}
    
    public void addUndirectedEdge (String a, String b, int c){
        nodes.get(getIndex(a)).addNeighbor(b, c); nodes.get(getIndex(b)).addNeighbor(a, c);}                     //if {BA} = {AB}, they will be stored separately
    
    public void removeEdge(String a, String b){
        nodes.get(getIndex(a)).removeNeighbor(b);}
    
    public int getIndex(String a){
        for (int i=0; i<nodes.size(); i++) if (nodes.get(i).data.equals(a))return i; return -1;}
    
    public int[] DijkstrasShortestPath(String a){          
        int[] minWeight = new int[nodes.size()];
        boolean[] visited = new boolean[nodes.size()];
        for (int i=0; i<nodes.size(); i++)minWeight[i] = Integer.MAX_VALUE;                                                         //initialize to weights to infinity
        Node temp = nodes.get(getIndex(a)); minWeight[getIndex(a)] = 0;                                                             //starting node and set its weight to 0
        while (temp != null){
            visited[getIndex(temp.data)] = true;                                                                                    //mark as visited
            for (int i=0; i<temp.getNeighbors().size(); i++){                                                                       //updates the weights of neighbors to minimum
                int tWeight = temp.getWeight(temp.getNeighbors().get(i)) + minWeight[getIndex(temp.data)];
                if (tWeight < minWeight[getIndex(temp.getNeighbors().get(i))]) minWeight[getIndex(temp.getNeighbors().get(i))] = tWeight;
            }
            int itemp = Integer.MAX_VALUE, rtemp = Integer.MAX_VALUE; 
            for (int i=0;  i<nodes.size();i++)if (minWeight[i]<itemp && visited[i]==false) {rtemp = i; itemp = minWeight[i];}       //checks the next node or vertex to be visited
            if (Integer.MAX_VALUE==rtemp) break;                                                                                    //breaks if there are no more univisited node
            else temp = nodes.get(rtemp);                                                                                           //else go to the least unvisited node
        }
        return minWeight;}                                                                                                           //returns the minimum weights as an array of int
    
    
    public int[] BellmanFord (String a){
        int[] minWeight = new int[nodes.size()];
        boolean[] visited = new boolean[nodes.size()];
        for (int i=0; i<nodes.size(); i++) minWeight[i] = Integer.MAX_VALUE;                                        //sets everything to "infinity"
        nodes.add(0, nodes.remove(getIndex(a))); minWeight[0] = 0; visited[0] = true;                               //switches the first node to the top of list; sets first node to zero and visited
        int RelaxationCount = 0;                                                                                    //number of Relaxations
        while(RelaxationCount <= nodes.size()){
            boolean minWeightCheck = false;
            for (int j=0; j<nodes.size(); j++)if (visited[getIndex(nodes.get(j).data)])                             //goes to the visited nodes
            for(int k=0; k<nodes.get(j).getNeighbors().size(); k++){                                                //checks the neighbors of unvisited nodes
                visited[getIndex(nodes.get(j).getNeighbors().get(k))] = true;                                       //mark neighbor as visited
                int tWeight = nodes.get(j).getWeight(nodes.get(j).getNeighbors().get(k)) + minWeight[getIndex(nodes.get(j).data)];
                if (tWeight < minWeight[getIndex(nodes.get(j).getNeighbors().get(k))]) {
                    minWeight[getIndex(nodes.get(j).getNeighbors().get(k))] = tWeight; minWeightCheck = true;}      //checks if there are changes
            }
            if (RelaxationCount == nodes.size()&&minWeightCheck) System.out.println ("Negative Cycle");             //notify if the graph is a negative cycle 
            RelaxationCount++;
        }
        return minWeight;}
    
    public int[][] FloydWarshall (){
        int minWeight[][] = new int[nodes.size()][nodes.size()];
        for (int i = 0; i<nodes.size(); i++)                                                        //set the matrix to infinity
        for (int j = 0; j<nodes.size(); j++) minWeight[i][j] = 99999999;                            //because Integer.MAX_VALUE + something will result to negative
        for (int i = 0; i<nodes.size(); i++) minWeight[i][i] = 0;                                   //set sources to 0
        for (int i = 0; i<nodes.size(); i++)                                                        //set the weights of edges in the matrix
        for (int j = 0; j<nodes.get(i).getNeighbors().size(); j++)
           minWeight[getIndex(nodes.get(i).data)][getIndex(nodes.get(i).getNeighbors().get(j))] = nodes.get(i).getWeight(nodes.get(i).getNeighbors().get(j));
        for (int k = 0; k<nodes.size(); k++)                                                        //set the minimum weights (Floyd's algo)
        for (int i = 0; i<nodes.size(); i++)
        for (int j = 0; j<nodes.size(); j++) if (minWeight[i][j] > minWeight[i][k] + minWeight[k][j]) minWeight[i][j] = minWeight[i][k] + minWeight[k][j];
        return minWeight;}                                                                         //returns the two-dimensional array of weights
    
    
    public ArrayList<Node> Kruskals (){                                                                                  //this algorithm changes the global
        ArrayList<Edge> edges = initiateEdges();                                                                         //make an edge class, in the edge {AB} != {BA}
        for (int i=0; i<nodes.size(); i++) nodes.get(i).clearNeighbors();                                                //clear the edges of the graph
        while (edges.size()!=0){
            addUndirectedEdge(edges.get(0).source, edges.get(0).destination, edges.get(0).weight);                       //add the edge on graph
            if (isCycle()){                                                                                              //If cycle, remove two edges since it is undirected
                removeEdge(edges.get(0).source, edges.get(0).destination); removeEdge(edges.get(0).destination, edges.get(0).source);}
            if(edgeIndex(edges.get(0).destination, edges.get(0).source, edges)>0)                                        //remove the duplicate edge in the queue
                edges.remove(edgeIndex(edges.get(0).destination, edges.get(0).source, edges));
            edges.remove(0);                                                                                             //remove the current edge from edge queue
        }
        return nodes;}                                                                                                    //returns the new list of nodes with modified neighbors
    
    private int edgeIndex(String a, String b, ArrayList<Edge> edges){                                                    //get the index of the edge
        for (int i=0; i<edges.size(); i++) if (edges.get(i).source.equals(a) && edges.get(i).destination.equals(b)) return i; return -1;}
    
    private ArrayList<Edge> initiateEdges(){                                                                             //fill up the edge class and then sort  
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int i=0; i<nodes.size(); i++) for (int j=0; j<nodes.get(i).getNeighbors().size(); j++)                      //store the edges
            edges.add(new Edge(nodes.get(i).data, nodes.get(i).getNeighbors().get(j), nodes.get(i).getWeight(nodes.get(i).getNeighbors().get(j)))); 
        for (int i=1; i<edges.size(); i++){                                                                              //sort the edges using insertion sort
            int j=i;
            while (j > 0 && edges.get(j).weight < edges.get(j-1).weight){ 
                Edge temp = new Edge(edges.get(j).source, edges.get(j).destination, edges.get(j).weight);
                edges.get(j).setEdge(edges.get(j-1).source, edges.get(j-1).destination, edges.get(j-1).weight);
                edges.get(j-1).setEdge(temp.source, temp.destination, temp.weight); j--;
            }
        }
        return edges;}
    
    public boolean isCycle(){
        boolean[] visited = new boolean [nodes.size()];
        for (int i=0; i<nodes.size();i++)if (!visited[i]) if (isCycle(nodes.get(i), visited, -1)) return true; return false;}    //check all nodes to check for other tree
    
    private boolean isCycle(Node current, boolean[] visited, int parent){
        visited[getIndex(current.data)] = true;                                                                                 //mark the current node as true
        ArrayList <String> neighbors = current.getNeighbors();                                                                  //get the neighbors of the current node
        int i = 0;                                                                                                              //counter
        while(i<neighbors.size()){                                                                                              //check all the neighbors of the node
            if (parent>=0 && visited[getIndex(neighbors.get(i))]){if (!neighbors.get(i).equals(nodes.get(parent).data)) return true;}  //if the visited neighbor is not the parent
            else if (!visited[getIndex(neighbors.get(i))]) if (isCycle(nodes.get(getIndex(neighbors.get(i))), visited, getIndex(current.data))) return  true;
            i++;                                                                                                                //(above line) check the next unvisited neighbor
        } 
        return false;}
}