package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import main.Painel;

public class Mouse implements MouseListener, MouseMotionListener
{
	private Painel painel;
	public Mouse(Painel painel){
		this.painel = painel;
	}
	@Override
	public void mouseDragged(MouseEvent e)
	{
	}
	@Override
	public void mouseMoved(MouseEvent e)
	{
		painel.setRectPos(e.getX(), e.getY());
	}
	@Override
	public void mouseClicked(MouseEvent e)
	{
	}
	@Override
	public void mousePressed(MouseEvent e)
	{
	}
	@Override
	public void mouseReleased(MouseEvent e)
	{
	}
	@Override
	public void mouseEntered(MouseEvent e)
	{
	}
	@Override
	public void mouseExited(MouseEvent e)
	{
	}
}
