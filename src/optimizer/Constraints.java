/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizer;

/**
 *
 * @author smriti
 */
public class Constraints {
    
    private String constraint;
    private int constraint_num;
    private String resource_name;
    private int penalty;
    
    private String const_LHS;
    private String const_RHS;
    private String const_sign;
    
    
    // Getter and setter methods for the constraints.
    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

    public int getConstraint_num() {
        return constraint_num;
    }

    public void setConstraint_num(int constraint_num) {
        this.constraint_num = constraint_num;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public String getConst_LHS() {
        return const_LHS;
    }

    public void setConst_LHS(String const_LHS) {
        this.const_LHS = const_LHS;
    }

    public String getConst_RHS() {
        return const_RHS;
    }

    public void setConst_RHS(String const_RHS) {
        this.const_RHS = const_RHS;
    }

    public String getConst_sign() {
        return const_sign;
    }

    public void setConst_sign(String const_sign) {
        this.const_sign = const_sign;
    }
    
    
    
    /**
     * Splits the constraint into 3 parts
     */
    public void split()
    {        
        int splitLoc1=0;
        int splitLoc2=0;
        boolean cError= false;
        for(int z=0;z<constraint.length();z++)
        {
            if(constraint.charAt(z)=='>' || constraint.charAt(z)=='<')
            {
                splitLoc1=z;
                if(constraint.charAt(z+1)=='=')
                {
                    splitLoc2=z+2; 
                    if(cError==false)
                        cError=true;
                    else
                        cError=false;
                }    
                else
                {
                    splitLoc2=z+1;
                    System.out.println(splitLoc2);                    
                }
            }
        }
        const_LHS = constraint.substring(0,splitLoc1 );
        const_sign = constraint.substring(splitLoc1,splitLoc2);
        const_RHS = constraint.substring(splitLoc2,constraint.length());
    }
    
}
