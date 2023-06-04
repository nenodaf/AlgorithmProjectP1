/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphFramework;

import airfreightapp.Location;

/**
 *
 * @author Nawal
 */
public class DBAIISourceSPAlg extends ShortestPathAlgorithm{

    public DBAIISourceSPAlg(Graph graph) {
        super(graph);
    }
    
    
  
    
    public void computeDijkstraBasedSPAlg(Graph graph)
    {
        
        for (int i=0; i<graph.getVertices().size(); i++) // This for loop is to make each vertex a source in each iteration 
        {
         //   System.out.println();
         //   System.out.println("The starting point location is "+graph.getVertices().get(i).getLabel());
         //   System.out.println("The routes from location "+graph.getVertices().get(i).getLabel()+" to the rest of the locations are:");
          //  System.out.println();
            SingleSourceSPAlg d = new SingleSourceSPAlg (graph); // Create an object 
            d.computeDijkstraAlg((Location) graph.getVertices().get(i)); // Declare the method for computing Dijkstra 
            
            
            if (Graph.vertices.size()<2000)
            {
                System.out.println();
            System.out.println("The starting point location is "+graph.getVertices().get(i).getLabel());
            System.out.println("The routes from location "+graph.getVertices().get(i).getLabel()+" to the rest of the locations are:");
            System.out.println();
                
            for (int j=0; j<d.resultList.size(); j++) // for loop for print the cost and path for each source to all the vertices 
            {
                 d.displayResult((Location) d.resultList.get(j));
                 System.out.println("--route length: "+d.resultList.get(j).getDistance());
            }
           
            System.out.println("----------------------------------------------------------------------");
            System.out.println();
            System.out.println(".....");
            }
            
        }
        
    
    }
    
  

   
    
}
