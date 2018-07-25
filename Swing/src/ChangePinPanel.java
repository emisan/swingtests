

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChangePinPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7706611514104837249L;

	private String pinEntry;
	
	private BorderLayout borderLayout;
	
	private Font infoFont;
	
	private JButton changePinButton, closeDialogButton;
	
	private JButton[] entryButtons;
	
	private JTextArea textArea;
	private JTextField txtfPinEntry;
	
	private JPanel entryButtonsPanel, controlButtonsPanel, buttonsPanel;

	public ChangePinPanel()
	{
		setBackground(Color.gray);
		initComponents();
	}

	private void initComponents()
	{		
		borderLayout = new BorderLayout();
		borderLayout.setHgap(10);
		borderLayout.setVgap(10);
		
		entryButtonsPanel = new JPanel();
		entryButtonsPanel.setLayout(new GridLayout(4, 3));
		
		entryButtons = new JButton[12];
		
		for(int i = 0; i < entryButtons.length; i++)
		{
			final int j = i; // notwendig: effectively final int, für den Lambda Ausdruck der ActionListener-Zuweisung !!
			
			if((i >= 0) && (i < 9)) // eingabezahlen 1-9
			{
				// leere Platzhalter schaffen um 0-Button
				entryButtons[i] = new JButton("" + (i+1));
				entryButtons[i].addActionListener(listener -> setPinEntry(entryButtons[j].getText()));
			}
			else if((i == 9) || (i == 11)) // platzhalter unten links und rechts
			{
				entryButtons[i] = new JButton("");
				entryButtons[i].setVisible(false);
			}
			else if(i == 10)
			{
				entryButtons[i] = new JButton("0");
				entryButtons[i].addActionListener(listener -> setPinEntry(entryButtons[j].getText()));
			}
			entryButtonsPanel.add(entryButtons[i]);
		}
		
		changePinButton = new JButton("Ändern");
		closeDialogButton = new JButton("Abbruch");
		
		changePinButton.addActionListener(listener -> System.out.println("neue Pin " + txtfPinEntry.getText()));
		closeDialogButton.addActionListener(listener -> System.exit(0));
		
		controlButtonsPanel = new JPanel();
		controlButtonsPanel.getInsets().set(10,  10, 10, 10);
		controlButtonsPanel.add(changePinButton);
		controlButtonsPanel.add(closeDialogButton);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(borderLayout);
		buttonsPanel.add(entryButtonsPanel, "North");
		buttonsPanel.add(controlButtonsPanel, "Center");
		
		infoFont = new Font("Arial", Font.BOLD, 16);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.gray);
		textArea.setForeground(Color.white);
		textArea.setFont(infoFont);
		textArea.setMargin(new java.awt.Insets(5, 5, 5, 5));
		
		txtfPinEntry = new JTextField(10);
		
		
		add(textArea, "North");
		add(txtfPinEntry, "Center");
		add(buttonsPanel, "South");
		
		validate();
	}
	
	private void setPinEntry(String zahl)
	{
		pinEntry = pinEntry + zahl;
		txtfPinEntry.setText(pinEntry);
		txtfPinEntry.repaint();
	}
	
	/**
	 * Legt die neue Information für den Informationsbereich fest und 
	 * f&uuml;hrt daraufhin ein &quot;repaint&quot; dieses Dialogfesnters durch, 
	 * um die neue Information anzuzeigen
	 * <p></p>
	 * @param infoText die neue Information
	 */
	public void setInfoText(String infoText) {
		textArea.setText(infoText);
		repaint();
	}
}
