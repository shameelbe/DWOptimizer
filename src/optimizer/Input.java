/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author smriti
 */
public class Input {

    int numberOfVariables = 0;
    static String profit = "5+7";
    //remove later
    public static void main(String args[]) throws IOException
    {
        genProfitCalc();
        genConstraintCalc();
    }
    
    
    Input() {
    }
    ;
    
    static ArrayList<Constraints> constraints = new ArrayList<Constraints>();
    String profitCalPath;
    String constCalPath;

    Input(String profit, ArrayList<Constraints> constraints) {
        this.profit = profit;
        this.constraints = constraints;
    }

    public static void genProfitCalc() throws IOException {
        String content_profit = "import java.io.*;\n"
                + "\n"
                + "public class ProfitCalc {\n"
                + "    \n"
                + "    public static void main(String[] args) {\n"
                + "        System.out.println(\"Hello World\");\n"
                + "		double x1,x2,x3,x4,x5,x6,x7,x8,x9,x10;\n"
                + "		double profit;\n"
                + "		profit = " + profit + "; \n"
                + "		\n"
                + "    }\n"
                + "    \n"
                + "}";

        File file = new File("C:\\Program Files\\RuntimeTest\\ProfitCalc.java");

        // if file doesnt exists, then create it
        
            file.createNewFile();
            System.out.println("File created");
            System.out.println(file.getCanonicalPath());
        

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content_profit);
        bw.close();

        // compile the java file
        String[] cmd1 = {"javac", "C:\\Program Files\\Java\\jdk1.7.0_25\\bin\\ProfitCalc.java"};
        Process process1 = Runtime.getRuntime().exec(cmd1);


    }

    public static void genConstraintCalc() throws IOException {

        int size = constraints.size();
        /**
         * Test code
         */
        size =2;
        Constraints c = new Constraints();
        c.setConst_LHS("5+7");
        
        Constraints c1 = new Constraints();
        c1.setConst_LHS("Math.sqrt(36)");
        constraints.add(c);constraints.add(c1);
        
        String contentConstraints = "import java.io.*;\n"
                + "\n"
                + "public class ConstraintCalc {\n"
                + "    \n"
                + "    public static void main(String[] args) {\n"
                + "        System.out.println(\"Hi..in the constraints file\");\n"
                + "		double[] constArr = new double[" + size + "];\n"
                + "        for(int i=0; i<" + size + "; i++)\n"
                + "        {";

        for (int i = 0; i < size; i++) {
            contentConstraints = contentConstraints.concat("\nconstArr[" + i + "]=" + constraints.get(i).getConst_LHS() + ";\n");
        }
        contentConstraints = contentConstraints.concat("}\n"
                + "    \n"
                + "}");

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
    
    public void calcNoOfVariables(){
        
    }
    
    public int getNoOfVariables(){
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
