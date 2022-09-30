package com.rboladao.rpg;

import com.rboladao.rpg.Personagem;
import java.util.Scanner;

public class Main {

  private static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    Personagem nero = new Personagem(Classe.LUTADOR, "Nero", false);
    Personagem cesar = new Personagem(Classe.LADINO, "Caesar", true);

    nero.pega(new Item(Item.POCAO_VIDA, 5));

    luta(nero, cesar);
  }

  public static void luta(Personagem a, Personagem b) {
    System.out.println("Uma batalha começou!");
    System.out.println(a);
    System.out.println(b);

    while (a.isVivo() && b.isVivo()) {
      if (a.isAuto()) {
        a.atacar(b);
        System.out.println(a.nome() + " atacou " + b.nome() + "!");
      } else {
        int opcao = menuLuta();
        switch (opcao) {
          case 1:
            a.atacar(b);
            System.out.println(a.nome() + " atacou " + b.nome() + "!");
            break;
          case 2:
            System.out.println("Você fugiu!");
            return;
          case 3:
            int item = menuItem(a);
            if (!a.usa(item)) {
              System.out.println("Item inválido.");
              continue;
            }
            System.out.println(a.nome() + " usou um item");
        }
      }
      System.out.println(b);

      Personagem temp = a;
      a = b;
      b = temp;
    }

    if (a.isVivo()) {
      System.out.println(a.nome() + " ganhou!");
    } else {
      System.out.println(b.nome() + " ganhou!");
    }
  }

  public static int menuLuta() {
    System.out.print("1) lutar\n2) fugir\n3) usa item\n>> ");

    return scan.nextInt();
  }

  public static int menuItem(Personagem p) {
    System.out.println(p.mostraInventario());
    System.out.print(">> ");
    return scan.nextInt();
  }
}
