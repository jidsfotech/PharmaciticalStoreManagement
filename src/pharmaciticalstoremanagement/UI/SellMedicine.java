/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmaciticalstoremanagement.UI;

import BusinessLogic.UserActivities;
import BusinessLogic.medicine;
import BusinessLogic.sales;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAJEED
 */
public class SellMedicine extends javax.swing.JPanel {

    ResultSet rs;
    DefaultTableModel dtm;
    DefaultTableModel itemCart_dtm;
    DefaultTableModel checkOutItemCart_dtm;

    SalesHistory updateHistory;

    int totalSalesPrice = 0;
    int numberOfItemInCArt = 0;
    int rowNum;

    JTable checkOutItemCart_Table;

    /**
     * Creates new form SellMedicine
     */
    public SellMedicine(SalesHistory updateHistory) {
        checkOutItemCart_Table = new JTable();
        this.updateHistory = updateHistory;
        initComponents();

        cartjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        cartjTable.getColumnModel().getColumn(1).setPreferredWidth(220);
        itemCart_dtm = (DefaultTableModel) cartjTable.getModel();
        itemCart_dtm.setRowCount(0);

        createChecoutTable(checkOutItemCart_Table);
        populateMedTable();

    }

    private void populateMedTable() {
        medicineTablejTable.getColumnModel().getColumn(0).setPreferredWidth(250);
        dtm = (DefaultTableModel) medicineTablejTable.getModel();
        rs = medicine.getAllMedicine();
        dtm.setRowCount(0);
        try {
            while (rs.next()) {

                String name = rs.getString("MedicineName");
                String quantity = rs.getString("QuantityInStore");
                String sales_price = rs.getString("SalePrice");
                String rate = rs.getString("InterestRate");

                dtm.addRow(new Object[]{name, quantity, sales_price, rate});

            }

            System.out.println("medicines loaded sucessfully");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void createChecoutTable(JTable checkOutItemTable) {
        checkOutItemTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Medicine name", "Quatity in store", "Quatity to sell", "Sales price", "Discount"}
        ) {
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        checkOutItemTable.getColumnModel().getColumn(0).setPreferredWidth(220);
        checkOutItemCart_dtm = (DefaultTableModel) checkOutItemTable.getModel();
        checkOutItemCart_dtm.setRowCount(0);
    }

    private void checkOut() {
        JPanel checkOutPanel = new JPanel(false);
        checkOutPanel.setLayout(new GridLayout(0, 1));

        JPanel LabelJPanel = new JPanel(false);
        LabelJPanel.setLayout(new GridLayout(0, 1));

        JPanel fieldPanel = new JPanel(false);
        fieldPanel.setLayout(new GridLayout(0, 1));

        JLabel cartItemsLabel = new JLabel("  Medicine name                                ||  Available Qty  ||  Qty to sell       ||   Price   || Discount");
        cartItemsLabel.setForeground(Color.blue);

        JLabel totalNumberItemLabel = new JLabel("Total items = ", JLabel.RIGHT);
        totalNumberItemLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        JLabel totalItemLabel = new JLabel(String.valueOf(numberOfItemInCArt));
        totalItemLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        totalItemLabel.setForeground(Color.red);

        JLabel totalPriceLabel = new JLabel("Total price = ", JLabel.RIGHT);
        totalPriceLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        JLabel totalPrice = new JLabel(String.valueOf(totalSalesPrice));
        totalPrice.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        totalPrice.setForeground(Color.red);

        LabelJPanel.add(totalNumberItemLabel);
        LabelJPanel.add(totalPriceLabel);

        fieldPanel.add(totalItemLabel);
        fieldPanel.add(totalPrice);

        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.X_AXIS));
        box.add(LabelJPanel);
        box.add(fieldPanel);

        checkOutPanel.setBackground(Color.white);
        checkOutPanel.add(cartItemsLabel);
        checkOutPanel.add(checkOutItemCart_Table);
        checkOutPanel.add(box);

        int result = JOptionPane.showConfirmDialog(null, checkOutPanel, "Confirm drug sales", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            sales.updateSalesRecord(checkOutItemCart_Table);

            this.updateHistory.dtm.fireTableCellUpdated(0, 0);
            this.updateHistory.displayTransactionHistory();
            this.updateHistory.revalidate();
        } else if (result == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Sales canceled", "Transaction canceled", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ddToCart() {
        String medName = medNamejLabel.getText();
        int quantityToSell = (int) quantityToSelljSpinner.getValue();
        int availableQuantity = UserActivities.validateSelectedBeforeAddToCart(quantityInStorejLabel);
        int medPrice = Integer.parseInt(salesPricejTextField.getText());
        int medInterestRate = Integer.parseInt(interestratejTextField.getText());

        if (quantityToSell <= 0) {
            JOptionPane.showMessageDialog(null, "you must enter atleast one quantity to sell", "input errorr",
                    JOptionPane.ERROR_MESSAGE);

        } else if (quantityToSell > availableQuantity) {
            JOptionPane.showMessageDialog(null, "quantity to sell can not be greater than available qiantity ", "input errorr",
                    JOptionPane.ERROR_MESSAGE);

        } else if (medPrice == 0) {
            JOptionPane.showMessageDialog(null, "please enter medicine price", "input errorr",
                    JOptionPane.ERROR_MESSAGE);

        } else {

            int interest = ((medPrice * medInterestRate) / 100);
            int salesPrice = ((medPrice - interest) * quantityToSell);

            itemCart_dtm.addRow(new Object[]{rowNum, medName, quantityToSell, salesPrice, interest});
            checkOutItemCart_dtm.addRow(new Object[]{medName, availableQuantity, quantityToSell, salesPrice, interest});

            totalSalesPrice += salesPrice ;

            int newQuantity = availableQuantity - quantityToSell;
            medicineTablejTable.setValueAt(newQuantity, rowNum, 1);

            medNamejLabel.setText("");
            quantityInStorejLabel.setText("");
            pricejLabel.setText("");
            salesPricejTextField.setText("0");
            interestratejTextField.setText("0");
            quantityToSelljSpinner.setValue(0);

            numberOfItemInCArt = cartjTable.getRowCount();
            totalNumbersOfItemjLabel.setText(Integer.toString(numberOfItemInCArt));
            totalSalesPricejLabel.setText(Integer.toString(totalSalesPrice));
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

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicineTablejTable = new javax.swing.JTable();
        searchMedicinejTextField = new javax.swing.JTextField();
        searchMedicinejButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        medNamejLabel = new javax.swing.JLabel();
        quantityInStorejLabel = new javax.swing.JLabel();
        pricejLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        quantityToSelljSpinner = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        salesPricejTextField = new javax.swing.JTextField();
        addTocatjButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        interestratejTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartjTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        totalSalesPricejLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        totalNumbersOfItemjLabel = new javax.swing.JLabel();
        deleteFromCatjButton = new javax.swing.JButton();
        CheckOutjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel6.setText("medicine name: ");

        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        medicineTablejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Medicine name", "Quantity Available", "Price", "Discount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        medicineTablejTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicineTablejTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medicineTablejTable);

        searchMedicinejButton.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchMedicinejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchMedicinejButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchMedicinejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchMedicinejButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel3.setText("medicine name: ");

        jLabel4.setText("Qunatity in strore :");

        jLabel5.setText("price :");

        medNamejLabel.setForeground(new java.awt.Color(0, 0, 204));

        quantityInStorejLabel.setForeground(new java.awt.Color(0, 0, 153));

        pricejLabel.setForeground(new java.awt.Color(0, 0, 204));

        jLabel7.setText("Qunatity to sell:");

        jLabel8.setText("Salese price:");

        salesPricejTextField.setText("0");
        salesPricejTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                salesPricejTextFieldFocusLost(evt);
            }
        });

        addTocatjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/placeorder2.png"))); // NOI18N
        addTocatjButton.setText(" Add to cart");
        addTocatjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTocatjButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Interest rate%:");

        interestratejTextField.setText("0");
        interestratejTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                interestratejTextFieldFocusLost(evt);
            }
        });

        jLabel10.setText("Item cart ");

        cartjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Medicine name", "Quatity to sell", "Sales price", "Discount "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cartjTable);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel11.setText("Total sales price :");

        totalSalesPricejLabel.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        totalSalesPricejLabel.setForeground(new java.awt.Color(255, 102, 0));
        totalSalesPricejLabel.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setText("Numbers of item:");

        totalNumbersOfItemjLabel.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        totalNumbersOfItemjLabel.setForeground(new java.awt.Color(255, 102, 0));
        totalNumbersOfItemjLabel.setText("0");

        deleteFromCatjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete33.png"))); // NOI18N
        deleteFromCatjButton.setText("Delete from cart ");
        deleteFromCatjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFromCatjButtonActionPerformed(evt);
            }
        });

        CheckOutjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/grant.jpg"))); // NOI18N
        CheckOutjButton.setText("Check out");
        CheckOutjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOutjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addTocatjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityToSelljSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salesPricejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(interestratejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantityInStorejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(medNamejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pricejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(deleteFromCatjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(totalSalesPricejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addComponent(totalNumbersOfItemjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(CheckOutjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(medNamejLabel))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(quantityInStorejLabel)
                            .addComponent(jLabel5)
                            .addComponent(pricejLabel))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(quantityToSelljSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(salesPricejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(interestratejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addTocatjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalNumbersOfItemjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteFromCatjButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalSalesPricejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(CheckOutjButton)
                .addGap(56, 56, 56))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sell Medicine");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Select Medicine");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addTocatjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTocatjButtonActionPerformed
        // TODO add your handling code here:
        ddToCart();
    }//GEN-LAST:event_addTocatjButtonActionPerformed

    private void medicineTablejTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicineTablejTableMouseClicked
        // TODO add your handling code here:
        rowNum = medicineTablejTable.getSelectedRow();
        String med_name = (String) medicineTablejTable.getValueAt(rowNum, 0);
        String med_quantity =  String.valueOf(medicineTablejTable.getValueAt(rowNum, 1));
        String med_price = String.valueOf(medicineTablejTable.getValueAt(rowNum, 2));
        String med_interestrate = String.valueOf(medicineTablejTable.getValueAt(rowNum, 3));

        medNamejLabel.setText((String) med_name);
        quantityInStorejLabel.setText(med_quantity);
        pricejLabel.setText(med_price);
        salesPricejTextField.setText (med_price);
        interestratejTextField.setText(med_interestrate);

        salesPricejTextField.setEditable(false);
        interestratejTextField.setEditable(false);
        
        
    }//GEN-LAST:event_medicineTablejTableMouseClicked

    private void salesPricejTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salesPricejTextFieldFocusLost
        // TODO add your handling code here:
        String salesPrice = salesPricejTextField.getText();
        UserActivities.validateIntegerInput(salesPricejTextField, salesPrice);
    }//GEN-LAST:event_salesPricejTextFieldFocusLost

    private void interestratejTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_interestratejTextFieldFocusLost
        // TODO add your handling code here:
        String intRate = interestratejTextField.getText();
        UserActivities.validateIntegerInput(interestratejTextField, intRate);
    }//GEN-LAST:event_interestratejTextFieldFocusLost

    private void CheckOutjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOutjButtonActionPerformed
        if (checkOutItemCart_Table.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Cart is empty, select medicine to sell before checkout", "input errorr",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            checkOut();
            itemCart_dtm.setRowCount(0);
            checkOutItemCart_dtm.setRowCount(0);
            totalNumbersOfItemjLabel.setText("");
            totalSalesPricejLabel.setText("");
        }
    }//GEN-LAST:event_CheckOutjButtonActionPerformed

    private void deleteFromCatjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFromCatjButtonActionPerformed
        // TODO add your handling code here:
        int row = cartjTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select Medicine to delete", "nothing to delete",
                    JOptionPane.INFORMATION_MESSAGE);

        } else {
            int deletedMed_sales_price = (int) cartjTable.getValueAt(row, 3);
            int updatePrice = totalSalesPrice -  deletedMed_sales_price;
            totalSalesPricejLabel.setText(Integer.toString(updatePrice));
            totalSalesPrice = updatePrice;
            
            totalNumbersOfItemjLabel.setText(Integer.toString(numberOfItemInCArt - 1));

            int index = (int) cartjTable.getValueAt(row, 0);
            int QtyInMedTable = (int) medicineTablejTable.getValueAt(index, 1);
            int QtyInCartTable = (int) cartjTable.getValueAt(row, 2);
            int updateQty = QtyInMedTable + QtyInCartTable;
            medicineTablejTable.setValueAt(updateQty, index, 1);

            ((DefaultTableModel) cartjTable.getModel()).removeRow(row);
            ((DefaultTableModel)checkOutItemCart_Table.getModel()).removeRow(row);


        }
    }//GEN-LAST:event_deleteFromCatjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckOutjButton;
    private javax.swing.JButton addTocatjButton;
    private javax.swing.JTable cartjTable;
    private javax.swing.JButton deleteFromCatjButton;
    private javax.swing.JTextField interestratejTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel medNamejLabel;
    private javax.swing.JTable medicineTablejTable;
    private javax.swing.JLabel pricejLabel;
    private javax.swing.JLabel quantityInStorejLabel;
    private javax.swing.JSpinner quantityToSelljSpinner;
    private javax.swing.JTextField salesPricejTextField;
    private javax.swing.JButton searchMedicinejButton;
    private javax.swing.JTextField searchMedicinejTextField;
    private javax.swing.JLabel totalNumbersOfItemjLabel;
    private javax.swing.JLabel totalSalesPricejLabel;
    // End of variables declaration//GEN-END:variables
}
