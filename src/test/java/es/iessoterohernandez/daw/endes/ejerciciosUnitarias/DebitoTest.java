package es.iessoterohernandez.daw.endes.ejerciciosUnitarias;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DebitoTest {
	
	private Debito d;
	private Cuenta c;
	
	@BeforeEach
	void setUp() throws Exception {
		d = new Debito("A", "Titular", new Date());
		c = new Cuenta("A", "Titular");
		d.setCuenta(c);
	}

	@Test
	void testRetirar() throws Exception {
		d.mCuentaAsociada.ingresar(100);
		d.mCuentaAsociada.retirar(50);
	}

	@Test
	void testIngresar() throws Exception {
		d.mCuentaAsociada.ingresar(100);
	}

	@Test
	void testPagoEnEstablecimiento() throws Exception {
		d.mCuentaAsociada.ingresar(100);
		d.pagoEnEstablecimiento("Datos", 50);
	}

	@Test
	void testGetSaldo() {
		d.mCuentaAsociada.getSaldo();
	}

}
