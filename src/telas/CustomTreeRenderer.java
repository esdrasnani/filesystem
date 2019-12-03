package telas;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import javax.swing.ImageIcon;
import telas.DevMenu;

public class CustomTreeRenderer extends DefaultTreeCellRenderer {

    public CustomTreeRenderer() {
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        
        if(value != null){
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

            ImageIcon leafIcon = createImageIcon("icon.png");
            ImageIcon folderIcon = createImageIcon("folder.png");
            ImageIcon closedFolderIcon = createImageIcon("closedfolder.png");

            if(node.isLeaf()){
                this.setIcon(leafIcon);
            }
            if(node.getAllowsChildren()){
                this.setIcon(folderIcon);
            }
        }
        return this;
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
}