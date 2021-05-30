package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

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
		JComboBox<String> ufBox = new JComboBox<String>(ufStrings);
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
				try {
					Cliente cliente = new Cliente(
							Menu.listaClientes.recuperarUltimo() != null ? Menu.listaClientes.recuperarUltimo().getId()+1 : 0,
									new Date(System.currentTimeMillis()), 
									txtNome.getText(), 
									txtCpf.getText(), 
									txtTel.getText(), 
									txtEmail.getText(),
									end()
							);
					Menu.listaClientes.inserir(cliente);
					Menu.listaEnderecos.inserir(end());
					
					
					Menu.clienteController.saveListCliente(Menu.listaClientes);
					Menu.enderecoController.saveListEndereco(Menu.listaEnderecos);
					
					txtNome.setText("");
					txtCpf.setText("");
					txtTel.setText("");
					txtEmail.setText("");
					txtLog.setText("");
					txtCid.setText("");
					txtNum.setText("");
					txtComp.setText("");
					ufBox.setSelectedIndex(0);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
					
				} catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro, por favor tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			public Endereco end() {
				Endereco end = new Endereco(
						Menu.listaClientes.recuperarUltimo() != null ? Menu.listaClientes.recuperarUltimo().getId() : 0, 
						txtLog.getText(),
						txtCid.getText(),
						(String) ufBox.getSelectedItem(),
						Integer.parseInt(txtNum.getText()),
						txtComp.getText()
												);
				return end;
			}
			
			
			
		});
		
		
		btnCadastrar.setBackground(new Color(211,211,211));
		btnCadastrar.setBounds(320, 400, 150, 23);
		contentPane.add(btnCadastrar);
	}
	
}
