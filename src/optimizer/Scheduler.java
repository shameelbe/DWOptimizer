/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizer;

import java.io.IOException;

/**
 *
 * @author Aditya Padhye
 */
public class Scheduler {    
    
    int noOfGeneration;
    double finalProfit;

    public double getFinalProfit() {
        return finalProfit;
    }
    
    
    Scheduler(){
        this.noOfGeneration = 1; // hardcoding 
    }
    

    public double[] createSchedule(Input input) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        double[] schedule = new double[input.getNoOfVariables()];
        
        Population pop = new Population(input.getNoOfVariables());
        for(int i = 0; i < noOfGeneration; i++){
            pop.calculatePopulationFitness(input);
            pop.reproduce();
            pop.nextGeneration();        
        }       
        schedule = pop.topMemberDecimalValues();
        finalProfit=pop.topMemberProfit();
        return schedule;
    }
}
