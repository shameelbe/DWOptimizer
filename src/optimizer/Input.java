package optimizer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author smriti
 */
public class Input {

    String profit="x1+x4x7";
    ArrayList<Constraints> constraints = new ArrayList<Constraints>();
    String profitCalPath;
    String constCalPath;
    OutputStream stdin = null;
    InputStream stderr = null;
    InputStream stdout = null;
    int numberOfVariables = 0;
    //static String profit = "5+7";
    
    //remove later
    public static void main(String args[]) throws IOException {
        //genProfitCalc();
        Input i = new Input();
        // i.genProfitCalc();
        i.genConstraintCalc();
        boolean flag=i.validateInput();System.out.print(flag);

    }

    Input() {
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
    public void genProfitCalc() throws IOException {
        String content_profit = "import java.io.*;\n"
                + "\n"
                + "public class ProfitCalc {\n"
                + "    \n"
                + "    public static void main(String[] args) {\n"
                + "        System.out.println(\"Hello World\");\n"
                + "            ArrayList<Double> bagpipeVals = new ArrayList<>();\n"
                + "              \n"
                + "            for(int i=0;i<10;i++){\n"
                + "				bagpipeVals.add(Double.parseDouble(args[i]));\n"
                + "				}\n"
                + "                computeProfit(bagpipeVals);\n"
                + "    }\n"
                + "    \n"
                + "	\n"
                + "	public static void computeProfit(ArrayList<Double> bagpipeVals)\n"
                + "    {\n"
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
                + "        profit =" + profit + ";\n"
                + "        System.out.println(\"profit = \"+profit);\n"
                + "    }\n"
                + "        \n"
                + "}";

        File file = new File("C:\\Program Files\\RuntimeTest\\ProfitCalc.java");

        // if file doesnt exists, then create it
        file.createNewFile();
        System.out.println("File created");
        System.out.println(file.getCanonicalPath());

        //write the contents to the file
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content_profit);
        bw.close();

        // compile the java file
        String[] cmd1 = {"javac", "C:\\Program Files\\Java\\jdk1.7.0_25\\bin\\ProfitCalc.java"};
        Process process1 = Runtime.getRuntime().exec(cmd1);
    }

    /**
     * This method creates and compiles the constraint calculator
     *
     * @throws IOException
     */
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
                + "\n"
                + "    \n"
                + "    public static void main(String[] args) {\n"
                + "        \n"
                + "        System.out.println(\"Hi..in the constraints file\");\n"
                + "        ArrayList<Double> bagpipeVals = new ArrayList<>();\n"
                + "       \n"
                + "        for (int i = 0; i < 10; i++) {\n"
                + "            bagpipeVals.add(Double.parseDouble(args[i]));\n"
                + "        }\n"
                + "        \n"
                + "        checkConstraints(bagpipeVals);\n"
                + "    }\n"
                + "\n"
                + "    public static void checkConstraints(ArrayList<Double> bagpipeVals)\n"
                + "    {\n"
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
        }
        contentConstraints = contentConstraints.concat("\n      System.out.println(Arrays.toString(penalty));");
        contentConstraints = contentConstraints.concat("}\n}");

        File file = new File("C:\\Program Files\\RuntimeTest\\ConstraintCalc.java");
        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contentConstraints);
        bw.close();

        String[] cmd2 = {"javac", "C:\\Program Files\\Java\\jdk1.7.0_25\\bin\\ConstraintCalc.java"};
        Process process2 = Runtime.getRuntime().exec(cmd2);

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
