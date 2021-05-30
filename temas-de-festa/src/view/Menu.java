package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;
	private String opcaoNome = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 576, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143,188,143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindoa = new JLabel("GERENCIAMENTO DE FESTAS");
		lblBemVindoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindoa.setForeground(new Color(20, 20, 20));
		lblBemVindoa.setFont(new Font("Arial", Font.BOLD, 26));
		lblBemVindoa.setBounds(80, 11, 400, 59);
		contentPane.add(lblBemVindoa);
		
		JButton btnClientes = new JButton("CLIENTES");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcaoNome = "Cliente";
				Opcoes Login = new Opcoes(opcaoNome);
				Login.setVisible(true);
				dispose();
			}
		});
		btnClientes.setBackground(new Color(211,211,211));
		btnClientes.setBounds(291, 68, 246, 45);
		contentPane.add(btnClientes);
		
		JButton btnTemas = new JButton("TEMAS");
		btnTemas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcaoNome = "Tema";
				Opcoes novoTema = new Opcoes(opcaoNome);
				novoTema.setVisible(true);
				dispose();
			}
		});
		btnTemas.setBackground(new Color(211,211,211));
		btnTemas.setBounds(25, 140, 246, 45);
		contentPane.add(btnTemas);
		
		JButton btnContratos = new JButton("CONTRATOS");
		btnContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcaoNome = "Contrato";
				Opcoes novoContrato = new Opcoes(opcaoNome);
				novoContrato.setVisible(true);
				dispose();
			}
		});
		btnContratos.setBackground(new Color(211,211,211));
		btnContratos.setBounds(291, 140, 246, 45);
		contentPane.add(btnContratos);
		
		JButton btnFestas = new JButton("FESTAS");
		btnFestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcaoNome = "Festa";
				Opcoes novaFesta = new Opcoes(opcaoNome);
				novaFesta.setVisible(true);
				dispose();
			}
		});
		btnFestas.setBackground(new Color(211,211,211));
		btnFestas.setBounds(25, 68, 246, 45);
		contentPane.add(btnFestas);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnSair.setBackground(new Color(211,211,211));
		btnSair.setBounds(25, 211, 512, 45);
		contentPane.add(btnSair);
	}

}
