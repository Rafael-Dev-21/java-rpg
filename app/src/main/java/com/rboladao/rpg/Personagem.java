package com.rboladao.rpg;

import java.util.LinkedList;
import java.util.List;

public class Personagem {

  private String nome;

  private int vida, mana;
  private int ataque, defesa;

  private Classe classe;

  private boolean auto;

  private List<Item> inventario;

  public Personagem(Classe classe, String nome, boolean auto) {
    this.nome = nome;
    this.vida = classe.vida;
    this.mana = classe.mana;
    this.ataque = classe.ataque;
    this.defesa = classe.defesa;
    this.classe = classe;
    this.auto = auto;

    inventario = new LinkedList<>();
  }

  public void atacar(Personagem alvo) {
    int dano = ataque + (int) (ataque * Math.random());
    dano = dano / 2 - alvo.defesa / 4;
    alvo.levaDano(dano);
  }

  public void levaDano(int dano) {
    vida = vida - dano;
  }

  public void cura(int vida, int mana) {
    this.vida = this.vida + vida;
    this.mana = this.mana + mana;
  }

  public void pega(Item item) {
    if (inventario.contains(item)) inventario.get(item.tipo).mais(item.quantidade);
    else inventario.add(item.tipo, item);
  }

  public boolean usa(int tipo) {
    return inventario.get(tipo).usa(this);
  }

  public String mostraInventario() {
    StringBuilder builder = new StringBuilder();
    builder.append("================\n");
    builder.append("Inventário do ").append(nome).append("\n");
    builder.append("----------------\n");
    for (Item item : inventario) {
      builder.append("- ").append(item.tipo).append(") ").append(item.toString());
    }
    builder.append("================\n");

    return builder.toString();
  }

  public boolean isVivo() {
    return vida > 0;
  }

  public boolean isAuto() {
    return auto;
  }

  public String nome() {
    return nome;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("================\n");
    builder.append(nome).append("\n");
    builder.append("----------------\n");
    builder.append("vida: ").append(vida).append("\n");
    builder.append("mana: ").append(mana).append("\n");
    builder.append("ataque: ").append(ataque).append("\n");
    builder.append("defesa: ").append(defesa).append("\n");
    builder.append("================\n");

    return builder.toString();
  }
}
