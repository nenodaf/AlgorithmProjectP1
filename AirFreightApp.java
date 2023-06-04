/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package airfreightapp;

import GraphFramework.DBAIISourceSPAlg;
import GraphFramework.SingleSourceSPAlg;
import GraphFramework.Vertex;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Nawal
 */
public class AirFreightApp {

    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("To read from file choose 1 , to generate a random graph choose from 2 to 6");
        int choice = input.nextInt();
        
        switch (choice) {
            case 1:
                File file = new File ("graphFile.txt");
                AFRouteMap map1 = new AFRouteMap();
                map1.readGraphFromFile(file);
                DBAIISourceSPAlg di = new DBAIISourceSPAlg(map1);
                di.computeDijkstraBasedSPAlg(map1);
                break;
            case 2:
                {
                    AFRouteMap map2 = new AFRouteMap();
                    long start = System.currentTimeMillis();
                    map2.make_graph(2000,10000);
                    long end = System.currentTimeMillis();
                    long total = end-start; 
                    DBAIISourceSPAlg di2 = new DBAIISourceSPAlg(map2);
                    di2.computeDijkstraBasedSPAlg(map2);
                    System.out.println("The total run time Dijkstra Algorithm : "+total);
                    break;
                }
            case 3:
                {
                    AFRouteMap map2 = new AFRouteMap();
                    long start = System.currentTimeMillis();
                    map2.make_graph(3000,15000);
                    long end = System.currentTimeMillis();
                    long total = end-start; 
                    DBAIISourceSPAlg di2 = new DBAIISourceSPAlg(map2);
                    di2.computeDijkstraBasedSPAlg(map2);
                    System.out.println("The total run time Dijkstra Algorithm : "+total);
                    break;
                }
            case 4:
                {
                    AFRouteMap map2 = new AFRouteMap();
                    long start = System.currentTimeMillis();
                    map2.make_graph(4000,20000);
                    long end = System.currentTimeMillis();
                    long total = end-start; 
                    DBAIISourceSPAlg di2 = new DBAIISourceSPAlg(map2);
                    di2.computeDijkstraBasedSPAlg(map2);
                    System.out.println("The total run time Dijkstra Algorithm : "+total);
                    break;
                }
            case 5:
                {
                    AFRouteMap map2 = new AFRouteMap();
                    long start = System.currentTimeMillis();
                    map2.make_graph(5000,25000);
                    long end = System.currentTimeMillis();
                    long total = end-start; 
                    DBAIISourceSPAlg di2 = new DBAIISourceSPAlg(map2);
                    di2.computeDijkstraBasedSPAlg(map2);
                    System.out.println("The total run time Dijkstra Algorithm : "+total);
                    break;
                }
            case 6:
                {
                    AFRouteMap map2 = new AFRouteMap();
                    long start = System.currentTimeMillis();
                    map2.make_graph(6000,30000);
                    long end = System.currentTimeMillis();
                    long total = end-start; 
                    DBAIISourceSPAlg di2 = new DBAIISourceSPAlg(map2);
                    di2.computeDijkstraBasedSPAlg(map2);
                    System.out.println("The total run time Dijkstra Algorithm : "+total);
                    break;
                }
            default:
                break;
        }
        
        
        
        
        
        
        
        
        
        
        
        System.out.println("DONE");
         
        
        
        
    }
}
