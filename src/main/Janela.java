package main;
import javax.swing.JFrame;

public class Janela
{
	private JFrame jframe;
	private int largura = 400;
	private int altura = 400;
	public Janela(Painel painel)
	{
		jframe = new JFrame();
		jframe.setSize(largura,altura);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(painel);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
}
