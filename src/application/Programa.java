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
			boss.setVida(100);
			boss.setAtaque(12);
		} else if (dificuldade == 3) {
			boss.setVida(150);
			boss.setAtaque(15);
		}
		
		while (player.vivo() && boss.vivo()) {
			System.out.println("Escolha uma ação:\n1. Ataque básico\n2. Tentar fugir\n");
			int escolha = sc.nextInt();
			
			if (escolha == 1) {
				player.atacar(boss);
                if (boss.vivo()) {
                    boss.atacar(player);
                }
			} else if (escolha == 2) {
				fugir = player.tentarFugir();
				
				if (fugir) {
					System.out.println("Você fugiu.");
					break;
				} else {
					System.out.println("Você tentou fugir e falhou.");
					boss.atacar(player);
				}
			}
			
		}
		
		if (player.vivo() && fugir == false) {
			System.out.println("Mensagem de vitória");
		} else if (fugir == false){
			System.out.println("Mensagem de derrota");
		}
		
		sc.close();
	}

}
