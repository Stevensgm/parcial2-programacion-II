package com.battlesystem;
// esta sera la clase abstracta profe, para guerrero y mago  y dragon 

public abstract class Criatura {
    protected String nombre;
    protected int salud;
    protected int fuerza;
    protected Arma armaEquipada;

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    public abstract void atacar(Criatura objetivo);
    public abstract void defender(int dano);

    public boolean estaViva() {
        return this.salud > 0;
    }

    public void equiparArma(Arma arma) {
        this.armaEquipada = arma;
    }

    public void desequiparArma() {
        this.armaEquipada = null;
    }

    // Getters y Setters mínimos
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public void setSalud(int salud) { this.salud = salud; }
}