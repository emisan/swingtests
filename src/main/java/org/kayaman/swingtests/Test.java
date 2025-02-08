package org.kayaman.swingtests;

import org.kayaman.swingtests.others.JListTest;

import javax.swing.SwingUtilities;

public class Test
{
	public static void main(String[] args)
	{

		SwingUtilities.invokeLater(JListTest::new);

//		SwingUtilities.invokeLater(() -> {
//			MedysInfoDialog infoDialog = new MedysInfoDialog();
//			infoDialog.setNextButtonVisible(true);
//			infoDialog.setVisible(true);
//		});

		// Undecorated test

//		SwingUtilities.invokeLater(new Runnable()
//				{
//					@Override
//					public void run()
//					{
//						new UndecoratedFrame();
//					}
//				});
		
//		SwingUtilities.invokeLater(new Runnable()
//		{
//			@Override
//			public void run()
//			{
//				new UndecoratedDialog();
//			}
//		});
	}
}
