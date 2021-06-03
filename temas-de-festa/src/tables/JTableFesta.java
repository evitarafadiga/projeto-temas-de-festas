package tables;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.MergeSort;
import controller.dataStructures.list.Lista;
import model.Cliente;
import model.ClienteTableModel;
import model.Endereco;
import model.Festa;
import model.FestaTableModel;
import model.Tema;
import view.Menu;

public class JTableFesta extends JFrame {
	
	public static Lista lista = new Lista();

	private JPanel contentPane;
    private JTable tabela;
    private JScrollPane scrollPainel;

    public JTableFesta() {
        renderizarTela();
    }

    private void renderizarTela() {
    	setTitle("Lista de Festas");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143,188,143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
       
        //cria um objeto do nosso model
		MergeSort ms = new MergeSort();
		Festa[] vetorFesta = ms.getListaFesta();
		Lista<Festa> newListaFesta = new Lista<Festa>();
		for(Festa dado : vetorFesta) {
			newListaFesta.inserir(dado);
		}
    	FestaTableModel model = new FestaTableModel(newListaFesta);
        
        //instancia a tabela já com o model como argumento
        this.tabela = new JTable(model);
        this.scrollPainel = new JScrollPane(tabela);
        scrollPainel.setBounds(0, 0, 790, 500);

        contentPane.add(scrollPainel);
        
        JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});

		btnSair.setBackground(new Color(211, 211, 211));
		btnSair.setBounds(25, 550, 250, 45);
		contentPane.add(btnSair);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Festa t = new Festa();

				for (int i = 0; i < Menu.listaFestas.tamanho(); i++) {
					t = Menu.listaFestas.recuperar(i);
					if (t.getSelect() == true)
						try {
							Menu.listaFestas.remover(t);
							if(!(Menu.listaFestas.estaVazia())) {
								Menu.festaController.saveListFesta(Menu.listaFestas);
							}
							JOptionPane.showMessageDialog(null, "Festa removida com sucesso", "Informação",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Erro na remoção.", "Informação",
									JOptionPane.INFORMATION_MESSAGE);
						}
				}
				JTableFesta cadTema = new JTableFesta();
				cadTema.setVisible(true);
				dispose();
			}
		});

		btnExcluir.setBackground(new Color(211, 211, 211));
		btnExcluir.setBounds(400, 550, 250, 45);
		contentPane.add(btnExcluir);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTableFesta tb = new JTableFesta();
                tb.setLocationRelativeTo(null);
                tb.setVisible(true);
            }
        });
    }
}