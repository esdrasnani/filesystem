/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author esdras
 */
public class DevMenu extends javax.swing.JFrame {

    /**
     * Creates new form DevMenu
     */
    public static String nome;
    public static String caminho;
    public static String header;
    public static byte[] conteudo;
    public static String dataCriacao;
    
    
    /*
    public static String filename = "";
    public static String header = "";
    public static byte [] conteudoArquivos;
    public static String arquivoComHash = "";
    public static String dataCriacao = "";
    public static List<Arquivo> arquivos;
    */
    public DevMenu(String nome, String caminho, String header, String dataCriacao, byte[] conteudo, int novo) {
        this.nome = nome;
        this.caminho = caminho;
        this.header = header;
        this.dataCriacao = dataCriacao;
        this.conteudo = conteudo;          
        initComponents();
        if (novo == 0)
            montarArvore();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Add File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Extrair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("DEV");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jTree1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private JTree jt;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setDialogTitle("Selecione o local do Arquivo");
        
        fileChooser.setAcceptAllFileFilterUsed(true);
       
        
        if(fileChooser.showSaveDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            writebytes(file);
            
            DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
            if(model.getRoot() == null){
                 root = new DefaultMutableTreeNode("DEV");
            }
            DefaultMutableTreeNode file_name = new DefaultMutableTreeNode(file.getName());
            root.add(file_name);
            model.reload();
            model.setRoot(root);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        if(node != null){
            if(node.isLeaf()){     
                TreePath[] paths = jTree1.getSelectionPaths();
                String nomeExtrair = "";
                for(TreePath path : paths){
                    nomeExtrair = path.getLastPathComponent().toString();
                }
                String extensao = nomeExtrair.substring(nomeExtrair.indexOf(".")+1);
                String nome = nomeExtrair.substring(0, nomeExtrair.indexOf("."));
                JFileChooser fileChooser = new JFileChooser();

                fileChooser.setDialogTitle("Selecione o local do Arquivo");

                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Arquivos " + extensao +" (." + extensao + ")", extensao));
                fileChooser.setName(nomeExtrair);

                fileChooser.setSelectedFile(new File(nome));

                if(fileChooser.showSaveDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
                    
                    List<String> list = Arrays.asList(header.split("###"));
                    list = new ArrayList<String>(list);
                    
                    
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Não é possível extrair um diretório!\n\nPor favor, selecione um arquivo.", "ATENÇÂO", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, selecione o arquivo a ser extraído!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private byte[] readFileToByteArray(File file) {
        FileInputStream fis = null;
        // Creating a byte array using the length of the file
        // file.length returns long which is cast to int
        byte[] bArray = new byte[(int) file.length()];
        try{
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();        
            
        }catch(IOException ioExp){
            ioExp.printStackTrace();
        }
        return bArray;
    }
    
    private void writebytes(File file){
        try{
            byte[] fileBytes = readFileToByteArray(file);
            
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            String data_criacao = fmt.format(new Date());
            
            int inicio = conteudo.length;
            
            header += "###" + file.getName() + "&&&1&&&" + file.getPath() 
                   + "&&&" + inicio + "&&&" + fileBytes.length + "&&&" + data_criacao;
            
            
            byte[] newBytes = Arrays.copyOf(conteudo, conteudo.length + fileBytes.length);
            System.arraycopy(fileBytes, 0, newBytes, conteudo.length, fileBytes.length);
            
            conteudo = newBytes;
            
            FileOutputStream dev = new FileOutputStream(caminho+".dev");            
            String newBytesHeader = header + "$$$" + new String(conteudo);
            dev.write(newBytesHeader.getBytes());
            System.out.println("Arquivo Inserido com Sucesso");
            dev.close();
        }
        catch(Exception e){
            System.out.println("Exception" + e);
        }
    }
    
     private void montarArvore(){
        // Ler header
        List<String> list = Arrays.asList(header.split("###"));
        list = new ArrayList<String>(list);
        
        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree1.getModel().getRoot(); 
        if(model.getRoot() == null){
                 root = new DefaultMutableTreeNode("DEV");
        }
        list.remove(0);
        list.remove(0);
        System.out.println(list);
        
        for(String s : list) {
           String [] arquivoPart = s.split("&&&");
           DefaultMutableTreeNode file_name = new DefaultMutableTreeNode(arquivoPart[0]);
           root.add(file_name);
           model.reload();
           model.setRoot(root);
        }
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
            java.util.logging.Logger.getLogger(DevMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DevMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DevMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DevMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
                        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

}
