package frame;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class App {
public static int spinnerVal;
	private JFrame frame;
	List<Tanulo> tanulok = new ArrayList<Tanulo>();
	private JTable table;
	String[][] data;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		createStudents();

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
frame.setTitle("Tanulók");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 11, 381, 208);
		frame.getContentPane().add(scrollPane);

		table = new JTable();

		String[] columnNames = { "Tanuló neve", "Irodalom", "Matek", "Azonosító" };
		model = new DefaultTableModel();
		table.setModel(model);

		ListSelectionModel select = table.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {
					StringBuilder row = new StringBuilder();
					row.append(table.getModel().getValueAt(table.getSelectedRow(), 0).toString() + " irodalom: ");
					row.append(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
					row.append(" matek: ");
					row.append(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
					JOptionPane.showMessageDialog(frame, row, "adatok", JOptionPane.PLAIN_MESSAGE, null);
				}
			}
		});

		model.setColumnIdentifiers(columnNames);
		getAllData();
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		scrollPane.setViewportView(table);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				getRowsByFilter((int)spinner.getValue());
				
			}
		});
		

		spinner.setBounds(160, 230, 69, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel = new JLabel("Irodalom");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(93, 230, 74, 14);
		frame.getContentPane().add(lblNewLabel);

	}

	public int createStudents() {
		Tanulo[] tanuloArray = {
		new Tanulo(1, "Kis Pista", (byte) 2, (byte) 2),
		new Tanulo(2, "Nagy Elek", (byte) 3, (byte) 2),
		new Tanulo(3, "Horváth Béla", (byte) 4, (byte) 2),
		new Tanulo(4, "John Doe", (byte) 41, (byte) 2),
		new Tanulo(5, "Kovács Fruzsina", (byte) 3, (byte) 2),
		new Tanulo(6, "Cserepes Virág", (byte) 5, (byte) 2)
		};
		return tanuloArray.length;
	}

	private void getAllData() {
		removeAllRows();
		for (Tanulo tanulo : tanulok) {
			if (tanulo.getIrodalom() > 0) {
				Object[] o = new Object[4];
				o[0] = tanulo.getName();
				o[1] = tanulo.getIrodalom();
				o[2] = tanulo.getMatek();
				o[3] = tanulo.getAzonosito();
				model.addRow(o);
			}

		}
	}

	public int removeAllRows() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		int rowCount = dm.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			dm.removeRow(i);
		}
		return dm.getRowCount();
	}
	
	public void getRowsByFilter(int value) {
		removeAllRows();
		for (Tanulo tanulo : tanulok) {
			if (tanulo.getIrodalom() >= value) {
				Object[] o = new Object[4];
				o[0] = tanulo.getName();
				o[1] = tanulo.getIrodalom();
				o[2] = tanulo.getMatek();
				o[3] = tanulo.getAzonosito();
				model.addRow(o);
			}

		}
		
	}
	
	public String getFrameTitle() {
		return frame.getTitle();
	}
	
	public Rectangle getFrameBound() {
		return frame.getBounds();
		
	}
	
	public int getFraneCloseOperation() {
		return frame.getDefaultCloseOperation();
	}
}
