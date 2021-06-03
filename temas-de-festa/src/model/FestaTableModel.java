package model;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import controller.dataStructures.list.Lista;

public class FestaTableModel extends AbstractTableModel {
	
    //aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela  
    private String colunas[] = {"Cliente ID", "Tema ID","Endereço", "Valor", "Despesas", "Descricao de Despesas", "Data/Hora Início", "Data/Hora Fim", "Selecionado"};
    private Lista<Festa> festa;
    private final int COLUNA_ID = 0;
    private final int COLUNA_IDTEMA = 1;
    private final int COLUNA_END = 2;
    private final int COLUNA_VALOR = 3;
    private final int COLUNA_DESPESAS = 4;
    private final int COLUNA_DESC = 5;
    private final int COLUNA_HORAI = 6;
    private final int COLUNA_HORAF = 7;
    private final int COLUNA_SELECT = 8;
    
   
    public FestaTableModel(Lista<Festa> festas) {
        this.festa = festas;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
    	return festa.tamanho();
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
        	case COLUNA_IDTEMA:
        		return Integer.class;
            case COLUNA_END:
                return String.class;
            case COLUNA_VALOR:
                return Double.class;
            case COLUNA_DESPESAS:
            	return Double.class;
            case COLUNA_DESC:
                return String.class;
            case COLUNA_HORAI:
                return String.class;
            case COLUNA_HORAF:
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
        Festa festa = this.festa.recuperar(rowIndex);
        DateFormat df = DateFormat.getInstance();
        switch (columnIndex) {
            
            case COLUNA_ID:
        		return festa.getCliente();
        	case COLUNA_IDTEMA:
        		return festa.getTema();
        	case COLUNA_END:
                return festa.getEndereco();
            case COLUNA_VALOR:
            	return festa.getValor();
            case COLUNA_DESPESAS:
            	return festa.getDespesas();
            case COLUNA_DESC:
                return festa.getDescricaoDespesas();
            case COLUNA_HORAI:
                return df.format(festa.getHoraInicio());
            case COLUNA_HORAF:
            	return df.format(festa.getHoraFim());
            case COLUNA_SELECT:
            	return festa.getSelect();
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
        Festa festa = this.festa.recuperar(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
        	case COLUNA_ID:
        		festa.setCliente((int) aValue);
        		break;
        	case COLUNA_IDTEMA:
        		festa.setTema((int) aValue);
        		break;
            case COLUNA_END:
                festa.setEndereco((Endereco) null);
                break;
            case COLUNA_VALOR:
                festa.setValor((Double) aValue);
                break;
            case COLUNA_DESPESAS:
            	festa.setDespesas((Double) aValue);
            	break;
            case COLUNA_DESC:
                festa.setDescricaoDespesas((String) aValue);
                break;
            case COLUNA_HORAI:
                festa.setHoraInicio((Date.valueOf((String) aValue)));
                break;
            case COLUNA_HORAF:
            	festa.setHoraFim((Date.valueOf((String) aValue)));
            case COLUNA_SELECT:
            	festa.setSelect((boolean) aValue);
           	break;
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}