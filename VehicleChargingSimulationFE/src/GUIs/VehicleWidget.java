package GUIs;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Entities.Battery;
import Entities.Vehicle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VehicleWidget extends JPanel {

	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel arrivalLabel;
	private JTextField arrivalTextField;
	private JLabel departureLabel;
	private JTextField departureTextField;
	private JLabel capacityLabel;
	private JTextField capacityTextField;
	private JLabel chargePowerLabel;
	private JTextField chargePowerTextField;
	private JLabel SOCLabel;
	private JTextField SOCTextField;
	private JLabel desiredChargeLabel;
	private JTextField desiredChargeTextField;

	private GroupLayout gl_contentPane;
	
	public VehicleWidget() {
		
		nameLabel = new JLabel("Name");
		arrivalLabel = new JLabel("Arrival");
		departureLabel = new JLabel("Departure");
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		arrivalTextField = new JTextField();
		arrivalTextField.setToolTipText("Time in minutes since start of simulation");
		arrivalTextField.setColumns(10);
		departureTextField = new JTextField();
		departureTextField.setToolTipText("Time in minutes since start of simulation(if absent will set to integer maxvalue)");
		departureTextField.setColumns(10);
		capacityLabel = new JLabel("Capacity(kWh)");
		capacityTextField = new JTextField();
		capacityTextField.setColumns(10);
		chargePowerLabel = new JLabel("Charge Power(kW)");
		chargePowerTextField = new JTextField();
		chargePowerTextField.setColumns(10);
		SOCLabel = new JLabel("SOC(%)");
		SOCTextField = new JTextField();
		SOCTextField.setColumns(10);
		desiredChargeLabel = new JLabel("DesiredCharge(%)");
		desiredChargeTextField = new JTextField();
		desiredChargeTextField.setColumns(10);
		
		setLayout();
		
	}
	
	private void setLayout() {
		gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(capacityLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(capacityTextField, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
									.addGap(34)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(chargePowerTextField, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
										.addComponent(chargePowerLabel))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(SOCTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addComponent(SOCLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(desiredChargeLabel, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
										.addComponent(desiredChargeTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
									.addGap(93))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(5)
									.addComponent(arrivalTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(departureTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(arrivalLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(departureLabel, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameLabel)
						.addComponent(arrivalLabel)
						.addComponent(departureLabel))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(arrivalTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(departureTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chargePowerLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chargePowerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(capacityLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(capacityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(desiredChargeLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(desiredChargeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(SOCLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(SOCTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(45))
		);
			this.setLayout(gl_contentPane);
	}

	public void SetName(String name) {
		nameTextField.setText(name);
	}
	
	public void SetArrival(int arrival) {
		arrivalTextField.setText(Integer.toString(arrival));
	}
	
	public void SetDeparture(int departure) {
		departureTextField.setText(Integer.toString(departure));
	}
	
	public void SetCapacity(float capacity) {
		capacityTextField.setText(Float.toString(capacity));
	}
	
	public void SetSOC(float SOC) {
		SOCTextField.setText(Float.toString(SOC));
	}
	
	public void SetChargePower(float chargePower) {
		chargePowerTextField.setText(Float.toString(chargePower));
	}
	
	public void SetDesiredCharge(float desiredCharge) {
		desiredChargeTextField.setText(Float.toString(desiredCharge));
	}
	
	public Vehicle makeVehicle() {
		String departureString = departureTextField.getText();
		int departure = 0;
		if(departureString.isBlank()) departure = Integer.MAX_VALUE;
		else departure = Integer.parseInt(departureString);
		Vehicle vehicle =  new Vehicle(nameTextField.getText(),
				Integer.parseInt(arrivalTextField.getText()), departure,
				Float.parseFloat(desiredChargeTextField.getText()));
		vehicle.AddComponent("Battery", makeBattery());
		return vehicle;
	}
	
	private Battery makeBattery() {
		Battery battery = new Battery(Float.parseFloat(SOCTextField.getText()),
				Float.parseFloat(capacityTextField.getText()), Float.parseFloat(chargePowerTextField.getText()));
		return battery;
	}
}
