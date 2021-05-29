package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ClienteTableModel;
import controller.dataStructures.list.Lista;
import model.Cliente;
import model.Endereco;

public class JTableExample extends JFrame {

    private JTable tabela;
    private JScrollPane scrollPainel;

    public JTableExample() {
        renderizarTela();
    }

    private void renderizarTela() {
        
        //4 ojetos criados para popular a tabela
    
    	Lista<Cliente> lista = new Lista<>();
    	Endereco end = null;
        Cliente c = new Cliente(1,null,"Fulano da Silva","698654585","11977548392","fulano.123@yahoo.com.br",end);
        Cliente c1 = new Cliente(1,null,"Fulano da Silva","698654585","11977548392","fulano.123@yahoo.com.br",end);
        Cliente c2 = new Cliente(1,null,"Fulano da Silva","698654585","11977548392","fulano.123@yahoo.com.br",end);
        Cliente c3 = new Cliente(1,null,"Fulano da Silva","698654585","11977548392","fulano.123@yahoo.com.br",end);
        Cliente c4 = new Cliente(1,null,"Fulano da Silva","698654585","11977548392","fulano.123@yahoo.com.br",end);
        Cliente c5 = new Cliente(1,null,"Fulano da Silva","698654585","11977548392","fulano.123@yahoo.com.br",end);
        Cliente c6 = new Cliente(1,null,"Fulano da Silva","698654585","11977548392","fulano.123@yahoo.com.br",end);
        Cliente c7 = new Cliente(1,null,"Fulano da Silva","698654585","11977548392","fulano.123@yahoo.com.br",end);
        Cliente c8 = new Cliente(1,null,"Fulano da Silva","698654585","11977548392","fulano.123@yahoo.com.br",end);
        Cliente c9 = new Cliente(1,null,"Fulano da Silva","698654585","11977548392","fulano.123@yahoo.com.br",end);
        
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
        ClienteTableModel model = new ClienteTableModel(lista);
        
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
                JTableExample tb = new JTableExample();
                tb.setLocationRelativeTo(null);
                tb.setVisible(true);
            }
        });
    }
}