package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.dataStructures.list.Lista;
import model.Tema;

public class CadastroTema extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	JFileChooser chooser = new JFileChooser();
	private JTextField txtValor;
	private String[] status = { "Disponível", "Indisponível", "Manutenção", "Fora de Estoque" };
	private JTextField txtDesc;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroTema frame = new CadastroTema();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public CadastroTema() {
		setTitle("Cadastro de Temas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 576, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBemVindoa = new JLabel("TEMAS");
		lblBemVindoa.setForeground(new Color(20, 20, 20));
		lblBemVindoa.setFont(new Font("Arial", Font.BOLD, 26));
		lblBemVindoa.setBounds(125, 11, 400, 59);
		contentPane.add(lblBemVindoa);

		JLabel lblNome = new JLabel("Nome do Tema:");
		lblNome.setBounds(100, 100, 150, 14);
		contentPane.add(lblNome);

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setBounds(100, 130, 150, 14);
		contentPane.add(lblPreco);

		JComboBox statusBox = new JComboBox(status);
		statusBox.setSelectedIndex(0);
		statusBox.setBounds(280, 190, 207, 20);
		contentPane.add(statusBox);

		JLabel lblDesc = new JLabel("Descrição:");
		lblDesc.setBounds(100, 160, 150, 14);
		contentPane.add(lblDesc);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(100, 190, 150, 14);
		contentPane.add(lblStatus);

		JLabel lblImg = new JLabel("Imagem do Tema:");
		lblImg.setBounds(100, 220, 150, 14);
		contentPane.add(lblImg);

		txtNome = new JTextField();
		txtNome.setBounds(280, 100, 207, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(50);

		txtValor = new JTextField();
		txtValor.setBounds(280, 130, 207, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(50);

		txtDesc = new JTextField();
		txtDesc.setBounds(280, 160, 207, 20);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		JButton btnImg = new JButton("Upload");
		btnImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(chooser);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
				}
			}
		});
		
		btnImg.setBackground(new Color(211, 211, 211));
		btnImg.setBounds(280, 220,207, 20);
		contentPane.add(btnImg);
			

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
				}
		});

		btnVoltar.setBackground(new Color(211, 211, 211));
		btnVoltar.setBounds(100, 400, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnCadastrar = new JButton("SALVAR TEMA");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Chamar Cadastro
				Image image = null;
				File sourceimage = new File("/images/broken-icon.gif");
				try { image = ImageIO.read(sourceimage);} catch (IOException e1) { e1.printStackTrace();}
				
				try { image = ImageIO.read(chooser.getSelectedFile());} catch (IOException ex) { ex.printStackTrace();}
				Tema theme = new Tema(1,					
							image,
							Double.parseDouble(txtValor.getText().replaceAll(",",".")),
							(String) statusBox.getSelectedItem(),
							new Date(System.currentTimeMillis()),
							txtDesc.getText());
				Menu.listaTemas.inserir(theme);
				
				Lista<Tema> lista = new Lista<Tema>();
				lista.inserir(theme);
				System.out.printf("Tema incluido na lista de temas: \n" + lista.recuperar(0).toString());

			}

		});

		btnCadastrar.setBackground(new Color(211, 211, 211));
		btnCadastrar.setBounds(320, 400, 150, 23);
		contentPane.add(btnCadastrar);
	}

}
