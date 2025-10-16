package com.battlesystem;

public class SimulacionBatalla {

    public static void simularBatalla(Criatura c1, Criatura c2) {
        System.out.println("\n==================================");
        System.out.println("INICIO DE LA BATALLA");
        System.out.println(c1.getNombre() + " vs " + c2.getNombre());
        System.out.println("==================================");

        int turno = 1;
        Criatura atacante = c1;
        Criatura defensor = c2;

        while (c1.estaViva() && c2.estaViva()) {
            System.out.println("\n--- Turno " + turno + " ---");
            
            if (atacante instanceof IVolador) {
                ((IVolador) atacante).volar(); 
            }
            if (atacante instanceof IMagico && turno == 1) {
                ((IMagico) atacante).aprenderHechizo("Rayo Arcano"); 
            }

            atacante.atacar(defensor);

            Criatura temp = atacante;
            atacante = defensor;
            defensor = temp;
            turno++;
        }

        System.out.println("\n==================================");
        if (c1.estaViva()) {
            System.out.println("GANADOR: " + c1.getNombre() + " (Salud restante: " + c1.getSalud() + ")");
        } else if (c2.estaViva()) {
            System.out.println("GANADOR: " + c2.getNombre() + " (Salud restante: " + c2.getSalud() + ")");
        } else {
            System.out.println("EMPATE: Doble KO.");
        }
    }

    public static void main(String[] args) {
        Arma espadaMaestra = new Arma("Espada Maestra", 25);
        Arma baculoMagico = new Arma("Báculo Arcano", 10);
        Arma lanzaDragon = new Arma("Lanza de Obsidiana", 45);

        Criatura guerrero = new Guerrero("Leónidas", 120, 30, "Placas de Acero");
        Criatura mago = new Mago("Merlín", 80, 20);
        Criatura dragon = new Dragon("Ignis", 150, 40, "Negras");

        guerrero.equiparArma(espadaMaestra);
        mago.equiparArma(baculoMagico);
        dragon.equiparArma(lanzaDragon);

        simularBatalla(guerrero, dragon);
    }
}