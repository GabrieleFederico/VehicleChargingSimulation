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
	
	/**
	 * Create the frame.
	 */
	public StationDetailsWidget() {
		
		nameLabel = new JLabel("Name");
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		capacityLabel = new JLabel("Capacity");
		capacityTextField = new JTextField();
		capacityTextField.setColumns(10);
		chargePowerLabel = new JLabel("Charge Power");
		chargePowerTextField = new JTextField();
		chargePowerTextField.setColumns(10);
		SOCLabel = new JLabel("SOC");
		SOCTextField = new JTextField();
		SOCTextField.setColumns(10);
		
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
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(capacityTextField, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(capacityLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chargePowerLabel)
							.addGap(33)
							.addComponent(SOCLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(strategyLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chargePowerTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addComponent(SOCTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(strategyDropPanel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(strategyLabel)
								.addComponent(SOCLabel)
								.addComponent(chargePowerLabel)
								.addComponent(capacityLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(capacityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(chargePowerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(SOCTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(strategyDropPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(nameLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(56))
		);
		
		this.setLayout(gl_contentPane);
	}
	
	public Station makeStation() {
		Station station = new Station();
		station.AddComponent("Battery", makeBattery());
		station.SetName(nameTextField.getText());
		station.SetStrategy(strategyDropPanel.getItemAt(strategyDropPanel.getSelectedIndex()));
		return station;
	}
	
	private Battery makeBattery() {
		Battery battery = new Battery(Integer.parseInt(SOCTextField.getText()),
				Integer.parseInt(capacityTextField.getText()), Integer.parseInt(chargePowerTextField.getText()));
		return battery;
	}
}

