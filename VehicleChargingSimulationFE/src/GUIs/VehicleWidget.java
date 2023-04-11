package GUIs;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Entities.Battery;
import Entities.Vehicle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
	
	/**
	 * Create the frame.
	 */
	public VehicleWidget() {
		
		nameLabel = new JLabel("Name");
		arrivalLabel = new JLabel("Arrival");
		departureLabel = new JLabel("Departure");
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		arrivalTextField = new JTextField();
		arrivalTextField.setColumns(10);
		departureTextField = new JTextField();
		departureTextField.setColumns(10);
		capacityLabel = new JLabel("Capacity");
		capacityTextField = new JTextField();
		capacityTextField.setColumns(10);
		chargePowerLabel = new JLabel("Charge Power");
		chargePowerTextField = new JTextField();
		chargePowerTextField.setColumns(10);
		SOCLabel = new JLabel("SOC");
		SOCTextField = new JTextField();
		SOCTextField.setColumns(10);
		desiredChargeLabel = new JLabel("DesiredCharge");
		desiredChargeTextField = new JTextField();
		desiredChargeTextField.setColumns(10);
		
		gl_contentPane = new GroupLayout(this);
		setLayout();
		
	}
	
	private void setLayout() {
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGap(50)
								.addComponent(arrivalLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(departureLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(arrivalTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(departureTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(capacityLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGap(50)
								.addComponent(chargePowerLabel)
								.addGap(10)
								.addComponent(SOCLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(desiredChargeLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(capacityTextField, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addGap(41)
								.addComponent(chargePowerTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addGap(39)
								.addComponent(SOCTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(desiredChargeTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(6)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(nameLabel)
							.addComponent(arrivalLabel)
							.addComponent(departureLabel))
						.addGap(11)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(arrivalTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(departureTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(capacityLabel)
							.addComponent(chargePowerLabel)
							.addComponent(SOCLabel)
							.addComponent(desiredChargeLabel))
						.addGap(11)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(capacityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(chargePowerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(SOCTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(desiredChargeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(150)
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
		Vehicle vehicle =  new Vehicle(nameTextField.getText(),
				Integer.parseInt(arrivalTextField.getText()), Integer.parseInt(departureTextField.getText()),
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
