package frame;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpnnerChangeEventListener implements ChangeListener {

	static int  value ;
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		 JSpinner spinner = (JSpinner) e.getSource();

		    // Get the new value
		    value = (int)spinner.getValue();
		    App.spinnerVal=value;
		    
	}

}
