/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphFramework;


import airfreightapp.Location;
import java.util.*;

/**
 *
 * @author Nawal
 */
public class SingleSourceSPAlg extends ShortestPathAlgorithm {

   //  LinkedList<Vertex> settled; 
     PriorityQueue<Vertex> pq;
     Location source;
     LinkedList<Vertex> resultList;
     Vertex u; 
     String the_source;

    public SingleSourceSPAlg(Graph graph) {
        super(graph);
    }
 
    
   public void  computeDijkstraAlg(Location source)
    {
       for (Vertex v : Graph.vertices) 
       {
           v.setDistance(Integer.MAX_VALUE); // Make all the distances for all vertices the largest possible number
           v.setIsVisited(false); // set all isVisited to false
           v.setParent(null); // set all parents to null 
       }
       
       
      
       source.setDistance(0); // First set the distance of the source to 0 
       source.setParent(null); // Set the parent of the source to null 
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparing(Vertex::getDistance));
       resultList = new LinkedList<>(); //initilize the result list 
       the_source = source.getLabel();  // for tracing
       pq.clear(); // clear the queue after every new source 
       resultList.clear(); // clear the result list after every new source 
       pq.add(source); // add the source to the queue

           
       while (!pq.isEmpty()) // while the queue is empty 
       {

           u = pq.poll();   // remove the vertex with the smallest distance from the queue
           String the_removed = u.getLabel();
         
//           if (!resultList.contains(u))
  //         resultList.add(u); // and add it to the result list if it is not already exist 

            for (Edge e : u.getAdjList()) // generate the adjency list for the vertex 
            {
               Vertex  v = e.getTarget(); // generate the neighbours from the adj list 
                String the_target = v.getLabel();
                
          //      if (resultList.contains(v))
            //      continue; 
                  
           //     if (!pq.contains(v)) // add the neighbour if it is not exist in the queue
             //    pq.add(v); 
                
             
               
                    int newDistance = u.getDistance() + e.getWeight(); // compute the new distance
                    
                    if (newDistance<v.getDistance()) // compare the new distance with the neighbour distance
                    {
                        v.setDistance(newDistance); // update the distance
                        v.setParent(u); // update the parent
                        pq.add(v);
                   
                    }
                
            }
            if (!resultList.contains(u)) // add the neighbour if it is not exist in the queue
                resultList.add(u); 
            u.setIsVisited(true);
       
    }
        
    }
   

   
   public void displayResult(Location dest) // Display the paths and the lengths 
   {
       
       

   if (dest.getParent() != null)
   {
       displayResult((Location) dest.getParent());
       dest.displayInfo();
   } 
       
   else 
       dest.displayInfo();


  
    

   }
    
}
