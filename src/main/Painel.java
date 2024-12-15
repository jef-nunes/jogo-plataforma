package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.Mouse;
import inputs.Teclado;
import static utils.Constants.JogadorConst.*;
import static utils.Constants.Direcoes.*;

public class Painel extends JPanel
{
	private final Color azulCeu = new Color(71, 210, 252);
	private final Color verdeGrama = new Color(82, 196, 96);
	private final Color marromTerra = new Color(171, 104, 55);
	
	private BufferedImage[] jogadorIdleAnim;
	private BufferedImage[] jogadorJumpAnim;
	private BufferedImage[] jogadorRunAnim;
	
	private boolean jogadorMoveBool = false;
	private int jogadorAto = IDLE;
	private int jogadorDirecao = -1;
	
	private int animTick;
	private int animIndex;
	private int animSpeed = 30;
	
	private Mouse mouse;
	private float cursorX;
	private float cursorY;
	private float deltaX = 100f;
	private float deltaY = 100f;

	public Painel()
	{
		this.loadRecursos();
		this.mouse = new Mouse(this);
		this.setDimPainel();
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		this.addKeyListener(new Teclado(this));
	}

	private void loadRecursos()
	{
		this.jogadorIdleAnim = new BufferedImage[4];
		this.jogadorIdleAnim[0] = this.importarImagem("/player-idle-1.png");
		this.jogadorIdleAnim[1] = this.importarImagem("/player-idle-2.png");
		this.jogadorIdleAnim[2] = this.importarImagem("/player-idle-3.png");
		this.jogadorIdleAnim[3] = this.importarImagem("/player-idle-4.png");
		
		this.jogadorJumpAnim = new BufferedImage[2];
		this.jogadorJumpAnim[0] = this.importarImagem("/player-jump-1.png");
		this.jogadorJumpAnim[1] = this.importarImagem("/player-jump-2.png");
		
		this.jogadorRunAnim = new BufferedImage[5];
		this.jogadorRunAnim[0] = this.importarImagem("/player-run-1.png");
		this.jogadorRunAnim[1] = this.importarImagem("/player-run-2.png");
		this.jogadorRunAnim[2] = this.importarImagem("/player-run-3.png");
		this.jogadorRunAnim[3] = this.importarImagem("/player-run-4.png");
		this.jogadorRunAnim[4] = this.importarImagem("/player-run-5.png");
	}
	
	private BufferedImage importarImagem(String pathImagem)
	{
		BufferedImage img;
		InputStream is = getClass().getResourceAsStream(pathImagem);
		try
		{
			img = ImageIO.read(is);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			img = null;
		}
		finally
		{
			try
			{
				is.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return img;
	}
	private void setDimPainel()
	{
		Dimension dim = new Dimension(1280,800);
		this.setMinimumSize(dim);
		this.setPreferredSize(dim);
		this.setMaximumSize(dim);
	}
	
	public void moverJogador(int direcao)
	{
		this.jogadorDirecao = direcao;
		this.jogadorMoveBool = true;
	}
	
	public void setJogadorMoveBool(boolean valor)
	{
		this.jogadorMoveBool = valor;
	}
	
	public void setCursorPos(int x, int y)
	{
		this.cursorX = x;
		this.cursorY = y;
	}
	public void fixRectPos()
	{
		if(this.deltaX > 300)
		{
			this.deltaX = 300;
		}
		else if(this.deltaX < 0)
		{
			this.deltaX = 0;
		}
		
		if(this.deltaY > 230)
		{
			this.deltaY = 230;
		}
		else if(this.deltaY < 0)
		{
			this.deltaY = 0;
		}
	}
	
	private BufferedImage getJogadorSpriteAtual() {
	    switch(this.jogadorAto) {
	    	// adicionada lógica para garantir que o índice
	    	// não ultrapasse o limite do array
	        case IDLE:
	            return this.jogadorIdleAnim[Math.min(this.animIndex, this.jogadorIdleAnim.length - 1)];
	        case RUNNING:
	            return this.jogadorRunAnim[Math.min(this.animIndex, this.jogadorRunAnim.length - 1)];
	        case JUMPING:
	            return this.jogadorJumpAnim[Math.min(this.animIndex, this.jogadorJumpAnim.length - 1)];
	        default:
	            return this.jogadorIdleAnim[0];
	    }
	}
	
	public void updateJogadorAnim()
	{
		if(this.jogadorMoveBool)
		{
			this.jogadorAto = RUNNING;
		}
		else
		{
			this.jogadorAto = IDLE;
		}
		
		this.animTick++;
		if(animTick >= animSpeed)
		{
			animTick = 0;
			animIndex++;
			if(animIndex >= GetQuantSprites(jogadorAto))
			{
				animIndex = 0;
			}
		}
	}
	
	public void updateJogadorPos()
	{
		if(this.jogadorMoveBool)
		{
			switch(this.jogadorDirecao)
			{
				case LEFT:
					deltaX-=5;
					break;
				case UP:
					deltaY-=5;
					break;
				case RIGHT:
					deltaX+=5;
					break;
				case DOWN:
					deltaY+=5;
					break;
			}
		}
	}
	
	public void printCoordenadas()
	{
		System.out.println("X:"+this.deltaX);
		System.out.println("Y:"+this.deltaY);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// ceu
		g.setColor(this.azulCeu);
		g.fillRect(0, 0, 400, 400);
		// grama
		g.setColor(this.verdeGrama);
		g.fillRect(0, 275, 400, 25);
		// terra
		g.setColor(this.marromTerra);
		g.fillRect(0, 300, 400, 100);
		
		// personagem
		this.updateJogadorAnim();
		this.updateJogadorPos();
		g.drawImage(this.getJogadorSpriteAtual(), (int)deltaX, (int)deltaY, 100, 100, null);
		
		// cursor
		g.setColor(Color.white);
		g.fillRect((int)this.cursorX, (int)this.cursorY, 25, 25);
	}
}