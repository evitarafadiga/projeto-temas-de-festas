package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ClienteController;
import controller.EnderecoController;
import controller.FestaController;
import controller.dataStructures.list.Lista;
import model.Cliente;
import model.Endereco;
import model.Festa;

public class CadastroFesta extends JFrame {

	private JPanel contentPane;
	private JTextField txtClienteId;
	private JTextField txtTemaId;
	private JTextField txtLog;
	private JTextField txtCid;
	private JTextField txtNum;
	private JTextField txtComp;
	
	private JTextField txtValor;
	private JTextField txtDespesas;
	private JTextField txtDesconto;
	private JTextField txtDesc;
	
	String[] ufStrings = { "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE","RN","PB","PE", "AL", "SE", "BA","MG", "ES", "RJ", "SP", "PR", "SC", "RS","MS", "MT", "GO", "DF"};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFesta frame = new CadastroFesta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroFesta() {
		setTitle("Cadastro de Festa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 576, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143,188,143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindoa = new JLabel("CADASTRO DE FESTA");
		lblBemVindoa.setForeground(new Color(20, 20, 20));
		lblBemVindoa.setFont(new Font("Arial", Font.BOLD, 26));
		lblBemVindoa.setBounds(125, 11, 400, 59);
		contentPane.add(lblBemVindoa);
		
		JLabel lblClienteId = new JLabel("ID do Cliente:");
		lblClienteId.setBounds(100, 100, 150, 14);
		contentPane.add(lblClienteId);
		
		JLabel lblTemaId = new JLabel("ID do Tema:");
		lblTemaId.setBounds(100, 130, 150, 14);
		contentPane.add(lblTemaId);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(100, 160, 150, 14);
		contentPane.add(lblValor);
		
		JLabel lblDespesas = new JLabel("Despesas:");
		lblDespesas.setBounds(100, 190, 150, 14);
		contentPane.add(lblDespesas);
		
		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(100, 220, 150, 14);
		contentPane.add(lblDesconto);
		
		JLabel lblDesc = new JLabel("Descrição de Despesa:");
		lblDesc.setBounds(100, 250, 150, 14);
		contentPane.add(lblDesc);
		
		JLabel lblLog = new JLabel("Logradouro:");
		lblLog.setBounds(100, 300, 150, 14);
		contentPane.add(lblLog);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(100, 330, 150, 14);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("UF:");
		lblEstado.setBounds(100, 360, 150, 14);
		contentPane.add(lblEstado);
		
		JLabel lblNumRes = new JLabel("Número:");
		lblNumRes.setBounds(100, 390, 150, 14);
		contentPane.add(lblNumRes);
		
		JLabel lblComp = new JLabel("Complemento:");
		lblComp.setBounds(100, 420, 150, 14);
		contentPane.add(lblComp);
		
		txtClienteId = new JTextField();
		txtClienteId.setBounds(280, 100, 207,20);
		contentPane.add(txtClienteId);
		txtClienteId.setColumns(50);
		
		txtTemaId = new JTextField();
		txtTemaId.setBounds(280, 130, 207,20);
		contentPane.add(txtTemaId);
		txtTemaId.setColumns(50);
		
		txtValor = new JTextField();
		txtValor.setBounds(280, 160, 207, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		txtDespesas = new JTextField();
		txtDespesas.setBounds(280, 190, 207, 20);
		contentPane.add(txtDespesas);
		txtDespesas.setColumns(10);
		
		txtDesconto = new JTextField();
		txtDesconto.setBounds(280, 220, 207, 20);
		contentPane.add(txtDesconto);
		txtDesconto.setColumns(10);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(280, 250, 207, 20);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		txtLog = new JTextField();
		txtLog.setBounds(280, 300, 207, 20);
		contentPane.add(txtLog);
		txtLog.setColumns(10);
		
		txtCid = new JTextField();
		txtCid.setBounds(280, 330, 207, 20);
		contentPane.add(txtCid);
		txtCid.setColumns(10);
		
		JComboBox ufBox = new JComboBox(ufStrings);
		ufBox.setSelectedIndex(0);
		ufBox.setBounds(280, 360, 207, 20);
		contentPane.add(ufBox);
		
		txtNum = new JTextField();
		txtNum.setBounds(280, 390, 207, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		txtComp = new JTextField();
		txtComp.setBounds(280, 420, 207, 20);
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
		btnVoltar.setBounds(100, 450, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamar Cadastro
				Festa festa = new Festa(
						Integer.parseInt(txtClienteId.getText()),
						Integer.parseInt(txtTemaId.getText()),
						end(),
						Double.parseDouble(txtValor.getText().replaceAll(",",".")),
						Double.parseDouble(txtDespesas.getText().replaceAll(",",".")),
						Double.parseDouble(txtDesconto.getText().replaceAll(",",".")),
						txtDesc.getText(),
						new Date(System.currentTimeMillis()),
						new Date(System.currentTimeMillis()));
				Lista<Festa> lista = new Lista<Festa>();
				lista.inserir(festa);
				System.out.printf("Festa incluida na lista: \n" + lista.recuperar(0).toString(), Endereco.showUF(""));
				
				FestaController cc = new FestaController();
				cc.saveListFesta(lista);
			}
			
			public Endereco end() {
				int num = 0;
				Endereco end = new Endereco(1, txtLog.getText(),
												txtCid.getText(),
												(String) ufBox.getSelectedItem(),
												Integer.parseInt(txtNum.getText()),
												txtComp.getText());
				
				Lista<Endereco> listaEnd = new Lista<Endereco>();
				listaEnd.inserir(end);
				System.out.printf("Endereco incluido na lista: \n" + listaEnd.recuperar(0).toString(), Endereco.showUF(""));
				EnderecoController ec = new EnderecoController();
				ec.saveListEndereco(listaEnd);
				return end;
			}
			
			
			
		});
		
		
		btnCadastrar.setBackground(new Color(211,211,211));
		btnCadastrar.setBounds(320, 450, 150, 23);
		contentPane.add(btnCadastrar);
	}
	
}