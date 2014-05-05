package optimizer;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.abstractmeta.toolbox.compilation.compiler.JavaSourceCompiler;
import org.abstractmeta.toolbox.compilation.compiler.impl.JavaSourceCompilerImpl;

/**
 * The Class is responsible for setting up the input provided by user for
 * calculation. The profit and constraint functions are provided as String by
 * Users. It is converted into function (creating JAVA code and compiling it at
 * runtime). Reference : We used the free open source JAVA LIBRARY for JAVA code
 * Compilation at runtime. Link :
 * https://code.google.com/p/compilation-toolbox/downloads/list
 *
 * @author Smriti Batra and Shameel Mohamed
 */
public class Input {
    //member variables

    String profit;
    private int numberOfVariables = 0;
    JavaSourceCompiler.CompilationUnit compilationUnit;
    JavaSourceCompiler javaSourceCompiler;
    String content_profit;
    profitInterface pFunction;
    private ArrayList<Constraints> constraints = new ArrayList<Constraints>();
    // setter methods

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public void setConstraints(ArrayList<Constraints> constraints) {
        this.constraints = constraints;
    }

    /**
     * Constructor initializes the variables required to compile runtime
     *
     * @return void
     */
    Input() {
        javaSourceCompiler = new JavaSourceCompilerImpl();
        compilationUnit = javaSourceCompiler.createCompilationUnit();
    }

    /**
     * This method creates and compiles the profit calculator It creates a JAVA
     * code and compiles it in runtime to compute the profit function provided
     * as String.
     *
     * @return void
     * @throws IOException
     */
    public void genProfitCalc() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        javaSourceCompiler = new JavaSourceCompilerImpl();
        compilationUnit = javaSourceCompiler.createCompilationUnit();

        content_profit = "package optimizer;\n"
                + "import java.io.*;\n"
                + "\n"
                + "import   java.lang.Math.*;\n"
                + "  import java.util.ArrayList;  \n"
                + "public class ProfitCalc implements profitInterface {\n"
                + "    \n"
                + "	\n"
                + "	public double computeProfit(double[] bagpipeVals)\n"
                + "    {\n"
                + "        double [] x = bagpipeVals; \n"
                + "        double profit = " + profit + ";\n"
                + "        return profit;\n"
                + "    }\n"
                + "        \n"
                + "}";

        compilationUnit.addJavaSource("optimizer.ProfitCalc", content_profit);
        ClassLoader classLoader = javaSourceCompiler.compile(compilationUnit);
        Class pClass = classLoader.loadClass("optimizer.ProfitCalc");
        pFunction = (profitInterface) pClass.newInstance();

    }

    /**
     * It calls the function compute profit from ProfitCalc created at runtime
     * to compute profit and returns the profit value.
     *
     * @return double returns the computed profit value.
     * @throws IOException
     */
    public double returnProfit(double[] bagpipeVals) {

        return pFunction.computeProfit(bagpipeVals);
    }

    /**
     * Validates the input. Check Whether COnstraints are specified for all
     * input variables and also calculates the number of input variables and set
     * the value for no of variables.
     *
     * @return boolean true if validation passes else false.
     * @throws IOException
     */
    public boolean validateInput() {
        ArrayList<String> inputVars = new ArrayList<String>();
        int i = 0;
        boolean flag = false;

        int out = 0;
        while (out <= profit.length() - 1) {

            i = profit.indexOf("x", i);
            if (i >= 0) {
                if (!inputVars.contains(profit.substring(i, i + 4))) {
                    inputVars.add(profit.substring(i, i + 4));
                }
            }
            out = i + 4;
            i++;
            out++;
        }

        for (String s : inputVars) {
            flag = false;

            for (Constraints s1 : constraints) {
                String cons = s1.getConstraint();
                if (cons.contains(s)) {
                    flag = true;

                }
            }

            if (flag == false) {
                JOptionPane.showMessageDialog(null, "Constraints are not defined for all variables in Profit Function", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }
        System.out.println("Inputs validated.");
        numberOfVariables = inputVars.size();
        System.out.println("inputVars.size()");
        return true;
    }

    /**
     * This method creates and compiles the constraint calculator
     *
     * @throws IOException
     */
    /**
     * This method creates and compiles the constraint calculator It creates a
     * JAVA code and compiles it in runtime to compute the COnstraint functions
     * provided as String. It computes penalty for all constraint violation and
     * returns total penalty value.
     *
     * @param doube[] array of different bagpipe values
     * @return double returns the computed total penalty value.
     * @throws IOException
     */
    public double genConstraintCalc(double[] bagpipeVals) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        int size = constraints.size();
        double pTotal = 0.0;
        JavaSourceCompiler javaSourceCompiler = new JavaSourceCompilerImpl();
        JavaSourceCompiler.CompilationUnit compilationUnit = javaSourceCompiler.createCompilationUnit();
        for (int i = 0; i < size; i++) {
            Constraints con = constraints.get(i);
            double pValue = 0.0;
            System.out.println(con.getConst_LHS());
            String contentConstraints = "package optimizer;\n"
                    + "import java.io.*;\n"
                    + "\n"
                    + "import  java.lang.Math.*;\n"
                    + "  import java.util.ArrayList;  \n"
                    + "public class ConstraintCalc implements constraintInterface {\n"
                    + "\n"
                    + "    public double checkConstraints(double[] bagpipeVals)\n"
                    + "    {\n"
                    + "        double [] x = bagpipeVals; \n"
                    + "        double p_temp=0; \n"
                    + "        if((" + con.getConstraint() + ")) \n"
                    + "	   p_temp = 0;\n"
                    + "	   else \n"
                    + "	   p_temp = " + con.getConst_LHS() + ";\n"
                    + "        return p_temp;			\n"
                    + "      			\n"
                    + "  				\n"
                    + "    }\n"
                    + " }\n";

            compilationUnit.addJavaSource("optimizer.ConstraintCalc", contentConstraints);
            ClassLoader classLoader = javaSourceCompiler.compile(compilationUnit);
            Class cClass = classLoader.loadClass("optimizer.ConstraintCalc");
            constraintInterface t = (constraintInterface) cClass.newInstance();
            double lhs = t.checkConstraints(bagpipeVals);
            double rhs;
            double difference;
            if (lhs == 0) {
                difference = 0;
            } else {
                rhs = Double.parseDouble(con.getConst_RHS());
                difference = rhs - lhs;
            }
            if (difference < 0) {
                difference = -1 * difference;
            }
            pValue = difference * con.getPenalty();

            pTotal = pTotal + pValue;
        }
        return pTotal;
    }

    // getter method
    public int getNoOfVariables() {
        return this.numberOfVariables;
    }
}
