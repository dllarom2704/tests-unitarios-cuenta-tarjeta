package es.iessoterohernandez.daw.endes.ejerciciosUnitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {
	private Movimiento m;
	
	@BeforeEach
	public void setUp() {
		m = new Movimiento();
	}
	
	@Test
	void testGetImporte() {
		assertEquals(0, m.mImporte);
	}

	@Test
	void testGetConcepto() {
		assertEquals(null, m.mConcepto);
	}

	@Test
	void testSetConcepto() {
		assertEquals(null, m.mConcepto);
	}

	@Test
	void testGetFecha() {
		var d = new Date();
		assertEquals(d, m.mFecha);
		
	}

	@Test
	void testSetFecha() {
		var d = new Date();
		assertEquals(d, m.getFecha());
	}

	@Test
	void testSetImporte() {
		assertEquals(0, m.mImporte);
	}

}
