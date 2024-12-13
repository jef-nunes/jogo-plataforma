package inputs;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.Painel;

public class Teclado implements KeyListener
{
	private Painel painel;
	public Teclado(Painel painel)
	{
		this.painel = painel;
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_W:
				painel.updateDeltaY(-5);
				break;
				
			case KeyEvent.VK_A:
				painel.updateDeltaX(-5);
				break;
				
			case KeyEvent.VK_S:
				painel.updateDeltaY(+5);
				break;
				
			case KeyEvent.VK_D:
				painel.updateDeltaX(+5);
				break;
		}
	}
}

