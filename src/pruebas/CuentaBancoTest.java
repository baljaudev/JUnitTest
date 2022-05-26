package pruebas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class CuentaBancoTest {

    CuentaBanco cuenta; // Instancia de la clase CuentaBanco para poder usar sus métodos y atributos

    @BeforeClass // Este método se ejecuta antes de TODAS las pruebas
    public static void inicioPruebas() {
        System.out.println("¡Iniciando las pruebas de clase!");
    }


    @AfterClass // Este método se ejecuta después de TODAS las pruebas
    public static void finPruebas() {
        System.out.println("Finalizando las pruebas de clase... ¡FIN!");
    }


    @Before // Este método se ejecuta antes de CADA prueba
    public void creaCuentaBanco() {
        cuenta=new CuentaBanco(1500,"abc123"); // Se crea una instancia de la clase CuentaBanco
        System.out.println("Probando método...");
    }


    @After // Este método se ejecuta después de CADA prueba
    public void borraCuentaBanco() {
        cuenta=null; // Se borra la instancia de la clase CuentaBanco para que no interfiera con las pruebas siguientes
        System.out.println("...Fin prueba de método");
    }


    @org.junit.Test // Este método es una prueba
    public void testIngresar() {
        //CuentaBanco cuenta=new CuentaBanco(1500,"abc123");
        int resultado=cuenta.ingresar(500);
        assertEquals("fallo al ingresar",2000,resultado);
    }

    @org.junit.Test
    public void testRetirar() {
        //CuentaBanco cuenta=new CuentaBanco(1500,"abc123");
        int resultado=cuenta.retirar(500,"abc123");
        assertEquals("fallo de prueba (retirar)",1000,resultado);
    }


    @org.junit.Test
    public void testPasswordCorrecta() {
        //CuentaBanco cuenta=new CuentaBanco(1500, "abc123");
        boolean resultado = cuenta.passwordCorrecta("abc123");
        assertTrue("No es true, contraseña errónea", resultado);

    }
}