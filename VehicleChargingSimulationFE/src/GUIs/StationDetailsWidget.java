package GUIs;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Entities.Battery;
import Entities.Station;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StationDetailsWidget extends JPanel {

	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel capacityLabel;
	private JTextField capacityTextField;
	private JLabel chargePowerLabel;
	private JTextField chargePowerTextField;
	private JLabel SOCLabel;
	private JTextField SOCTextField;
	private JLabel strategyLabel;
	private JComboBox<String> strategyDropPanel;

	private GroupLayout gl_contentPane;
	private JTextField maxVehiclesTextField;
	private JLabel maxVehiclesLabel;
	
	public StationDetailsWidget() {
		
		nameLabel = new JLabel("Name");
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		capacityLabel = new JLabel("Capacity(kWh)");
		capacityTextField = new JTextField();
		capacityTextField.setColumns(10);
		chargePowerLabel = new JLabel("Charge Power(kW)");
		chargePowerTextField = new JTextField();
		chargePowerTextField.setColumns(10);
		SOCLabel = new JLabel("SOC(%)");
		SOCTextField = new JTextField();
		SOCTextField.setColumns(10);
		maxVehiclesTextField = new JTextField();
		maxVehiclesTextField.setColumns(10);
		maxVehiclesLabel = new JLabel("MAX Vehicles");
		
		strategyDropPanel = new JComboBox<>();
		strategyDropPanel.setModel(new DefaultComboBoxModel<String>(new String[] { "FCFS", "EDF", "RR" }));
		
		strategyLabel = new JLabel("Strategy");
		
		setLayout();
		
	}
	
	private void setLayout() {
		
		gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(capacityLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(capacityTextField, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(chargePowerLabel)
						.addComponent(chargePowerTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(SOCTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(SOCLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(243, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(strategyLabel)
						.addComponent(strategyDropPanel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(maxVehiclesTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(maxVehiclesLabel)
							.addContainerGap(187, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(nameLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(strategyLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(strategyDropPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(maxVehiclesLabel)
							.addGap(6)
							.addComponent(maxVehiclesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(capacityLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(capacityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(chargePowerLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(chargePowerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(SOCLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(SOCTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(50))
		);
		
		this.setLayout(gl_contentPane);
	}
	
	public void SetName(String name) {
		nameTextField.setText(name);
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
	
	public void SetStrategy(String strategy) {
		for(int i = 0; i < strategyDropPanel.getItemCount(); i++) {
			if(strategyDropPanel.getItemAt(i).equals(strategy))
				strategyDropPanel.setSelectedIndex(i);
		}
	}
	
	public void SetMaxVehicles(int maximumChargingVehicles) {
		maxVehiclesTextField.setText(Integer.toString(maximumChargingVehicles));		
	}
	
	public Station makeStation() {
		Station station = new Station();
		station.AddComponent("Battery", makeBattery());
		station.SetName(nameTextField.getText());
		station.SetStrategy(strategyDropPanel.getItemAt(strategyDropPanel.getSelectedIndex()));
		station.SetMaximumChargingVehicles(Integer.parseInt(maxVehiclesTextField.getText()));
		return station;
	}
	
	private Battery makeBattery() {
		Battery battery = new Battery(Float.parseFloat(SOCTextField.getText()),
				Float.parseFloat(capacityTextField.getText()), Float.parseFloat(chargePowerTextField.getText()));
		return battery;
	}

}

