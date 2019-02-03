/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmaciticalstoremanagement.UI;

import BusinessLogic.UserActivities;
import BusinessLogic.inventory;
import BusinessLogic.sales;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author MAJEED
 */
public class Reports extends javax.swing.JPanel {

    DefaultComboBoxModel dcm;

    /**
     * Creates new form Reports
     */
    public Reports() {
        initComponents();

        reportTypeComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        labeljPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BoderLayoutjPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        reportTypejComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        fromThisDatejXDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        toThisDatejXDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        labeljPanel.setBackground(new java.awt.Color(204, 204, 204));
        labeljPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GENERATE SALES AND INVENTORY REPORTS ");
        labeljPanel.add(jLabel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 426;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 0, 10);
        add(labeljPanel, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel3, gridBagConstraints);

        BoderLayoutjPanel.setBackground(new java.awt.Color(255, 255, 255));
        BoderLayoutjPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BoderLayoutjPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Type of report:");

        reportTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("From this date :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("To this date :");

        toThisDatejXDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toThisDatejXDatePickerActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/printer.png"))); // NOI18N
        jButton1.setText("Generate Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BoderLayoutjPanelLayout = new javax.swing.GroupLayout(BoderLayoutjPanel);
        BoderLayoutjPanel.setLayout(BoderLayoutjPanelLayout);
        BoderLayoutjPanelLayout.setHorizontalGroup(
            BoderLayoutjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BoderLayoutjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BoderLayoutjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BoderLayoutjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BoderLayoutjPanelLayout.createSequentialGroup()
                        .addComponent(fromThisDatejXDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toThisDatejXDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BoderLayoutjPanelLayout.createSequentialGroup()
                        .addComponent(reportTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(BoderLayoutjPanelLayout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        BoderLayoutjPanelLayout.setVerticalGroup(
            BoderLayoutjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BoderLayoutjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BoderLayoutjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(BoderLayoutjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromThisDatejXDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toThisDatejXDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 134;
        gridBagConstraints.ipady = 39;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 148, 0);
        add(BoderLayoutjPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void reportTypeComboBox() {
        dcm = new DefaultComboBoxModel();
        dcm.addElement("Select type of report to generate");
        dcm.addElement("Sales");
        dcm.addElement("Inventory");
        reportTypejComboBox.setModel(dcm);
    }

    private void toThisDatejXDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toThisDatejXDatePickerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toThisDatejXDatePickerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formatDate = new SimpleDateFormat("YYY-MM-dd hh:mm:ss");
        boolean isReportTypeSelected = UserActivities.validateJComboBoxSelection(reportTypejComboBox);
        if (isReportTypeSelected) {

            if (UserActivities.validateDate(fromThisDatejXDatePicker)) {

                if (UserActivities.validateDate(toThisDatejXDatePicker)) {

                    String reportType = (String) reportTypejComboBox.getSelectedItem();
                    String fromThisDate = formatDate.format(fromThisDatejXDatePicker.getDate());
                    String toThisDate = formatDate.format(toThisDatejXDatePicker.getDate());

                    if (reportType == "Inventory") {
                        inventory.generateInventoryReport(fromThisDate, toThisDate);
                    }else{
                        sales.generateSalesReport(fromThisDate, toThisDate);
                    }

                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BoderLayoutjPanel;
    private org.jdesktop.swingx.JXDatePicker fromThisDatejXDatePicker;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel labeljPanel;
    private javax.swing.JComboBox<String> reportTypejComboBox;
    private org.jdesktop.swingx.JXDatePicker toThisDatejXDatePicker;
    // End of variables declaration//GEN-END:variables
}
