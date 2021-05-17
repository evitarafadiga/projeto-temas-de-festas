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

import controller.dataStructures.list.Lista;
import model.Cliente;
import model.Endereco;

public class CadastroEndereco {
	
	private JPanel contentPane;
	private JTextField txtLog;
	private JTextField txtCid;
	private JTextField txtUf;
	private JTextField txtNum;
	private JTextField txtComp;
	
	String[] ufStrings = { "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE","RN","PB","PE", "AL", "SE", "BA","MG", "ES", "RJ", "SP", "PR", "SC", "RS","MS", "MT", "GO", "DF"};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEndereco frame = new CadastroEndereco();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void clienteTemEndereco() {
		
	}
	
	
}
