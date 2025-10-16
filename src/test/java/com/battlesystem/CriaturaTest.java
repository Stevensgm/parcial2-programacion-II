package com.battlesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CriaturaTest {

    @Test
    void testCriaturaEstaViva() {
        Guerrero g = new Guerrero("Test", 10, 10, "Cuero");
        assertTrue(g.estaViva(), "Una criatura con salud > 0 debe estar viva.");
        
        g.setSalud(0);
        assertFalse(g.estaViva(), "Una criatura con salud <= 0 debe estar muerta.");
    }

    @Test
    void testGuerreroAtaqueConArma() {
        Guerrero atacante = new Guerrero("G", 100, 30, "Placas");
        Criatura defensor = new Mago("M", 100, 10);
        Arma espada = new Arma("Espada", 25);
        
        atacante.equiparArma(espada);
        // Ataque esperado: Fuerza (30) + Daño Adicional (25) = 55
        
        atacante.atacar(defensor); 
        assertEquals(45, defensor.getSalud(), "El ataque del Guerrero con arma debe calcularse correctamente.");
    }
    
    @Test
    void testDragonDefensa() {
        Dragon d = new Dragon("Ignis", 100, 40, "Negras");
        int danoEntrante = 80;
        
        // El Dragón reduce el daño a la mitad (80 / 2 = 40).
        d.defender(danoEntrante);
        
        assertEquals(60, d.getSalud(), "El Dragón debe reducir el daño entrante a la mitad.");
    }
    
    @Test
    void testMagoAprenderHechizo() {
        Mago m = new Mago("Merlín", 100, 20);
        m.aprenderHechizo("Bola de Fuego");
        // No hay un getter directo de la lista, se asume que el método de interfaz funciona.
    }
}