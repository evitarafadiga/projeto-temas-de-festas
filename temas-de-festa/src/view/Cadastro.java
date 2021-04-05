package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtLog;
	private JTextField txtCid;
	private JTextField txtUf;
	private JTextField txtNum;
	private JTextField txtComp;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cadastro() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 576, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95,158,160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindoa = new JLabel("CADASTRO DE CLIENTE");
		lblBemVindoa.setForeground(new Color(20, 20, 20));
		lblBemVindoa.setFont(new Font("Arial", Font.BOLD, 26));
		lblBemVindoa.setBounds(125, 11, 400, 59);
		contentPane.add(lblBemVindoa);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(100, 100, 150, 14);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF/CNPJ:");
		lblCPF.setBounds(100, 130, 150, 14);
		contentPane.add(lblCPF);
		
		JLabel lblTel = new JLabel("Telefone:");
		lblTel.setBounds(100, 160, 150, 14);
		contentPane.add(lblTel);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(100, 190, 150, 14);
		contentPane.add(lblEmail);
		
		JLabel lblLog = new JLabel("Logradouro:");
		lblLog.setBounds(100, 220, 150, 14);
		contentPane.add(lblLog);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(100, 250, 150, 14);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("UF:");
		lblEstado.setBounds(100, 280, 150, 14);
		contentPane.add(lblEstado);
		
		JLabel lblNumRes = new JLabel("Número:");
		lblNumRes.setBounds(100, 310, 150, 14);
		contentPane.add(lblNumRes);
		
		JLabel lblComp = new JLabel("Complemento:");
		lblComp.setBounds(100, 340, 150, 14);
		contentPane.add(lblComp);
		
		txtNome = new JTextField();
		txtNome.setBounds(280, 100, 207,20);
		contentPane.add(txtNome);
		txtNome.setColumns(50);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(280, 130, 207,20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(50);
		
		txtTel = new JTextField();
		txtTel.setBounds(280, 160, 207, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(280, 190, 207, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtLog = new JTextField();
		txtLog.setBounds(280, 220, 207, 20);
		contentPane.add(txtLog);
		txtLog.setColumns(10);
		
		txtCid = new JTextField();
		txtCid.setBounds(280, 250, 207, 20);
		contentPane.add(txtCid);
		txtCid.setColumns(10);
		
		txtUf = new JTextField();
		txtUf.setBounds(280, 280, 207, 20);
		contentPane.add(txtUf);
		txtUf.setColumns(10);
		
		txtNum = new JTextField();
		txtNum.setBounds(280, 310, 207, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		txtComp = new JTextField();
		txtComp.setBounds(280, 340, 207, 20);
		contentPane.add(txtComp);
		txtComp.setColumns(10);
		
		JButton btnEntrar = new JButton("Voltar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		
		btnEntrar.setBackground(new Color(72,209,204));
		btnEntrar.setBounds(100, 400, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnSair = new JButton("CADASTRAR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro Login = new Cadastro();
				Login.setVisible(true);
			}
		});
		
		btnSair.setBackground(new Color(72,209,204));
		btnSair.setBounds(320, 400, 150, 23);
		contentPane.add(btnSair);
	}
}
