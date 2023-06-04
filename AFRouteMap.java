/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airfreightapp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;

/**
 *
 * @author Nawal
 */
public class AFRouteMap extends Graph{
    
     @Override
     public Vertex creatVertex(String label, boolean isVisited, String city)
   {
    return new Location(label, isVisited, city);
   }
      
    @Override
      public Edge creatEdge(Vertex source, Vertex target, int weight)
    {
    return new Route(source, target, weight);
    }
    
    
}
