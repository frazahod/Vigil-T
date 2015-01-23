
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JLabel;
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

/*
This class is extremely similar to the email class, so for futher explanation 
view my comments for that code.
*/
public class Cell extends javax.swing.JFrame {

    /**
     * Creates new form Cell
     */
    
    /*
    Initialize some fields. The file and buffered readers are for optimization.
    The arrays holds fields from the window so that I can use for loops later.
    Except for emailCar. That holds the email adress that allows for email to 
    text..... because we are super high tech.
    */
    Integer num;
    FileReader fileReader;
    BufferedReader bufferedReader;
    JTextField[] compArr;
    String[] emailCar = new String[]{"@txt.att.net","@messaging.sprintpcs.com","@tmomail.net","@vtext.com"};
    String[] cellMail = new String[4];
    String[] cellAlarm;
    Component[] comp3;
    
    /*
    Once again, this is the constructor. It everything inside it is run whenever
    a new instance of the object is created. (i.e. someone calls new Cell()) 
    This means that when the user clicks next from Email it creates a new Cell 
    object and runs everything inside this constructor.
    
    
    */
    public Cell() {
        initComponents();
        //disable next until the user hits save.
        next.setEnabled(false);
        //initialize a bunch of arrays so that the foor loops can be used.
        compArr = new JTextField[]{cells1,cells2,cells3,cells4};
        Component[] comp2 = new Component[]{jLabel1,jLabel2,jLabel3,jLabel4};
        comp3 = new Component[]{name1,name2,name3,name4};
        
        /*
        Create file object with Name, check if it exists and use the information
        from it. For more information see the comments in the Email class.
        */
        File file = new File("Name");
        if(file.exists()){
          try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            
            String s = bufferedReader.readLine();
            name1.setText(s);
            s = bufferedReader.readLine();
            name2.setText(s);
            s = bufferedReader.readLine();
            name3.setText(s);
            s = bufferedReader.readLine();
            name4.setText(s);
            //num is stupidly one less than the actual number of thermometers.
            bufferedReader.readLine();
            num = Integer.parseInt(bufferedReader.readLine());
            /*
            If this breaks everything put the next two commented out lines back
            into the code. (it broke it)
            */
            cellAlarm = new String[4];
            for(int i = 0; i <= num; i++){
                cellAlarm[i] = "y";
            }
            cellMail = new String[4];
            for(int j=0;j<4;j++){
                compArr[j].setEnabled(false);
                comp2[j].setEnabled(false);
                comp3[j].setEnabled(false);
            }
            
            for(int j=0;j<=num;j++){
                compArr[j].setEnabled(true);
                comp2[j].setEnabled(true);
                comp3[j].setEnabled(true);
            }
            
            for(int j=3;j>num;j--){
                numSen.removeItemAt(j);
            }
            
            bufferedReader.close();
            
            /*
            Create Cell file. This is where all of the information for this
            window is stored. If the file exists, read the information from it
            into the fields of the window.
            */
            //System.out.println("problem");
            file = new File("Cell");
            if(file.exists()){
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                //first line plaine numbers
                
                s = bufferedReader.readLine();
                String[] sArr = s.split(" ");
                
                //second line; numbers with extensions
                s = bufferedReader.readLine();
                
                String[] sArr2 = s.split(" ");
                //System.out.println("problem");
                //cellMail[3] = "hello";
                for(int i = 0; i < sArr2.length; i++){
                    cellMail[i] = sArr2[i];
                    //System.out.print(i);
                }
                //System.out.println("problem");
                //cellMail = sArr2;
                for(int i = 0; i < sArr.length; i++){
                    compArr[i].setText(sArr[i]);
                }
                //System.out.println("problem");
                //last line, cell alarms
                s = bufferedReader.readLine();
                //System.out.println("problem");
                String nameLabel;
                String[] tempArr;
                tempArr = s.split(" ");
                //Added to create extra spaces in cellAlarm. Inefficient!
                //String[] tempArr = new String[num +1];
                for(int k = 0; k < tempArr.length; k++){
                    cellAlarm[k] = tempArr[k];
                }
                //cellAlarm = tempArr;
                //System.out.println(s);
                //System.out.println(cellAlarm.length);
                
                for(int i = 0; i <cellAlarm.length; i++){
                    
                    if(cellAlarm[i].equals("y")){
                        nameLabel = ((JLabel)comp3[i]).getText() + ": Alarm ON";
                        ((JLabel)comp3[i]).setText(nameLabel);   
                    }else if(cellAlarm[i].equals("n")){
                        nameLabel = ((JLabel)comp3[i]).getText() + ": Alarm OFF";
                        ((JLabel)comp3[i]).setText(nameLabel);
                    }
                }
                
                
                bufferedReader.close();
            }else{
                String nameLabel;
                for(int i = 0; i <= num; i++){
                    
                    if(cellAlarm[i].equals("y")){
                        nameLabel = ((JLabel)comp3[i]).getText() + ": Alarm ON";
                        ((JLabel)comp3[i]).setText(nameLabel);   
                    }else if(cellAlarm[i].equals("n")){
                        nameLabel = ((JLabel)comp3[i]).getText() + ": Alarm OFF";
                        ((JLabel)comp3[i]).setText(nameLabel);
                    }
                }
            }
            
          }catch(Exception e){
              e.printStackTrace();
              
          }
        }
    }
    
    private void setAlarms(){
        String nameLabel;
        for(int i = 0; i < cellAlarm.length; i++){
            if(cellAlarm[i].equals("y")){
                nameLabel = ((JLabel)comp3[i]).getText();
                nameLabel = nameLabel.replaceAll("OFF", "ON");
                ((JLabel)comp3[i]).setText(nameLabel);   
            }else if(cellAlarm[i].equals("n")){
                nameLabel = ((JLabel)comp3[i]).getText();
                nameLabel = nameLabel.replaceAll("ON", "OFF");
                ((JLabel)comp3[i]).setText(nameLabel);
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

        jMenuItem3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        cells1 = new javax.swing.JTextField();
        name1 = new javax.swing.JLabel();
        cells2 = new javax.swing.JTextField();
        cells3 = new javax.swing.JTextField();
        name2 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cells4 = new javax.swing.JTextField();
        name4 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        back = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textAlarm = new javax.swing.JRadioButton();
        numSen = new javax.swing.JComboBox();
        cellAdd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        carrier = new javax.swing.JComboBox();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fuck = new javax.swing.JMenu();
        toRename = new javax.swing.JMenuItem();
        toEmail = new javax.swing.JMenuItem();
        toDailyMail = new javax.swing.JMenuItem();
        toWebPost = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("1.)");

        cells1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cells1FocusGained(evt);
            }
        });

        name1.setText("1");

        cells2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cells2FocusGained(evt);
            }
        });

        cells3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cells3FocusGained(evt);
            }
        });

        name2.setText("2");

        name3.setText("3");

        jLabel2.setText("2.)");

        jLabel3.setText("3.)");

        cells4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cells4FocusGained(evt);
            }
        });

        name4.setText("4");

        jLabel4.setText("4.)");

        jLabel5.setText("Cell numbers below will recieve text alarms from the indicated sensor if text alarms are enabled");

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel6.setText("Text Alarms");

        textAlarm.setText("DISABLED");
        textAlarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAlarmActionPerformed(evt);
            }
        });

        numSen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sensor 1", "Sensor 2", "Sensor 3", "Sensor 4" }));

        jLabel7.setText("Cell #");

        jLabel8.setText("Carrier");

        carrier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATT", "Sprint", "T-Mobile", "Verizon" }));

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        error.setText(" ");

        fuck.setText("File");

        toRename.setText("Names");
        toRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toRenameActionPerformed(evt);
            }
        });
        fuck.add(toRename);

        toEmail.setText("Alarm Email");
        toEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toEmailActionPerformed(evt);
            }
        });
        fuck.add(toEmail);

        toDailyMail.setText("Daily Email");
        toDailyMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toDailyMailActionPerformed(evt);
            }
        });
        fuck.add(toDailyMail);

        toWebPost.setText("Web Post");
        toWebPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toWebPostActionPerformed(evt);
            }
        });
        fuck.add(toWebPost);

        jMenuBar1.add(fuck);

        jMenu1.setText("Test");

        jMenuItem5.setText("Test Sensor 1");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem4.setText("Test Sensor 2");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setText("Test Sensor 3");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Test Sensor 4");
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
                        .addComponent(numSen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cellAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carrier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remove))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cells2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cells3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(name4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cells4, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cells1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(8, 8, 8))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(back)
                                    .addGap(177, 177, 177)
                                    .addComponent(save)
                                    .addGap(18, 18, 18)
                                    .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(next)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textAlarm)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cells1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cells2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name2)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cells3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name3)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cells4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name4)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textAlarm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numSen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cellAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(carrier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add)
                    .addComponent(remove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next)
                    .addComponent(back)
                    .addComponent(save)
                    .addComponent(error))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Controls text alert button. Selects and deselects and sets the text to 
    enabled and disabled. The text displays the CURRENT state of the alerts.
    */
    private void textAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAlarmActionPerformed
        if(textAlarm.isSelected()==true){
            textAlarm.setText("ENABLED");
            cellAlarm[numSen.getSelectedIndex()] = "y";
        }else{
            textAlarm.setText("DISABLED");
            cellAlarm[numSen.getSelectedIndex()] = "n";
        }
        setAlarms();
    }//GEN-LAST:event_textAlarmActionPerformed

    /*
    Method called when the user clicks save. Writes all of the information 
    to the Cell file. There are two arrays. One contains the information from the
    text boxesesesees and the other that same information with the correct 
    @whatever.whatever for email to text messaging.
    */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        boolean bool = true;
        try{
            fileWriter= new FileWriter("Cell");
            bufferedWriter= new BufferedWriter(fileWriter);
            for(int i=0; i<=num;i++){
                if(compArr[i].getText().equals("")){
                    cellAdd.setText("EMPTY FIELD!");
                    next.setEnabled(false);
                    bool=false;
                    File file = new File("Cell");
                    file.delete();
                    return;
                    
                    
                }else{
                    next.setEnabled(true);
                    bool=true;
                     
                }
                if(i == num)
                    bufferedWriter.write(compArr[i].getText() + "\n");
                else
                    bufferedWriter.write(compArr[i].getText() + " ");
                
            }
            for(int i=0; i<=num;i++){
                if(i == num)
                    bufferedWriter.write(cellMail[i] + "\n");
                else
                    bufferedWriter.write(cellMail[i] + " ");
                
            }
            /*if(textAlarm.isSelected() == true)
                bufferedWriter.write("y");
            else
                bufferedWriter.write("n");*/
            for(int i = 0; i < cellAlarm.length; i++){
                bufferedWriter.write(cellAlarm[i] + " ");
            }
            
            bufferedWriter.close();
            next.setEnabled(bool);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveActionPerformed

    /*
    changes the selection based on where was clicked
    */
    private void cells1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cells1FocusGained
        numSen.setSelectedIndex(0);
        cells1.setEditable(false);
        if(cellAlarm[0].equals("y")){
            textAlarm.setSelected(true);
            textAlarm.setText("ENABLED");
        }else{
            textAlarm.setSelected(false);
            textAlarm.setText("DISABLED");
        }
    }//GEN-LAST:event_cells1FocusGained

    private void cells2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cells2FocusGained
        numSen.setSelectedIndex(1);
        cells2.setEditable(false);
        if(cellAlarm[1].equals("y")){
            textAlarm.setSelected(true);
            textAlarm.setText("ENABLED");
        }else{
            textAlarm.setSelected(false);
            textAlarm.setText("DISABLED");
        }
    }//GEN-LAST:event_cells2FocusGained

    private void cells3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cells3FocusGained
       numSen.setSelectedIndex(2);
       cells3.setEditable(false);
       //System.out.println(cellAlarm.length);
       if(cellAlarm[2].equals("y")){
            textAlarm.setSelected(true);
            textAlarm.setText("ENABLED");
        }else{
            textAlarm.setSelected(false);
            textAlarm.setText("DISABLED");
        }
    }//GEN-LAST:event_cells3FocusGained

    private void cells4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cells4FocusGained
        numSen.setSelectedIndex(3);
        cells4.setEditable(false);
        if(cellAlarm[3].equals("y")){
            textAlarm.setSelected(true);
            textAlarm.setText("ENABLED");
        }else{
            textAlarm.setSelected(false);
            textAlarm.setText("DISABLED");
        }
    }//GEN-LAST:event_cells4FocusGained

    /*
    Method called when the user clicks add. The screen displays only the cell
    numbers that were added, but in a seperate array the @blah.blah for the 
    specific carrier is added. Both the data from the text fields and the usable
    addresses from the seperate array are written when the save button is clicked
    and the corresponding method is called.
    */
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        int num1 = numSen.getSelectedIndex();
        int num2 = carrier.getSelectedIndex();
        String l = carrier.getSelectedItem().toString();
        String s;
        String r;
        s = compArr[num1].getText();
        //s = s.replaceAll(" ", "");
        //System.out.println("here");
        /*if(cellMail.length <= num1){
            r="";
        }else */
        if(cellMail[num1]!= null){
            r = cellMail[num1];  
        }else{
            r="";
        }
        if(!s.equals("")){
            s += ",";
            r +=",";
        }
        //System.out.println("here");
        s += cellAdd.getText().replaceAll(" ", "").replaceAll("-", "") + "(" + l + ")";
        r += cellAdd.getText().replaceAll(" ", "").replaceAll("-", "") + emailCar[num2];
        compArr[num1].setText(s);
        cellMail[num1] = r;
        //System.out.println("here");
    }//GEN-LAST:event_addActionPerformed

    /*
    Removes a cell number. Has to change multiple arrays because the data is 
    stored in more than one place. See add method.
    */
    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        String s = compArr[numSen.getSelectedIndex()].getText();
        String r;
        int num2 = carrier.getSelectedIndex();
        r = cellAdd.getText() + emailCar[num2];
        /*
        This took a lot of work so I dont really want to remove it permenantly,
        just in case.
        */
        /*if(cellMail[numSen.getSelectedIndex()].contains(r + ",")){
            cellMail[numSen.getSelectedIndex()] = cellMail[numSen.getSelectedIndex()].replaceAll(r + ",", "");
            compArr[numSen.getSelectedIndex()].setText(s.replaceAll(cellAdd.getText()+",","" ));
        }else if(cellMail[numSen.getSelectedIndex()].contains("," + r )){
            cellMail[numSen.getSelectedIndex()] = cellMail[numSen.getSelectedIndex()].replaceAll("," + r , "");
            compArr[numSen.getSelectedIndex()].setText(s.replaceAll("," + cellAdd.getText(),"" ));
        }else if(cellMail[numSen.getSelectedIndex()].contains(r)){
            cellMail[numSen.getSelectedIndex()] = cellMail[numSen.getSelectedIndex()].replaceAll(r, "");
           compArr[numSen.getSelectedIndex()].setText(s.replaceAll(cellAdd.getText(),"" ));
        }else{
            //cellMail[numSen.getSelectedIndex()]
        }*/
        compArr[numSen.getSelectedIndex()].setText("");
        cellMail[numSen.getSelectedIndex()] = " ";
    }//GEN-LAST:event_removeActionPerformed
    /*
    Next few are obvious if you have looked at any of the other classes.
    */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
        new Email().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        this.setVisible(false);
        new DailyMail().setVisible(true);
    }//GEN-LAST:event_nextActionPerformed

    private void toRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toRenameActionPerformed
        this.setVisible(false);
        new Rename().setVisible(true);
    }//GEN-LAST:event_toRenameActionPerformed

    private void toEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toEmailActionPerformed
        this.setVisible(false);
        new Email().setVisible(true);
    }//GEN-LAST:event_toEmailActionPerformed

    private void toDailyMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDailyMailActionPerformed
        this.setVisible(false);
        new DailyMail().setVisible(true);
    }//GEN-LAST:event_toDailyMailActionPerformed

    private void toWebPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toWebPostActionPerformed
        this.setVisible(false);
        new webpostinfo().setVisible(true);
    }//GEN-LAST:event_toWebPostActionPerformed

    /*
    These allow the user to test if the text alerts are working by calling 
    specific comscript profiles built for the purpose.
    */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
            
        try{
            Runtime.getRuntime().exec("mono ComScript.Mono.exe Test1");
        }catch(IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try{
            Runtime.getRuntime().exec("mono ComScript.Mono.exe Test2");
        }catch(IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try{
            Runtime.getRuntime().exec("mono ComScript.Mono.exe Test3");
        }catch(IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         try{
            Runtime.getRuntime().exec("mono ComScript.Mono.exe Test4");
        }catch(IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */

    /*
    Main menu. No touch!
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
            java.util.logging.Logger.getLogger(Cell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JComboBox carrier;
    private javax.swing.JTextField cellAdd;
    private javax.swing.JTextField cells1;
    private javax.swing.JTextField cells2;
    private javax.swing.JTextField cells3;
    private javax.swing.JTextField cells4;
    private javax.swing.JLabel error;
    private javax.swing.JMenu fuck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JButton next;
    private javax.swing.JComboBox numSen;
    private javax.swing.JButton remove;
    private javax.swing.JButton save;
    private javax.swing.JRadioButton textAlarm;
    private javax.swing.JMenuItem toDailyMail;
    private javax.swing.JMenuItem toEmail;
    private javax.swing.JMenuItem toRename;
    private javax.swing.JMenuItem toWebPost;
    // End of variables declaration//GEN-END:variables
}
