/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphFramework;

/**
 *
 * @author Nawal
 */
public class Edge implements Comparable<Edge>{
    // class attributes 
    public Vertex parent;
    public Vertex source;
    public Vertex target;
    int weight;
    // Constructor
    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
    
    
    // getters and setters
     public Vertex getParent (){
        return parent;
     }
     public void setParent(Vertex parent){
        this.parent=parent;
     }
     
     public Vertex getSource(){
        return source;
     }

      public void setSource(Vertex source){
        this.source=source;
     }
     
     public Vertex getTarget(){
        return target;
     }

     public void setTarget(Vertex target){
        this.target=target;
     }
     
     public int getWeight(){
        return weight;
     }

     public void setWeight(int weight){
        this.weight=weight;
     }
     

    // display information method 
     public void dispalyInfo(Edge edge){
     System.out.print(" : route length: " + edge.getWeight() + "\n");
    }
     
    // Compare Metoed (For Kruskal Algorithm) // by Yasmeen *****
     @Override
     public int compareTo(Edge weightEdge){
         // Compare based on weith
         return Integer.compare(this.weight, weightEdge.weight);
     }


}

