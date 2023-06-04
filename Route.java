/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airfreightapp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

/**
 *
 * @author Nawal
 */
public class Route extends Edge{
    
    public Route(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
    }
    
}
