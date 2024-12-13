package main;
import java.util.Map;
import java.util.HashMap;

public class Jogo
{
	private Janela janela;
	public Jogo()
	{
		Painel painel = new Painel();
		Janela janela = new Janela(painel);
		painel.requestFocus();
	}
	public void printStatus(){
		if(janela != null){
			System.out.println("Janela de jogo criada");
		}
	}
}
