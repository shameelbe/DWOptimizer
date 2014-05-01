/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizer;

import java.util.ArrayList;

/**
 *
 * @author Adix
 */
public class Population {
    int generationNo;
    Member[] members;    
    int maxGenerations;
    int crossover;
    
    Population(int numberOfVars){
        this.members = new Member[10];
        this.generationNo = 0;        
        for(int i =0; i < 10; i++){
            members[i] = new Member(numberOfVars);            
        }       
    }
    
    public void nextGeneration(){
                
        
    }
    
    private void calculatePopulationFitness(Input input){
        for(int i =0; i < 10; i++){
            members[i].calculateFitness(input);
        }        
    }
    
    public void reproduce(){
        
    }       
}
