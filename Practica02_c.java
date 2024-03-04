package Parte1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JComboBox;

public class Practica02_c extends JFrame implements ActionListener{
	
	String[] opciones = {"Opcion 1", "Opcion 2", "Opcion 3"};
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton Bsalir;
	private JTextArea textArea;
	private JTextField campoTexto;
	private JPasswordField campoPassword;
	private JFormattedTextField campoFormateado;
	private JSpinner spinner;
	private JSlider slider;
	private JComboBox<String> comboBox;
	
	
	public static void main(String[] args) {
		Practica02_c ventana = new Practica02_c();
	}

	/**
	 * Create the frame.
	 */
	public Practica02_c() {
		setTitle("Ejemplo de componentes de entrada de texto");
		setSize(442,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		panel=new JPanel();
		panel.setBounds(0, 0, 403, 365);
		getContentPane().setLayout(null);
		
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel etiqueta1 = new JLabel("JButton");
		etiqueta1.setBounds(03, 3, 178, 36);
		panel.add(etiqueta1);
		panel.setLayout(null);
		Bsalir.addActionListener(this);
		Bsalir = new JButton("Haz clic para salir");
		Bsalir.setBounds(188, 3, 172, 36);
		panel.add(Bsalir);
		
		JLabel etiqueta2 = new JLabel("JTextField");
		etiqueta2.setBounds(0, 49, 148, 36);
		panel.add(etiqueta2);
		campoTexto = new JTextField();
		campoTexto.setBounds(188, 50, 172, 36);
		panel.add(campoTexto);
		
		JLabel etiqueta3 = new JLabel("JPasswordField");
		etiqueta3.setBounds(0, 95, 148, 36);
		panel.add(etiqueta3);
		campoPassword = new JPasswordField();
		campoPassword.setBounds(188, 97, 172, 36);
		panel.add(campoPassword);
		
		JLabel etiqueta4 = new JLabel("JTextArea");
		etiqueta4.setBounds(0, 141, 148, 36);
		JScrollPane scrollPane= new JScrollPane();
		scrollPane.setBounds(188,141,172,36);
		panel.add(etiqueta4);
		panel.add(scrollPane);
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		JLabel etiqueta5 = new JLabel("JFormattedTextField");
		etiqueta5.setBounds(0, 187, 141, 36);
		panel.add(etiqueta5);
		campoFormateado = new JFormattedTextField();
		campoFormateado.setBounds(188, 187, 172, 36);
		campoFormateado.setValue(12345.67);
		panel.add(campoFormateado);
				
		JLabel etiqueta6 = new JLabel("JSpinner");
		etiqueta6.setBounds(0, 233, 141, 36);
		panel.add(etiqueta6);
		SpinnerNumberModel modeloSpinner = new SpinnerNumberModel(0,0,100,1);
		getContentPane().setLayout(null);
		spinner = new JSpinner(modeloSpinner);
		spinner.setBounds(188, 233, 172, 36);
		panel.add(spinner);
		
		JLabel etiqueta7 = new JLabel("JSlider");
		etiqueta7.setBounds(0, 279, 148, 36);
		panel.add(etiqueta7);
		slider = new JSlider();
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(188, 280, 178, 36);
		panel.add(slider);
		
		JLabel etiqueta8 = new JLabel("JComboBox");
		etiqueta8.setBounds(0, 325,148, 36);
		panel.add(etiqueta8);
		
		comboBox = new JComboBox(opciones);
		comboBox.setBounds(188, 325, 172, 36);
		panel.add(comboBox);
		
		setVisible(true);
		getContentPane().add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.Bsalir) {
			String cadena= " valor de JTextfield "+this.campoTexto.getText().trim();
			cadena= cadena+"\n"+" valor de JTextfield "+this.campoPassword.getText().trim();
			cadena= cadena+"\n"+" valor de Jtextarea "+this.textArea.getText();
			cadena= cadena+"\n"+" valor de Jformattedtextfield "+this.campoFormateado.getText().trim();
			cadena= cadena+"\n"+" valor de spinner "+this.spinner.getValue().toString();
			cadena= cadena+"\n"+" valor de slidder "+String.valueOf(this.slider.getValue());
			if(comboBox.getSelectedIndex()>-1)
				cadena= cadena+"\n"+ "valor de combo es "+this.comboBox.getSelectedItem().toString();
			
			JOptionPane.showMessageDialog(this, cadena);
		}
		
	}
}
