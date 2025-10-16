package com.battlesystem;

public class Guerrero extends Criatura {
    private String tipoArmadura;

    public Guerrero(String nombre, int salud, int fuerza, String tipoArmadura) {
        super(nombre, salud, fuerza);
        this.tipoArmadura = tipoArmadura;
    }

    @Override
    public void atacar(Criatura objetivo) {
        if (!this.estaViva()) return;
        
        int danoTotal = this.fuerza;
        String armaNombre = "sus puños";

        if (this.armaEquipada != null) {
            danoTotal += this.armaEquipada.getDanoAdicional();
            armaNombre = this.armaEquipada.getNombre();
        }

        System.out.println(nombre + " golpea con " + armaNombre + " (Daño Total: " + danoTotal + ").");
        objetivo.defender(danoTotal);
    }

    @Override
    public void defender(int dano) {
        int reduccion = this.fuerza / 5; 
        int danoFinal = Math.max(1, dano - reduccion); 
        
        this.salud -= danoFinal;
        if (this.salud < 0) this.salud = 0;
        
        System.out.println(nombre + " se protege con " + tipoArmadura + ". Daño recibido: " + danoFinal + ". Salud: " + this.salud);
    }
}