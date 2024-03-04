package Parte2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Practica03_a extends JFrame implements ActionListener{
		ListaInsumos listainsumo;
		ListaCategorias listacategorias;
		
		private JComboBox ComboCategoria;
		private JTextField Tid,Tinsumo;
		private JButton Bagregar,Beliminar,Bsalir;
		private JTextArea areaProductos;
		private JPanel panelFormulario;
		public void inicializarcategorias() {
			this.listacategorias= new ListaCategorias();
			 Categoria nodo1= new Categoria ("01","Materiales");
			 Categoria nodo2= new Categoria ("02","Mano de Obra");
			 Categoria nodo3= new Categoria ("03","Maquinaria y Equipo");
			 Categoria nodo4= new Categoria ("04","Servicios");
			 this.listacategorias.agregarCategoria(nodo1);
			 this.listacategorias.agregarCategoria(nodo2);
			 this.listacategorias.agregarCategoria(nodo3);
			 this.listacategorias.agregarCategoria(nodo4);
			 
		}
		public Practica03_a() {
			super("Administracio de Productos");
			this.inicializarcategorias();
			this.listainsumo= new ListaInsumos();
			setBounds(0,0,390,370);
			this.panelFormulario= new JPanel();
			this.panelFormulario.setLayout(null);
			getContentPane().add(panelFormulario,BorderLayout.CENTER);

			JLabel labelcategoria= new JLabel("Categoria:");
			labelcategoria.setBounds(10, 66, 71, 20);
			ComboCategoria= new JComboBox(this.listacategorias.CategoriasArreglo());
			ComboCategoria.setEditable(false);
			ComboCategoria.setBounds(91,66,160,20);
			ComboCategoria.addActionListener(this);
			panelFormulario.add(labelcategoria);
			panelFormulario.add(ComboCategoria);
			
			JLabel labelId= new JLabel ("ID:");
			labelId.setBounds(10,9,71,20);
			this.Tid= new JTextField(10);
			this.Tid.setEditable(false);
			this.Tid.setBounds(91,9,147,20);
			panelFormulario.add(labelId);
			panelFormulario.add(Tid);
			
			JLabel labelInsumo= new JLabel ("Insumo:");
			labelInsumo.setBounds(10,34,71,20);
			this.Tinsumo= new JTextField(20);
			this.Tinsumo.setEditable(false);
			this.Tinsumo.setBounds(91,35,147,20);
			panelFormulario.add(labelInsumo);
			panelFormulario.add(Tinsumo);
			
			this.Bagregar= new JButton ("Agregar");
			this.Bagregar.setBounds(20,104,111,20);
			this.Bagregar.addActionListener(this);
			panelFormulario.setLayout(null);
			panelFormulario.add(Bagregar);
			
			this.Beliminar= new JButton ("Eliminar");
			this.Beliminar.setBounds(153,104,111,20);
			this.Beliminar.addActionListener(this);
			panelFormulario.setLayout(null);
			panelFormulario.add(Beliminar);
			
			this.Bsalir= new JButton ("Salir");
			this.Bsalir.setBounds(274,104,79,20);
			this.Bsalir.addActionListener(this);
			panelFormulario.add(Bsalir);
			
			JScrollPane scrollPane= new JScrollPane();
			scrollPane.setBounds(10,132,357,179);
			panelFormulario.add(scrollPane);
			this.areaProductos= new JTextArea(10,40);
			scrollPane.setViewportView(areaProductos);
			this.areaProductos.setEditable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);						
		}
		public void VolveralInicio() {
			this.Bagregar.setText("Agregar");
			this.Bsalir.setText("Salir");
			this.Beliminar.setEnabled(true);
			this.Tid.setEditable(false);
			this.Tinsumo.setEditable(false);
			this.ComboCategoria.setEditable(false);
			this.Tid.setText("");
			this.Tinsumo.setText("");
			this.ComboCategoria.setSelectedIndex(0);
		}
		public void Altas() {
			if(this.Bagregar.getText().compareTo("Agregar")==0){
				this.Bagregar.setText("Salvar");
				this.Bsalir.setText("Cancelar");
				this.Beliminar.setEnabled(false);
				this.Tid.setEditable(true);
				this.Tinsumo.setEditable(true);
				this.ComboCategoria.setEditable(true);
				this.ComboCategoria.setFocusable(true);
			}
			else {
				System.out.println("aqui");
				if(!this.Tid.getText().equals("") && !this.Tinsumo.getText().equals("") && this.ComboCategoria.getSelectedItem() != null) { 
					System.out.println("aqui");
					String id,insumo,idcategoria;
					id=this.Tid.getText().trim();
					insumo=this.Tinsumo.getText().trim();
					idcategoria= ((Categoria)this.ComboCategoria.getSelectedItem()).getIdcategoria().trim();
					Insumo nodo= new Insumo(id,insumo,idcategoria);
					if(!this.listainsumo.agregarInsumo(nodo))
						JOptionPane.showMessageDialog(this, "lo siento el id "+id+ "ya existe lo tiene asignado "+this.listainsumo.buscarInsumo(id));
					else
						{this.areaProductos.setText(this.listainsumo.toString());
						
						}
				}
				this.VolveralInicio();
				}
		}
		public void Eliminar() {
			Object[] opciones= this.listainsumo.idinsumos();
			String id= (String) JOptionPane.showInputDialog(null,"Seleccione una opcion:", "Eliminacion de insumos", JOptionPane.PLAIN_MESSAGE,null,opciones,opciones[0]);
			if((id!=null)|| (!id.isEmpty())) {
				if(!this.listainsumo.eliminarInsumoPorId(id))
					JOptionPane.showMessageDialog(this,"No existe este id");
				else
					this.areaProductos.setText(this.listainsumo.toString());
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==this.Bagregar)
				this.Altas();
			else if(e.getSource()==this.Beliminar)
				this.Eliminar();
			else if(e.getSource()==Bsalir) {
				if(this.Bsalir.getText().compareTo("Cancelar")==0)
					this.VolveralInicio();
				else
					this.dispose();
			}
		}
		public static void main(String[] args) {
			new Practica03_a();
		}
}
