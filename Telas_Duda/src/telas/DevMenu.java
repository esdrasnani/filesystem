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
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static javafx.scene.input.DataFormat.IMAGE;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
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
    ImageIcon leafIcon = createImageIcon("icon.png");
    ImageIcon folderIcon = createImageIcon("folder.png");
    ImageIcon closedFolderIcon = createImageIcon("closedfolder.png");
    
    public DevMenu(String nome, String caminho, String header, String dataCriacao, byte[] conteudo, int novo) {
        this.nome = nome;
        this.caminho = caminho;
        this.header = header;
        this.dataCriacao = dataCriacao;
        this.conteudo = conteudo;     
        initComponents();
        
        if (leafIcon != null) {
            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
            renderer.setLeafIcon(closedFolderIcon);
            jTree1.setCellRenderer(renderer);
        }
        
        if (novo == 0){
            montarArvore();
        }
    }
    
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = DevMenu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
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

        jPanel1 = new javax.swing.JPanel();
        btn_add_file = new javax.swing.JButton();
        btn_extract_file = new javax.swing.JButton();
        btn_create_folder = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        btn_add_file.setBackground(new java.awt.Color(153, 153, 153));
        btn_add_file.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_add_file.setText("Add File");
        btn_add_file.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_add_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_fileActionPerformed(evt);
            }
        });

        btn_extract_file.setBackground(new java.awt.Color(153, 153, 153));
        btn_extract_file.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_extract_file.setText("Extract File");
        btn_extract_file.setActionCommand("Excluir Arquivo");
        btn_extract_file.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_extract_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_extract_fileActionPerformed(evt);
            }
        });

        btn_create_folder.setBackground(new java.awt.Color(153, 153, 153));
        btn_create_folder.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_create_folder.setText("Create Folder");
        btn_create_folder.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_create_folder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_create_folderActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arquivos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14))); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("DEV");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(231, 231, 231));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btn_create_folder, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_add_file, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_extract_file, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_add_file, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_create_folder, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_extract_file, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_fileActionPerformed
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
        
        if (leafIcon != null) {
            DefaultTreeCellRenderer renderer = 
                new DefaultTreeCellRenderer();
            renderer.setLeafIcon(leafIcon);
            renderer.setOpenIcon(folderIcon);
            renderer.setClosedIcon(closedFolderIcon);
            jTree1.setCellRenderer(renderer);
        }
 
    }//GEN-LAST:event_btn_add_fileActionPerformed

    private void btn_extract_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_extract_fileActionPerformed
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
    }//GEN-LAST:event_btn_extract_fileActionPerformed

    private void btn_create_folderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_create_folderActionPerformed
        
    }//GEN-LAST:event_btn_create_folderActionPerformed
    
    private JTree jt;    
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
            System.out.println(newBytesHeader);
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
    private javax.swing.JButton btn_add_file;
    private javax.swing.JButton btn_create_folder;
    private javax.swing.JButton btn_extract_file;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

}
