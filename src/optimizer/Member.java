/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizer;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Aditya Padhye
 */
public class Member implements Comparable<Member>{
    private int bitSize = 10;
    private int geneLength;
    String genes;
    private double fitness;
    private double[] decimalValue;
      
    /**
     * Creates members with random genes for the initial population
     * @param numOfVars number of variables inputted by the user.
     */
    Member(int numOfVars){        
        this.geneLength = numOfVars*bitSize;      
        this.decimalValue = new double[numOfVars];
        this.genes = createRandomString();
    }
    
    /**
     * Creates a random string for the initial population    
     * @return randomly generated string of 0's and 1's
     */
    private String createRandomString(){
        Random r = new Random();        
        String tempGene = "0";
        for(int i = 0; i < this.geneLength - 1; i++){
            if(r.nextBoolean()){               
                tempGene = tempGene.concat("1");
            }
            else{                
                tempGene = tempGene.concat("0");
            }
        }       
        return tempGene;        
    }
    
    /**
     * Computes the decimal values for the genes
     */
    public void computeDecimalValue(){
        int decNo = this.geneLength/bitSize;         
        for(int i = 0; i < decNo; i++){
              String sub = genes.substring(i*bitSize, (i+1)*bitSize);
              System.out.println(sub);
              System.out.println(Integer.parseInt(sub, 2));
              decimalValue[i] = (double)Integer.parseInt(sub, 2);
          }        
    } 
    
    /**
     * Calculates the fitness of the Member.
     */
    public void calculateFitness(Input input) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        //ArrayList<Double> list = (ArrayList) Arrays.asList(decimalValue);
        fitness = input.returnProfit(decimalValue) - input.genConstraintCalc(decimalValue);
        System.out.println("Fitness "+fitness);
        
    }
        
    public int compareTo(Member o) {
        if (this.fitness > o.fitness){
            return 1;
        }
        else return 0;
    }
    
    //setter getter methods for the class.    
    public int getGeneLength() {
        return geneLength;
    }

    public void setGeneLength(int geneLength) {
        this.geneLength = geneLength;
    }

    public String getGenes() {
        return genes;
    }

    public void setGenes(String genes) {
        this.genes = genes;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double[] getDecimalValue() {
        return decimalValue;
    }       
    
}
