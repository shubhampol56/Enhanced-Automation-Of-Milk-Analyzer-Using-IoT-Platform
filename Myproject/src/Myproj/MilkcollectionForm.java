/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myproj;


import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.toedter.calendar.JDateChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

//import com.fazecast.jSerialComm.SerialPort
/**
 *
 * @author Apurva
 */


public class MilkcollectionForm extends javax.swing.JFrame implements SerialPortDataListener{

    DB db;
    DBCollection table;

        com.google.gson.JsonArray collections = new com.google.gson.JsonArray();
   
        int c=0;
        int p=0;
        
        String serial = "";
        // Date date1;
    /**
     * Creates new form MilkcollectionForm
     */
        
        
        
        
    public MilkcollectionForm(){
        
           

          initComponents();
          
          showdate.setText(String.valueOf(c));
          
          Socket sock = new Socket();
          InetSocketAddress addr=new InetSocketAddress("www.google.com",80);
          try{
          sock.connect(addr,3000);
          
          }catch(Exception e){
          javax.swing.JOptionPane.showMessageDialog(null, "Internet not connected");
          uploaddata.setEnabled(false);
          }
        

   
                /*
                
		if(serialPort.openPort())
			System.out.println("Port opened successfully.");
		else {
			System.out.println("Unable to open the port.");
			return;
		}
                
                
                

		serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);

		      Scanner data = new Scanner(serialPort.getInputStream());
		
                while(data.hasNextLine()){
                    
			try{
                            for(int i=0;i<15;i++)
                {
                    try{
                        weight.setText(data.nextLine());
                        }catch(Exception e){}   
                }
                            System.out.println(data.nextLine());
                            serialPort.closePort();
		System.out.println("Done.");
                            
                       // quantity.setText(data.nextLine());
                        }catch(Exception e){}
                          
		}
                */

    }
        

    
    public void clearall()
    {
        
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        shift = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        snf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        weight = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        animal = new javax.swing.JComboBox<>();
        uploaddata = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        enter = new javax.swing.JButton();
        showdate = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        supplier = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        progressbar = new javax.swing.JProgressBar();
        checkconnection = new javax.swing.JButton();
        Recieve = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("collection");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Milk Collection");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setText("Select Milk Type:-");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("Select Supplier");

        shift.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        shift.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MORNING", "EVENING" }));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setText("SNF:-");

        snf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snfActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("Fat:-");

        fat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setText("Total Weight:-");

        weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setText("Select Shift:-");

        animal.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        animal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cow", "Buffalo" }));

        uploaddata.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        uploaddata.setText("UPLOAD");
        uploaddata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploaddata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploaddataMouseClicked(evt);
            }
        });
        uploaddata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploaddataActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel9.setText("Date:-");

        enter.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        enter.setText("Enter");
        enter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enterMouseClicked(evt);
            }
        });

        showdate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Records Not Uploaded:");

        progressbar.setStringPainted(true);

        checkconnection.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        checkconnection.setText("Check Connection");
        checkconnection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkconnectionMouseClicked(evt);
            }
        });

        Recieve.setText("Initialize Connection");
        Recieve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecieveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Recieve, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(supplier)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(51, 51, 51)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(snf)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fat)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(animal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shift, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(299, 299, 299))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(showdate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(checkconnection, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(uploaddata, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(57, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Recieve, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shift, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(animal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enter, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(snf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkconnection, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uploaddata, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(948, 775));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void snfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snfActionPerformed

    private void fatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fatActionPerformed

    private void weightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightActionPerformed

    private void uploaddataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploaddataMouseClicked
        
    }//GEN-LAST:event_uploaddataMouseClicked

    private void uploaddataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploaddataActionPerformed
       
       /*
         Mongo mongo = new Mongo("localhost",27017);
  db=mongo.getDB("Projectoffline");
  table=db.getCollection("Suppliers");
       */
  
            MongoClientURI uri = new MongoClientURI("mongodb+srv://pranav:123456879@cluster0-54amg.mongodb.net/socketTimeoutMS=1000&authSource=Project");
          
           System.out.println("Connection established ");
           MongoClient mongoClient = new MongoClient(uri);
           db = mongoClient.getDB("Project");
           table = db.getCollection("Suppliers");
  
  
  
       for(int i=0;i<collections.size();i++)
       {
           
           int total = collections.size();
           int curr = i+1;
           p=(curr*100)/total;
            
           JsonObject obj = collections.get(i).getAsJsonObject();
           Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();//will return members of your object
          int j=0;
          String arr[] = new String[7];
           for (Map.Entry<String, JsonElement> entry: entries) 
            {
                 arr[j]=entry.getValue().toString();
                 j++;
            }
            BasicDBObject where = new BasicDBObject();
            
            String name = arr[0];
            name = name.replaceAll("^\"|\"$", "");
            
        where.put("First Name", name);
        
        DBCursor cursor = table.find(where);
          
        while(cursor.hasNext())
        {
            
            BasicDBObject document = new BasicDBObject();
      
         document.put("Date", arr[1]);
        document.put("Select Shift",arr[2]); 
        document.put("Select Animal",arr[3]);
        document.put("Fat",arr[4]);
        document.put("snf",arr[5]);
        document.put("weight",arr[6]);
        
        
        BasicDBObject update = new BasicDBObject();
        update.put("$push", new BasicDBObject("Collection",document));
        table.update(cursor.next(), update);
        c=0;    
        showdate.setText(String.valueOf(c));
        }
         progressbar.setValue(p);
       }    
        
    }//GEN-LAST:event_uploaddataActionPerformed

    private void dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateMouseClicked
        System.out.println(date.getDate());
    }//GEN-LAST:event_dateMouseClicked
    
    private void enterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enterMouseClicked

        c++;
        showdate.setText(String.valueOf(c));
        com.google.gson.JsonObject collection= new com.google.gson.JsonObject();
        collection.addProperty("Supplier", supplier.getText());
        collection.addProperty("Date", date.getDate().toString());
        collection.addProperty("Select Shift", shift.getSelectedItem().toString());
        collection.addProperty("Select Animal", animal.getSelectedItem().toString());
        collection.addProperty("Fat", fat.getText());
        collection.addProperty("Snf", snf.getText());
        collection.addProperty("weight", weight.getText());
        
        collections.add(collection);
        

        fat.setText("");
        snf.setText("");
        weight.setText("");
    }//GEN-LAST:event_enterMouseClicked

    private void checkconnectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkconnectionMouseClicked
        Socket sock = new Socket();
          InetSocketAddress addr=new InetSocketAddress("www.google.com",80);
          try{
          sock.connect(addr,3000);
          uploaddata.setEnabled(true);
          }catch(Exception e){
              javax.swing.JOptionPane.showMessageDialog(null, "Internet not connected");
          uploaddata.setEnabled(false);
          }
    }//GEN-LAST:event_checkconnectionMouseClicked

    private void RecieveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecieveMouseClicked
             SerialPort[] ports = SerialPort.getCommPorts();
		SerialPort serialPort = ports[0];
                if(serialPort.openPort())
			System.out.println("Port opened successfully.");
		else {
			System.out.println("Unable to open the port.");
			return;
		}
                serialPort.addDataListener(new SerialPortDataListener() {
   @Override
   public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_AVAILABLE; }
   @Override
   public void serialEvent(SerialPortEvent event)
   {
      if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
         return;
        byte[] newData = new byte[serialPort.bytesAvailable()];
        int numRead = serialPort.readBytes(newData, newData.length);
        String s = new String(newData);
        serial=serial.concat(new String(newData));
        System.out.println("Read " + serial + " bytes.");
        System.out.println(serial.length());
        if(serial.length()==12){
        fat.setText(serial.substring(0, 2)+"."+serial.substring(2, 4));
        snf.setText(serial.substring(4, 6)+"."+serial.substring(6, 8));
        weight.setText(serial.substring(8, 10));
        serial="";
        
        }
     /* Scanner data = new Scanner(serialPort.getInputStream());
      while(data.hasNextLine()){
                    
			try{
                           
                
                        weight.setText(data.nextLine());
                        System.out.println(data.nextLine());
                         
                           
                            serialPort.closePort();
		System.out.println("Done.");
                            
                       // quantity.setText(data.nextLine());
                        }catch(Exception e){}
                          
		}
      */
      
   }
});        
    }//GEN-LAST:event_RecieveMouseClicked

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
            java.util.logging.Logger.getLogger(MilkcollectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MilkcollectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MilkcollectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MilkcollectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MilkcollectionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Recieve;
    private javax.swing.JComboBox<String> animal;
    private javax.swing.JButton checkconnection;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton enter;
    private javax.swing.JTextField fat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar progressbar;
    private javax.swing.JComboBox<String> shift;
    private javax.swing.JLabel showdate;
    private javax.swing.JTextField snf;
    private javax.swing.JTextField supplier;
    private javax.swing.JButton uploaddata;
    private javax.swing.JTextField weight;
    // End of variables declaration//GEN-END:variables

    @Override
    public int getListeningEvents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
