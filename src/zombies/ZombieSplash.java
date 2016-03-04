package zombies;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZombieSplash extends JFrame {

	private JPanel contentPane;
	private JComboBox<Object> comboBox;
	private int choice;
	private boolean running = false;
	private volatile boolean clicked = false;
	
	
	public ZombieSplash() {
		running = true;
	}
	
	public int getLevel() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 230);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{350};
		gbl_contentPane.rowHeights = new int[]{20, 50, 50, 50, 50};
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblWelcome = new JLabel("Welcome to Zombies!");
		lblWelcome.setForeground(Color.RED);
		lblWelcome.setFont(new Font("Helvetica", Font.BOLD, 24));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.anchor = GridBagConstraints.NORTH;
		gbc_lblWelcome.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblWelcome.gridx = 0;
		gbc_lblWelcome.gridy = 1;
		contentPane.add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblChooseAScenario = new JLabel("Choose a scenario:");
		lblChooseAScenario.setFont(new Font("Helvetica", Font.BOLD, 20));
		GridBagConstraints gbc_lblChooseAScenario = new GridBagConstraints();
		gbc_lblChooseAScenario.insets = new Insets(0, 0, 5, 0);
		gbc_lblChooseAScenario.gridx = 0;
		gbc_lblChooseAScenario.gridy = 2;
		contentPane.add(lblChooseAScenario, gbc_lblChooseAScenario);
		
		comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Helvetica", Font.BOLD, 16));
		comboBox.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(new String[] {
				"lonesome (scene 1) ", 
				"face-off (scene 2)", 
				"the grid (scene 3)", 
				"showdown (scene 4)", 
				"pinwheel (scene 5)"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 3;
		contentPane.add(comboBox, gbc_comboBox);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disposeWindow();
				choose(getSelection());
				click();
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridx = 0;
		gbc_btnOk.gridy = 4;
		contentPane.add(btnOk, gbc_btnOk);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		while (running) {
			if (clicked) {
				running = false;
				return choice;
			}
		}
		return 0;
	}
	
	private void click() {
		this.clicked = true;
	}
	
	private int getSelection() {
		return comboBox.getSelectedIndex() + 1;
	}
	
	private void choose(int choice) {
		this.choice = choice;
	}
	
	private void disposeWindow() {
		this.dispose();
	}

}
