package com.binance.connector.futures.conn.UI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * создаем кнопку закрыть в таблице, как это происходит лучше не спашивать
 */
public class ClosePositionButtonListener {

  JButton closePositionButton = new JButton();
  public ClosePositionButtonListener(DefaultTableModel defaultTableModel, JTable table) {

    table.setModel(defaultTableModel);
    table.getColumn("ClosePosition").setCellRenderer(new ButtonRenderer());
    table.getColumn("ClosePosition").setCellEditor(new ButtonEditor(new JCheckBox()));

    closePositionButton.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            ClosePositionDialogUI closePositionDialogUI = new ClosePositionDialogUI(defaultTableModel,
                table);
          }
        }
    );
  }
  static class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
      setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
      setText((value == null) ? "Close" : value.toString());
      return this;
    }
  }

  class ButtonEditor extends DefaultCellEditor {

    private String label;


    public ButtonEditor(JCheckBox checkBox) {
      super(checkBox);
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
        boolean isSelected, int row, int column) {
      label = (value == null) ? "Close" : value.toString();
      closePositionButton.setText(label);
      return closePositionButton;
    }

    public Object getCellEditorValue() {
      return new String(label);
    }
  }
}
