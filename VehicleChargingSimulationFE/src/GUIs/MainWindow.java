package GUIs;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private ArrayList<StationWidget> stationWidgets = new ArrayList<>();
	private JButton addVehicleButton;
	private JButton importButton;
	private JButton exportButton;
	private JButton runButton;
	private JTabbedPane stationsTabbedPane;
	private JComboBox<String> strategyDropPanel;
	private JButton addStationButton;
	private GroupLayout gl_contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		addVehicleButton = new JButton("Add Vehicle");
		
		importButton = new JButton("Import");
		
		exportButton = new JButton("Export");
		
		runButton = new JButton("Run");
		
		stationsTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		strategyDropPanel = new JComboBox<String>();
		strategyDropPanel.setModel(new DefaultComboBoxModel<String>(new String[] {"FCFS", "EDF", "RR"}));
		
		addStationButton = new JButton("Add Station");
		gl_contentPane = new GroupLayout(contentPane);
		setMainLayout();
		
		addStation(stationsTabbedPane);
		
		contentPane.setLayout(gl_contentPane);
		
		addVehicleButton.addActionListener(e-> {
			int selectedIndex = stationsTabbedPane.getSelectedIndex();
            if (selectedIndex != -1) {
            	addVehicle((JPanel) ((JScrollPane) stationsTabbedPane.getComponentAt(selectedIndex)).getViewport().getView());
            }
		});
		
		addStationButton.addActionListener(e -> {
        	addStation(stationsTabbedPane);
        });
		
		importButton.addActionListener(e->{
			importFromJSON();
		});
		
		exportButton.addActionListener(e->{
			exportToJSON();
		});
		
		runButton.addActionListener(e->{
			runSimulation();
		});
		
		setContentPane(contentPane);
	}
	
	private void addStation(JTabbedPane tabbedPane) {
		JScrollPane station = new StationWidget();
		stationWidgets.add((StationWidget) station);
    	tabbedPane.addTab("Station " + (tabbedPane.getTabCount() + 1), station);
	}
	
	private void addVehicle(JPanel tabPanel) {
        JPanel widgetPanel = new VehicleWidget();
        ((StationWidget)(stationsTabbedPane.getComponentAt(stationsTabbedPane.getSelectedIndex()))).add(widgetPanel);
        tabPanel.add(widgetPanel);
        tabPanel.revalidate();
        tabPanel.repaint();
	}

	private void importFromJSON() {
		
	}
	
	private void exportToJSON() {
		
	}
	
	private void runSimulation() {
		ProcessBuilder pb = new ProcessBuilder();
		File pythonScriptsDir = new File("D:/VehicleChargingSimulation/VehicleChargingSimulationScripts");
		pb.directory(pythonScriptsDir);
		pb.command("py", "hello.py");
		try {
			String fileName = "ChargingSim"+ Calendar.getInstance().getTimeInMillis();
			pb.redirectOutput(new File("D:/VehicleChargingSimulation/VehicleChargingSimulationScripts/"+fileName+".txt"));
			//pb.redirectOutput(new File("D:/VehicleChargingSimulation/VehicleChargingSimulationScripts/tets.txt"));

			pb.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setMainLayout() {
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(stationsTabbedPane, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(exportButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(runButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(importButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(strategyDropPanel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(6)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(addStationButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addComponent(addVehicleButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
						.addGap(121))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(37)
								.addComponent(addStationButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(addVehicleButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addGap(23)
								.addComponent(strategyDropPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(importButton)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(exportButton)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(runButton))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(stationsTabbedPane, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
	}
}

