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
        this.noOfGeneration = 100; // hardcoded 
    }
    
    /**
     * Runs the genetic algorithm to create a schedule
     * @param input the input parameters
     * @return created schedule with profit value
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
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
