/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphFramework;

import java.util.LinkedList;

/**
 *
 * @author Nawal
 */
public class Vertex {
      String label;
      boolean isVisited;
      private LinkedList<Edge> adjList = new LinkedList<Edge>();
      int distance; 
      Vertex parent; 
    //Constructor
      
    public Vertex(String label,boolean isVisited){
        this.label = label;
  //      this.distance = distance;
    }
    
    // getters and setters
    public  String getLabel(){
        return label;
    }
    public void setLabel(String label){
        this.label=label;
        
    }
     
     public boolean getisVisted(){
        return isVisited;
      }

      public void setIsVisited(boolean isVisited){
        this.isVisited=isVisited;
    }

    public LinkedList<Edge> getAdjList (){
        
        return adjList;
       
    } 
    
    public int getDistance()
    {
        return distance; 
    }
    
    public void setDistance(int distance)
    {
        this.distance= distance;
    }
    
    public Vertex getParent()
    {
        return parent; 
    }
    
   public void setParent(Vertex parent)
    {
        this.parent = parent; 
    }
    
   

      // display information method 
    public void dispalyInfo(Vertex ver){
    //System.out.println("The vertex label: "+label+"\n is the vertex visited?"+isVisited);
        System.out.print("Loc" + ver.getLabel());
      }
    
      //@Override
    /*public int compareTo(Vertex distanceVertex){
         // Compare based on distance
         return Integer.compare( distanceVertex.distance, this.distance);
     }*/
    
    public int getIndex()
    {
        return label.charAt(0)-'A';
    }


    
}
