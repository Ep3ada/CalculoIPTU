package unit.br.com.bandtec;

import static org.junit.Assert.*;
import br.com.bandtec.calculoiptu.utils.CalcularIptu;
import org.junit.Test;

public class CalculoIptuTest {

    /*@Test
    public void testeFaixa3() {
        CalcularIptu iptu = new CalcularIptu();

        double valor = 300000.0;
        double resultado = iptu.calcularPagaAVista("São Paulo", valor);
        double esperado = (valor * 0.011);
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);

        valor = 300001.0;
        resultado = iptu.calcularPagaAVista("São Paulo", valor);
        esperado = (valor * 0.011);
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 500000.0;
        resultado = iptu.calcularPagaAVista("São Paulo", valor);
        esperado = (valor * 0.011);
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 600000.0;
        resultado = iptu.calcularPagaAVista("São Paulo", valor);
        esperado = (valor * 0.011);
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 600001.0;
        resultado = iptu.calcularPagaAVista("São Paulo", valor);
        esperado = (valor * 0.011);
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);
    }

    @Test
    public void testeFaixa2() {
        CalcularIptu iptu = new CalcularIptu();

        double valor = 150000.0;
        double resultado = iptu.calcularPagaAVista("São Paulo", valor);
        double esperado = (valor * 0.009);
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);

        valor = 150001.0;
        resultado = iptu.calcularPagaAVista("São Paulo", valor);
        esperado = (valor * 0.009);
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 200000;
        resultado = iptu.calcularPagaAVista("São Paulo", valor);
        esperado = (valor * 0.009);
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 300000.0;
        resultado = iptu.calcularPagaAVista("São Paulo", valor);
        esperado = (valor * 0.009);
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 300001.0;
        resultado = iptu.calcularPagaAVista("São Paulo", valor);
        esperado = (valor * 0.009);
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);
    }

    @Test
    public void testeFaixa4() {
        CalcularIptu iptu = new CalcularIptu();

        double valor = 600000.0;
        double resultado = iptu.calcularPagaAVista("São Paulo", valor);
        double esperado = (valor * 0.013);
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);

        valor = 600001.0;
        resultado = iptu.calcularPagaAVista("São Paulo", valor);
        esperado = (valor * 0.013);
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);
    }

    @Test
    public void testeFaixa1() {
        CalcularIptu iptu = new CalcularIptu();

        double valor = 60000.0;
        double resultado = iptu.calcularPagaAVista("São Paulo", valor);
        double esperado = (valor * 0.0);
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 150000.0;
        resultado = iptu.calcularPagaAVista("São Paulo", valor);
        esperado = (valor * 0.0);
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 150001.0;
        resultado = iptu.calcularPagaAVista("São Paulo", valor);
        esperado = (valor * 0.0);
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarErroEmNumeroNegativo() {
        CalcularIptu iptu = new CalcularIptu();
        double valor = -100000.0;
        double resultado = iptu.calcularPagaAVista("São Paulo", valor);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testarErroEmNomeCidade() {
        CalcularIptu iptu = new CalcularIptu();
        double valor = 100000.0;
        double resultado = iptu.calcularPagaAVista("São P", valor);

    }*/
}
