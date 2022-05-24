package pruebas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CuentaBancoTestIngresaParam {

    private String passwordInicial;
    private int saldoInicial;
    private int cantidadDepositada;
    private int resultado;


    public CuentaBancoTestIngresaParam(String passwordInicial, int saldoInicial,
                                       int cantidadDepositada, int resultado) {
        this.passwordInicial = passwordInicial;
        this.saldoInicial = saldoInicial;
        this.cantidadDepositada = cantidadDepositada;
        this.resultado = resultado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> datosIngresar() {
        return Arrays.asList(new Object[][] {
                { "pass123", 1500, 500, 2000 }, //[passwordInicial, saldoInicial, cantidadDepositada, resultado]
                { "pass123", 1500, 2000, 3500 },
                { "pass", 1500, 500, 2000 },
                { "pass", 1500, 2000, 3500 },
                { "pass123", 1500, 0, -1 }, //si da error es -1 según el método
                { "pass123", 1500, -500, -1 }
        });
    }

    @Test
    public void ingresar() {
        CuentaBanco cuenta = new CuentaBanco(saldoInicial, passwordInicial);
        int result=cuenta.ingresar(cantidadDepositada);
        assertEquals("fallo al ingresar", resultado, result);
    }
}