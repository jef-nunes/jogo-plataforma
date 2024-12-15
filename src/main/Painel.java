package main;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import inputs.Mouse;
import inputs.Teclado;

public class Painel extends JPanel
{
	private Color color = new Color(150,20,90);
	private Mouse mouse;
	private float deltaX = 100f;
	private float deltaY = 100f;
	private float dirX = 0.003f;
	private float dirY = 0.003f;
	private int frames = 0;
	private long lastCheck = 0;
	private Random random;
	public Painel()
	{
		random = new Random();
		mouse = new Mouse(this);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		addKeyListener(new Teclado(this));
	}
	public void updateDeltaX(int value)
	{
		this.deltaX += value;
	}
	public void updateDeltaY(int value)
	{
		this.deltaY += value;
	}
	public void setRectPos(int x, int y)
	{
		this.deltaX = x;
		this.deltaY = y;
	}
	public void paintComponent(Graphics g)
	{
		updateRectangle();
		g.setColor(this.color);
		super.paintComponent(g);
		g.fillRect((int)this.deltaX, (int)this.deltaY, 50, 50);
	}
	private void updateRectangle()
	{
		this.deltaX += dirX;
		if(deltaX >= 325 || deltaX <= 0){
			dirX *= -1;
			this.color = getRectColor();
		}
		this.deltaY += dirY;
		if(deltaY >= 325 || deltaY <= 0){
			dirY *= -1;
			this.color = getRectColor();
		}
	}
	private Color getRectColor()
	{
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		return new Color(r,g,b);
	}
}
