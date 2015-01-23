
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fraserhood
 */
public class Rename extends javax.swing.JFrame {

    /**
     * Creates new form Rename
     */
    FileReader fileReader;
    BufferedReader bufferedReader;
    //Adding this to fix plots if number of thermometers is changed.
    Integer number;
    
    /*
    This is the constructor, it creates individual instances of the object.
    It initializes arrays that I use to cycle through the various fields in 
    the gui to make the code cleaner. The arrays contain the individual text
    fields.
    */
    public Rename() {
        initComponents();
        //Set the default number of sensors to 4.
        
        numSen.setSelectedIndex(3);
        
        //Create the arrays
        
        JTextField[] h = new JTextField[]{h1,h2,h3,h4};
        JTextField[] l = new JTextField[]{l1,l2,l3,l4};
        
        //Disable the next button until the save button is clicked.
        next.setEnabled(false);
        
        //Create new file to write information to.
        File file = new File("Name");
        
        //Check if the file already exits (setup has been run previously)
        
        if(file.exists()){
            
            //Parse the text in the file into the fields of the gui.
          try{
            fileReader = new FileReader("Name");
            bufferedReader = new BufferedReader(fileReader);
            String s = bufferedReader.readLine();
            
            //This shouldn't cause problems because if no information is entered
            //a newline is saved so it should just read nothing.
            rn1.setText(s);
            s = bufferedReader.readLine();
            rn2.setText(s);
            s = bufferedReader.readLine();
            rn3.setText(s);
            s = bufferedReader.readLine();
            rn4.setText(s);
            s = bufferedReader.readLine();
            String[] strArr = s.split(",");
            
            //Read the temperature info into the correct text box.
            s = bufferedReader.readLine();
            
            Integer i = Integer.parseInt(s);
            //nvmnd //changed to strArr.length from <= i*2+1
            for(int j =0; j<(i+1)*2;j++){
                if((j%2==0) || (j==0)){
                    h[j/2].setText(strArr[j]);
                }else{
                    l[j/2].setText(strArr[j]);
                }
            }
            
            //Sets the number of sensors and fills out the rest of the fields.
            numSen.setSelectedIndex(i);
            number = i;
            s = bufferedReader.readLine();
            sampleInterval.setText(s);
            
            bufferedReader.close();
          }catch(IOException e){
              
          }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        rn1 = new javax.swing.JTextField();
        rn2 = new javax.swing.JTextField();
        rn3 = new javax.swing.JTextField();
        rn4 = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        h1 = new javax.swing.JTextField();
        h2 = new javax.swing.JTextField();
        h3 = new javax.swing.JTextField();
        h4 = new javax.swing.JTextField();
        l1 = new javax.swing.JTextField();
        l2 = new javax.swing.JTextField();
        l3 = new javax.swing.JTextField();
        l4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        numSen = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sampleInterval = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        toCell = new javax.swing.JMenuItem();
        toDailyMail = new javax.swing.JMenuItem();
        toWebPost = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rn1.setText("thermometer 1");

        rn2.setText("thermometer 2");

        rn3.setText("thermometer 3");

        rn4.setText("thermometer 4");

        save.setText("save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        next.setText("next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jLabel1.setText("1.)");

        jLabel2.setText("2.)");

        jLabel3.setText("3.)");

        jLabel4.setText("4.)");

        h1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h1ActionPerformed(evt);
            }
        });

        jLabel5.setText("High");

        jLabel6.setText("Low");

        jLabel7.setText("# of sensors");

        numSen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        numSen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numSenActionPerformed(evt);
            }
        });

        jLabel8.setText("Name of Sensor");

        jLabel9.setText("Sample Interval (m)");

        sampleInterval.setText("15");

        jMenu1.setText("File");

        toCell.setText("Alarm Email");
        toCell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toCellActionPerformed(evt);
            }
        });
        jMenu1.add(toCell);

        toDailyMail.setText("Text Alarms");
        toDailyMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toDailyMailActionPerformed(evt);
            }
        });
        jMenu1.add(toDailyMail);

        toWebPost.setText("Daily Email");
        toWebPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toWebPostActionPerformed(evt);
            }
        });
        jMenu1.add(toWebPost);

        jMenuItem1.setText("Web Post");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                        .addComponent(next))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rn4)
                                .addComponent(rn3)
                                .addComponent(rn2)
                                .addComponent(rn1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(h3)
                                .addComponent(h1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(h2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(l3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numSen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(sampleInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(46, 46, 46)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numSen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sampleInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(next))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
    Executed when the user clicks save. Writes all of the pertinent information
    to a file called Name.
    */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        //This code does all of the actuall writing.
        try{
            fileWriter= new FileWriter("Name");
            //Create buffereWriter with fileWriter object for file i/o
            bufferedWriter= new BufferedWriter(fileWriter); 
            bufferedWriter.write(rn1.getText() + "\n");
            bufferedWriter.write(rn2.getText() + "\n");
            bufferedWriter.write(rn3.getText() + "\n");
            bufferedWriter.write(rn4.getText() + "\n");
            bufferedWriter.write(h1.getText() + "," + l1.getText() + ","+h2.getText() + "," + l2.getText() + ","+h3.getText() + "," + l3.getText() + ","+h4.getText() + "," + l4.getText() + "\n");
            bufferedWriter.write(numSen.getSelectedIndex() + "\n");
            bufferedWriter.write(sampleInterval.getText() + "\n");
            bufferedWriter.close();
            
            /* 1/8/15 - this is a fix to allow the user to change the number of
            thermometers without disrupting the plots. I will save an old plot
            and have the program begin to create a new one.
            */
            
            /*
            This code needs to be made to work. DO IT!
            */
            /*if(number != numSen.getSelectedIndex()){
                
                Integer i = 1;
                
                DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
                Date date = new Date();
                String s = dateformat.format(date);
            
                //Find the two files that will need to be modified.
                File file = new File("/home/pi/ComScriptPi/profiles/Temperature_parse/TempData.txt");
                File file2 = new File("/home/pi/ComScriptPi/profiles/Temperature_parse/TempDataPlot.png");
                File newFile = new File(file.getName() + "-" + s + " ");
                File newFile2 = new File(file2.getName() + "-" + s + " ");
                
                //Check if this has been done before
                if(newFile.exists()){
                    while(newFile.exists()){
                        newFile = new File(newFile.getName() + i.toString());
                        i++;
                    }
                    newFile.createNewFile();
                }else{
                    newFile.createNewFile();
                }
                
                i = 1;
                if(newFile2.exists()){
                    while(newFile2.exists()){
                        newFile2 = new File(newFile2.getName() + i.toString());
                        i++;
                    }
                    newFile2.createNewFile();
                }else{
                    newFile2.createNewFile();
                }
                
                
                
                if(file.exists()){
                    System.out.println("ln test: 1");
                    Boolean bool = file.renameTo(newFile);
                    if(bool){
                        System.out.println("entering second if statement");
                        file.delete();
                    }
                    
                    bool = file2.renameTo(newFile2);
                    if(bool){
                        file2.delete();
                    }
                    
                }
                
            }*/
            
            next.setEnabled(true);
        }catch(IOException e){
            numSen.setSelectedIndex(0);
                
        }
    }//GEN-LAST:event_saveActionPerformed

    /*
    Executed when the user clicks next. Makes this window invisible and 
    creates and displays the next window.
    */
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        this.setVisible(false);
        new Email().setVisible(true);

    }//GEN-LAST:event_nextActionPerformed
    
    /*
    This is an accident. Doesnt do anything and shouldnt do anything.
    */
    private void h1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_h1ActionPerformed

    /*
    Runs when the user selects the number of sensors of the program selects the
    number of sensors. Essentially just runs whenever that little menu is changed.
    */
    private void numSenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numSenActionPerformed
       /*
        Create a ton of arrays that constain all of the objects in the gui. This
        is so that I can cycle through them with for loops rather than calling 
        them one at a time within if statements. (I use these arrays a lot I 
        should really just make them fields in the class)
        */
       Component[] comp = new Component[]{rn1,rn2,rn3,rn4,h1,l1,h2,l2,h3,l3,h4,l4,jLabel1,jLabel2,jLabel3,jLabel4};
       Component[] compR = new Component[]{rn1,rn2,rn3,rn4};
       Component[] compH = new Component[]{h1,h2,h3,h4};
       Component[] compL = new Component[]{l1,l2,l3,l4};
       Component[] compN = new Component[]{jLabel1,jLabel2,jLabel3,jLabel4};
       //Start by setting everything to false.
       for(int i=0;i<comp.length;i++){
           comp[i].setEnabled(false);
       }
       //Enable the fields based on the number of thermometers being used.
       for(int i=0;i<=numSen.getSelectedIndex();i++){
           compR[i].setEnabled(true);
           compH[i].setEnabled(true);
           compL[i].setEnabled(true);
           compN[i].setEnabled(true);
       }
       //Set unused names to not in use.
       for(int i = 3; i > (numSen.getSelectedIndex()); i--){
           //requires a cast to the original class to use setText method.
           ((JTextField)compR[i]).setText("Not in use!");
       }
    }//GEN-LAST:event_numSenActionPerformed

    /*
    The following methods are called from within the file menu. They allow
    the user to visit specific windows rather than going through them all one
    by one even though they only want to change one email.
    */
    private void toCellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toCellActionPerformed
        this.setVisible(false);
        new Email().setVisible(true);
    }//GEN-LAST:event_toCellActionPerformed

    private void toDailyMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDailyMailActionPerformed
        this.setVisible(false);
        new Cell().setVisible(true);
    }//GEN-LAST:event_toDailyMailActionPerformed

    private void toWebPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toWebPostActionPerformed
        this.setVisible(false);
        new DailyMail().setVisible(true);
    }//GEN-LAST:event_toWebPostActionPerformed

    /*
    !!! Name this something rational next time you are mucking around with the
    gui !!!
    */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
        new webpostinfo().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    /*
    Main method. I havent added anything so there is no reason to edit this at
    all.
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
            java.util.logging.Logger.getLogger(Rename.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rename.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rename.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rename.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rename().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField h1;
    private javax.swing.JTextField h2;
    private javax.swing.JTextField h3;
    private javax.swing.JTextField h4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JTextField l1;
    private javax.swing.JTextField l2;
    private javax.swing.JTextField l3;
    private javax.swing.JTextField l4;
    private javax.swing.JButton next;
    private javax.swing.JComboBox numSen;
    private javax.swing.JTextField rn1;
    private javax.swing.JTextField rn2;
    private javax.swing.JTextField rn3;
    private javax.swing.JTextField rn4;
    private javax.swing.JTextField sampleInterval;
    private javax.swing.JButton save;
    private javax.swing.JMenuItem toCell;
    private javax.swing.JMenuItem toDailyMail;
    private javax.swing.JMenuItem toWebPost;
    // End of variables declaration//GEN-END:variables
}
