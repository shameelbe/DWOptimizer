/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizer;

/**
 *
 * @author Adix
 */
public class Scheduler {    
    
    int noOfGeneration;
    
    Scheduler(){
        this.noOfGeneration = 100; // hardcoding 
    }
    
    public int[] createSchedule(Input input){
        int[] schedule = new int[input.getNoOfVariables()];
        
        Population pop = new Population(input.getNoOfVariables());
        for(int i = 0; i < noOfGeneration; i++){
            pop.reproduce();
            pop.nextGeneration();        
        }       
        schedule = pop.topMemberDecimalValues();
        return schedule;
    }
}
