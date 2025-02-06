package src;

import javax.swing.JDialog;
import javax.swing.JRootPane;

public class UndecoratedDialog extends JDialog
{
	public UndecoratedDialog()
	{
		initDialog();
	}
	
	private void initDialog()
	{
		setTitle("undecorated Dialog");
		setSize(640, 480);
		setUndecorated(true);
		setVisible(true);
	}
}
