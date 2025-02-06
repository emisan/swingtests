package src;


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


	private static final String MEDYS_VSDM_NAME = "MEDYS Versichertenstammdaten-Management (VSDM)";

    private JButton nextButton;

    private JPanel mainPanel;
    private JTextArea textArea;

    private TitledBorder textPanelBorder;


	/**
	 * Erstell eine neue Instanz dieser Klasse
	 */
	public MedysInfoDialog() {
		initDialog();
	}
	
//	public MedysInfoDialog(int defaultCloseOperation)
//	{
//		initDialog(defaultCloseOperation);
//	}
	
	private void initDialog()
	{	
		initDialogConstraints();
		initComponents();
	}
	
	/*
	 * Eigenschaften dieses Fensters festlegen
	 */
	private void initDialogConstraints() {
		
		setSize(640, 480);
		setTitle(MedysInfoDialog.MEDYS_VSDM_NAME);
		setVisible(true);
		
//		System.out.println("Close-Operation = " + WindowConstants.EXIT_ON_CLOSE);
//
//		if((WindowConstants.EXIT_ON_CLOSE >= 0) && (WindowConstants.EXIT_ON_CLOSE < 3))
//		{
//			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		}
//		else
//		{
//			setDefaultCloseOperation(EXIT_ON_CLOSE);
//		}
	}
	
	private void initComponents()
	{
        Map<String, JComponent> changeAblePanels;
        JComboBox<String> changePanelChoice;
		final Component[] komponenteImZentrum = new Component[1];
        ImageIcon corporateImage = new ImageIcon(getClass().getClassLoader().getResource("Logo.png"));
        JLabel labelForImage = new JLabel();
		labelForImage.setIcon(corporateImage);

        JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.add(labelForImage);

        JButton closeButton = new JButton("Schliessen");
//		closeButton.addActionListener(listener -> {
//			int closeOperation = getDefaultCloseOperation();
//			switch(closeOperation)
//			{
//				case 0: //DO NOTHING ON CLOSE
//					break;
//				case 1: // HIDE ON CLOSE
//					setVisible(false);
//					break;
//				case 2: //DISPOSE ON CLOSE
//					dispose();
//					break;
//				case 3: // EXIT ON CLOSE
//					System.exit(0);
//					break;
//			}
//		});
		
		nextButton = new JButton("Weiter");
		nextButton.setVisible(false);

        JButton showNextButton = new JButton("Zeig Weiter");
		showNextButton.addActionListener(listener -> nextButton.setVisible(true));

        JButton hideNextButton = new JButton("Verstecke Weiter");
		hideNextButton.addActionListener(listener -> nextButton.setVisible(false));

        // GUI-Komponenten
        //
        Font infoFont = new Font("Arial", Font.BOLD, 16);
		
		textPanelBorder = new TitledBorder("INFO");
		textPanelBorder.setTitleFont(infoFont);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(infoFont);
		textArea.setMargin(new Insets(5, 10, 10, 5));

        JScrollPane scrollPanel = new JScrollPane(textArea);
		scrollPanel.setPreferredSize(new Dimension(this.getWidth()-20, 400));
		scrollPanel.setBorder(textPanelBorder);
		
		komponenteImZentrum[0] = scrollPanel;

        PanelA panelA = new PanelA();
        PanelB panelB = new PanelB();
        ChangePinPanel pinEingabePanel = new ChangePinPanel();
		
		changeAblePanels = new HashMap<>();
		changeAblePanels.put("Panel B", panelB);
		changeAblePanels.put("Panel A", panelA);
		changeAblePanels.put("Pin-Eingabe", pinEingabePanel);
		changeAblePanels.put("Standard", scrollPanel);
		
		changePanelChoice = new JComboBox<>();
		
		for(String key : changeAblePanels.keySet())
		{
			changePanelChoice.addItem(key);
		}
		
		changePanelChoice.addActionListener(listener -> {
			
			Component austauschKomponente = changeAblePanels.get(changePanelChoice.getItemAt(changePanelChoice.getSelectedIndex()));
			
			changeComponentOfPanelWith(mainPanel, komponenteImZentrum[0], austauschKomponente, BorderLayout.CENTER);
			komponenteImZentrum[0] = austauschKomponente;
			validate();
		});

        JPanel buttonPanel = new JPanel();
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
		setLocationRelativeTo(null);
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
	 * @param oldComponent die Komponente, die ersetzt werden soll
	 * @param newComponent die Komponente, die die neue Komponente an der Orientierungsangabe ist
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
				}
			}
		}
	}
	/*
	 * Helper für changeComponentOfPanelWith
	 */
	private boolean istOrientierungVonBorderLayout(String orientierungsAngabe)
	{
		return orientierungsAngabe != null && (orientierungsAngabe.equals(BorderLayout.BEFORE_LINE_BEGINS)
                || orientierungsAngabe.equals(BorderLayout.CENTER)
                || orientierungsAngabe.equals(BorderLayout.EAST)
                || orientierungsAngabe.equals(BorderLayout.LINE_END)
                || orientierungsAngabe.equals(BorderLayout.NORTH)
                || orientierungsAngabe.equals(BorderLayout.PAGE_END)
                || orientierungsAngabe.equals(BorderLayout.PAGE_START)
                || orientierungsAngabe.equals(BorderLayout.SOUTH)
                || orientierungsAngabe.equals(BorderLayout.WEST));
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
