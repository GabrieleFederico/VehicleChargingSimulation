package GUIs;
import javax.swing.*;
import java.awt.*;

public class MyWidget extends JPanel {
	
	JLabel nameLabel;
	JTextField nameTextField;
	JLabel arrivalLabel;
	JTextField arrivalTextField;
	JLabel departureLabel;
	JTextField departureTextField;
	JLabel capacityLabel;
	JTextField capacityTextField;
	JLabel chargePowerLabel;
	JTextField chargePowerTextField;
	JLabel SOCLabel;
	JTextField SOCTextField;
	JLabel desiredChargeLabel;
	JTextField desiredChargeTextField;
	
	GroupLayout layout;
	
    public MyWidget() {
        layout = new GroupLayout(this);
        setLayout(layout);

        nameLabel = new JLabel("Name");
        nameTextField = new JTextField(10);
        arrivalLabel = new JLabel("Arrival");
        arrivalTextField = new JTextField(10);
        departureLabel = new JLabel("Departure");
        departureTextField = new JTextField(10);
        capacityLabel = new JLabel("Capacity");
        capacityTextField = new JTextField(10);
        chargePowerLabel = new JLabel("ChargePower");
        chargePowerTextField = new JTextField(10);
        SOCLabel = new JLabel("SOC");
        SOCTextField = new JTextField(10);
        desiredChargeLabel = new JLabel("Desired Charge");
        desiredChargeTextField = new JTextField(10);

        setLayout();

        setPreferredSize(new Dimension(300, 200));
    }
    
    private void setLayout() {
    	layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nameLabel)
                        .addComponent(arrivalLabel)
                        .addComponent(departureLabel)
                        .addComponent(capacityLabel)
                    )
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nameTextField)
                        .addComponent(arrivalTextField)
                        .addComponent(departureTextField)
                        .addComponent(capacityTextField)
                    )
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(chargePowerLabel)
                        .addComponent(SOCLabel)
                        .addComponent(desiredChargeLabel)
                    )
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(chargePowerTextField)
                        .addComponent(SOCTextField)
                        .addComponent(desiredChargeTextField)
                    )
            );

            layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(nameTextField)
                        .addComponent(chargePowerLabel)
                        .addComponent(chargePowerTextField)
                    )
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(arrivalLabel)
                        .addComponent(arrivalTextField)
                        .addComponent(SOCLabel)
                        .addComponent(SOCTextField)
                    )
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(departureLabel)
                        .addComponent(departureTextField)
                        .addComponent(desiredChargeLabel)
                        .addComponent(desiredChargeTextField)
                    )
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(capacityLabel)
                        .addComponent(capacityTextField)
                    )
            );
    }
}
