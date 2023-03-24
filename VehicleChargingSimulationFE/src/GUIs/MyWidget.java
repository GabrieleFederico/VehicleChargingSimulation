package GUIs;
import javax.swing.*;
import java.awt.*;

public class MyWidget extends JPanel {
    public MyWidget() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        JLabel label1 = new JLabel("Name");
        JTextField textField1 = new JTextField(10);
        JLabel label2 = new JLabel("Arrival");
        JTextField textField2 = new JTextField(10);
        JLabel label3 = new JLabel("Departure");
        JTextField textField3 = new JTextField(10);
        JLabel label4 = new JLabel("Capacity");
        JTextField textField4 = new JTextField(10);
        JLabel label5 = new JLabel("ChargePower");
        JTextField textField5 = new JTextField(10);
        JLabel label6 = new JLabel("SOC");
        JTextField textField6 = new JTextField(10);
        JLabel label7 = new JLabel("Desired Charge");
        JTextField textField7 = new JTextField(10);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label1)
                    .addComponent(label2)
                    .addComponent(label3)
                    .addComponent(label4)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(textField1)
                    .addComponent(textField2)
                    .addComponent(textField3)
                    .addComponent(textField4)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label5)
                    .addComponent(label6)
                    .addComponent(label7)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(textField5)
                    .addComponent(textField6)
                    .addComponent(textField7)
                )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(textField1)
                    .addComponent(label5)
                    .addComponent(textField5)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label2)
                    .addComponent(textField2)
                    .addComponent(label6)
                    .addComponent(textField6)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(textField3)
                    .addComponent(label7)
                    .addComponent(textField7)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label4)
                    .addComponent(textField4)
                )
        );

        setPreferredSize(new Dimension(300, 200));
    }
}
