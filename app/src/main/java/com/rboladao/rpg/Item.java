package com.rboladao.rpg;

import com.rboladao.rpg.Personagem;

public class Item {

  public static int POCAO_VIDA = 0;
  public static int POCAO_MANA = 1;

  private String nome;
  private int vida, mana;
  public final int tipo;
  public int quantidade;

  public Item(int tipo, int quant) {
    this.tipo = tipo;
    switch (tipo) {
      case 0:
        nome = "Poção";
        vida = 10;
        mana = 0;
        break;
      case 1:
        nome = "Elixir";
        vida = 0;
        mana = 10;
        break;
      default:
        nome = "Pão";
        vida = 0;
        mana = 0;
    }
    quantidade = quant;
  }

  public boolean usa(Personagem per) {
    if (quantidade <= 0) return false;
    quantidade--;
    per.cura(vida, mana);
    return true;
  }

  public void mais(int quanto) {
    quantidade = quantidade + quanto;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    if (!(other instanceof Item)) return false;

    Item item = (Item) other;

    return tipo == item.tipo;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder(nome);
    builder.append("(").append(quantidade).append(")");
    builder.append(": ");
    builder.append(vida).append("hp ");
    builder.append(mana).append("mp\n");

    return builder.toString();
  }
}
