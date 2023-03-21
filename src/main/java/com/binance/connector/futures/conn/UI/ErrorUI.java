package com.example.binancefuturescloseposition.futures.conn.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ErrorUI extends JDialog {

  private JPanel contentPane;
  private JButton buttonOK;
  public JTextPane logTextPane;

  public ErrorUI() {

    this.pack();
    this.setVisible(true);
    this.setSize(200, 250);
    this.setLocationRelativeTo(null);
    setContentPane(contentPane);
    setModal(true);
    getRootPane().setDefaultButton(buttonOK);
    buttonOK.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        onOK();
      }
    });

  }

  private void onOK() {
    // add your code here
    dispose();
  }


  public static void main(String[] args) {
    ErrorUI dialog = new ErrorUI();
    dialog.pack();
    dialog.setVisible(true);
    System.exit(0);
  }
}
