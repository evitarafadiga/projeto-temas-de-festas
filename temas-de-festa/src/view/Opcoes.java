package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Opcoes extends JFrame{

	private JPanel contentPane;
	private static String nomeOpcao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Opcoes frame = new Opcoes(nomeOpcao);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Opcoes(String nomeOpcao) {
		setTitle(nomeOpcao);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 576, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143,188,143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindoa = new JLabel("Opções de "+nomeOpcao);
		lblBemVindoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindoa.setForeground(new Color(20, 20, 20));
		lblBemVindoa.setFont(new Font("Arial", Font.BOLD, 26));
		lblBemVindoa.setBounds(80, 11, 400, 59);
		contentPane.add(lblBemVindoa);
		
		JButton btnClientes = new JButton("Cadastro de "+nomeOpcao);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(nomeOpcao) {
				case "Cliente":
					CadastroCliente Login = new CadastroCliente();
					Login.setVisible(true);
					dispose();
					break;
				case "Festa":
					CadastroFesta LoginFesta = new CadastroFesta();
					//LoginFesta.setVisible(true);
					//dispose();
				case "Endereco":
					CadastroEndereco cadEnd = new CadastroEndereco();
					//cadEnd.setVisible(true);
					//dispose();
				case "Tema":
					CadastroTema cadTema = new CadastroTema();
					cadTema.setVisible(true);
					dispose();
				default:
					break;	
				}	
			}
		});
		btnClientes.setBackground(new Color(211,211,211));
		btnClientes.setBounds(291, 68, 246, 45);
		contentPane.add(btnClientes);
		
		JButton btnTemas = new JButton("Lista de "+nomeOpcao);
		btnTemas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				switch(nomeOpcao) {
				case "Cliente":
					CadastroCliente Login = new CadastroCliente();
					Login.setVisible(true);
					dispose();
				
				case "Festa":
					CadastroFesta LoginFesta = new CadastroFesta();
					//LoginFesta.setVisible(true);
					//dispose();
				case "Endereco":
					CadastroEndereco cadEnd = new CadastroEndereco();
					//cadEnd.setVisible(true);
					//dispose();
				case "Tema":
					CadastroTema cadTema = new CadastroTema();
					cadTema.setVisible(true);
					dispose();
				default:
					break;
					
				}
			}
		});
		btnTemas.setBackground(new Color(211,211,211));
		btnTemas.setBounds(25, 140, 246, 45);
		contentPane.add(btnTemas);
		
		JButton btnContratos = new JButton("Remocao de "+nomeOpcao);
		btnContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(nomeOpcao) {
				case "Cliente":
					CadastroCliente Login = new CadastroCliente();
					Login.setVisible(true);
					dispose();
				
				case "Festa":
					CadastroFesta LoginFesta = new CadastroFesta();
					//LoginFesta.setVisible(true);
					//dispose();
				case "Endereco":
					CadastroEndereco cadEnd = new CadastroEndereco();
					//cadEnd.setVisible(true);
					//dispose();
				case "Tema":
					CadastroTema cadTema = new CadastroTema();
					cadTema.setVisible(true);
					dispose();
				default:
					break;
					
				}
			}
		});
		btnContratos.setBackground(new Color(211,211,211));
		btnContratos.setBounds(291, 140, 246, 45);
		contentPane.add(btnContratos);
		
		JButton btnFestas = new JButton("Atualização de "+nomeOpcao);
		btnFestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				switch(nomeOpcao) {
				case "Cliente":
					CadastroCliente Login = new CadastroCliente();
					Login.setVisible(true);
					dispose();
				
				case "Festa":
					CadastroFesta LoginFesta = new CadastroFesta();
					//LoginFesta.setVisible(true);
					//dispose();
				case "Endereco":
					CadastroEndereco cadEnd = new CadastroEndereco();
					//cadEnd.setVisible(true);
					//dispose();
				case "Tema":
					CadastroTema cadTema = new CadastroTema();
					cadTema.setVisible(true);
					dispose();
				default:
					break;
					
				}
			}
		});
		btnFestas.setBackground(new Color(211,211,211));
		btnFestas.setBounds(25, 68, 246, 45);
		contentPane.add(btnFestas);
		
		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		
		btnSair.setBackground(new Color(211,211,211));
		btnSair.setBounds(25, 211, 512, 45);
		contentPane.add(btnSair);
	}
}
