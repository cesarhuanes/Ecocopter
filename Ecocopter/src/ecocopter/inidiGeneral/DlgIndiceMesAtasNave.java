/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ecocopter.inidiGeneral;

import ecocopter.interParticular.DlgReporteIncideMesAtas;
import ecocopter.bean.Atas;
import ecocopter.bean.Nave;
import ecocopter.bean.ReportesParticulares;
import ecocopter.beanDataSource.indicesGene.DSIndiceGeneCuarto;
import ecocopter.conexion.VariablesConexion;
import ecocopter.dao.FacadeEcopter;
import ecocopter.dao.FacadeHoras;
import ecocopter.dao.FacadeReportes;
import ecocopter.interfaces.DlgReportes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author desarrollo2
 */
public final class DlgIndiceMesAtasNave extends javax.swing.JFrame {
   DefaultTableModel dt=new DefaultTableModel(); 
   public String codAta="";
   public String ano="";
   private String codNave="";
    DSIndiceGeneCuarto data= null;
   List<DSIndiceGeneCuarto> lst = new ArrayList<DSIndiceGeneCuarto>();
   /**
     * Creates new form DlgIndiceMesAtas
     */
    public DlgIndiceMesAtasNave() {
        initComponents();
         listarCombo();
         listarComboNave();
         this.setTitle("Indice de Fallas vs. Mes en función de Atas");
         cargarTamano();
         setColumnName();
        clearTexto();
    }
   public void cargarTamano(){//llamar este metodo en el constructor
     this.setSize(900, 530);
     this.setResizable(false); // no permit cambiar de tamaño
     this.setDefaultCloseOperation(DlgIndiceMesAtasNave.DO_NOTHING_ON_CLOSE);//inavilitar el cerrado
     this.setLocationRelativeTo(null);//centrado
     
    }
    private void setColumnName(){
    JTable.setModel(dt);
    dt.addColumn("MES");
    dt.addColumn("N°FALLAS");
    dt.addColumn("N°HORAS");
    dt.addColumn("INDICE");
    JTable.getColumnModel().getColumn(0).setPreferredWidth(70);
    JTable.getColumnModel().getColumn(1).setPreferredWidth(85);
    JTable.getColumnModel().getColumn(2).setPreferredWidth(85);
    JTable.getColumnModel().getColumn(3).setPreferredWidth(75);
    }
     private void clearTexto(){
     this.txtFallas.setText("");
     this.txtHoras.setText("");
     this.txtIndice.setText("");
     this.txtFallas.setEnabled(false);
     this.txtHoras.setEnabled(false);
     this.txtIndice.setEnabled(false);
     this.txtFallas.setText("0.00");
     this.txtHoras.setText("0.00");
     this.txtIndice.setText("0.00");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        spnanos = new com.toedter.calendar.JYearChooser();
        btnExportar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbAta = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cmbNave = new javax.swing.JComboBox();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFallas = new javax.swing.JTextField();
        txtHoras = new javax.swing.JTextField();
        txtIndice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnExportar.setText("Exportar PDF");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnReporte.setText("Generar");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccionar Ata:");

        jLabel2.setText("Seleccionar año:");

        cmbAta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Seleccionar Nave:");

        cmbNave.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbNave, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAta, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnanos, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Total Fallas:");
        jLabel3.setBounds(10, 20, 70, 14);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("Total Horas:");
        jLabel4.setBounds(10, 60, 80, 20);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("Total Indice:");
        jLabel5.setBounds(10, 100, 80, 14);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFallas.setBounds(110, 10, 80, 25);
        jLayeredPane1.add(txtFallas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtHoras.setBounds(110, 50, 80, 25);
        jLayeredPane1.add(txtHoras, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtIndice.setBounds(110, 100, 80, 25);
        jLayeredPane1.add(txtIndice, javax.swing.JLayeredPane.DEFAULT_LAYER);

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(JTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   private void calcularDatos(int totalFallas,int totalHoras){
    double indice=0;
     txtFallas.setText(""+totalFallas);
     if(totalFallas==0){
     JOptionPane.showMessageDialog( null,"No se determino fallas.","Información",JOptionPane.WARNING_MESSAGE);
     }
     txtFallas.setDisabledTextColor(Color.BLUE);
     txtHoras.setText(""+totalHoras);
     txtHoras.setDisabledTextColor(Color.BLUE);
     if(totalHoras<=totalFallas){
      txtHoras.setDisabledTextColor(Color.RED);   
     }
     indice=Double.parseDouble(String.valueOf(totalFallas))/Double.parseDouble(String.valueOf(totalHoras));
     indice=Math.rint(indice*100)/100;
     txtIndice.setText(""+indice);
     if(indice>=1){
     this.txtIndice.setDisabledTextColor(Color.RED);
      JOptionPane.showMessageDialog( null," Verificar la Cantidad de Horas de Vuelo.\n Indice de Falla Incorrecto.","Información",JOptionPane.WARNING_MESSAGE);
     }else{
     this.txtIndice.setDisabledTextColor(Color.BLUE);
    
     } 
    }
    ArrayList lstNave=(ArrayList)FacadeEcopter.ListaNave();
    public void listarComboNave(){
    Nave nave;
    this.cmbNave.removeAllItems();
    for(int f=0; f<lstNave.size();f++){
    nave=(Nave)lstNave.get(f);
    this.cmbNave.insertItemAt(FacadeEcopter.LeerNave(f).getNomNave(), f);
    }
    }
    public  int getCodnave(){
        Nave nave;
        int codNave = 0;
        try{
        int index=cmbNave.getSelectedIndex();
        nave=(Nave)lstNave.get(index);
        codNave=Integer.parseInt(nave.getIdNave());
        System.out.print("Codigo Nave"+nave);
        }catch(Exception e){
            e.printStackTrace();
        }
      return codNave;
    }
    public String getCastCodNave(){
    String codigo="";
    codigo=String.valueOf(this.getCodnave());
    return codigo.trim();
    } 
     public  String getNomNave(){
        String nave="";
        try{
        int index=cmbNave.getSelectedIndex();
        nave=this.cmbNave.getItemAt(index).toString();
        System.out.print("nave "+nave);
        }catch(Exception e){
            e.printStackTrace();
        }
      return nave;
    }
    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
         clearTexto();
        dt.setRowCount(0);
        double indice=0;
        int falla=0;
        int horaMes=0;
        this.setAno(this.anos());
        this.setCodAta(this.getValueAta());
        this.setCodNave(getCastCodNave());
        FacadeReportes reportes=new FacadeReportes();
        FacadeHoras horas=new FacadeHoras();
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for(ReportesParticulares x:reportes.ListReporte4(this.getCodNave(),this.getCodAta(), this.getAno())){
            int cantHoras=horas.getCantHorasMesNaveAno(x.getMes().toLowerCase().trim(),this.getNomNave(), this.getAno());
            System.out.println("Cantidad"+cantHoras);
            if(cantHoras>0){
             falla=falla+x.getCantAta();
             horaMes=horaMes+cantHoras;
             indice=Double.parseDouble(String.valueOf(x.getCantAta()))/Double.parseDouble(String.valueOf(cantHoras));
             indice= Math.rint(indice*100)/100;   
             datos.setValue(indice, "", x.getMes());
             dt.addRow(new Object[]{x.getMes(),x.getCantAta(),cantHoras,indice});//pintamos la grilla
             data=new DSIndiceGeneCuarto(x.getMes(),x.getCantAta(),cantHoras,indice);
             lst.add(data);
            }
            }

        JFreeChart barchart=ChartFactory.createLineChart("Indice de Fallas vs Meses", "Meses", "Indice de Fallas", datos,PlotOrientation.VERTICAL,false,true,false);
        CategoryPlot   barcrt=barchart.getCategoryPlot();
        barcrt.setRangeGridlinePaint(Color.orange);

        ChartPanel barpanel=new ChartPanel(barchart);
        panel.removeAll();
        panel.add(barpanel,BorderLayout.CENTER);
        panel.validate();
        calcularDatos(falla,horaMes);

    }//GEN-LAST:event_btnReporteActionPerformed
    public void cargaJasper(){
        try {
            String imagen="\\\\"+VariablesConexion.ip+"\\Sistema\\imagen\\logo.jpg";
            String rutaInform="\\\\"+VariablesConexion.ip+"\\Sistema\\reportes\\indiceOctavo.jasper";
            Map parametros = new HashMap();
            parametros.put("nomNave",getNomNave());
            parametros.put("codAta",this.getCodAta());
            parametros.put("ano", this.getAno());
            //parametros.put("imagen",this.getClass().getResourceAsStream(imagen));
            JasperPrint jasperPrint = JasperFillManager.fillReport(rutaInform, parametros, new JRBeanCollectionDataSource(lst));
            JasperViewer viewer=new JasperViewer(jasperPrint,false);
            viewer.setTitle("Informe");
            viewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(DlgReporteIncideMesAtas.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
     DlgReportes reportes=new DlgReportes();
     reportes.setVisible(true);
     this.setVisible(false);    
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
        cargaJasper();
    }//GEN-LAST:event_btnExportarActionPerformed

    private void txtFallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFallasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFallasActionPerformed
   ArrayList lista=(ArrayList)FacadeReportes.ListAtas();
    public void listarCombo(){
    Atas ata;
    this.cmbAta.removeAllItems();
    for(int f=0; f<lista.size();f++){
    ata=(Atas)lista.get(f);
    this.cmbAta.insertItemAt(FacadeReportes.LeerAta(f).getCodAta(), f);
    }
    }
    
    public  String getValueAta(){
        String codAta="";
        try{
        int index=cmbAta.getSelectedIndex();
        codAta=this.cmbAta.getItemAt(index).toString();
        System.out.println("Nave "+codAta);
        }catch(Exception e){
            e.printStackTrace();
        }
      return codAta;
    }
    
     private String  anos(){
    return  ano=String.valueOf(spnanos.getYear());     
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
            java.util.logging.Logger.getLogger(DlgIndiceMesAtasNave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgIndiceMesAtasNave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgIndiceMesAtasNave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgIndiceMesAtasNave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DlgIndiceMesAtasNave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbAta;
    private javax.swing.JComboBox cmbNave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel;
    private com.toedter.calendar.JYearChooser spnanos;
    private javax.swing.JTextField txtFallas;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtIndice;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the codAta
     */
    public String getCodAta() {
        return codAta;
    }

    /**
     * @param codAta the codAta to set
     */
    public void setCodAta(String codAta) {
        this.codAta = codAta;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the codNave
     */
    public String getCodNave() {
        return codNave;
    }

    /**
     * @param codNave the codNave to set
     */
    public void setCodNave(String codNave) {
        this.codNave = codNave;
    }
}
