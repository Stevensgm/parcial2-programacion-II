package com.battlesystem;

public class Dragon extends Criatura implements IVolador {
    private String nombreEscamas;

    public Dragon(String nombre, int salud, int fuerza, String nombreEscamas) {
        super(nombre, salud, fuerza);
        this.nombreEscamas = nombreEscamas;
    }

    @Override
    public void volar() {
        System.out.println(nombre + " despega con sus alas.");
    }

    @Override
    public void aterrizar() {
        System.out.println(nombre + " aterriza pesadamente.");
    }
/// esta es la logica para atacar y defender del dragon
    @Override
    public void atacar(Criatura objetivo) {
        if (!this.estaViva()) return;
        
        int danoBase = this.fuerza * 2; 
        int danoTotal = danoBase;
        
        if (this.armaEquipada != null) {
            danoTotal += this.armaEquipada.getDanoAdicional(); 
            System.out.println(nombre + " escupe fuego y usa su " + this.armaEquipada.getNombre() + " (Daño total: " + danoTotal + ")");
        } else {
             System.out.println(nombre + " muerde ferozmente (Daño: " + danoTotal + ")");
        }

        objetivo.defender(danoTotal);
    }
/// defensa del drake 
    @Override
    public void defender(int dano) {
        int danoReducido = dano / 2;
        this.salud -= danoReducido;
        if (this.salud < 0) this.salud = 0;
        
        System.out.println(nombre + " usa sus escamas (" + nombreEscamas + "). Daño recibido: " + danoReducido + ". Salud: " + this.salud);
    }
}