package optimizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * This class is responsible for defining all the requirements pertaining to GUI
 * and passes the input received from user to the input class. LIBRARY for JAVA
 * code Compilation at runtime. Link :
 * https://code.google.com/p/compilation-toolbox/downloads/list
 *
 * @author Shameel and Samuel Reference : We used the free open source JAVA
 */
public class OptimizerGUI extends javax.swing.JDialog {

    int count = 0;
    DefaultListModel d = new DefaultListModel();  //DefaultListModel to control the JList
    private ArrayList<String> constraint = new ArrayList<String>(); //store contraints 
    private ArrayList<String> penalty = new ArrayList<String>(); // store penalty
    private ArrayList<Constraints> cList = new ArrayList<Constraints>();
    private int i;

    /**
     * Creates new form Proj_Mockup
     */
    public OptimizerGUI() {
    }

    public OptimizerGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ProfitFunction = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        ResourceLabel = new javax.swing.JLabel();
        ConstraintsLabel = new javax.swing.JLabel();
        PenaltyLabel = new javax.swing.JLabel();
        ResourceType = new javax.swing.JComboBox();
        Constraint = new javax.swing.JTextField();
        Penalty = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        RemoveButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        DisplaySchedule = new javax.swing.JButton();
        ViewPastSchedules = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        DisplayArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PROFIT FUNCTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 0, 51)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 255));

        jLabel1.setText("Enter the Profit Function");

        ProfitFunction.setText("Input Profit Function");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(ProfitFunction, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ProfitFunction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "RESOURCES AND CONSTRAINTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 51, 51)));
        jPanel2.setToolTipText("");

        ResourceLabel.setText("Resource");

        ConstraintsLabel.setText("Constraint");

        PenaltyLabel.setText("Penalty");

        ResourceType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Resource1", "Resource2","Resource3","Resource4","Resource6","Resource7","Resource8","Resource9","Resource10"}));
        ResourceType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResourceTypeActionPerformed(evt);
            }
        });

        Constraint.setText("Enter Constraint Function");
        Constraint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConstraintActionPerformed(evt);
            }
        });

        Penalty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PenaltyActionPerformed(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        RemoveButton.setText("Remove");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ResourceLabel)
                                .addGap(0, 37, Short.MAX_VALUE))
                            .addComponent(ResourceType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConstraintsLabel)
                            .addComponent(Constraint, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Penalty, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddButton))
                    .addComponent(PenaltyLabel)
                    .addComponent(RemoveButton)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResourceLabel)
                    .addComponent(ConstraintsLabel)
                    .addComponent(PenaltyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResourceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Constraint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Penalty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveButton))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DisplaySchedule.setText("Display Production Schedule");
        DisplaySchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayScheduleActionPerformed(evt);
            }
        });

        ViewPastSchedules.setText("View Past Schedules");
        ViewPastSchedules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewPastSchedulesActionPerformed(evt);
            }
        });

        DisplayArea.setColumns(20);
        DisplayArea.setRows(5);
        jScrollPane2.setViewportView(DisplayArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DisplaySchedule)
                    .addComponent(ViewPastSchedules))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(DisplaySchedule)
                        .addGap(18, 18, 18)
                        .addComponent(ViewPastSchedules)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Help ?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PenaltyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PenaltyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PenaltyActionPerformed

    /**
     * Passes the input profit function to Input Class object Adds the created
     * the constraint object to list and passes the same to input class Creates
     * an object of Scheduler and invoke the appropriate method to start
     * optiizmation process
     */
    private void DisplayScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayScheduleActionPerformed
        // TODO add your handling code here:       

        Input Start = new Input();
        Start.setProfit(ProfitFunction.getText());
        try {
            Start.genProfitCalc();
        } catch (IOException ex) {
            Logger.getLogger(OptimizerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error in Compiling Classes runtime. Please check your JRE version", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(OptimizerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Error in Compiling Classes runtime. Please check your JRE version", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(OptimizerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Error in Compiling Classes runtime. Please check your JRE version", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(OptimizerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Input Profit Function", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Start.setConstraints(cList);

        if (Start.validateInput()) {
            //get from scheduler
            Scheduler sch = new Scheduler();
            double[] list = null;
            String result = " ";
            //get from scheduler

            try {
                list = sch.createSchedule(Start);
                for (int l = 0; l < list.length; l++) {
                    result = result + " " + list[l];
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error in Compiling Classes runtime. Please check your JRE version", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(OptimizerGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error in Compiling Classes runtime. Please check your JRE version", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(OptimizerGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                JOptionPane.showMessageDialog(null, "Error in Compiling Classes runtime. Please check your JRE version", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(OptimizerGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                JOptionPane.showMessageDialog(null, "Error in Compiling Classes runtime. Please check your JRE version", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(OptimizerGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Input Constraint Function", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, "Error in Input Variables. Values should range from x[0] to x[9] and ordered numerically", "Error", JOptionPane.ERROR_MESSAGE);
            }
            String finalProfit = " Profit:" + sch.getFinalProfit();
            result = result + finalProfit;
            DisplayArea.setText(result);
        }
    }//GEN-LAST:event_DisplayScheduleActionPerformed

    private void ConstraintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConstraintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConstraintActionPerformed

    /**
     * Adds the Constraint values from the constraint text box to the list and
     * to the Input Class Object
     */
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed

        String[] strings = new String[3];
        strings[0] = (String) ResourceType.getSelectedItem();
        strings[1] = Constraint.getText();
        constraint.add(strings[1]);
        strings[2] = Penalty.getText();
        penalty.add(strings[2]);

        Constraints con = new Constraints();
        con.setConstraint(strings[1]);
        con.setResource_name(strings[0]);
        try {
            con.setPenalty((int) Double.parseDouble(strings[2]));
            con.split();
            cList.add(con);
            d.add(count, "Constraint Function of " + strings[0] + " : " + strings[1] + " And Penalty = " + strings[2]);
            jList1.setModel(d);
            Constraint.setText("");
            Penalty.setText("");
            count++;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Enter a valid number for penalty", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(OptimizerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    /**
     * Removes the Constraint values from the constraint text box to the list
     * and to the Input Class Object
     */
    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        // Remove selected contraints
        try {
            String Temp = jList1.getSelectedValue().toString();
            int size = cList.size();
            for (int k = 0; k < size; k++) {
                if (Temp.contains((cList.get(k)).getConstraint())) {
                    cList.remove(k);
                }
            }
            constraint.remove(jList1.getSelectedIndex());
            penalty.remove(jList1.getSelectedIndex());
            d.remove(jList1.getSelectedIndex());
            count--;
            //Test Part
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No Vaues to remove", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_RemoveButtonActionPerformed

    @SuppressWarnings("empty-statement")
    private void ViewPastSchedulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewPastSchedulesActionPerformed
        // TODO add your handling code here:
        //TEST
        int j = constraint.size();
        System.out.println(getConstraint());
        System.out.println(getPenalty());
        System.out.println(getProfitFunction());
        System.out.println(DisplayArea.getText());
        DisplayArea.setText("Past Schedule");// We need to get past schedule and print them out here
    }//GEN-LAST:event_ViewPastSchedulesActionPerformed

    private void ResourceTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResourceTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResourceTypeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "The Darwinian Production Scheduler:\n"
                + "\n"
                + "The Darwinian Scheduler uses Genetic Algorithms to compute the most optimal production schedule for the given profit function and set of resource constraints.\n"
                + "\n"
                + "Sample profit function:\n"
                + "x[0]+x[1]+x[3]\n"
                + "\n"
                + "Sample constraint:\n"
                + "x[0]+x[1]+x[3]<150\n"
                + "\n"
                + "x[0],x[1],x[2] are the three different types of bagpipes that need to be produced.\n"
                + "The program can create a schedule for a maximum of 10 different type of bagpipes.\n"
                + "There should be at least one constraint on every type of bagpipe being produced.", "Help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    public ArrayList<String> getConstraint() {
        return constraint;
    }

    public void setConstraint(ArrayList<String> constraint) {
        this.constraint = constraint;
    }

    public String getProfitFunction() {
        return ProfitFunction.getText();
    }

    public void setProfitFunction(JTextField ProfitFunction) {
        this.ProfitFunction = ProfitFunction;
    }

    public ArrayList<String> getPenalty() {
        return penalty;
    }

    public void setPenalty(ArrayList<String> penalty) {
        this.penalty = penalty;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OptimizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptimizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptimizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptimizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OptimizerGUI dialog = new OptimizerGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextField Constraint;
    private javax.swing.JLabel ConstraintsLabel;
    private javax.swing.JTextArea DisplayArea;
    private javax.swing.JButton DisplaySchedule;
    private javax.swing.JTextField Penalty;
    private javax.swing.JLabel PenaltyLabel;
    private javax.swing.JTextField ProfitFunction;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JLabel ResourceLabel;
    private javax.swing.JComboBox ResourceType;
    private javax.swing.JButton ViewPastSchedules;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
