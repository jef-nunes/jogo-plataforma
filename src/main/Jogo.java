package main;

public class Jogo implements Runnable
{
	private Janela janela;
	private Painel painel;
	private Thread threadJogo;
	private final int FPS_SET = 120;
	public Jogo()
	{
		this.painel = new Painel();
		this.janela = new Janela(painel);
		this.painel.requestFocus();
		this.startGameLoop();
	}
	@Override
	public void run()
	{
		double tempoPorFrame = 1000000000.0 / FPS_SET;
		long ultimoFrame = System.nanoTime();
		long agora = System.nanoTime();
		int frames = 0;
		long ultimoCheck = System.currentTimeMillis();
		while(true)
		{
			agora = System.nanoTime();
			if(agora - ultimoFrame >= tempoPorFrame)
			{
				this.painel.repaint();
				ultimoFrame = agora;
				frames++;
			}
			
			if(System.currentTimeMillis() - ultimoCheck >= 1000)
			{
				ultimoCheck = System.currentTimeMillis();
				System.out.println("FPS: "+frames);
				frames=0;
			}
		}
	}
	private void startGameLoop()
	{
		this.threadJogo = new Thread(this);
		this.threadJogo.start();
	}
	public void printStatus(){
		if(janela != null){
			System.out.println("Janela de jogo criada");
		}
	}
}
