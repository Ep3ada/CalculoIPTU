package unit.br.com.bandtec;

import br.com.bandtec.calculoiptu.domain.Faixa;
import static org.junit.Assert.*;
import br.com.bandtec.calculoiptu.utils.CalcularIptu;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CalculoIptuTest {

    static List<Faixa> fxs = new ArrayList<Faixa>();
    static CalcularIptu iptu = new CalcularIptu();

    private void inicializar() {
        Faixa f = new Faixa();
        f.setLimiteInferior(0.0);
        f.setLimiteSuperior(150000.0);
        f.setPorcentagem(0.0);
        Faixa f2 = new Faixa();
        f2.setLimiteInferior(150001.0);
        f2.setLimiteSuperior(300000.0);
        f2.setPorcentagem(0.009);
        Faixa f3 = new Faixa();
        f3.setLimiteInferior(300001.0);
        f3.setLimiteSuperior(600000.0);
        f3.setPorcentagem(0.011);
        Faixa f4 = new Faixa();
        f4.setLimiteInferior(600001.0);
        f4.setLimiteSuperior(0.0);
        f4.setPorcentagem(0.013);
        fxs.add(f);
        fxs.add(f2);
        fxs.add(f3);
        fxs.add(f4);
    }

    @Test
    public void testeFaixa1() {
        inicializar();

        double valor = 60000.0;
        double resultado = iptu.calcularPagaAVista(valor, fxs);
        double esperado = (valor * fxs.get(0).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 150000.0;
        resultado = iptu.calcularPagaAVista(valor, fxs);
        esperado = (valor * fxs.get(0).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 150001.0;
        resultado = iptu.calcularPagaAVista(valor, fxs);
        esperado = (valor * fxs.get(0).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);
    }

    @Test
    public void testeFaixa2() {
        inicializar();
        double valor = 150000.0;
        double resultado = iptu.calcularPagaAVista(valor, fxs);
        double esperado = (valor * fxs.get(1).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);

        valor = 150001.0;
        resultado = iptu.calcularPagaAVista(valor, fxs);
        esperado = (valor * fxs.get(1).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 200000;
        resultado = iptu.calcularPagaAVista(valor, fxs);
        esperado = (valor * fxs.get(1).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 300000.0;
        resultado = iptu.calcularPagaAVista(valor, fxs);
        esperado = (valor * fxs.get(1).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 300001.0;
        resultado = iptu.calcularPagaAVista(valor, fxs);
        esperado = (valor * fxs.get(1).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);
    }

    @Test
    public void testeFaixa3() {
        inicializar();
        double valor = 300000.0;
        double resultado = iptu.calcularPagaAVista(valor, fxs);
        double esperado = (valor * fxs.get(2).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);

        valor = 300001.0;
        resultado = iptu.calcularPagaAVista(valor, fxs);
        esperado = (valor * fxs.get(2).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 500000.0;
        resultado = iptu.calcularPagaAVista(valor, fxs);
        esperado = (valor * fxs.get(2).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 600000.0;
        resultado = iptu.calcularPagaAVista(valor, fxs);
        esperado = (valor * fxs.get(2).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);

        valor = 600001.0;
        resultado = iptu.calcularPagaAVista(valor, fxs);
        esperado = (valor * fxs.get(2).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);
    }

    @Test
    public void testeFaixa4() {
        inicializar();
        double valor = 600000.0;
        double resultado = iptu.calcularPagaAVista(valor, fxs);
        double esperado = (valor * fxs.get(3).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertNotEquals(esperado, resultado, 0);

        valor = 600001.0;
        resultado = iptu.calcularPagaAVista(valor, fxs);
        esperado = (valor * fxs.get(3).getPorcentagem());
        esperado = esperado - (esperado * 0.15);
        assertEquals(esperado, resultado, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarErroEmNumeroNegativo() {
        CalcularIptu iptu = new CalcularIptu();
        Faixa f = new Faixa();
        f.setLimiteInferior(100000.0);
        f.setLimiteSuperior(300000.0);
        f.setPorcentagem(0.011);
        List<Faixa> fxs = new ArrayList<Faixa>();
        fxs.add(f);
        double valor = -100000.0;
        double resultado = iptu.calcularPagaAVista(valor, fxs);

    }
}
