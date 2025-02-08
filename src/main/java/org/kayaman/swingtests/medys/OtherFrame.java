package org.kayaman.swingtests.medys;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OtherFrame extends JFrame
{
	private JButton showButton, closeButton;
	
	private JPanel buttonPanel;
	
	public OtherFrame()
	{
		initFrame();
	}
	
	private void initFrame()
	{
		showButton = new JButton("Zeig MedysInfoDialog");
		showButton.addActionListener(listener -> new MedysInfoDialog().setInCenterOfParent(this));
		
		closeButton = new JButton("Schliessen");
		closeButton.addActionListener(listener -> System.exit(0));
		
		buttonPanel = new JPanel();
		buttonPanel.add(showButton);
		buttonPanel.add(closeButton);
		
		getContentPane().add(buttonPanel, BorderLayout.CENTER);
		
		setSize(800, 600);
		setTitle("Other Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		validate();
	}
}
