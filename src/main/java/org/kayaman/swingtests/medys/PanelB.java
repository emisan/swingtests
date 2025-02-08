package org.kayaman.swingtests.medys;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelB extends JPanel
{

private JButton processButton, cancelButton;
	
	private JLabel infoLabel;
	
	private JPanel buttonPanel;
	
	public PanelB()
	{
		infoLabel = new JLabel();
		infoLabel.setSize(300, 200);
		
		processButton = new JButton("Weiter");
		cancelButton = new JButton("Abbruch");
		
		processButton.addActionListener(listener -> infoLabel.setText(processButton.getText() + " gedrückt!"));
		
		cancelButton.addActionListener(listener -> infoLabel.setText(cancelButton.getText() + " gedrückt!"));
		
		buttonPanel = new JPanel();
		buttonPanel.add(processButton);
		buttonPanel.add(cancelButton);
		buttonPanel.getInsets().set(10, 5, 10, 5);
		
		setLayout(new BorderLayout());
		add(infoLabel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
	}
}
