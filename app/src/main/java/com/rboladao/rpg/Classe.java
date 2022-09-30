package com.rboladao.rpg;

public enum Classe {
  LUTADOR(50, 0, 10, 10),
  MAGO(30, 100, 8, 5),
  LADINO(30, 0, 12, 8);
  public final int vida, mana, ataque, defesa;

  private Classe(int vida, int mana, int ataque, int defesa) {
    this.vida = vida;
    this.mana = mana;
    this.ataque = ataque;
    this.defesa = defesa;
  }
}
