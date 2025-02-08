package org.kayaman.swingtests.medys;
import javax.swing.JDialog;

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
