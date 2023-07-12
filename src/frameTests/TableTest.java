package frameTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;

import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Test;

import frame.App;
import frame.Tanulo;

class TableTest {

	@Test
	void rowCountAfterRemoveAllTest() {
		App app = new App();
		assertEquals(0, app.removeAllRows());
	}
	
	
	@Test
	void createStudentsTest() {
		App app = new App();
		assertEquals(6, app.createStudents());
	}
	
	
	
	@Test
	void existTableTest() {
		App app = new App();
		assertTrue(app.existTable());
		
	}
	
	
	@Test
	void existModelTableTest() {
		App app = new App();
		Tanulo tanulo = new Tanulo(1, "m", (byte)1, (byte)1);
		DefaultTableModel modelT = app.model;
		Object[] o = new Object[4];
		o[0] = tanulo.getName();
		o[1] = tanulo.getIrodalom();
		o[2] = tanulo.getMatek();
		o[3] = tanulo.getAzonosito();
		modelT.addRow(o);
		assertEquals(1, modelT.getRowCount());

	}
	
	
}
