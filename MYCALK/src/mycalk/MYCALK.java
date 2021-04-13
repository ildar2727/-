
package mycalk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

 public class MYCALK {
     private JTextField koefficientField;//окно ввода территориального коэф
     private JLabel koefficientLabel;//
     private JLabel kLabel;
     private JTextField groundtarifField;//окно ввода базового тарифа
     private JLabel groundtarifLabel;//
     private JLabel rubLabel;
     private JTextField powerField;//окно ввода мощности двигателя
     private JLabel powerLabel;
     private JLabel kWtLabel;
     private JTextField timeField;//окно ввода срока страхования
     private JLabel timeLabel;
     private JLabel yearLabel;
     private JLabel stazhLabel;
     private JTextField stazhField;//окно вввода стажа водителя
     private JLabel vozrastLabel;
     private JTextField vozrastField;//окно ввода возраста водителя
private JButton calcButton;
private JLabel resultLabel;
private JFrame mainFrame;

  MYCALK() {
      
      groundtarifField = new JTextField("0");
      groundtarifField.setHorizontalAlignment(JTextField.RIGHT);
      groundtarifLabel = new JLabel("базовый тариф");
      rubLabel = new JLabel ("руб");
      koefficientLabel = new JLabel(" территориальный коэффициент ");
      koefficientField = new JTextField("0");
      koefficientField.setHorizontalAlignment(JTextField.RIGHT);
      kLabel = new JLabel("фиксированное значение");
      powerLabel = new JLabel("мощность двигателя");
      powerField = new JTextField("0");
      kWtLabel = new JLabel("лошадинные силы");
      powerField.setHorizontalAlignment(JTextField.RIGHT);
      timeLabel = new JLabel("срок страхования");
      timeField = new JTextField("0");
      timeField.setHorizontalAlignment(JTextField.RIGHT);
      yearLabel = new JLabel("г");
      stazhLabel = new JLabel("стаж водителя");
      stazhField = new JTextField("0");
      stazhField.setHorizontalAlignment(JTextField.RIGHT);
      vozrastLabel = new JLabel("возраст водителя");
      vozrastField = new JTextField("0");
      vozrastField.setHorizontalAlignment(JTextField.RIGHT);
      calcButton = new JButton("Рассчитать");
      calcButton.addActionListener(new ActionListener() {
      @Override
           public void actionPerformed(ActionEvent ae) {
try {
double  koefficient =Double.parseDouble( koefficientField.getText());
double groundtarif =Double.parseDouble(groundtarifField.getText());
double power =Double.parseDouble(powerField.getText());
double time =Double.parseDouble(timeField.getText());
double stazh =Double.parseDouble(stazhField.getText());
double vozrast =Double.parseDouble(vozrastField.getText());
double ikv = (stazh+vozrast) / 50 ;
double cost = (koefficient * groundtarif * (power/100) * time)/ikv;
int x = (int)Math.round(cost);
resultLabel.setText("<html>Стоимость <fontstyle='color: green; font-weight: bold;'>"  + "</font> страховки обойдётся в <font style='color: green; font-weight: bold;'>" + x + "</font> руб.</html>");
}

catch ( NumberFormatException nfe ) {
resultLabel.setText("неверный формат введённых данных");
   }
  }
}); 

resultLabel = new JLabel("Введите необходимые данные");
GridBagLayout layout = new GridBagLayout();
GridBagConstraints constraints = new GridBagConstraints();
constraints.weightx = 1.0;
constraints.weighty = 1.0;
constraints.insets = new Insets(15, 15, 15, 15);
constraints.gridx = 0;
constraints.anchor = GridBagConstraints.WEST;
constraints.ipadx =180;
constraints.gridy = 0;
layout.setConstraints(koefficientLabel, constraints);
constraints.gridy = 1;
layout.setConstraints(powerLabel, constraints);
constraints.gridy = 2;
layout.setConstraints(timeLabel, constraints);
constraints.gridy = 3;
layout.setConstraints(groundtarifLabel, constraints);
constraints.gridy = 4;
layout.setConstraints(stazhLabel, constraints);
constraints.gridy = 5;
layout.setConstraints(vozrastLabel, constraints);
constraints.gridy = 6;
constraints.anchor = GridBagConstraints.EAST;
constraints.ipadx = 90;
constraints.gridy = 0;
layout.setConstraints(koefficientField, constraints);
constraints.gridy = 1;
layout.setConstraints(powerField, constraints);
constraints.gridy = 2;
layout.setConstraints(timeField, constraints);
constraints.gridy = 3;
layout.setConstraints(groundtarifField, constraints);
constraints.gridy = 4;
layout.setConstraints(stazhField, constraints);
constraints.gridy = 5;
layout.setConstraints(vozrastField, constraints);
constraints.gridy = 6;
constraints.gridx = 3;
constraints.ipadx = 0;
constraints.gridy = 0;
layout.setConstraints(kLabel, constraints);
constraints.gridy = 1;
layout.setConstraints(kWtLabel, constraints);
constraints.gridy = 2;
layout.setConstraints(yearLabel, constraints);
constraints.gridy = 3;
layout.setConstraints(rubLabel, constraints);
constraints.gridx = 0;
constraints.gridy = 4;
constraints.gridwidth = GridBagConstraints.REMAINDER;
constraints.anchor = GridBagConstraints.EAST;

constraints.gridy = 6;
layout.setConstraints(calcButton, constraints);
constraints.fill = GridBagConstraints.HORIZONTAL;
constraints.anchor = GridBagConstraints.WEST;
constraints.gridy = 7;
layout.setConstraints(resultLabel, constraints);
mainFrame = new JFrame("Расчёт страхования по ОСАГО");
mainFrame.setSize(1000, 500);
Container c = mainFrame.getContentPane();
c.setBackground(Color.LIGHT_GRAY);
calcButton.setBackground(Color.RED);
mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
mainFrame.setLayout(layout);
mainFrame.add(koefficientLabel);
mainFrame.add(powerLabel);
mainFrame.add(timeLabel);
mainFrame.add(koefficientField);
mainFrame.add(powerField);
mainFrame.add(timeField);
mainFrame.add(kLabel);
mainFrame.add(yearLabel);
mainFrame.add(kWtLabel);
mainFrame.add(groundtarifLabel);
mainFrame.add(groundtarifField);
mainFrame.add(rubLabel);
mainFrame.add(calcButton);
mainFrame.add(resultLabel);
mainFrame.add(stazhLabel);
mainFrame.add(stazhField);
mainFrame.add(vozrastLabel);
mainFrame.add(vozrastField);
mainFrame.pack();
mainFrame.setVisible(true);
}
}

