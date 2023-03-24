package GUIs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private ArrayList<VehicleWidget> vehicleWidgets = new ArrayList<>();

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
		
		JButton addVehicleButton = new JButton("Add Vehicle");
		
		JButton importButton = new JButton("Import");
		
		JButton exportButton = new JButton("Export");
		
		JButton runButton = new JButton("Run");
		
		JTabbedPane stationsTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JComboBox<String> strategyDropPanel = new JComboBox<String>();
		strategyDropPanel.setModel(new DefaultComboBoxModel<String>(new String[] {"FCFS", "EDF", "RR"}));
		
		JButton addStationButton = new JButton("Add Station");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(stationsTabbedPane, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(exportButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(runButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(importButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(strategyDropPanel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(addStationButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(addVehicleButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
					.addGap(121))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(addStationButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(addVehicleButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(strategyDropPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(importButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(exportButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(runButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(stationsTabbedPane, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		JScrollPane scrollPane = new JScrollPane();
		stationsTabbedPane.addTab("Station 1", null, scrollPane, null);
		
		JPanel innerPanel = new JPanel();
		scrollPane.setViewportView(innerPanel);
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		innerPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		Dimension maxSize = innerPanel.getPreferredSize();
		maxSize.width = Short.MAX_VALUE;
		innerPanel.setMaximumSize(maxSize);
		
		contentPane.setLayout(gl_contentPane);
		
		addVehicleButton.addActionListener(e-> {
			int selectedIndex = stationsTabbedPane.getSelectedIndex();
            if (selectedIndex != -1) {
                JPanel tabPanel = (JPanel) ((JScrollPane) stationsTabbedPane.getComponentAt(selectedIndex)).getViewport().getView();
                JPanel widgetPanel = new MyWidget();
                //vehicleWidgets.add(widgetPanel);
                tabPanel.add(widgetPanel);
                tabPanel.revalidate();
                tabPanel.repaint();
            }
		});
		
		addStationButton.addActionListener(e -> {
        	JPanel tabPanel = new JPanel();
        	tabPanel.setLayout(new BoxLayout(tabPanel, BoxLayout.Y_AXIS));
        	JScrollPane newScrollPane = new JScrollPane(tabPanel);
        	newScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        	newScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        	stationsTabbedPane.addTab("Station " + (stationsTabbedPane.getTabCount() + 1), newScrollPane);

        });
		
		setContentPane(contentPane);
	}
	
}

