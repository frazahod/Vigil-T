
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class Email extends javax.swing.JFrame {

    /**
     * Creates new form Email
     */
    /*
    Create some fields used by the rest of the program.
    */
    Integer num;
    FileReader fileReader;
    BufferedReader bufferedReader;
    JTextField[] compArr;
    
    /* (for those uninitiated with Java/OO languages.)
    Constructor. This is not a method this creates individual instances of the
    class. You would usually only use this for things like initializing fields
    but I was having some problems with Java bitching about static references to
    dynamic blah blah blah so I have shoved a lot of extraneous code in here.
    */
    public Email() {
        initComponents();
        //Disable next until the user saves thier information.
        next.setEnabled(false);
        //Create some arrays to cycle through for coding convenienvce.
        /*
        Note that one of these arrays (the one that is already initialized) is 
        a field. That means I use it later. That also means that the constructor
        is actually constructing beyond initComponents() which is a miracle.
        */
        compArr = new JTextField[]{emails1,emails2,emails3,emails4};
        Component[] comp2 = new Component[]{jLabel1,jLabel2,jLabel3,jLabel4};
        Component[] comp3 = new Component[]{name1,name2,name3,name4};
        //probably to scared to totally remove this array.
        //Component[] comp4 = new Component[]{emails1,emails2,emails3,emails4};
        
        /*
        Create a new file object called Name. Name is the name of the file that
        stores such important things as how many thermometers are being connected
        and what they are called.
        */
        File file = new File("Name");
        
        /*
        If the user is in this part of the setup program than Name should already
        exist and if it doesnt nothing is going to work anyway, but better safe
        than sorry.
        */
        if(file.exists()){
            
          /*
          This is where all of the file reading and filling fields in the gui
            happens. The try catch is there because we don't want the whole thing
            to crash if there is a problem reading the file.
          */
          try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            //Use readLine to read in the text from the file and then set the gui.
            String s = bufferedReader.readLine();
            
            name1.setText(s);
            s = bufferedReader.readLine();
            name2.setText(s);
            s = bufferedReader.readLine();
            name3.setText(s);
            s = bufferedReader.readLine();
            name4.setText(s);
            
            bufferedReader.readLine();
            num = Integer.parseInt(bufferedReader.readLine());
            /*
            The next two loops just set the relevant fields enabled depending
            on how many thermometers the user said were being used.
            */
            for(int j=0;j<4;j++){
                //I deleted a bunch of commented out arrays.setEnableds 11/29/2014
                compArr[j].setEnabled(false);
                comp2[j].setEnabled(false);
                comp3[j].setEnabled(false);
                
                
            }
            for(int j=0;j<=num;j++){
                
                compArr[j].setEnabled(true);
                comp2[j].setEnabled(true);
                comp3[j].setEnabled(true);
                
                
            }
            
            /*
            This is me actually being clever and meticulous. It stops the drop
            down menu from displaying thermometers that arent being used, so 
            that the user cant select a disabled textbox, break things, and be 
            confused.
            */
            for(int j=3;j>num;j--){
                numSen.removeItemAt(j);
            }
            //Closing the reader is really important if you want anything to 
            //work properly
            bufferedReader.close();
            /*
            Create new file Email. Check if it exits etc.. Email is the name of
            the file that all of the data from this part of the gui is written
            to. I am using multiple files because I didn't bother to code it so
            that it reads from a specific line. A benefit of this is that it is
            easy to find and edit information without opening the GUI because the
            files arent too large and are labeled with their contents.
            */
            file = new File("Email");
            //check if the file is already present.
            if(file.exists()){
                /*
                File parsing based on spaces.
                */
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                s = bufferedReader.readLine();
                String[] sArr = s.split(" ");
                for(int j=0;j<sArr.length;j++){
                    compArr[j].setText(sArr[j]);
                }
                bufferedReader.close();
            }
          }catch(IOException e){
              e.printStackTrace();
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

        emails1 = new javax.swing.JTextField();
        emails2 = new javax.swing.JTextField();
        emails3 = new javax.swing.JTextField();
        emails4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        numSen = new javax.swing.JComboBox();
        emailAdd = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        next = new javax.swing.JButton();
        save = new javax.swing.JButton();
        back = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        toRename = new javax.swing.JMenuItem();
        toCell = new javax.swing.JMenuItem();
        toDailyMail = new javax.swing.JMenuItem();
        toWebPost = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        emails1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emails1FocusGained(evt);
            }
        });

        emails2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emails2FocusGained(evt);
            }
        });

        emails3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emails3FocusGained(evt);
            }
        });

        emails4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emails4FocusGained(evt);
            }
        });

        jLabel1.setText("1.)");

        jLabel2.setText("2.)");

        jLabel3.setText("3.)");

        jLabel4.setText("4.)");

        name1.setText("1");

        name2.setText("2");

        name3.setText("3");

        name4.setText("4");

        numSen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "sensor 1", "sensor 2", "sensor 3", "sensor 4" }));

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        jLabel5.setText("Email");

        jLabel6.setText("Emails below will recieve alarms from the indicated sensor");

        menu.setText("File");

        toRename.setText("Names");
        toRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toRenameActionPerformed(evt);
            }
        });
        menu.add(toRename);

        toCell.setText("Text Alarms");
        toCell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toCellActionPerformed(evt);
            }
        });
        menu.add(toCell);

        toDailyMail.setText("Daily Email");
        toDailyMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toDailyMailActionPerformed(evt);
            }
        });
        menu.add(toDailyMail);

        toWebPost.setText("Web Post");
        toWebPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toWebPostActionPerformed(evt);
            }
        });
        menu.add(toWebPost);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(numSen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(emailAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(add)
                                .addGap(18, 18, 18)
                                .addComponent(remove))
                            .addComponent(emails1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emails2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emails3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emails4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save)
                        .addGap(169, 169, 169)
                        .addComponent(next)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emails1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(name1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emails2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(name2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emails3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(name3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emails4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(name4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numSen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add)
                    .addComponent(remove)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next)
                    .addComponent(save)
                    .addComponent(back))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Runs when the user clicks add. This is the method that adds an email.
    */
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        num = numSen.getSelectedIndex(); //Was int num changed to num 11/29/14
        String s;
        /*
        Get the text from the text field and add it to the selected thermometer.
        If multiple addresses are being used add a comma between them.
        */
        s = compArr[num].getText();
        if(!s.equals("")){
            s += ",";
        }
        s += emailAdd.getText();
        compArr[num].setText(s);
    }//GEN-LAST:event_addActionPerformed

    /*
    This is the method run when the user clicks save. It writes all of the 
    emails that were added to a file.
    */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        /*
        What the hell does bool do? I dont check it inside this method and
        that is where it is declared. I dont want to break anything by removing 
        it but I think that it is useless. Also it is stupid that Java considers
        booleans a primitive. Just use 1 and 0 like C and make our lives easier.
        */
        boolean bool = true;
        
        /*
        Creat email file and write all of the information to it.
        //Why didnt I comment all of this when I wrote it like a responsible adult?
        */
        try{
            fileWriter= new FileWriter("Email");
            bufferedWriter= new BufferedWriter(fileWriter);
            for(int i=0; i<=num;i++){
                if(compArr[i].getText().equals("")){
                    //Warn the user about empty fields when they click save.
                    emailAdd.setText("EMPTY FIELD!");
                    next.setEnabled(false);
                    bool=false;
                    /*
                    I am still on the fence about this code. It deletes the saved
                    file if the user hits save with an empty field. I don't see
                    any reason not to let the user save with empty fields.
                    */
                    File file = new File("Email");
                    file.delete();
                    return;
                }else{
                    bool=true;
                    next.setEnabled(true);
                }
                bufferedWriter.write(compArr[i].getText() + " ");
            }
            bufferedWriter.close();
            
            next.setEnabled(bool);
        }catch(IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveActionPerformed

    /*
    Just sets the selecte thermometer to whichever text box the user clicked on.
    */
    private void emails1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emails1FocusGained
         numSen.setSelectedIndex(0);// TODO add your handling code here:
    }//GEN-LAST:event_emails1FocusGained

    private void emails2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emails2FocusGained
        numSen.setSelectedIndex(1);// TODO add your handling code here:
    }//GEN-LAST:event_emails2FocusGained

    private void emails3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emails3FocusGained
        numSen.setSelectedIndex(2);// TODO add your handling code here:
    }//GEN-LAST:event_emails3FocusGained

    private void emails4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emails4FocusGained
        numSen.setSelectedIndex(3);// TODO add your handling code here:
    }//GEN-LAST:event_emails4FocusGained

    /*
    Removes an email. The commented code allows the emails to be removed one
    by one but Vince didnt like that. Now it just kills all of it. Vince might
    have a rather authoritarian personality. "I dont like that one. Kill them ALL!"
    (I am kind of glad though because the code I removed was really ugly.)
    */
    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        /*String s = compArr[numSen.getSelectedIndex()].getText();
        if(s.contains(emailAdd.getText()+ ",")){
            s = s.replaceAll(emailAdd.getText() + ",", "");
            compArr[numSen.getSelectedIndex()].setText(s);
        }else if(s.contains("," + emailAdd.getText())){
            s = s.replaceAll("," + emailAdd.getText(), "");
            compArr[numSen.getSelectedIndex()].setText(s);
        }else if(s.contains(emailAdd.getText())){
            s = s.replaceAll(emailAdd.getText(), "");
            compArr[numSen.getSelectedIndex()].setText(s);
        }else{
            emailAdd.setText("Email not found!");
        }*/
        compArr[numSen.getSelectedIndex()].setText("");
    }//GEN-LAST:event_removeActionPerformed

    /*
    Goes the the previous startup box. Sets this one invisible. 
    */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
        
        new Rename().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    /*
    Same as above but for next.
    */
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        this.setVisible(false);
        new Cell().setVisible(true);
    }//GEN-LAST:event_nextActionPerformed

    /*
    Allows user to select specific startup windows from the file menu.
    */
    private void toRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toRenameActionPerformed
        this.setVisible(false);
        new Rename().setVisible(true);
    }//GEN-LAST:event_toRenameActionPerformed

    private void toCellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toCellActionPerformed
        this.setVisible(false);
        new Cell().setVisible(true);
    }//GEN-LAST:event_toCellActionPerformed

    private void toDailyMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDailyMailActionPerformed
        this.setVisible(false);
        new DailyMail().setVisible(true);
    }//GEN-LAST:event_toDailyMailActionPerformed

    private void toWebPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toWebPostActionPerformed
        this.setVisible(false);
        new webpostinfo().setVisible(true);
    }//GEN-LAST:event_toWebPostActionPerformed

    /**
     * @param args the command line arguments
     */
    /*
    Dont muck about with this, it is auto-generated code.
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
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Email().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JTextField emailAdd;
    private javax.swing.JTextField emails1;
    private javax.swing.JTextField emails2;
    private javax.swing.JTextField emails3;
    private javax.swing.JTextField emails4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menu;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JButton next;
    private javax.swing.JComboBox numSen;
    private javax.swing.JButton remove;
    private javax.swing.JButton save;
    private javax.swing.JMenuItem toCell;
    private javax.swing.JMenuItem toDailyMail;
    private javax.swing.JMenuItem toRename;
    private javax.swing.JMenuItem toWebPost;
    // End of variables declaration//GEN-END:variables
}
