package org.kayaman;

import org.kayaman.medys.MedysInfoDialog;

import javax.swing.SwingUtilities;

public class Test
{
	// Timer - Test
	
//	static int counter = 0;
//	
//	static final int getCounter()
//	{
//		return counter;
//	}
//	
//	static void setCounter(int count)
//	{
//		counter = count;
//	}
//	
	public static void main(String[] args)
	{
		// Undecorated test
//		SwingUtilities.invokeLater(() -> new UndecoratedFrame());

		SwingUtilities.invokeLater(() -> {
            MedysInfoDialog infoDialog = new MedysInfoDialog();
            infoDialog.setNextButtonVisible(true);
        });
	}
}
