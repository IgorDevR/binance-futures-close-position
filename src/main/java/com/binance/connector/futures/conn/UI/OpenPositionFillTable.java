package com.example.binancefuturescloseposition.futures.conn.UI;

import com.binance.connector.futures.conn.service.PositionsService;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * клас для заполнения данных таблицы
 */
public class OpenPositionFillTable {

  /**
   * запонить таблицу
   * @param defaultTableModel
   * @param table
   */
  public static void fill(DefaultTableModel defaultTableModel, JTable table) {

    defaultTableModel.setNumRows(0);
    table.setModel(new DefaultTableModel());
    String[][] rowArr = PositionsService.getOpenPositions();

    if(rowArr.length == 0){
      defaultTableModel.addRow(new String[]{"Открытых","позиций", "нет"});
    }
    for (String[] row : rowArr) {
      defaultTableModel.addRow(row);
    }

    ClosePositionButtonListener closePositionButtonListener = new ClosePositionButtonListener(defaultTableModel, table);

  }


}
