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
public class ManageStore extends javax.swing.JPanel {

    /**
     * Creates new form ManageStore
     */
    public ManageStore() {
        initComponents();
        
        UpdateMedicine updateMed = new UpdateMedicine();
        jTabbedPane2.add("Update Medicine",updateMed);
        AddMedicneGroup addMedGroup = new AddMedicneGroup();
        jTabbedPane2.add("Add Medicine Group",addMedGroup);
        AddMedicneCartegory addMedCategory = new AddMedicneCartegory();
        jTabbedPane2.add("Add Medicine category",addMedCategory);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
