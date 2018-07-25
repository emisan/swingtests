import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

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
//		ActionListener actl = new ActionListener()
//		{
//			
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
//				setCounter(getCounter() + 1);
//			}
//		};
//		
//		MedysInfoDialog infoDialog = new MedysInfoDialog();
//		infoDialog.setNextButtonVisible(true);
//		infoDialog.setVisible(true);
		
		// Undecorated test
		
		SwingUtilities.invokeLater(new Runnable()
				{
					@Override
					public void run()
					{
						new UndecoratedFrame();
					}
				});
		
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
