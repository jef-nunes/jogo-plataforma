package main;
import java.awt.Graphics;
import javax.swing.JPanel;
import inputs.Mouse;
import inputs.Teclado;

public class Painel extends JPanel
{
	private Mouse mouse;
	private int deltaX = 0;
	private int deltaY = 0;
	public Painel()
	{
		mouse = new Mouse(this);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		addKeyListener(new Teclado(this));
	}
	public void updateDeltaX(int value)
	{
		this.deltaX += value;
		repaint();
	}
	public void updateDeltaY(int value)
	{
		this.deltaY += value;
		repaint();
	}
	public void setRectPos(int x, int y)
	{
		this.deltaX = x;
		this.deltaY = y;
		repaint();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillRect(this.deltaX, this.deltaY, 50, 50);
		
	}
}
