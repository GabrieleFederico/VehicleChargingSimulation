package GUIs;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;

import Entities.Station;


public class StationWidget extends JScrollPane {

	public JPanel panel;
	private ArrayList<VehicleWidget> vehicleWidgets = new ArrayList<>();
	public StationDetailsWidget stationDetails = new StationDetailsWidget();
	
	public StationWidget() {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	this.setViewportView(panel);;
    	this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    	panel.add(stationDetails);
    	panel.add(new JSeparator());
	}
	
	public void AddVehicleWidget(VehicleWidget vehicleWidget) {
		panel.add(vehicleWidget);
		vehicleWidgets.add(vehicleWidget);
		panel.add(new JSeparator());
	}
	
	public ArrayList<VehicleWidget> GetVehicleWidgets() {
		return vehicleWidgets;
	}

	public Station makeStation() {
		return stationDetails.makeStation();
	}

}
