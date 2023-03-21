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
import javax.swing.JTabbedPane;

public class CustomWidgetTabbedPane extends JFrame {

    private JPanel contentPanel;
    private JScrollPane scrollPane;
    private JButton addButton;

    public CustomWidgetTabbedPane() {
        super("Custom Widget Tabbed Pane");

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
        getContentPane().setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        // set up the horizontal layout
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(scrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton));

        // set up the vertical layout
        layout.setVerticalGroup(layout.createParallelGroup()
                .addComponent(scrollPane)
                .addComponent(addButton, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        // set up the resize behavior
        contentPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int width = contentPanel.getWidth();
                int height = contentPanel.getHeight();
                scrollPane.setPreferredSize(new Dimension(width, height));
                scrollPane.revalidate();
            }
        });

        // create a tabbed pane and add the scroll pane to it
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Custom Widgets", scrollPane);

        getContentPane().add(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        CustomWidgetTabbedPane ui = new CustomWidgetTabbedPane();
    }
}
