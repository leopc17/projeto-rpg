package application;

import java.util.Scanner;

import entities.Personagem;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Personagem player = new Personagem("Player", 100, 10);
		Personagem boss = new Personagem("Boss");
		
		int dificuldade;
		boolean fugir = false;
		
		System.out.println("Escolha a dificuldade do jogo:\n1. Fácil\n2. Médio\n3. Difícil\n");
		dificuldade = sc.nextInt();
		
		if (dificuldade == 1) {
			boss.setVida(50);
			boss.setAtaque(8);
		} else if (dificuldade == 2) {
			boss.setVida(80);
			boss.setAtaque(12);
		} else if (dificuldade == 3) {
			boss.setVida(120);
			boss.setAtaque(13);
		}
		
		while (player.vivo() && boss.vivo() && fugir == false) {
			System.out.println("Escolha uma ação:\n1. Ataque básico\n2. Tentar fugir\n");
			int escolha = sc.nextInt();
			
			switch (escolha) {
				case 1:
					player.atacar(boss);
					
	                if (boss.vivo()) {
	                    boss.atacar(player);
	                }
	                break;
	                
				case 2:
					fugir = player.tentarFugir();
					
					if (fugir) {
						System.out.println("Você fugiu.");
					} else {
						System.out.println("Você tentou fugir e falhou.");
						boss.atacar(player);
					}
					break;
				default:
					System.out.println("Erro, tente novamente.");
			}
			
		}
		
		System.out.println();
		
		if (player.vivo() && fugir == false) {
			System.out.println("Você venceu. Parabéns!");
		} else if (fugir == false){
			System.out.println("Você perdeu. Tente outra vez.");
		}
		
		sc.close();
	}

}
