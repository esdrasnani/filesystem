package telas;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.plaf.TreeUI;
import javax.swing.plaf.basic.BasicTreeUI;
import telas.DevMenu;

public class CustomTreeRenderer extends DefaultTreeCellRenderer {

    public CustomTreeRenderer() {
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

            ImageIcon leafIcon = createImageIcon("icon.png");
            ImageIcon folderIcon = createImageIcon("folder.png");
            ImageIcon closedFolderIcon = createImageIcon("closedFolder.png");
            ImageIcon plusIcon = createImageIcon("plus.png");
            ImageIcon minusIcon = createImageIcon("minus.png");

            if(node.getAllowsChildren()){
                this.setIcon(closedFolderIcon);
            }
            else{
                this.setIcon(leafIcon);
            }
            
            this.setOpenIcon(folderIcon);
                this.setClosedIcon(closedFolderIcon);
            
            TreeUI tui = tree.getUI();
            if (tui instanceof BasicTreeUI) {
              ((BasicTreeUI)tui).setCollapsedIcon(plusIcon);
              ((BasicTreeUI)tui).setExpandedIcon(minusIcon);
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