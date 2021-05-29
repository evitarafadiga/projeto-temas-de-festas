package model;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import controller.dataStructures.list.Lista;

public class EnderecoTableModel extends AbstractTableModel {
	
    //aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela  
    private String colunas[] = {"ID", "Logradouro","Cidade", "Estado", "N.", "Complemento", "Selecionado"};
    private Lista<Endereco> ends;
    private final int COLUNA_ID = 0;
    private final int COLUNA_LOG = 1;
    private final int COLUNA_CIDADE = 2;
    private final int COLUNA_ESTADO = 3;
    private final int COLUNA_NUM = 4;
    private final int COLUNA_COMP = 5;
    private final int COLUNA_SELECT = 6;
    
   
    public EnderecoTableModel(Lista<Endereco> end) {
        this.ends = end;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
    	return ends.tamanho();
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
        	case COLUNA_LOG:
        		return String.class;
            case COLUNA_CIDADE:
                return String.class;
            case COLUNA_ESTADO:
                return String.class;
            case COLUNA_NUM:
            	return String.class;
            case COLUNA_COMP:
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
        Endereco end = this.ends.recuperar(rowIndex);

        switch (columnIndex) {
            
            case COLUNA_ID:
        		return end.getIdCliente();
        	case COLUNA_LOG:
        		return end.getLogradouro();
        	case COLUNA_CIDADE:
                return end.getCidade();
            case COLUNA_ESTADO:
            	return end.getEstado();
            case COLUNA_NUM:
            	return end.getNumero();
            case COLUNA_COMP:
                return end.getComplemento();
            case COLUNA_SELECT:
            	return end.getSelect();
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
        Endereco end = this.ends.recuperar(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
        	case COLUNA_ID:
        		end.setIdCliente((int) aValue);
        		break;
        	case COLUNA_LOG:
        		end.setLogradouro((String) aValue);
        		break;
            case COLUNA_CIDADE:
                end.setCidade((String)(aValue));
                break;
            case COLUNA_ESTADO:
                end.setEstado((String) aValue);
                break;
            case COLUNA_NUM:
            	end.setNumero((int) aValue);
            	break;
            case COLUNA_COMP:
                end.setComplemento((String) aValue);
                break;
            case COLUNA_SELECT:
            	end.setSelect((boolean) aValue);
           	break;
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}