package com.binance.connector.futures.conn.UI;

import com.binance.connector.futures.conn.util.HeadersForTables;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jetbrains.annotations.NotNull;

/**
 * создаем компоненты таблице при старе приложения
 */
public class CreateComponent {

  private DefaultTableModel defaultTableModel;
  private JTable table;

  public CreateComponent(DefaultTableModel openPositionTableModel, JTable openPositionTable) {
    this.defaultTableModel = openPositionTableModel;
    this.table = openPositionTable;

  }


  public  void createOpenPositionTable(){
    String[] columnsNames = HeadersForTables.getHeadersOpenPosition();
    defaultTableModel = createHeaderInTable(columnsNames);
    table = new JTable(defaultTableModel);

  }
  @NotNull
  private static DefaultTableModel createHeaderInTable(String[] headersArr) {
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    defaultTableModel.setDataVector(new Object[0][0], headersArr);
    return defaultTableModel;
  }

  public DefaultTableModel getDefaultTableModel() {
    return defaultTableModel;
  }

  public JTable getJtable() {
    return table;
  }


}
