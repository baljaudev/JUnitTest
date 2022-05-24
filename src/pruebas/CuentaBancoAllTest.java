package pruebas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class) // Anotación para indicar que la clase es una Suite de pruebas
@Suite.SuiteClasses({ CuentaBancoTestRetiraParam.class, CuentaBancoTestIngresaParam.class, CuentaBancoTest.class }) // Anotación para indicar que las clases que contiene son las que se van a ejecutar

public class CuentaBancoAllTest {
}