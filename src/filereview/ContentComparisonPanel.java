/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereview;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author wkuan
 */
public class ContentComparisonPanel extends JPanel{
    private List<String> base;
    private List<String> comp;
    private JTable comparisonTable;
    private JScrollPane scrollPane;
    private int cmntCount;
    private final int TABLE_SIZE = 4;
    private final int LINE_INDEX = 0;
    private final int BASE_INDEX = 1;
    private final int COMP_INDEX = 2;
    private final int CMNT_INDEX = 3;
    public ContentComparisonPanel(List<String> aBase, List<String> aComp){
        super(new BorderLayout());
        base = aBase;
        comp = aComp;
        cmntCount = Integer.max(base.size(), comp.size());
        Object[] baseArr = base.toArray();
        Object[] compArr = comp.toArray();
        Object[] cmntArr = new Object[cmntCount];
        Object[] lineArr = new Object[cmntCount];
        Object[][] tableContent = new Object[cmntCount][];
        String[] tableHeader = new String[this.TABLE_SIZE];
        tableHeader[this.LINE_INDEX] = "Info";
        tableHeader[this.BASE_INDEX] = "Base content";
        tableHeader[this.COMP_INDEX] = "Compared content";
        tableHeader[this.CMNT_INDEX] = "Coments";
        for (int i=0;i<cmntCount;i++) {
            tableContent[i] = new Object[this.TABLE_SIZE];
            tableContent[i][this.LINE_INDEX] = lineArr[i];
            tableContent[i][this.BASE_INDEX] = baseArr[i];
            tableContent[i][this.COMP_INDEX] = compArr[i];
            tableContent[i][this.CMNT_INDEX] = cmntArr[i];
        }
        comparisonTable = new JTable(tableContent,tableHeader);
        comparisonTable.setBounds(0,0,750, 750);
        comparisonTable.getColumnModel().getColumn(this.BASE_INDEX).setMinWidth(350);
        comparisonTable.getColumnModel().getColumn(this.COMP_INDEX).setMinWidth(350);
        comparisonTable.getColumnModel().getColumn(this.BASE_INDEX).setCellRenderer(new WordWrapCellRenderer());
        comparisonTable.getColumnModel().getColumn(this.COMP_INDEX).setCellRenderer(new WordWrapCellRenderer());
        scrollPane = new JScrollPane(comparisonTable);
        this.add(scrollPane,BorderLayout.CENTER);        
    }
    
    static class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {
        public WordWrapCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
        }
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
            if (table.getRowHeight(row) != getPreferredSize().height) {
                table.setRowHeight(row, getPreferredSize().height);
            }
            return this;
        }
    }
}
