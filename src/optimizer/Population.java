/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * The population class is container for the population of members. Each generation consists of 10 individual members.
 * @author Aditya Padhye
 */
public class Population {
    int generationNo;
    int noOfMembers;
    Member[] members;   
    Member[] children;
    int maxGenerations;
    int crossover;
    
    /**
     * Population initialization.
     * @param numberOfVars 
     */
    Population(int numberOfVars){
        this.noOfMembers = 10; //hard coding initial population to 10
        this.members = new Member[10];
        this.children = new Member[10];
        this.generationNo = 0;        
        for(int i =0; i < this.noOfMembers; i++){
            members[i] = new Member(numberOfVars);             
            children[i] = new Member(numberOfVars);            
        }       
    }          
    
    /**
     * Selects individuals for the next generation from the parent and child lists.
     *  2 members having highest fitness from the initial population will be retained. 2 members from the children will be rejected
     */
    public void nextGeneration(){               
        for(int i=2;i < this.noOfMembers - 2; i++){
            members[i] = children[i-2];           
        }
        Arrays.sort(members);
        Arrays.sort(children);
    }
    
    /**
     * 
     * @param input contains the constraints in which the population thrives. The profit function and the constraints
     * are an environment which determines the fitness of the members.
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public void calculatePopulationFitness(Input input) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        for(int i =0; i < 10; i++){
            members[i].computeDecimalValue();
            members[i].calculateFitness(input);
            children[i].computeDecimalValue();
            children[i].calculateFitness(input);
        }        
    }
    
    /**
     * Reproduction using random crossover.
     */
    public void reproduce(){ 
        Random r = new Random(); 
        Arrays.sort(members);                       
        for(int i = 0; i < 5; i++){
            crossover = r.nextInt(members[i].getGeneLength()-1);
            children[2*i].genes = members[2*i].genes.substring(crossover);
            children[2*i + 1].genes = members[2*i + 1].genes.substring(crossover);
            
            children[2*i].genes = children[2*i].genes.concat(members[2*i].genes.substring(0, crossover));
            children[2*i + 1].genes = children[2*i + 1].genes.concat(members[2*i + 1].genes.substring(0, crossover));
            System.out.println(members[2*i].genes);
            System.out.println(members[2*i + 1].genes);
            System.out.println(crossover);
            System.out.println(children[2*i].genes);
            System.out.println(children[2*i + 1].genes);
        }
    }

    /**
     * 
     * @return most fittest member for that generation
     */
    public double[] topMemberDecimalValues() {
        return members[0].getDecimalValue();
    }        
    
    /**
     * 
     * @return fitness value of the fittest member.
     */
    public double topMemberProfit()
    {
        return members[0].getFitness();
    }
}
