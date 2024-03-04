package Parte1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Practica01_03 extends JDialog {
	private JPanel contentPane;

	private final JPanel contentPanel = new JPanel();

	
	public static void main(String[] args) {
		try {
			Practica01_03 dialog = new Practica01_03();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Practica01_03() {
		setBounds(100, 100, 450, 300);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		}
	}


