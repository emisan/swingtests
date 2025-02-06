package org.kayaman.medys;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelA extends JPanel
{
	private final JButton okButton;
    private final JButton cancelButton;
	
	private final JLabel infoLabel;

    public PanelA()
	{
		infoLabel = new JLabel();
		infoLabel.setSize(300, 200);
		
		okButton = new JButton("Ok");
		cancelButton = new JButton("Abbruch");
		
		okButton.addActionListener(listener -> infoLabel.setText(okButton.getText() + " gedrückt!"));
		
		cancelButton.addActionListener(listener -> infoLabel.setText(cancelButton.getText() + " gedrückt!"));

        JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		buttonPanel.getInsets().set(10, 5, 10, 5);
		
		setLayout(new BorderLayout());
		add(infoLabel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
	}
}
