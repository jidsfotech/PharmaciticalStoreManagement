/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmaciticalstoremanagement.UI;

/**
 *
 * @author MAJEED
 */
import BusinessLogic.UserActivities;
import BusinessLogic.inventory;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class PharmacyStoreMainFrame extends javax.swing.JFrame {

    boolean adminPermission = false;
    DisplayMedicine displayMed;

    /**
     * Creates new form PharmacyStoreMainFrame
     */
    public PharmacyStoreMainFrame() {
        initComponents();

        expiredProductAlertJLabel.setVisible(false);

        displayMed = new DisplayMedicine();
        CardLayout card = (CardLayout) (StorePagesSwitcherJPanel.getLayout());
        StorePagesSwitcherJPanel.add(displayMed, "displayMedicine");
        card.show(StorePagesSwitcherJPanel, "displayMedicine");

        setExpiredProductsAlert();

    }

    public static void setExpiredProductsAlert() {
        Timer timer;
        SimpleDateFormat formatDate = new SimpleDateFormat("YYY-MM-dd");
        Date currentDate = new Date();
        ResultSet expiredMeds = inventory.getInventoryRecord();

        try {
            while (expiredMeds.next()) {
                String expDate = expiredMeds.getString("ExpDate");

                try {
                    if (formatDate.parse(expDate).before(currentDate)) {
                        expiredProductAlertJLabel.setVisible(true);
                        timer = new Timer(1000, UserActivities.expProductAlert(expiredProductAlertJLabel));
                        timer.start();

                    }
                } catch (ParseException ex) {
                    Logger.getLogger(DisplayMedicine.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayMedicine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPermision(String userStatus) {
        System.out.println(userStatus);
        if (userStatus.equals("Administrator")) {
            displayMed.deletejButton.setEnabled(true);
            manageStorejButton.setEnabled(true);
            AdminjButton.setEnabled(true);

        } else {
            manageStorejButton.setEnabled(false);
            AdminjButton.setEnabled(false);
        }
    }

    private static JPanel expiredProducts() {
        String[] cols = {"ID", "Expired Medicine", "ManufacturedDate", "ExpiryDate"};
        final String[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, cols);
        ResultSet expiredMeds = inventory.getInventoryRecord();

        try {
            while (expiredMeds.next()) {
                int medID = expiredMeds.getInt("idInventory");
                String medName = expiredMeds.getString("MedicineName");
                String manuDate = expiredMeds.getString("ManufDate");
                String ExpiryDate = expiredMeds.getString("ExpDate");

                model.addRow(new Object[]{medID, medName, manuDate, ExpiryDate});
            }
        } catch (SQLException ex) {
            Logger.getLogger(PharmacyStoreMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        JTable expiredProductsListTable = new JTable(model);
        expiredProductsListTable.getColumnModel().getColumn(0).setPreferredWidth(9);
        expiredProductsListTable.getColumnModel().getColumn(1).setPreferredWidth(220);

        JPanel displayExpiredProductsJpanel = new JPanel(false);
        displayExpiredProductsJpanel.setLayout(new BoxLayout(displayExpiredProductsJpanel, BoxLayout.Y_AXIS));
        displayExpiredProductsJpanel.add(new JScrollPane(expiredProductsListTable));
        JPanel panel = new JPanel();

        JButton deleteMedicine = new JButton("Delet Medicine");
        deleteMedicine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(null,
                        "Delete Medicine",
                        "Comfirm delete",
                        JOptionPane.YES_NO_OPTION);
                if (action == JOptionPane.YES_OPTION) {
                    int rowToRemove = expiredProductsListTable.getSelectedRow();
                    int med_ID = (int) expiredProductsListTable.getValueAt(rowToRemove, 0);
                    if (rowToRemove == -1) {
                        JOptionPane.showMessageDialog(null, "Select Medicine to delete", "nothing to delete",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.println(med_ID);
                        inventory.deleteexpiredMeds(med_ID);
                        ((DefaultTableModel) expiredProductsListTable.getModel()).removeRow(rowToRemove);
                        ((DefaultTableModel) expiredProductsListTable.getModel()).fireTableDataChanged();
                    }
                }
            }
        });
        panel.add(deleteMedicine);

        displayExpiredProductsJpanel.add(panel);
        return displayExpiredProductsJpanel;
    }

    /**
     * public void changePanel(JPanel objPanel){
     *
     * StorePagesDisplayJPanel.removeAll();
     * StorePagesDisplayJPanel.add(objPanel); StorePagesDisplayJPanel.repaint();
     * StorePagesDisplayJPanel.revalidate(); }
     */
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
        StoreNavigationJPanel = new javax.swing.JPanel();
        SalesjButton = new javax.swing.JButton();
        displayMedicinejButton = new javax.swing.JButton();
        manageStorejButton = new javax.swing.JButton();
        generateReportjButton4 = new javax.swing.JButton();
        AdminjButton = new javax.swing.JButton();
        StorePagesSwitcherJPanel = new javax.swing.JPanel();
        loggedInUserjLabel = new javax.swing.JLabel();
        logoutjButton = new javax.swing.JButton();
        expiredProductAlertJLabel = new javax.swing.JLabel();
        PharmacyStoreMenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        alerts = new javax.swing.JMenu();
        userProfile = new javax.swing.JMenu();
        addMedicine = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        view = new javax.swing.JMenu();
        Sales = new javax.swing.JMenu();
        sellMed = new javax.swing.JMenu();
        salseHistory = new javax.swing.JMenu();
        salseAlert = new javax.swing.JMenu();
        Reports = new javax.swing.JMenu();
        dailyReports = new javax.swing.JMenu();
        WeeklyReports = new javax.swing.JMenu();
        monthlyReport = new javax.swing.JMenu();
        stuckUpdateReport = new javax.swing.JMenu();
        manageStore = new javax.swing.JMenu();
        addMed = new javax.swing.JMenu();
        updateStore = new javax.swing.JMenu();
        deleteDrugs = new javax.swing.JMenu();
        Administrator = new javax.swing.JMenu();
        addNewUser = new javax.swing.JMenu();
        manageUsers = new javax.swing.JMenu();
        usersActivate = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OLAYIWOLA PHARMACY NIGERIA LIMITED");

        StoreNavigationJPanel.setBackground(new java.awt.Color(30, 139, 224));
        StoreNavigationJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        StoreNavigationJPanel.setForeground(new java.awt.Color(204, 204, 204));

        SalesjButton.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        SalesjButton.setText("Perform Sales");
        SalesjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesjButtonActionPerformed(evt);
            }
        });

        displayMedicinejButton.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        displayMedicinejButton.setText("Medicine in Store");
        displayMedicinejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayMedicinejButtonActionPerformed(evt);
            }
        });

        manageStorejButton.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        manageStorejButton.setText("Manage Store");
        manageStorejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStorejButtonActionPerformed(evt);
            }
        });

        generateReportjButton4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        generateReportjButton4.setText("Generate Reports");
        generateReportjButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportjButton4ActionPerformed(evt);
            }
        });

        AdminjButton.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        AdminjButton.setText("Administrator");
        AdminjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StoreNavigationJPanelLayout = new javax.swing.GroupLayout(StoreNavigationJPanel);
        StoreNavigationJPanel.setLayout(StoreNavigationJPanelLayout);
        StoreNavigationJPanelLayout.setHorizontalGroup(
            StoreNavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StoreNavigationJPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(displayMedicinejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(SalesjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(manageStorejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(generateReportjButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(AdminjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        StoreNavigationJPanelLayout.setVerticalGroup(
            StoreNavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StoreNavigationJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(StoreNavigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayMedicinejButton)
                    .addComponent(SalesjButton)
                    .addComponent(generateReportjButton4)
                    .addComponent(AdminjButton)
                    .addComponent(manageStorejButton))
                .addContainerGap())
        );

        StorePagesSwitcherJPanel.setBackground(new java.awt.Color(255, 255, 255));
        StorePagesSwitcherJPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        StorePagesSwitcherJPanel.setMinimumSize(new java.awt.Dimension(10, 10));
        StorePagesSwitcherJPanel.setPreferredSize(new java.awt.Dimension(10, 10));
        StorePagesSwitcherJPanel.setLayout(new java.awt.CardLayout());

        loggedInUserjLabel.setBackground(new java.awt.Color(204, 204, 204));
        loggedInUserjLabel.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        loggedInUserjLabel.setForeground(new java.awt.Color(0, 204, 0));
        loggedInUserjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loggedInUserjLabel.setText("YANKE MEDICAL STORE");

        logoutjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logout3.jpg"))); // NOI18N
        logoutjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutjButtonActionPerformed(evt);
            }
        });

        expiredProductAlertJLabel.setFont(new java.awt.Font("Tunga", 3, 14)); // NOI18N
        expiredProductAlertJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/medicineoutofstock.png"))); // NOI18N
        expiredProductAlertJLabel.setText("Some products instore has expired ");
        expiredProductAlertJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expiredProductAlertJLabelMouseClicked(evt);
            }
        });

        File.setText("File");

        alerts.setText("Alerts");
        File.add(alerts);

        userProfile.setText("View User Profile");
        File.add(userProfile);

        addMedicine.setText("Add new Medicine");
        File.add(addMedicine);

        exit.setText("Exit");
        exit.setToolTipText("exit");
        File.add(exit);

        PharmacyStoreMenuBar.add(File);

        Edit.setText("Edit");
        PharmacyStoreMenuBar.add(Edit);

        view.setText("View ");
        PharmacyStoreMenuBar.add(view);

        Sales.setText("Sales");

        sellMed.setText("Sell Medicine");
        sellMed.setToolTipText("opens the sales page");
        Sales.add(sellMed);

        salseHistory.setText("Sales History");
        Sales.add(salseHistory);

        salseAlert.setText("Sales Alert");
        Sales.add(salseAlert);

        PharmacyStoreMenuBar.add(Sales);

        Reports.setText("Reports");

        dailyReports.setText("Daily Salse Report");
        Reports.add(dailyReports);

        WeeklyReports.setText("Weekly Salse Report");
        Reports.add(WeeklyReports);

        monthlyReport.setText("Mothly Salse Report");
        Reports.add(monthlyReport);

        stuckUpdateReport.setText("Stuck Update Report");
        Reports.add(stuckUpdateReport);

        PharmacyStoreMenuBar.add(Reports);

        manageStore.setText("Manage Store");

        addMed.setText("Add Medicine");
        manageStore.add(addMed);

        updateStore.setText("Edit & Update Drugs in stuck");
        manageStore.add(updateStore);

        deleteDrugs.setText("Remove Drug from store");
        manageStore.add(deleteDrugs);

        PharmacyStoreMenuBar.add(manageStore);

        Administrator.setText("Administrator");

        addNewUser.setText("Add New User");
        Administrator.add(addNewUser);

        manageUsers.setText("Manage Users ");
        Administrator.add(manageUsers);

        usersActivate.setText("View User Activity");
        Administrator.add(usersActivate);

        PharmacyStoreMenuBar.add(Administrator);

        setJMenuBar(PharmacyStoreMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StorePagesSwitcherJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(expiredProductAlertJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loggedInUserjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(StoreNavigationJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logoutjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loggedInUserjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(expiredProductAlertJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StoreNavigationJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StorePagesSwitcherJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
        );

        StorePagesSwitcherJPanel.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     */
    private void displayMedicinejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayMedicinejButtonActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout) (StorePagesSwitcherJPanel.getLayout());
        StorePagesSwitcherJPanel.add(displayMed, "displayMedicine");
        card.show(StorePagesSwitcherJPanel, "displayMedicine");
    }//GEN-LAST:event_displayMedicinejButtonActionPerformed

    private void SalesjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesjButtonActionPerformed
        // TODO add your handling code here:
        SalesPage salesPage = new SalesPage();
        CardLayout card = (CardLayout) (StorePagesSwitcherJPanel.getLayout());
        StorePagesSwitcherJPanel.add(salesPage, "sellMedicine");
        card.show(StorePagesSwitcherJPanel, "sellMedicine");
    }//GEN-LAST:event_SalesjButtonActionPerformed

    private void manageStorejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStorejButtonActionPerformed
        // TODO add your handling code here:
        ManageStore manageStore = new ManageStore();
        CardLayout card = (CardLayout) (StorePagesSwitcherJPanel.getLayout());
        StorePagesSwitcherJPanel.add(manageStore, "manageStore");
        card.show(StorePagesSwitcherJPanel, "manageStore");
    }//GEN-LAST:event_manageStorejButtonActionPerformed

    private void generateReportjButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportjButton4ActionPerformed
        // TODO add your handling code here:
        Reports reports = new Reports();
        CardLayout card = (CardLayout) (StorePagesSwitcherJPanel.getLayout());
        StorePagesSwitcherJPanel.add(reports, "generateReport");
        card.show(StorePagesSwitcherJPanel, "generateReport");
    }//GEN-LAST:event_generateReportjButton4ActionPerformed

    private void AdminjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminjButtonActionPerformed
        // TODO add your handling code here:
        Administrator admin = new Administrator();
        CardLayout card = (CardLayout) (StorePagesSwitcherJPanel.getLayout());
        StorePagesSwitcherJPanel.add(admin, "Administrator");
        card.show(StorePagesSwitcherJPanel, "Administrator");
    }//GEN-LAST:event_AdminjButtonActionPerformed

    private void logoutjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutjButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }//GEN-LAST:event_logoutjButtonActionPerformed

    private void expiredProductAlertJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expiredProductAlertJLabelMouseClicked
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        frame.add(expiredProducts());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_expiredProductAlertJLabelMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Administrator;
    private javax.swing.JButton AdminjButton;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JMenuBar PharmacyStoreMenuBar;
    private javax.swing.JMenu Reports;
    private javax.swing.JMenu Sales;
    private javax.swing.JButton SalesjButton;
    private javax.swing.JPanel StoreNavigationJPanel;
    private static javax.swing.JPanel StorePagesSwitcherJPanel;
    private javax.swing.JMenu WeeklyReports;
    private javax.swing.JMenu addMed;
    private javax.swing.JMenu addMedicine;
    private javax.swing.JMenu addNewUser;
    private javax.swing.JMenu alerts;
    private javax.swing.JMenu dailyReports;
    private javax.swing.JMenu deleteDrugs;
    private javax.swing.JButton displayMedicinejButton;
    private javax.swing.JMenuItem exit;
    public static javax.swing.JLabel expiredProductAlertJLabel;
    private javax.swing.JButton generateReportjButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel loggedInUserjLabel;
    private javax.swing.JButton logoutjButton;
    private javax.swing.JMenu manageStore;
    private javax.swing.JButton manageStorejButton;
    private javax.swing.JMenu manageUsers;
    private javax.swing.JMenu monthlyReport;
    private javax.swing.JMenu salseAlert;
    private javax.swing.JMenu salseHistory;
    private javax.swing.JMenu sellMed;
    private javax.swing.JMenu stuckUpdateReport;
    private javax.swing.JMenu updateStore;
    private javax.swing.JMenu userProfile;
    private javax.swing.JMenu usersActivate;
    private javax.swing.JMenu view;
    // End of variables declaration//GEN-END:variables
}
