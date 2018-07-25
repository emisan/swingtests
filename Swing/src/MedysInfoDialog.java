


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;


public class MedysInfoDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Component komponenteImZentrum;
	
	private final String MEDYS_ICON_NAME = "Logo.png";
	
	private static final String MEDYS_VSDM_NAME = "MEDYS Versichertenstammdaten-Management (VSDM)";
	
	// GUI-Komponenten
	//
	private Font infoFont;
	private JButton closeButton, nextButton, showNextButton, hideNextButton;
	private JComboBox<String> changePanelChoice;
	private JLabel labelForImage;
	private JPanel mainPanel, logoPanel, buttonPanel;
	private JTextArea textArea;
	private JScrollPane scrollPanel;
	
	private ImageIcon corporateImage;
	private TitledBorder textPanelBorder;
	
	private PanelA panelA;
	private PanelB panelB;
	private ChangePinPanel pinEingabePanel;
	
	private Map<String, JComponent> changeAblePanels;
	
	/**
	 * Erstell eine neue Instanz dieser Klasse
	 */
	public MedysInfoDialog() {
		
		initDialog(WindowConstants.EXIT_ON_CLOSE);
	}
	
//	public MedysInfoDialog(int defaultCloseOperation)
//	{
//		initDialog(defaultCloseOperation);
//	}
	
	private void initDialog(int closeOperation)
	{	
		initDialogConstraints(closeOperation);
		initComponents();
		setVisible(true);
	}
	
	/*
	 * Eigenschaften dieses Fensters festlegen
	 */
	private void initDialogConstraints(int closeOperation) {
		
		setSize(640, 480);
		setTitle(MedysInfoDialog.MEDYS_VSDM_NAME);
		
		System.out.println("Close-Operation = " + closeOperation);
		
		if((closeOperation >= 0) && (closeOperation < 3))
		{
			setDefaultCloseOperation(closeOperation);
		}
		else
		{
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
		setLocationRelativeTo(null);
	}
	
	private void initComponents()
	{
		/* prepare warn-icon image to be displayed in sunDisclaimerPanel */
		corporateImage = new ImageIcon(getClass().getClassLoader().getResource(MEDYS_ICON_NAME));
		labelForImage = new JLabel();
		labelForImage.setIcon(corporateImage);
		
		logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.add(labelForImage);
		
		closeButton = new JButton("Schliessen");
		closeButton.addActionListener(listener -> {
			int closeOperation = getDefaultCloseOperation();
			switch(closeOperation)
			{
				case 0: //DO NOTHING ON CLOSE
					break;
				case 1: // HIDE ON CLOSE
					setVisible(false);
					break;
				case 2: //DISPOSE ON CLOSE
					dispose();
					break;
				case 3: // EXIT ON CLOSE
					System.exit(0);
					break;
			}
		});
		
		nextButton = new JButton("Weiter");
		nextButton.setVisible(false);
		
		showNextButton = new JButton("Zeig Weiter");
		showNextButton.addActionListener(listener -> {
			nextButton.setVisible(true);
		});
		
		hideNextButton = new JButton("Verstecke Weiter");
		hideNextButton.addActionListener(listener -> {
			nextButton.setVisible(false);
		});
		
		infoFont = new Font("Arial", Font.BOLD, 16);
		
		textPanelBorder = new TitledBorder("INFO");
		textPanelBorder.setTitleFont(infoFont);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(infoFont);
		textArea.setMargin(new Insets(5, 10, 10, 5));
		
		scrollPanel = new JScrollPane(textArea);
		scrollPanel.setPreferredSize(new Dimension(this.getWidth()-20, 400));
		scrollPanel.setBorder(textPanelBorder);
		
		komponenteImZentrum = scrollPanel;
		
		panelA = new PanelA();
		panelB = new PanelB();
		pinEingabePanel = new ChangePinPanel();
		
		changeAblePanels = new HashMap<String, JComponent>();
		changeAblePanels.put("Panel B", panelB);
		changeAblePanels.put("Panel A", panelA);
		changeAblePanels.put("Pin-Eingabe", pinEingabePanel);
		changeAblePanels.put("Standard", scrollPanel);
		
		changePanelChoice = new JComboBox<String>();
		
		for(String key : changeAblePanels.keySet())
		{
			changePanelChoice.addItem(key);
		}
		
		changePanelChoice.addActionListener(listener -> {
			
			Component austauschKomponente = changeAblePanels.get(changePanelChoice.getItemAt(changePanelChoice.getSelectedIndex()).toString());
			
			changeComponentOfPanelWith(mainPanel, komponenteImZentrum, austauschKomponente, BorderLayout.CENTER);
			komponenteImZentrum = austauschKomponente;
			validate();
		});
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.gray);
		buttonPanel.add(changePanelChoice);
		buttonPanel.add(nextButton);
		buttonPanel.add(showNextButton);
		buttonPanel.add(hideNextButton);
		buttonPanel.add(closeButton);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(logoPanel, BorderLayout.NORTH);
		mainPanel.add(scrollPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		getContentPane().add(mainPanel);
		
		validate();
	}
	
	public void changeMainPanelTo(JPanel anotherPanel)
	{
		if(anotherPanel != null)
		{
			getContentPane().remove(mainPanel);
			repaint();
			mainPanel = anotherPanel;
			getContentPane().add(mainPanel);
			validate();
		}
	}
	
	/**
	 * Wechselt eine vorhandene UI-Komponente <code>toChange</code> mit einer Neuen <code>withComponent</code> in einem 
	 * JPanel <code>panel</code> aus.<br><br>
	 * 
	 * Der Parameter <code>layoutOrientation</code> mu&szlig; eine Orientierungsangabe des {@link BorderLayout}-Managers
	 * sein und das JPanel mu&szlig; diesen LayoutManager vorher gesetzt haben!<br><br>
	 * 
	 * <u>Rahmenbedingungen</u>
	 * <blockquote>
	 *  es wird keine Ersetzung durchgef&uuml;hrt, wenn..<br><br>
	 * 	<ul>
	 * 		<li>der LayoutManager des JPanel <i>nicht das BorderLayout</i> ist</li>
	 * 		<li>an der angegebenen <code>layoutOrientation</code> die Komponente <code>toChange</code> nicht existiert</li>
	 *  </ul>
	 * </blockquote>
	 * 
	 * @param panel das JPanel, das die <code>toChange</code>-Komponente in seinem RootPane beinhaltet
	 * @param toChange die Komponente, die ersetzt werden soll
	 * @param withComponent die Komponente, die die neue Komponente an der Orientierungsangabe ist
	 * @param layoutOrientation die Orientierungsangabe des BorderLayout des <code>panel</code> an der sich die Komponente
	 * 			<code>toChange</code> befindet
	 * @return die Komponente welche die alte ersetzt hat, sonst NULL
	 */
	public void changeComponentOfPanelWith(JPanel panel, Component oldComponent, Component newComponent, String layoutOrientation)
	{
		if (panel != null)
		{
			if ((panel.getLayout() instanceof BorderLayout) && istOrientierungVonBorderLayout(layoutOrientation))
			{
				if ((oldComponent != null) && (newComponent != null))
				{
					panel.remove(oldComponent);
					panel.repaint();
					panel.add(newComponent, layoutOrientation);
					oldComponent = newComponent;
				}
			}
		}
	}
	/*
	 * Helper für changeComponentOfPanelWith
	 */
	private boolean istOrientierungVonBorderLayout(String orientierungsAngabe)
	{
		return orientierungsAngabe != null
				? 
				orientierungsAngabe.equals(BorderLayout.AFTER_LAST_LINE) || orientierungsAngabe.equals(BorderLayout.AFTER_LINE_ENDS)
				|| orientierungsAngabe.equals(BorderLayout.BEFORE_FIRST_LINE) || orientierungsAngabe.equals(BorderLayout.BEFORE_LINE_BEGINS)
				|| orientierungsAngabe.equals(BorderLayout.CENTER) || orientierungsAngabe.equals(BorderLayout.EAST)
				|| orientierungsAngabe.equals(BorderLayout.LINE_END) || orientierungsAngabe.equals(BorderLayout.LINE_START)
				|| orientierungsAngabe.equals(BorderLayout.NORTH) || orientierungsAngabe.equals(BorderLayout.PAGE_END)
				|| orientierungsAngabe.equals(BorderLayout.PAGE_START) || orientierungsAngabe.equals(BorderLayout.SOUTH)
				|| orientierungsAngabe.equals(BorderLayout.WEST)
				: false;
	}
	
	public void changeDefaultCloseOperation(WindowConstants constant)
	{
		if(constant != null)
		{
			if(!constant.toString().equals(String.valueOf(WindowConstants.EXIT_ON_CLOSE)))
			{
				setDefaultCloseOperation(new Integer(constant.toString()));
			}
		}
	}
	
	/**
	 * Platziert diesen Dialog im Zentrum der Hauptanwendung, egal
	 * wo sich die Hauptanwendung am Bildschirm befindet
	 * <p></p>
	 * @param parent die Hauptanwendung aus der dieser Dialog aufgerufen wird
	 */
	public void setInCenterOfParent(JFrame parent) {
		
		int xPosMid = (int)parent.getLocationOnScreen().getX();
		int yPosMid = (int)parent.getLocationOnScreen().getY();
		setLocation(xPosMid + (parent.getWidth()/2 - this.getWidth()/2), 
				yPosMid + (parent.getHeight()/2 - this.getHeight()/2));
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
	
	/**
	 * Gibt den aktuellen Inhalt des TextArea-Bereichs zur&uuml;ck;
	 * 
	 * @return der aktuell angezeigte InfoText
	 */
	public String getInfoText()
	{
		return textArea.getText();
	}
	
	/**
	 * Zeigt das Level der Meldung im TitleBorder des Informationsausgabebereichs
	 * an.<br><br>
	 * 
	 * Ist der Parameter &quot;level&quot; <code>NULL</code>-wertig, so wird 
	 * als <i>Fallback</i> der Wert <i>Level.INFO</i> angegeben.
	 * 
	 * @param level ein Wert aus {@link Level}
	 */
	public void setLevel(Level level)
	{
		if(level != null)
		{
			textPanelBorder.setTitle(level.getName());
		}
		else
		{
			textPanelBorder.setTitle(Level.INFO.getName());
		}
		repaint();
	}
	
	public void setNextButtonVisible(boolean status)
	{
		nextButton.setVisible(status);
	}
}
