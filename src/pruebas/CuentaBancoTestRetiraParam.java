package pruebas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CuentaBancoTestRetiraParam {

    private String passwordInicial;
    private String passwordPrueba;
    private int saldoInicial;
    private int cantidadRetirada;
    private int resultado;

    public CuentaBancoTestRetiraParam(String passwordInicial, String passwordPrueba,
                                      int saldoInicial, int cantidadRetirada, int resultado) {
        this.passwordInicial = passwordInicial;
        this.passwordPrueba = passwordPrueba;
        this.saldoInicial = saldoInicial;
        this.cantidadRetirada = cantidadRetirada;
        this.resultado = resultado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> datosRetirar() {
        return Arrays.asList(new Object[][] {
                { "pass123", "pass123", 1500, 500, 1000 }, //[passwordInicial, passwordPrueba, saldoInicial, cantidadRetirada, resultado]
                { "pass123", "pass123", 1500, 2000, -1 },
                { "pass123", "pass", 1500, 500, -2 }, //si la contraseña es errónea, retorna -2
                { "pass123", "pass", 1500, 2000, -2 }
        });
    }


    @Test
    public void retirar() {
        CuentaBanco cuenta2 = new CuentaBanco(saldoInicial, passwordInicial);
        int result = cuenta2.retirar(cantidadRetirada,passwordPrueba);
        assertEquals("Fallo al retirar",resultado, result);

    }
}