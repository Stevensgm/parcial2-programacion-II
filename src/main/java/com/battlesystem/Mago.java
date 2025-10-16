package com.battlesystem;

import java.util.ArrayList;
import java.util.List;

public class Mago extends Criatura implements IMagico {
    private List<String> hechizosAprendidos;

    public Mago(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
        this.hechizosAprendidos = new ArrayList<>();
    }

    @Override
    public void aprenderHechizo(String hechizo) {
        hechizosAprendidos.add(hechizo);
        System.out.println(nombre + " ha aprendido: " + hechizo);
    }

    @Override
    public void lanzarHechizo(Criatura objetivo) {
        if (hechizosAprendidos.isEmpty()) {
            System.out.println(nombre + " no tiene hechizos para lanzar.");
            return;
        }
        
        int danoMagico = this.fuerza * 2; 
        
        System.out.println(nombre + " invoca " + hechizosAprendidos.get(0) + " a " + objetivo.getNombre() + ".");
        objetivo.defender(danoMagico);
    }

    @Override
    public void atacar(Criatura objetivo) {
        if (this.estaViva()) {
             lanzarHechizo(objetivo); 
        }
    }

    @Override
    public void defender(int dano) {
        this.salud -= dano;
        if (this.salud < 0) this.salud = 0;
        System.out.println(nombre + " intenta esquivar. Daño recibido: " + dano + ". Salud: " + this.salud);
    }
}