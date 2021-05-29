package tables;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

    public JTableTema() {
        renderizarTela();
    }

    private void renderizarTela() {
        
        //4 ojetos criados para popular a tabela
    	   	
    	JLabel imageLabel = new JLabel();
        ImageIcon imageicon = new ImageIcon(selectedImagePath);
        Image img = imageicon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
    	
    	Lista<Tema> lista = new Lista<>();
    	Tema c = new Tema(1,img,2.89,"Disponível",null,"Tema de festa infantil");
    	Tema c1 = new Tema(1,img,2.89,"Disponível",null,"Tema de festa infantil");
    	Tema c2 = new Tema(1,img,2.89,"Disponível",null,"Tema de festa infantil");
    	Tema c3 = new Tema(1,img,2.89,"Disponível",null,"Tema de festa infantil");
    	Tema c4 = new Tema(1,img,2.89,"Disponível",null,"Tema de festa infantil");
    	Tema c5 = new Tema(1,img,2.89,"Disponível",null,"Tema de festa infantil");
    	Tema c6 = new Tema(1,img,2.89,"Disponível",null,"Tema de festa infantil");
    	Tema c7 = new Tema(1,img,2.89,"Disponível",null,"Tema de festa infantil");
    	Tema c8 = new Tema(1,img,2.89,"Disponível",null,"Tema de festa infantil");
    	Tema c9 = new Tema(1,img,2.89,"Disponível",null,"Tema de festa infantil");
        
       
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
        TemaTableModel model = new TemaTableModel(lista);
        
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
                JTableTema tb = new JTableTema();
                tb.setLocationRelativeTo(null);
                tb.setVisible(true);
            }
        });
    }
}