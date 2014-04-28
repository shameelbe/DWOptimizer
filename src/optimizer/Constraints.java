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
        String delims = "[= ]";
        String[] tokens = constraint.split(delims);
        const_LHS=tokens[0];
        const_sign=tokens[1];
        const_RHS=tokens[2];
    }
    
}
