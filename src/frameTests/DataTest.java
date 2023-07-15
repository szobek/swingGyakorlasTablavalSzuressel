package frameTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import frame.App;
import frame.Tanulo;

class DataTest {

	@Test
	void searchByIDtest() {
		List<Tanulo> tanulok= new ArrayList<Tanulo>();
		tanulok.add(new Tanulo(2, "Nagy Elek", (byte) 3, (byte) 2));
		tanulok.add(new Tanulo(11, "Kis Elek", (byte) 3, (byte) 2));
		App app =new App();
		assertEquals(app.serchUserByID(2,tanulok), tanulok.get(0));
	}
	
	
	@Test
	void searchByIDFalsetest() {
		List<Tanulo> tanulok= new ArrayList<Tanulo>();
		tanulok.add(new Tanulo(2, "Nagy Elek", (byte) 3, (byte) 2));
		tanulok.add(new Tanulo(11, "Kis Elek", (byte) 3, (byte) 2));
		App app =new App();
		assertEquals(app.serchUserByID(1022,tanulok), null);
	}
	
	

}
