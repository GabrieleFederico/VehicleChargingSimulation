package GUIs;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import Controllers.Message;
import Entities.Battery;
import Entities.Scenario;
import Entities.Station;
import Entities.Vehicle;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFileChooser;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private ArrayList<StationWidget> stationWidgets = new ArrayList<>();
	private JButton importButton;
	private JButton exportButton;
	private JButton runButton;
	private JTabbedPane stationsTabbedPane;
	private JButton addVehicleButton;
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

		addStationButton = new JButton("Add Station");
		gl_contentPane = new GroupLayout(contentPane);
		setMainLayout();

		addStation(stationsTabbedPane);

		contentPane.setLayout(gl_contentPane);

		addVehicleButton.addActionListener(e -> {
			int selectedIndex = stationsTabbedPane.getSelectedIndex();
			if (selectedIndex != -1) {
				addVehicle((JScrollPane) stationsTabbedPane.getComponentAt(selectedIndex));
			}
		});

		addStationButton.addActionListener(e -> {
			addStation(stationsTabbedPane);
		});

		importButton.addActionListener(e -> {
			importFromJSON();
		});

		exportButton.addActionListener(e -> {
			try {
				exportToJSON();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		runButton.addActionListener(e -> {
			try {
				runSimulation();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		setContentPane(contentPane);
	}

	private JScrollPane addStation(JTabbedPane tabbedPane) {
		JScrollPane station = new StationWidget();
		stationWidgets.add((StationWidget) station);
		tabbedPane.addTab("Station " + (tabbedPane.getTabCount() + 1), station);
		return station;
	}

	private JPanel addVehicle(JScrollPane tabPanel) {
		JPanel widgetPanel = new VehicleWidget();
		((StationWidget) (tabPanel)).AddVehicleWidget((VehicleWidget)widgetPanel);
		tabPanel.revalidate();
		tabPanel.repaint();
		return widgetPanel;
	}

	private void importFromJSON() {
		
		JFileChooser jfc = new JFileChooser();
	    jfc.showDialog(null,"Please Select the File");
	    jfc.setVisible(true);
	    File filename = jfc.getSelectedFile();
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode scenarioNode = om.readTree(filename);
			Scenario scenario = new Scenario();
			scenario.SetName(scenarioNode.get("scenario_name").textValue());
			JsonNode stationsNode = scenarioNode.get("stations");
			JsonNodeType stationsNodeType = stationsNode.getNodeType();
			if(stationsNodeType == JsonNodeType.ARRAY) {
				for(JsonNode stationNode : stationsNode) {
					Station station = new Station();
					station.SetName(stationNode.get("station_name").textValue());
					station.SetStrategy(stationNode.get("strategy").textValue());
					station.SetMaximumChargingVehicles(stationNode.get("max_vehicles").asInt());
					JsonNode vehiclesNode = stationNode.get("vehicles");
					JsonNodeType vehiclesNodeType = vehiclesNode.getNodeType();
					if(vehiclesNodeType == JsonNodeType.ARRAY) {
						for(JsonNode vehicleNode : vehiclesNode) {
							Vehicle vehicle = new Vehicle();
							vehicle.SetName(vehicleNode.get("vehicle_name").textValue());
							vehicle.SetArrival(vehicleNode.get("arrival").asInt());
							vehicle.SetDeparture(vehicleNode.get("departure").asInt());
							vehicle.SetDesiredCharge(vehicleNode.get("desired_charge").asInt());
							JsonNode vehicleComponentsNode = vehicleNode.get("vehicle_components");
							JsonNodeType vehicleComponentsNodeType = vehicleComponentsNode.getNodeType();
							if(vehicleComponentsNodeType == JsonNodeType.ARRAY) {
								for(JsonNode vehicleComponentNode : vehicleComponentsNode) {
									Battery component = new Battery();
									component.SetCapacity(vehicleComponentNode.get("capacity").floatValue());
									component.SetChargePower(vehicleComponentNode.get("charge_power").floatValue());
									component.SetSOC(vehicleComponentNode.get("state_of_charge").asInt());
									vehicle.AddComponent(component.GetName(), component);
								}
							}
							station.AddVehicle(vehicle);
						}
					}
					JsonNode stationsComponentsNode = stationNode.get("station_components");
					JsonNodeType stationComponentsNodeType = stationsComponentsNode.getNodeType();
					if(stationComponentsNodeType == JsonNodeType.ARRAY) {
						for(JsonNode stationsComponentNode : stationsComponentsNode) {
							Battery component = new Battery();
							component.SetCapacity(stationsComponentNode.get("capacity").floatValue());
							component.SetChargePower(stationsComponentNode.get("charge_power").floatValue());
							component.SetSOC(stationsComponentNode.get("state_of_charge").asInt());
							station.AddComponent(component.GetName(), component);
						}
					}
					scenario.AddStation(station);
				}
			}
			makeUi(scenario);
			revalidate();
			repaint();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void makeUi(Scenario scenario) {
		ArrayList<Station> stations = scenario.GetStations();
		stationsTabbedPane.removeAll();
		for(int i = 0; i < stations.size(); i++) {
			StationWidget addedWidget;
			addedWidget = (StationWidget) addStation(stationsTabbedPane);
			StationDetailsWidget stationDetails = addedWidget.stationDetails;
			stationDetails.SetCapacity(
					((Battery)stations.get(i).GetComponents().get("Battery")).GetCapacity());
			stationDetails.SetChargePower(
					((Battery)stations.get(i).GetComponents().get("Battery")).GetChargePower());
			stationDetails.SetSOC(
					((Battery)stations.get(i).GetComponents().get("Battery")).GetSOC());
			stationDetails.SetName(stations.get(i).GetName());
			stationDetails.SetStrategy(stations.get(i).GetStrategy());
			stationDetails.SetMaxVehicles(stations.get(i).GetMaximumChargingVehicles());
			
			for(Vehicle vehicle : stations.get(i).GetVehicles()) {
				VehicleWidget vehicleWidget = (VehicleWidget) addVehicle((JScrollPane) stationsTabbedPane.getComponentAt(i));
				vehicleWidget.SetName(vehicle.GetName());
				vehicleWidget.SetArrival(vehicle.GetArrival());
				vehicleWidget.SetDeparture(vehicle.GetDeparture());
				vehicleWidget.SetCapacity(
						((Battery)vehicle.GetComponents().get("Battery")).GetCapacity());
				vehicleWidget.SetSOC(
						((Battery)vehicle.GetComponents().get("Battery")).GetSOC());
				vehicleWidget.SetChargePower(
						((Battery)vehicle.GetComponents().get("Battery")).GetChargePower());
				vehicleWidget.SetDesiredCharge(vehicle.GetDesiredCharge());
			}
		}
		
	}

	private void exportToJSON() throws IOException {
		Message message = new Message(Message.Operation.EXPORT, parseScenario());
		ProcessBuilder pb = new ProcessBuilder();
		File pythonScriptsDir = new File("../VehicleChargingSimulationScripts");
		pb.directory(pythonScriptsDir);
		pb.command("py", "main.py", message.toString());
		String fileName = "ChargingSim" + Calendar.getInstance().getTimeInMillis();
		pb.redirectOutput(new File("../Out/" + fileName + ".txt"));
		pb.redirectError(new File("../Err/" + fileName + ".txt"));
		pb.start();
	}

	private void runSimulation() throws IOException {
		Message message = new Message(Message.Operation.RUN, parseScenario());
		ProcessBuilder pb = new ProcessBuilder();
		File pythonScriptsDir = new File("../VehicleChargingSimulationScripts");
		pb.directory(pythonScriptsDir);
		pb.command("py", "main.py", message.toString());
		String fileName = "ChargingSim" + Calendar.getInstance().getTimeInMillis();
		pb.redirectOutput(new File("../Out/" + fileName + ".txt"));
		pb.redirectError(new File("../Err/" + fileName + ".txt"));
		pb.start();
		
	}

	private Scenario parseScenario() {
		Scenario scenario = new Scenario();
		for(int i = 0; i < stationsTabbedPane.getTabCount(); i++) {
			StationWidget stationWidget = ((StationWidget) (stationsTabbedPane.getComponentAt(i)));
			Station station = stationWidget.makeStation();
			for(VehicleWidget vehicleWidget : stationWidget.GetVehicleWidgets()) {
				station.AddVehicle(vehicleWidget.makeVehicle());
			}
			scenario.AddStation(station);
		}
		return scenario;
	}

	private void setMainLayout() {
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(stationsTabbedPane, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(exportButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(runButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(importButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(6)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(addStationButton, GroupLayout.PREFERRED_SIZE, 105,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(addVehicleButton, GroupLayout.PREFERRED_SIZE, 105,
												GroupLayout.PREFERRED_SIZE))))
				.addGap(121)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(37)
						.addComponent(addStationButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(addVehicleButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGap(23)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(importButton)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(exportButton)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(runButton))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(
								stationsTabbedPane, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}
}
