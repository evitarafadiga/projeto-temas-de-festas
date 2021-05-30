package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ClienteController;
import controller.EnderecoController;
import controller.dataStructures.list.Lista;
import model.Cliente;
import model.Endereco;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtLog;
	private JTextField txtCid;
//	private JTextField txtUf;
	private JTextField txtNum;
	private JTextField txtComp;
	
	String[] ufStrings = { "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE","RN","PB","PE", "AL", "SE", "BA","MG", "ES", "RJ", "SP", "PR", "SC", "RS","MS", "MT", "GO", "DF"};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroCliente() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 576, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143,188,143));
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
		
//		txtUf = new JTextField();
//		txtUf.setBounds(280, 280, 207, 20);
//		contentPane.add(txtUf);
//		txtUf.setColumns(10);
		JComboBox ufBox = new JComboBox(ufStrings);
		ufBox.setSelectedIndex(0);
		ufBox.setBounds(280, 280, 207, 20);
		contentPane.add(ufBox);
		
		txtNum = new JTextField();
		txtNum.setBounds(280, 310, 207, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		txtComp = new JTextField();
		txtComp.setBounds(280, 340, 207, 20);
		contentPane.add(txtComp);
		txtComp.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		
		btnVoltar.setBackground(new Color(211,211,211));
		btnVoltar.setBounds(100, 400, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamar Cadastro
				Cliente cliente = new Cliente(
						1,
						new Date(System.currentTimeMillis()), 
						txtNome.getText(), 
						txtCpf.getText(), 
						txtTel.getText(), 
						txtEmail.getText(),
						end()
					);
				Menu.listaClientes.inserir(cliente);
				Lista<Cliente> lista = new Lista<Cliente>();
				lista.inserir(cliente);
				System.out.printf("Cliente incluido na lista: \n" + lista.recuperar(0).toString(), Endereco.showUF(""));
				
				ClienteController cc = new ClienteController();
				cc.saveListCliente(lista);
			}
			
			public Endereco end() {
				int num = 0;
				Endereco end = new Endereco(1, txtLog.getText(),
												txtCid.getText(),
												(String) ufBox.getSelectedItem(),
												Integer.parseInt(txtNum.getText()),
												txtComp.getText());
				Menu.listaEnderecos.inserir(end);
				Lista<Endereco> listaEnd = new Lista<Endereco>();
				listaEnd.inserir(end);
				System.out.printf("Endereco incluido na lista: \n" + listaEnd.recuperar(0).toString(), Endereco.showUF(""));
				EnderecoController ec = new EnderecoController();
				ec.saveListEndereco(listaEnd);
				return end;
			}
			
			
			
		});
		
		
		btnCadastrar.setBackground(new Color(211,211,211));
		btnCadastrar.setBounds(320, 400, 150, 23);
		contentPane.add(btnCadastrar);
	}
	
}
