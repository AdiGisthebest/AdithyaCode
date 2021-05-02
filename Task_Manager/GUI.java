import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI implements ActionListener {
  Manager hi;
  JFrame frame;
  JPanel panel;
  public GUI() {
    frame = new JFrame("My desktop app");
    panel = new JPanel();
    JButton button = new JButton("Add Task");
    button.addActionListener(this);
    panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
    //panel.setLayout(new GridLayout(0,1));
    frame.add(panel,BorderLayout.CENTER);
    frame.add(button);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
    System.out.println("hi");
  }
  public static void main(String[] args) {
    new GUI();
  }
}
