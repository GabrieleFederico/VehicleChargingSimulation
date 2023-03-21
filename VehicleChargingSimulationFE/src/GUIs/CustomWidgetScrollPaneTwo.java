package GUIs;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CustomWidgetScrollPaneTwo extends JFrame {

    private JPanel contentPanel;
    private JScrollPane scrollPane;
    private JButton addButton;

    public CustomWidgetScrollPaneTwo() {
        super("Custom Widget Scroll Pane");

        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // set layout manager to vertical BoxLayout
        contentPanel.setPreferredSize(new Dimension(400, 400)); // set initial size of the panel

        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setPreferredSize(new Dimension(400, 400)); // set initial size of the scroll pane

        addButton = new JButton("Add Widget");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add your custom widget to the content panel here, e.g.
                contentPanel.add(Box.createVerticalStrut(10)); // add some vertical spacing between widgets
                contentPanel.add(new VehicleWidget());
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
        			.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(addButton, Alignment.CENTER, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        );
        getContentPane().setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        // set up the resize behavior
        contentPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int width = contentPanel.getWidth();
                int height = contentPanel.getHeight();
                scrollPane.setPreferredSize(new Dimension(width, height));
                scrollPane.revalidate();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        CustomWidgetScrollPane ui = new CustomWidgetScrollPane();
    }
}
