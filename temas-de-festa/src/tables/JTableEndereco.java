package tables;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.dataStructures.list.Lista;
import model.ClienteTableModel;
import model.Endereco;
import model.EnderecoTableModel;
import model.Tema;
import model.Endereco;
import view.Menu;

public class JTableEndereco extends JFrame {

    private JTable tabela;
    private JScrollPane scrollPainel;

    public JTableEndereco() {
        renderizarTela();
    }

    private void renderizarTela() {
        
        //4 ojetos criados para popular a tabela
    
    	
        
        //cria um objeto do nosso model
        EnderecoTableModel model = new EnderecoTableModel(Menu.listaEnderecos);
        
        //instancia a tabela já com o model como argumento
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
				Endereco t = new Endereco();

				for (int i = 0; i < Menu.listaEnderecos.tamanho(); i++) {
					t = Menu.listaEnderecos.recuperar(i);
					if (t.getSelect() == true)
						try {
							Menu.listaEnderecos.remover(t);
							Menu.enderecoController.saveListEndereco(Menu.listaEnderecos);
							JOptionPane.showMessageDialog(null, "Tema removido com sucesso", "Informação",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Erro na remoção.", "Informação",
									JOptionPane.INFORMATION_MESSAGE);
						}
				}
				JTableEndereco cadTema = new JTableEndereco();
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
                JTableEndereco tb = new JTableEndereco();
                tb.setLocationRelativeTo(null);
                tb.setVisible(true);
            }
        });
    }
}