/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphFramework;

import airfreightapp.Location;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.random;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Nawal
 */
public class Graph {
    
    int verticesNo, edgeNo; //vertices number and edges number
    boolean isDigraph; // is the graph is directed or not
    int weight; 
    
   
    public static LinkedList<Vertex> vertices ; // Linked list represent the list of vertices of a graph 
  
  



    //---------------------------------------------------
    public void make_graph(int verticesNum, int edgenum) { // REQ2
    Vertex v, u;
    String edgeKey = " ";
    vertices = new LinkedList<>();
    verticesNo = 0;
    isDigraph = true;

    for (Integer i = 0; i < verticesNum; i++) {
        vertices.add(creatVertex(i.toString(), false, i.toString())); //randomly initialize the vertices and their labels
        verticesNo++;
    }
    
    
    Set<String> addedEdgeSet = new HashSet<>();
    for (int i = 0; i < verticesNum - 1; i++) { // Make a connected graph
         weight = (int) ((Math.random() * 100) + 1);

        v = vertices.get(i); //get a vertex
        u = vertices.get((i + 1)); // get the next vertex
        edgeKey = u.getLabel()+"-"+v.getLabel();
        addEdge(v, u, weight); // make an edge between them
         addedEdgeSet.add(edgeKey);
    }

    Random random = new Random();
    int currentEdges = verticesNum - 1;
  

    while (currentEdges < edgenum) {
        if (edgeNo >= verticesNum * (verticesNum - 1) / 2) {
            break;
        }
        
     

        int index1 = random.nextInt(verticesNum);
        int index2 = random.nextInt(verticesNum);

        if (index1 == index2) {
            continue;
        }

      
            v = vertices.get(index1);
            u = vertices.get(index2);
            edgeKey = u.getLabel()+"-"+v.getLabel();
        if (!addedEdgeSet.contains(edgeKey)) {
          
            weight = (int) ((Math.random() * 100) + 1);
            addEdge(v, u, weight);
            currentEdges++;
            addedEdgeSet.add(edgeKey);
            
        }
    }

         
         
    // the next lines are not included in the project 
         /*   System.out.println("The graph generated from file :");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).getLabel() + " -> { ");
  
            LinkedList<Edge> list = vertices.get(i).getAdjList();
  
            if (list.isEmpty())
                System.out.print(" No adjacent vertices ");
            else {
                int size = list.size();
                for (int j = 0; j < size; j++) {
  
                    System.out.print(list.get(j).getTarget().getLabel()+" = "+list.get(j).getWeight());
                    if (j < size - 1)
                        System.out.print(" , ");
                }
            }
  
            System.out.println("}");
        }*/
    }
    // the previous lines are not included in the project
         
         
    
    
   
    

    
    
    
    //-------------
    public boolean isConnected(Vertex sourceVertex, Vertex targetVertex) { // a method to check whether two vertices has an edge 
        
        for (int i=0; i<vertices.size(); i++) { // iterate over all vertices
     
            for (int j=0; j<vertices.get(i).getAdjList().size(); j++) { // iterate over the adjency list of a specific vertex
               
                // Check whether the vertices has an edge
                if ((vertices.get(i).getAdjList().get(j).getSource().getLabel().equals(sourceVertex.getLabel()) && vertices.get(i).getAdjList().get(j).getTarget().getLabel().equals(targetVertex.getLabel()))
                        || (vertices.get(i).getAdjList().get(j).getSource().getLabel().equals(targetVertex.getLabel()) && vertices.get(i).getAdjList().get(j).getTarget().getLabel().equals(sourceVertex.getLabel()))) {
                    return true; //there is an edge and they are connected
                }
            }
        }

        return false; // no edges! 
    }
    //-------------
    //----------------------------------------------------
    
    //----------------------------------------------------
    public void readGraphFromFile(File graphFile) throws FileNotFoundException{
       vertices = new LinkedList<>();
        Location vertex1 = null;
        Location vertex2 = null;
                
        Integer cityNum1=1; 
        
        Scanner input = new Scanner(graphFile);
        
        input.next(); // read Digraph statement
        isDigraph = input.nextInt() != 0; // This statement will check whether the graph is drected or undirected

    int verticesNum = input.nextInt(); // This line will read the number of vertices
    int edgeNum = input.nextInt(); // This line will read the number of edges

    /*
    The next for loop will do the following: 
    1. First it will check whether the vertices read from the file are exist in the vertices list or not 
    2. If the vertex is not exist it will add it to the list and store it in vertex1 or vertex2 variables
    3. If the vertex is already exist it will assign to the vertex1 or vertex2 variable immediatly 
    4. It will creat edge between the vertices
    
    */
    for (int i=0; i<edgeNum; i++) //this loop will iterate over all vertices and edges
    {
        String verLabel1 = input.next(); // read the first vertex from file
        String verLabel2 = input.next(); // read the secon vertex from file 

        
        if (!isExist(verLabel1)) // check if the vertex is exist in vertices list 
        {
             vertex1 = (Location)creatVertex(verLabel1,false,cityNum1.toString()); // if it is not exist creat a vertex
             vertices.add(vertex1); // add the vertex to vertices list 
             verticesNo++;
             cityNum1++;
        }
        else // if the vertex is already exist just get it 
        {
            for (int j=0; j<vertices.size();j++)
            {
             
                if (vertices.get(j).getLabel().equals(verLabel1))
                {
                   
                    vertex1 = (Location) vertices.get(j);
                }
            }
        }
         
         if (!isExist(verLabel2))
        {
             vertex2 = (Location) creatVertex(verLabel2,false,cityNum1.toString()); // if it is not exist creat a vertex
             vertices.add(vertex2); // add the vertex to vertices list 
             verticesNo++;
             cityNum1++;
        }
         
         else // if the vertex is already exist just get it 
        {
            for (int j=0; j<vertices.size();j++)
            {
                if (vertices.get(j).getLabel().equals(verLabel2))
                    vertex2 = (Location) vertices.get(j);
            }
        }
         
         weight = input.nextInt(); // randomly select a weight
         addEdge(vertex1,vertex2,weight); // add the edge between the vertices
         
    }

    // the next lines are not included in the project 
   /*         System.out.println("The graph generated from file :");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).getLabel() + " -> { ");
  
            LinkedList<Edge> list = vertices.get(i).getAdjList();
  
            if (list.isEmpty())
                System.out.print(" No adjacent vertices ");
            else {
                int size = list.size();
                for (int j = 0; j < size; j++) {
  
                    System.out.print(list.get(j).getTarget().getLabel());
                    if (j < size - 1)
                        System.out.print(" , ");
                }
            }
  
            System.out.println("}");
        }*/
    }
    // the previous lines are not included in the project
    //----------------------------------------------------

    public boolean isExist(String vertexLabel) // this method will check whether a certin vertex is exist in the vertices list or not
    {
        for (int i=0; i<vertices.size(); i++)
        {
            if (vertices.get(i).getLabel().equals(vertexLabel))
                return true;
        }
        return false;
    }
    //----------------------------------------------------
    
     public void addEdge(Vertex v,Vertex u, int w ) {  // this method is to add an edge between to vertices


     
        if (isDigraph == false) // in the case the graph is not directed 
        {
        // intialize src to des edge, add it to the list
       
        v.getAdjList().add(creatEdge(v, u, weight));

        // intialize des to src edge, add it to the list
        
        u.getAdjList().add(creatEdge(u, v, weight));

        edgeNo+=2;// increments edge number by 2 if it is undirected graph
       
        
        }
        else // in the case the graph is directed
        {
             // intialize src to des edge, add it to the list
        
        v.getAdjList().add(creatEdge(v, u, weight));

          edgeNo++; // increments edge number by 1 in case it is a directd graph
        
        }
    }
     
      public Vertex creatVertex(String label, boolean isVisited, String city)
   {
        return null; 
   }
      
      public Edge creatEdge(Vertex source, Vertex target, int weight)
    {
        return null;
    }
      
      public void clearVerticesList()
      {
          vertices.clear();
          vertices.clear();
          verticesNo = 0;
      }
       
      public int getEdgeNo()
      {
          return edgeNo;
      }
  
      public LinkedList<Vertex> getVertices()
      {
          return vertices;
      }
        
    
}
