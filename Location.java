/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airfreightapp;

import GraphFramework.Vertex;

/**
 *
 * @author Nawal
 */
public class Location extends Vertex {
    String city; 

    public Location(String label, boolean isVisited, String city) {
        super(label, isVisited);
        this.city = city ;
    }
    
    public String getCityNum()
    {
        return city; 
    }
    
    public void displayInfo()
    {
          System.out.print( "loc. "+getLabel()+": city "+getCityNum()+"-" );
    }
    
}
