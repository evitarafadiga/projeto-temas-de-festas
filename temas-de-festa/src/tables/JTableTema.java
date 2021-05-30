package tables;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.dataStructures.list.Lista;
import model.ClienteTableModel;
import model.Endereco;
import model.EnderecoTableModel;
import model.Tema;
import model.TemaTableModel;
import model.Endereco;
import view.Menu;

public class JTableTema extends JFrame {

	private JTable tabela;
	private JScrollPane scrollPainel;
	private String selectedImagePath = "/temas-de-festa/src/images/broken-icon.gif";

	private int op;

	public JTableTema() {
		renderizarTela();
	}

	private void renderizarTela() {

		// 4 ojetos criados para popular a tabela

		// cria um objeto do nosso model
		TemaTableModel model = new TemaTableModel(Menu.listaTemas);

		// instancia a tabela já com o model como argumento
		this.tabela = new JTable(model);
		this.scrollPainel = new JScrollPane(tabela);

		this.add(scrollPainel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 576, 500);

		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});

		btnSair.setBackground(new Color(211, 211, 211));
		btnSair.setBounds(25, 380, 250, 45);
		scrollPainel.add(btnSair);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tema t = new Tema();

				for (int i = 0; i < Menu.listaTemas.tamanho(); i++) {
					t = Menu.listaTemas.recuperar(i);
					if (t.getSelect() == true)
						try {
							Menu.listaTemas.remover(t);
							;
							JOptionPane.showMessageDialog(null, "Tema removido com sucesso", "Informação",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Erro na remoção.", "Informação",
									JOptionPane.INFORMATION_MESSAGE);
						}
				}
				JTableTema cadTema = new JTableTema();
				cadTema.setVisible(true);
				dispose();
			}
		});

		btnExcluir.setBackground(new Color(211, 211, 211));
		btnExcluir.setBounds(280, 380, 250, 45);
		scrollPainel.add(btnExcluir);

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JTableTema tb = new JTableTema();
				tb.setLocationRelativeTo(null);
				tb.setVisible(true);
			}
		});
	}
}