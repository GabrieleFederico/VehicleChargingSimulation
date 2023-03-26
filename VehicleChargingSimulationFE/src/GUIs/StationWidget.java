package GUIs;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Entities.Vehicle;

public class StationWidget extends JScrollPane {

	private JPanel panel;
	private ArrayList<VehicleWidget> vehicleWidgets;
	
	/**
	 * Create the panel.
	 */
	public StationWidget() {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	this.setViewportView(panel);;
    	this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	public void AddVehicleWidget(VehicleWidget vehicleWidget) {
		vehicleWidgets.add(vehicleWidget);
	}

}
