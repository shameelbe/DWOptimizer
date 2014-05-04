package optimizer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.abstractmeta.toolbox.compilation.compiler.JavaSourceCompiler;
import org.abstractmeta.toolbox.compilation.compiler.impl.JavaSourceCompilerImpl;

/**
 *
 * @author smriti
 */
public class Input {

<<<<<<< HEAD
    String profit="x1+x4x7";
=======
    String profit;

    public void setProfit(String profit) {
        this.profit = profit;
    }
    
>>>>>>> 6c803d04980cb55b05d9572ae8dc83ca1d9326c6
    ArrayList<Constraints> constraints = new ArrayList<Constraints>();

    public void setConstraints(ArrayList<Constraints> constraints) {
        this.constraints = constraints;
    }
    String profitCalPath;
    String constCalPath;
    OutputStream stdin = null;
    InputStream stderr = null;
    InputStream stdout = null;
    int numberOfVariables = 3; //hard coding
    //static String profit = "5+7";
    JavaSourceCompiler.CompilationUnit compilationUnit;
    JavaSourceCompiler javaSourceCompiler;
    String content_profit;
    profitInterface pFunction;
    
    //remove later
    public static void main(String args[]) throws IOException {
        //genProfitCalc();
        Input i = new Input();
        // i.genProfitCalc();
<<<<<<< HEAD
        i.genConstraintCalc();
        boolean flag=i.validateInput();System.out.print(flag);
=======
        //i.genConstraintCalc();
>>>>>>> 6c803d04980cb55b05d9572ae8dc83ca1d9326c6

    }

    Input() {
        javaSourceCompiler = new JavaSourceCompilerImpl();
        compilationUnit = javaSourceCompiler.createCompilationUnit();
    }

    Input(String profit, ArrayList<Constraints> constraints) {
        this.profit = profit;
        this.constraints = constraints;
        
    }

    /**
     * This method creates and compiles the profit calculator
     *
     * @throws IOException
     */
public void genProfitCalc() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        javaSourceCompiler = new JavaSourceCompilerImpl();
	compilationUnit = javaSourceCompiler.createCompilationUnit();	
        
	content_profit = "package optimizer;\n"
                +"import java.io.*;\n"
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
        pFunction = (profitInterface)pClass.newInstance();
        

        
        
        //ArrayList<Double> list = new ArrayList<Double>();
        //list.add(2.0);
        //list.add(3.0);
        //list.add(4.0);
        //return pFunction.computeProfit(list);
    }

 public double returnProfit(double[] bagpipeVals)
 {
     System.out.println(pFunction.computeProfit(bagpipeVals));
     return pFunction.computeProfit(bagpipeVals);
 }
    /**
     * This method creates and compiles the constraint calculator
     *
     * @throws IOException
     */
<<<<<<< HEAD
    public void genConstraintCalc() throws IOException {

        int size = constraints.size();
        /**
         * Test code
         */
        size = 2;
        Constraints c = new Constraints();
        c.setConstraint("x1>5");

        Constraints c1 = new Constraints();
        c1.setConstraint("x8=7");
        constraints.add(c);
        constraints.add(c1);
        // Testing end

        String contentConstraints = "import java.util.ArrayList;\n"
                + "import java.util.Arrays;\n"
                + "\n"
                + "public class ConstraintCalc {\n"
=======


 /**
     * This method creates and compiles the constraint calculator
     *
     * @throws IOException
     */
    public double genConstraintCalc(double[] bagpipeVals) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	int size = constraints.size();
	double pTotal=0.0;
	JavaSourceCompiler javaSourceCompiler = new JavaSourceCompilerImpl();
        JavaSourceCompiler.CompilationUnit compilationUnit = javaSourceCompiler.createCompilationUnit();
    	for(int i=0; i<size; i++)
	{
	Constraints con = constraints.get(i);
	double pValue = 0.0;
        System.out.println(con.getConst_LHS());
	String contentConstraints = "package optimizer;\n"
                +"import java.io.*;\n"
>>>>>>> 6c803d04980cb55b05d9572ae8dc83ca1d9326c6
                + "\n"
		+ "import  java.lang.Math.*;\n"
                + "  import java.util.ArrayList;  \n"
                + "public class ConstraintCalc implements constraintInterface {\n"
                + "\n"
                + "    public double checkConstraints(double[] bagpipeVals)\n"
                + "    {\n"
<<<<<<< HEAD
                + "        double x1,x2,x3,x4,x5,x6,x7,x8,x9,x10;\n"
                + "        x1 = bagpipeVals.get(0);\n"
                + "        x2 = bagpipeVals.get(1);\n"
                + "        x3 = bagpipeVals.get(2);\n"
                + "        x4 = bagpipeVals.get(3);\n"
                + "        x5 = bagpipeVals.get(4);\n"
                + "        x6 = bagpipeVals.get(5);\n"
                + "        x7 = bagpipeVals.get(6);\n"
                + "        x8 = bagpipeVals.get(7);\n"
                + "        x9 = bagpipeVals.get(8);\n"
                + "        x10 = bagpipeVals.get(9);\n"
                + "        double[] constArr = new double[" + size + "];\n"
                + "        double[] penalty = new double[" + size + "];";

        for (int i = 0; i < size; i++) {
            contentConstraints = contentConstraints.concat("\nif(constraint.get("+i+").getConstraint())\n" +
"        {\n" +
"            penalty["+i+"]=Math.abs(constraint.get("+i+").getConst_RHS()-constraint.get("+i+").getConst_LHS());\n" +
"        }");
            //contentConstraints = contentConstraints.concat("\n      constArr[" + i + "]=" + constraints.get(i).getConst_LHS() + ";");
            //contentConstraints = contentConstraints.concat("\nif (constArr[" + i + "]" + constraints.get(i).getConst_sign() +constraints.get(i).getConst_RHS() + ")\n {penalty["+i+"] = ("+constraints.get(i).getPenalty()+")*Math.abs("+constraints.get(i).getConst_RHS()+"-constArr["+size+"]);\n}");
=======
		+ "        double [] x = bagpipeVals; \n"
                + "        double p_temp=0; \n"
		+ "        if(("+con.getConstraint()+")) \n"
                + "	   p_temp = 0;\n"
                + "	   else \n"
                + "	   p_temp = "+con.getConst_LHS()+";\n"
                + "        return p_temp;			\n"
                + "      			\n"
		+ "  				\n"
		+ "    }\n"  
		+ " }\n";
	
	compilationUnit.addJavaSource("optimizer.ConstraintCalc", contentConstraints);
    	ClassLoader classLoader = javaSourceCompiler.compile(compilationUnit);
    	Class cClass = classLoader.loadClass("optimizer.ConstraintCalc");
    	constraintInterface t = (constraintInterface)cClass.newInstance();
	double lhs= t.checkConstraints(bagpipeVals) ;
        double rhs;
        double difference;
	if(lhs==0)
        {
                        difference=0;
>>>>>>> 6c803d04980cb55b05d9572ae8dc83ca1d9326c6
        }
        else
        {
               rhs = Double.parseDouble(con.getConst_RHS());
               difference= rhs-lhs;
        }
	if(difference<0)
        {
            difference = -1 * difference;
        }
            pValue = difference * con.getPenalty();
        
	pTotal= pTotal + pValue;
	}
	System.out.println(pTotal);
        return pTotal;
	}
  

    /**
     * This method calculates the profit for each production schedule
     */
    public void computeProfit(ArrayList<Double> bagpipeVal) throws IOException {
        String[] cmd = {"java",
            "-classpath",
            "C:\\Program Files\\RuntimeTest\\ProfitCalc", bagpipeVal.get(0).toString(),
            bagpipeVal.get(1).toString(), bagpipeVal.get(2).toString(),
            bagpipeVal.get(3).toString(), bagpipeVal.get(4).toString(),
            bagpipeVal.get(5).toString(), bagpipeVal.get(6).toString(),
            bagpipeVal.get(7).toString(), bagpipeVal.get(8).toString(),
            bagpipeVal.get(9).toString()
        };
        Process process = Runtime.getRuntime().exec(cmd);

        stdin = process.getOutputStream();
        stderr = process.getErrorStream();
        stdout = process.getInputStream();

        String profit1 = stdin.toString();
    }

    /**
     * This method calculates the total penalty that applies on a schedule
     */
    public void computePenalty(ArrayList<Double> bagpipeVal) throws IOException {
        String[] cmd = {"java",
            "-classpath",
            "C:\\Program Files\\RuntimeTest\\ConstraintCalc", bagpipeVal.get(0).toString(),
            bagpipeVal.get(1).toString(), bagpipeVal.get(2).toString(),
            bagpipeVal.get(3).toString(), bagpipeVal.get(4).toString(),
            bagpipeVal.get(5).toString(), bagpipeVal.get(6).toString(),
            bagpipeVal.get(7).toString(), bagpipeVal.get(8).toString(),
            bagpipeVal.get(9).toString()
        };
        Process process = Runtime.getRuntime().exec(cmd);

        stdin = process.getOutputStream();
        stderr = process.getErrorStream();
        stdout = process.getInputStream();

    }
    
    /**
     * This method checks that every variable present in the profit function has at least one constraint defined on it
     */
    public boolean validateInput()
    {
        ArrayList<String> inputVars = new ArrayList<String>();
        int i=0;
        boolean flag = false ;
        //for(int j=0; j<numberOfVariables; j++)
        while(i!=profit.length()-1)
        {
            
        i = profit.indexOf("x",i);
        if(i>=0){
        inputVars.add("x"+profit.charAt(i+1));}
        i++;
        }
        
        for (String s:inputVars)
        {
            flag = false;
            for(Constraints s1:constraints)
            {
                String cons = s1.getConstraint();
                if(cons.contains(s))
                {
                    flag= true;
                    
                }
            }
            
            if(flag==false)
            {
                System.out.println("Not even one constraint present on "+s);
                System.out.println("Inputs not validated..");
                return false;
            }
            
        }
        System.out.println("Inputs validated.");
        return true;
    }

    public void calcNoOfVariables() {
    }

    public int getNoOfVariables() {
        return this.numberOfVariables;
    }

    public String getProfitCalPath() {
        return profitCalPath;
    }

    public void setProfitCalPath(String profitCalPath) {
        this.profitCalPath = profitCalPath;
    }

    public String getConstCalPath() {
        return constCalPath;
    }

    public void setConstCalPath(String constCalPath) {
        this.constCalPath = constCalPath;
    }
}
