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
    String profitEnv;
    String constraintEnv;
    
    Population(Input input){
        this.members = new Member[10];
        this.generationNo = 0;        
        this.profitEnv = input.getProfitCalPath();
        this.constraintEnv = input.getConstCalPath();
        for(int i =0; i < 10; i++){
            members[i] = new Member(input.getNoOfVariables());            
        }       
    }
    
    public void nextGeneration(){
        calculatePopulationFitness();        
        
    }
    
    private void calculatePopulationFitness(){
        for(int i =0; i < 10; i++){
            members[i].calculateFitness();
        }        
    }
    
    public void reproduce(){
        
    }       
}
