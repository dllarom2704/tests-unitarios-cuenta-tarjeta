package es.iessoterohernandez.daw.endes.ejerciciosUnitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreditoTest {

	private Credito c;
	
	@BeforeEach
	void setUp() throws Exception {
		String numero = "A", titular = "Titular";
		c = new Credito(numero, titular, new Date(), 100);
		c.setCuenta(new Cuenta(numero, titular));
	}

	@Test
	void testRetirar() throws Exception {
		c.retirar(50);
		assertEquals((100 - 50 * 0.05 < 3.0 ? 3 : 50 * 0.05) + 0.5, c.getSaldo());
	}

	@Test
	void testIngresar() throws Exception {
		c.ingresar(50);
		assertEquals(50, c.getSaldo());
	}

	@Test
	void testPagoEnEstablecimiento() throws Exception {
		c.pagoEnEstablecimiento("Establecimiento", 50);
		assertEquals(50, c.getSaldo());
	}

	@Test
	void testGetSaldo() {
		assertEquals(0, c.getSaldo());
	}

	@Test
	void testGetCreditoDisponible() {
		assertEquals(100, c.getCreditoDisponible());
	}

	@Test
	void testLiquidar() throws Exception {
		c.ingresar(100);
		
		var d = new Date();
		c.liquidar(d.getMonth(), d.getYear());
		assertEquals(100, c.getSaldo());
	}

}
