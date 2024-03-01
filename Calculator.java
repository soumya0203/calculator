package Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame
{
	 private JTextField display;
	 public Calculator() 
	 {
		 setTitle("Calculator");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setLayout(new BorderLayout());
		 
		 display= new JTextField();
		 display.setEditable(false);
		 add(display,BorderLayout.NORTH);
		 
		 JPanel buttonPanel= new JPanel();
		 buttonPanel.setLayout(new GridLayout(4,4));
		 
		 String[] buttonLabels = {"7", "8", "9", "/",
				                  "4", "5", "6", "*",
				                  "1", "2", "3", "-",
				                  "0", ".", "=", "+"
		 };
		 
		 for (String label:buttonLabels)
		 {
			 JButton button = new JButton(label);
			 button.addActionListener(new ButtonClickListener());
			 buttonPanel.add(button);
		 }
		 
		 add(buttonPanel, BorderLayout.CENTER);
		 
		 pack();
		 setLocationRelativeTo(null);
		 setVisible(true);
	 } 
		 private class ButtonClickListener implements ActionListener {
			 public void actionPerformed(ActionEvent e) {
				 JButton source = (JButton) e.getSource();
				 String buttonText = source.getText();
				 
				 if (buttonText.equals("="))
				 {
					calculateResult();
			      }
				 else {
			    	 updateDisplay(buttonText); 
			      }
			 }
		 }
		  
		 private void updateDisplay(String text) 
		 {
			 String currentText = display.getText();
			 display.setText(currentText+text);
		 }
		 
			private void calculateResult() {
			try {
				String expression = display.getText();
				double result = evaluateExpression(expression);
				display.setText(Double.toString(result));
				}
			catch (Exception ex) 
			{
				display.setText("Error");	
				}
		 }	
			private double evaluateExpression(String expression)
			{
				return 0;
			 }

	public static void main(String[] args) {
	new Calculator();

	}

}
