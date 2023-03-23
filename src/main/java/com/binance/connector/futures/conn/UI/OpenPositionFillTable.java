package com.binance.connector.futures.conn.UI;

import com.binance.connector.futures.conn.service.PositionsServiceCM;
import com.binance.connector.futures.conn.service.PositionsServiceUM;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * клас для заполнения данных таблицы
 */
public class OpenPositionFillTable {

  /**
   * запонить таблицу
   *
   * @param defaultTableModel
   * @param table
   * @param
   */
  public static void fillUM(DefaultTableModel defaultTableModel, JTable table) {

    String[][] rowArr = PositionsServiceUM.getOpenPositions();

    fillPos(defaultTableModel, table, rowArr);

  }

  public static void fillCM(DefaultTableModel defaultTableModel, JTable table) {

    String[][] rowArr = PositionsServiceCM.getOpenPositions();

    fillPos(defaultTableModel, table, rowArr);

  }

  public static void fillForClosePosBTN(DefaultTableModel defaultTableModel, JTable table) {

    String[][] rowArrUM = PositionsServiceUM.getOpenPositions();
    if (rowArrUM != null && rowArrUM.length > 0) {
      fillPos(defaultTableModel, table, rowArrUM);
      return;
    }
    String[][] rowArrCM = PositionsServiceCM.getOpenPositions();
    if (rowArrCM != null && rowArrCM.length > 0) {
      fillPos(defaultTableModel, table, rowArrCM);
      return;
    }

  }

  private static void fillPos(DefaultTableModel defaultTableModel, JTable table,
      String[][] rowArr) {

    defaultTableModel.setNumRows(0);
    table.setModel(new DefaultTableModel());

    if (rowArr.length == 0) {
      defaultTableModel.addRow(new String[]{"Открытых", "позиций", "нет"});
    }
    for (String[] row : rowArr) {
      defaultTableModel.addRow(row);
    }

    ClosePositionButtonListener closePositionButtonListener = new ClosePositionButtonListener(
        defaultTableModel, table);
  }


}
