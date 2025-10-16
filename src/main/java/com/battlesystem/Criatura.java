package com.battlesystem;

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
/// esto son los mretodos abstractos 
    public abstract void atacar(Criatura objetivo);
    public abstract void defender(int dano);

    public boolean estaViva() {
        return this.salud > 0;    /// PARA SABER SI ESTA VIVA
    }
/// METODOS PARA EQUIPAR Y DESEQUIPAR ARMAS
    public void equiparArma(Arma arma) {
        this.armaEquipada = arma;
    }

    public void desequiparArma() {
        this.armaEquipada = null;
    }

    // Getters y Setters 
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public void setSalud(int salud) { this.salud = salud; }
}