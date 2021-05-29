package tables;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.dataStructures.list.Lista;
import model.ClienteTableModel;
import model.Endereco;
import model.EnderecoTableModel;
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
    
    	Lista<Endereco> lista = new Lista<>();
    	Endereco end = null;
        Endereco c = new Endereco(1, "R. dos Bobos", "São Paulo", "SP", 155, "prox. a via ...");
        Endereco c1 = new Endereco(1, "R. dos Bobos", "São Paulo", "SP", 155, "prox. a via ...");
        Endereco c2 = new Endereco(1, "R. dos Bobos", "São Paulo", "SP", 155, "prox. a via ...");
        Endereco c3 = new Endereco(1, "R. dos Bobos", "São Paulo", "SP", 155, "prox. a via ...");
        Endereco c4 = new Endereco(1, "R. dos Bobos", "São Paulo", "SP", 155, "prox. a via ...");
        Endereco c5 = new Endereco(1, "R. dos Bobos", "São Paulo", "SP", 155, "prox. a via ...");
        Endereco c6 = new Endereco(1, "R. dos Bobos", "São Paulo", "SP", 155, "prox. a via ...");
        Endereco c7 = new Endereco(1, "R. dos Bobos", "São Paulo", "SP", 155, "prox. a via ...");
        Endereco c8 = new Endereco(1, "R. dos Bobos", "São Paulo", "SP", 155, "prox. a via ...");
        Endereco c9 = new Endereco(1, "R. dos Bobos", "São Paulo", "SP", 155, "prox. a via ...");
       
        lista.inserir(c);
        lista.inserir(c1);
        lista.inserir(c2);
        lista.inserir(c3);
        lista.inserir(c4);
        lista.inserir(c5);
        lista.inserir(c6);
        lista.inserir(c7);
        lista.inserir(c8);
        lista.inserir(c9);
        
        //cria um objeto do nosso model
        EnderecoTableModel model = new EnderecoTableModel(lista);
        
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
			}
		});
		
		btnSair.setBackground(new Color(211,211,211));
		btnSair.setBounds(25, 211, 512, 45);
		scrollPainel.add(btnSair);
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