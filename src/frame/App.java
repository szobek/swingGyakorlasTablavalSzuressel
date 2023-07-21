package frame;

import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Arrays;
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
import java.awt.Color;

public class App {
	//private static int spinnerVal;
	private JFrame frame;
	List<Tanulo> tanulok = new ArrayList<Tanulo>();
	private JTable table;
	String[][] data;
	public DefaultTableModel model;
	private JScrollPane scrollPane;
	LayoutManager layoutManager;

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
		layoutManager = null;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(layoutManager);
		frame.setTitle("Tanulók");
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 11, 381, 208);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setSelectionForeground(new Color(0, 102, 102));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(new Color(0, 204, 255));
		table.setToolTipText("Tanulók");

		String[] columnNames = { "Tanuló neve", "Irodalom", "Matek", "Azonosító" };
		model = new DefaultTableModel();
		table.setModel(model);

		ListSelectionModel select = table.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting() && table.getSelectedRow()  !=-1 ) {
						
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
		//getAllData();
		getRowsByFilter(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		scrollPane.setViewportView(table);

		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				getRowsByFilter((int) spinner.getValue());

			}
		});

		spinner.setBounds(160, 230, 69, 20);
		frame.getContentPane().add(spinner);

		JLabel lblNewLabel = new JLabel("Irodalom");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(93, 230, 74, 14);
		frame.getContentPane().add(lblNewLabel);

	}

	public Tanulo serchUserByID(int ID, List<Tanulo> tanulok) {
		return tanulok.stream().filter(x -> x.getAzonosito() == ID).findFirst().orElse(null);
	}

	public int createStudents() {
		Tanulo[] tanuloArray = { new Tanulo(1, "Kis Pista", (byte) 2, (byte) 2),
				new Tanulo(2, "Nagy Elek", (byte) 3, (byte) 2), new Tanulo(3, "Horváth Béla", (byte) 4, (byte) 2),
				new Tanulo(4, "John Doe", (byte) 41, (byte) 2), new Tanulo(5, "Kovács Fruzsina", (byte) 3, (byte) 2),
				new Tanulo(6, "Cserepes Virág", (byte) 5, (byte) 2) };
		tanulok = Arrays.asList(tanuloArray);
		return tanuloArray.length;
	}


	public int removeAllRows() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		int rowCount = dm.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			dm.removeRow(i);
		}
		return dm.getRowCount();
	}

	private void getRowsByFilter(int value) {
		removeAllRows();
		for (Tanulo tanulo : tanulok) {
			if (tanulo.getIrodalom() >= value) {
				createRow(tanulo);
			}

		}

	}
	
	private void createRow(Tanulo tanulo) {
		String[] o = new String[4];
		o[0] = tanulo.getName();
		o[1] = String.valueOf(tanulo.getIrodalom()) ;
		o[2] = String.valueOf(tanulo.getMatek());
		o[3] = String.valueOf(tanulo.getAzonosito());
		model.addRow(o);
	}

	// to test

	public String getFrameTitle() {
		return frame.getTitle();
	}

	public Rectangle getFrameBound() {
		return frame.getBounds();

	}

	public int getCloseOperation() {
		return frame.getDefaultCloseOperation();
	}

	public String getFrameLayout() {
		LayoutManager layout = frame.getContentPane().getLayout();
		if (layout == null) {
			return "null";
		} else {
			return layout.toString();
		}
	}

	public boolean existTable() {
		return table.getParent().equals(scrollPane.getViewport());
	}

}
