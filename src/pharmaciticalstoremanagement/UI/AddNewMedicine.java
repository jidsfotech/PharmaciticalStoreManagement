/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmaciticalstoremanagement.UI;

import BusinessLogic.UserActivities;
import BusinessLogic.category;
import BusinessLogic.group;
import BusinessLogic.medicine;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAJEED
 */
public class AddNewMedicine extends javax.swing.JDialog {

    DefaultComboBoxModel dcm;
    ResultSet rs;

    /**
     * Creates new form AddNewMedicine
     */
    public AddNewMedicine(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        populateMedGroupComboBox();
        populateMedCategoryComboBox();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMedicinePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        medNamejTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        medQuantityjTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        salesPricejTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        intRatejTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        purchasePricejTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        manufacturerjTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        groupjComboBox = new javax.swing.JComboBox<>();
        categoryjComboBox = new javax.swing.JComboBox<>();
        manufacturedDatejXDatePicker = new org.jdesktop.swingx.JXDatePicker();
        expiredDatejXDatePicker = new org.jdesktop.swingx.JXDatePicker();
        addMedicinejButton = new javax.swing.JButton();
        resetjButton1 = new javax.swing.JButton();
        closetjButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD NEW MEDICINE ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Medicine name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Quantity:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Sales price:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Interest Rate:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Purchase price:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Manufacturer");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Group:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Category:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Manufactured date:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Expired date:");

        groupjComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        categoryjComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addMedicinejButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addMedicinejButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/addmedicine.png"))); // NOI18N
        addMedicinejButton.setText("Add medicine");
        addMedicinejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMedicinejButtonActionPerformed(evt);
            }
        });

        resetjButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resetjButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/reset.png"))); // NOI18N
        resetjButton1.setText("Reset");
        resetjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetjButton1ActionPerformed(evt);
            }
        });

        closetjButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        closetjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cancel.png"))); // NOI18N
        closetjButton.setText("Close");
        closetjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closetjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addMedicinePanelLayout = new javax.swing.GroupLayout(addMedicinePanel);
        addMedicinePanel.setLayout(addMedicinePanelLayout);
        addMedicinePanelLayout.setHorizontalGroup(
            addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMedicinePanelLayout.createSequentialGroup()
                .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addMedicinePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMedicinePanelLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(intRatejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMedicinePanelLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medQuantityjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addMedicinePanelLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addMedicinePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addMedicinePanelLayout.createSequentialGroup()
                                .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMedicinePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(categoryjComboBox, 0, 384, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMedicinePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(groupjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(addMedicinePanelLayout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(salesPricejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMedicinePanelLayout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(medNamejTextField))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMedicinePanelLayout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(manufacturerjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(addMedicinePanelLayout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(purchasePricejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(addMedicinePanelLayout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(expiredDatejXDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMedicinePanelLayout.createSequentialGroup()
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(manufacturedDatejXDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(addMedicinePanelLayout.createSequentialGroup()
                                .addComponent(addMedicinejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(resetjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(closetjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        addMedicinePanelLayout.setVerticalGroup(
            addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMedicinePanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manufacturerjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medQuantityjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salesPricejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(intRatejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchasePricejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manufacturedDatejXDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addMedicinePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addMedicinePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(expiredDatejXDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(addMedicinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMedicinejButton)
                    .addComponent(resetjButton1)
                    .addComponent(closetjButton))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addMedicinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addMedicinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void populateMedGroupComboBox() {
        dcm = new DefaultComboBoxModel();
        rs = group.getAllMedicineGroup();
        try {
            dcm.addElement("Select medcine group");
            while (rs.next()) {
                String group = rs.getString("medGroup");
                dcm.addElement(group);
            }
            groupjComboBox.setModel(dcm);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void populateMedCategoryComboBox() {
        dcm = new DefaultComboBoxModel();
        rs = category.getAllMedicineCategory();
        try {
            dcm.addElement("Select medcine category");
            while (rs.next()) {
                String category = rs.getString("Category");
                dcm.addElement(category);
            }
            categoryjComboBox.setModel(dcm);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void addNewMed() {
        ArrayList<String> medData = new ArrayList<String>();
        SimpleDateFormat formatCurrentDateTime = new SimpleDateFormat("YYY-MM-dd hh:mm:ss");
        SimpleDateFormat formatDate = new SimpleDateFormat("YYY-MM-dd");

        String medcineName = medNamejTextField.getText();
        if (UserActivities.validateStringInput(medNamejTextField, medcineName)) {
            medData.add(medcineName);

            String medcineManufacturer = manufacturerjTextField.getText();
            if (UserActivities.validateStringInput(manufacturerjTextField, medcineManufacturer)) {
                medData.add(medcineManufacturer);

                String qunatity = medQuantityjTextField.getText();
                if (UserActivities.validateIntegerInput(medQuantityjTextField, qunatity)) {
                    medData.add(qunatity);

                    String purchasePrice = purchasePricejTextField.getText();
                    if (UserActivities.validateIntegerInput(purchasePricejTextField, purchasePrice)) {
                        medData.add(purchasePrice);

                        String salesPrice = salesPricejTextField.getText();
                        if (UserActivities.validateIntegerInput(salesPricejTextField, salesPrice)) {
                            medData.add(salesPrice);

                            String medicineIterestRate = intRatejTextField.getText();
                            if (UserActivities.validateIntegerInput(salesPricejTextField, medicineIterestRate)) {
                                medData.add(medicineIterestRate);

                                if (UserActivities.validateJComboBoxSelection(groupjComboBox)) {
                                    String medicineGroup = (String) groupjComboBox.getSelectedItem();
                                    medData.add(medicineGroup);

                                    if (UserActivities.validateJComboBoxSelection(categoryjComboBox)) {
                                        String medicineCategory = (String) categoryjComboBox.getSelectedItem();
                                        medData.add(medicineCategory);

                                        String currentDate = formatCurrentDateTime.format(new Date());
                                        medData.add(currentDate);

                                        if (UserActivities.validateDate(manufacturedDatejXDatePicker)) {
                                            String manufacturedDate = formatDate.format(manufacturedDatejXDatePicker.getDate());
                                            medData.add(manufacturedDate);

                                            if (UserActivities.validateDate(expiredDatejXDatePicker)) {
                                                String expireDate = formatDate.format(expiredDatejXDatePicker.getDate());
                                                medData.add(expireDate);

                                                if (medData.size() == 11) {
                                                    System.out.println(medData);
                                                    medicine.addNewMedicine(medData);

                                                    medNamejTextField.setText("");
                                                    manufacturerjTextField.setText("");
                                                    medQuantityjTextField.setText("");
                                                    purchasePricejTextField.setText("");
                                                    salesPricejTextField.setText("");
                                                    intRatejTextField.setText("");

                                                    groupjComboBox.setSelectedIndex(0);
                                                    categoryjComboBox.setSelectedIndex(0);

                                                    manufacturedDatejXDatePicker.getEditor().setText("");
                                                    expiredDatejXDatePicker.getEditor().setText("");

                                                    ((DefaultTableModel) UpdateMedicine.medNameListJTable.getModel()).fireTableDataChanged();

                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    public static void runAddNewMedicine() {
        AddNewMedicine addNewMedidneDialog = new AddNewMedicine(new javax.swing.JFrame(), true);

        addNewMedidneDialog.setLocationRelativeTo(null);
        addNewMedidneDialog.setVisible(true);
    }

    private void resetjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetjButton1ActionPerformed
        // TODO add your handling code here:
        medNamejTextField.setText("");
        manufacturerjTextField.setText("");
        medQuantityjTextField.setText("");
        purchasePricejTextField.setText("");
        salesPricejTextField.setText("");
        intRatejTextField.setText("");

        groupjComboBox.setSelectedIndex(0);
        categoryjComboBox.setSelectedIndex(0);

        manufacturedDatejXDatePicker.getEditor().setText("");
        expiredDatejXDatePicker.getEditor().setText("");
    }//GEN-LAST:event_resetjButton1ActionPerformed

    private void addMedicinejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMedicinejButtonActionPerformed
        // TODO add your handling code here:
        addNewMed();
    }//GEN-LAST:event_addMedicinejButtonActionPerformed

    private void closetjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closetjButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closetjButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addMedicinePanel;
    private javax.swing.JButton addMedicinejButton;
    private javax.swing.JComboBox<String> categoryjComboBox;
    private javax.swing.JButton closetjButton;
    private org.jdesktop.swingx.JXDatePicker expiredDatejXDatePicker;
    private javax.swing.JComboBox<String> groupjComboBox;
    private javax.swing.JTextField intRatejTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private org.jdesktop.swingx.JXDatePicker manufacturedDatejXDatePicker;
    private javax.swing.JTextField manufacturerjTextField;
    private javax.swing.JTextField medNamejTextField;
    private javax.swing.JTextField medQuantityjTextField;
    private javax.swing.JTextField purchasePricejTextField;
    private javax.swing.JButton resetjButton1;
    private javax.swing.JTextField salesPricejTextField;
    // End of variables declaration//GEN-END:variables
}
