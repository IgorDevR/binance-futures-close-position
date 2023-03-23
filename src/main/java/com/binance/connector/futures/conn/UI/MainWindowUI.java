package com.binance.connector.futures.conn.UI;

import com.binance.connector.futures.conn.util.file.FilesHandler;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainWindowUI extends JFrame {


  public MainWindowUI() throws HeadlessException {

    JFrame frame = new JFrame("Chat Frame");
    frame.setLayout(new FlowLayout());
    frame.setSize(450, 400);
    frame.setContentPane(basePanel);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    getOpenPositionsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        if (USDTCheckBox != null && USDTCheckBox.isSelected()) {
          OpenPositionFillTable.fillUM(openPositionTableModel, openPositionTable);

        }
        if (COINMCheckBox != null && COINMCheckBox.isSelected()) {
          OpenPositionFillTable.fillCM(openPositionTableModel, openPositionTable);

        }


      }
    });
/**
 * сохранить ключи кнопка
 */
    saveKeysButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!apiKeyField.getText().isEmpty() && !apiSecretField.getText().isEmpty()) {
          FilesHandler filesHandler = new FilesHandler();
          filesHandler.saveToFile(apiKeyField.getText(),
              apiSecretField.getText(), urlServerUSDTTextField.getText(),
              urlServerCoinMTextField.getText());
        }
      }
    });
    FilesHandler filesHandler = new FilesHandler();
    String[] keys = filesHandler.loadFromFile();
    if (keys.length > 0) {
      apiKeyField.setText(keys[0]);
      apiSecretField.setText(keys[1]);
      urlServerUSDTTextField.setText(keys[2]);
      urlServerCoinMTextField.setText(keys[3]);
    }


  }

  private JPanel basePanel;
  private JButton getInfoAccountButton;
  private JTabbedPane tabs;
  private JLabel keyLabel;
  private JLabel APILabel;
  private JTextField apiKeyField;
  private JTextField apiSecretField;
  private JButton saveKeysButton;
  private JButton closePositionButton;
  private JButton okClosePosButton;
  private JButton cancelClosePosButton;
  private JTable openPositionTable;
  private JButton getOpenPositionsButton;
  private JTextField urlServerUSDTTextField;
  private JTextField urlServerCoinMTextField;
  private JCheckBox USDTCheckBox;
  private JCheckBox COINMCheckBox;
  private DefaultTableModel openPositionTableModel;


  private void createUIComponents() {

    CreateComponent createComponent = new CreateComponent(openPositionTableModel,
        openPositionTable);
    createComponent.createOpenPositionTable();
    openPositionTableModel = createComponent.getDefaultTableModel();
    openPositionTable = createComponent.getJtable();
  }


}
