package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import controller.dataStructures.list.Lista;

public class TemaTableModel extends AbstractTableModel {
	
    //aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela  
    private String colunas[] = {"ID", "Imagem","Valor", "STATUS", "Data Disponib.", "Descrição", "Selecionado"};
    private Lista<Tema> temas;
    private final int COLUNA_ID = 0;
    private final int COLUNA_IMG = 1;
    private final int COLUNA_VALOR = 2;
    private final int COLUNA_STATUS = 3;
    private final int COLUNA_DATA = 4;
    private final int COLUNA_DESC = 5;
    private final int COLUNA_SELECT = 6;
    
   
    public TemaTableModel(Lista<Tema> temas) {
        this.temas = temas;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
    	return temas.tamanho();
    }
    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        	case COLUNA_ID:
        		return Integer.class;
        	case COLUNA_IMG:
        		return Image.class;
            case COLUNA_VALOR:
                return Double.class;
            case COLUNA_STATUS:
                return String.class;
            case COLUNA_DATA:
            	return Date.class;
            case COLUNA_DESC:
                return String.class;
            case COLUNA_SELECT:
            	return Boolean.class;
            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tema tema = this.temas.recuperar(rowIndex);

        switch (columnIndex) {
            
            case COLUNA_ID:
        		return tema.getId();
        	case COLUNA_IMG:
        		return tema.getImg();
        	case COLUNA_VALOR:
                return tema.getValor();
            case COLUNA_STATUS:
            	return tema.getStatus();
            case COLUNA_DATA:
            	return tema.getDataDisponibilizacao();
            case COLUNA_DESC:
                return tema.getDescricao();
            case COLUNA_SELECT:
            	return tema.getSelect();
            default:
                return String.class;
        }
//        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        Tema tema = this.temas.recuperar(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
        	case COLUNA_ID:
        		tema.setId((int) aValue);
        		break;
        	case COLUNA_IMG:
        		tema.setImg((Image) aValue);
        		break;
            case COLUNA_VALOR:
                tema.setValor((double) aValue);
                break;
            case COLUNA_STATUS:
                tema.setStatus((String) aValue);
                break;
            case COLUNA_DATA:
            	tema.setDataDisponibilizacao((Date) aValue);
            	break;
            case COLUNA_DESC:
                tema.setDescricao((String) aValue);
                break;
            case COLUNA_SELECT:
            	tema.setSelect((boolean) aValue);
           	break;
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}