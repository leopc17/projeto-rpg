package entities;

import java.util.Random;

public class Personagem {
	private String nome;
	private int vida;
	private int ataque;
	
	public Personagem(String nome, int vida, int ataque) {
		this.nome = nome;
		this.vida = vida;
		this.ataque = ataque;
	}
	
	public Personagem(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}
	
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	public boolean vivo() {
		if (vida > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void atacar(Personagem alvo) {
		Random random = new Random();
		int dano = random.nextInt(ataque);
		
		System.out.println(nome + " atacou " + alvo.nome + " e causou " + dano + " de dano.");
		
		alvo.vida -= dano;
		
		if(alvo.vida < 0) {
			alvo.vida = 0;
		}
		
		System.out.println(alvo.nome + " agora tem " + alvo.vida + " pontos de vida");
	}
	
	public boolean tentarFugir() {
		Random random = new Random();
		int n = random.nextInt(9);
		
		if (n <= 5) {
			return false;
		} else {
			return true;
		}
	}	
}