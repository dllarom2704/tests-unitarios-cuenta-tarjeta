package es.iessoterohernandez.daw.endes.ejerciciosUnitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CuentaTest {
	private Cuenta c;
	
	@BeforeEach
	public void setUp() throws Exception {
		c = new Cuenta("A", "Titular");
	}

	@ParameterizedTest
	@CsvSource("100")
	public void testIngresarDouble(double x) throws Exception {
		c.ingresar(x);
		assertEquals(100, c.getSaldo());
	}

	@ParameterizedTest
	@CsvSource("100")
	public void testRetirarDouble(double x) throws Exception {
		c.ingresar(100);
		c.retirar(x);
		assertEquals(0, c.getSaldo());
	}

	@ParameterizedTest
	@CsvSource("Concepto 1, 100")
	public void testIngresarStringDouble(String concepto, double x) throws Exception {
		c.ingresar(concepto, x);
		
		var m = new Movimiento();
		m.setConcepto(concepto);
		assertEquals("Concepto 1", m.getConcepto());
		
		assertEquals(100, c.getSaldo());
	}

	@ParameterizedTest
	@CsvSource("Concepto 1, 100")
	public void testRetirarStringDouble(String concepto, double x) throws Exception {
		c.ingresar(x);
		c.retirar(concepto, x);
		
		var m = new Movimiento();
		assertEquals(null, m.getConcepto());
		
		assertEquals(0, c.getSaldo());
	}

	@Test
	public void testGetSaldo() {
		assertEquals(0, c.getSaldo());
	}

	@Test
	public void testAddMovimiento() {
		Vector v = new Vector();
		assertEquals(v, c.mMovimientos);
	}

}
