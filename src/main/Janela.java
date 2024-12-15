package main;
import javax.swing.JFrame;

public class Janela
{
	private JFrame jframe;
	private int largura = 400;
	private int altura = 400;
	public Janela(Painel painel)
	{
		this.jframe = new JFrame();
		//this.jframe.setSize(largura,altura);
		this.jframe.setResizable(false);
		this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jframe.add(painel);
		this.jframe.setLocationRelativeTo(null);
		this.jframe.pack();
		this.jframe.setVisible(true);
	}
}
