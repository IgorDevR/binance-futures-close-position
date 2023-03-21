package com.example.binancefuturescloseposition.futures.conn.UI;

import com.binance.connector.futures.conn.service.PositionsService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class ClosePositionDialogUI extends JDialog {

  private JPanel contentPane;
  private JButton buttonOK;
  private JButton buttonCancel;

  /**
   * окно с вопросм удалить или нет
   * @param openPositionTableModel
   * @param openPositionTable
   */
  public ClosePositionDialogUI(DefaultTableModel openPositionTableModel, JTable openPositionTable) {

    this.pack();
    this.setVisible(true);
    this.setSize(200, 150);
    this.setLocationRelativeTo(null);
    setContentPane(contentPane);
    setModal(true);
    getRootPane().setDefaultButton(buttonOK);

    buttonOK.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        onOK(e,openPositionTableModel, openPositionTable);
      }
    });

    buttonCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        onCancel();
      }
    });

    // call onCancel() when cross is clicked
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        onCancel();
      }
    });

    // call onCancel() on ESCAPE
    contentPane.registerKeyboardAction(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                           onCancel();
                                         }
                                       }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
        JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
  }

  private void onOK(ActionEvent e, DefaultTableModel openPositionTableModel,
      JTable openPositionTable) {
    PositionsService.closeSelectPosition(openPositionTable);
    OpenPositionFillTable.fill(openPositionTableModel,openPositionTable);
    dispose();
  }

  private void onCancel() {
    // add your code here if necessary
    dispose();
  }

}
