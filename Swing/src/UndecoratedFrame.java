import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UndecoratedFrame extends JFrame
{
	public UndecoratedFrame()
	{
		initFrame();
	}

	private void initFrame()
	{
		setTitle("Undecorated Frame");
		setUndecorated(true);
		setSize(640, 480);
		setVisible(true);
	}
}
