package controller;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import controller.dataStructures.list.Lista;
import model.Cliente;
import model.Endereco;

public class ClienteTableModel extends AbstractTableModel {
	
    //aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela  
    private String colunas[] = {"ID", "Data Prospec.","nome", "CPF/CNPJ", "Tel.", "E-Mail", "Endereco>>", "Selecionado"};
    private Lista<Cliente> clientes;
    private final int COLUNA_ID = 0;
    private final int COLUNA_DATE = 1;
    private final int COLUNA_NOME = 2;
    private final int COLUNA_CPF = 3;
    private final int COLUNA_TEL = 4;
    private final int COLUNA_EMAIL = 5;
    private final int COLUNA_ENDERECO = 6;
    private final int COLUNA_SELECT = 7;
    
   
    public ClienteTableModel(Lista<Cliente> clientes) {
        this.clientes = clientes;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
    	return clientes.tamanho();
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
        	case COLUNA_DATE:
        		return Date.class;
            case COLUNA_NOME:
                return String.class;
            case COLUNA_CPF:
                return Integer.class;
            case COLUNA_TEL:
            	return String.class;
            case COLUNA_EMAIL:
                return Integer.class;
            case COLUNA_ENDERECO:
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
        Cliente cliente = this.clientes.recuperar(rowIndex);

        switch (columnIndex) {
            
            case COLUNA_ID:
        		return cliente.getId();
        	case COLUNA_DATE:
        		return cliente.getDataProspeccao();
        	case COLUNA_NOME:
                return cliente.getNome();
            case COLUNA_CPF:
            	return cliente.getCpfcnpj();
            case COLUNA_TEL:
            	return cliente.getTelefone();
            case COLUNA_EMAIL:
                return cliente.getEmail();
            case COLUNA_ENDERECO:
                return cliente.getEndereco();
            case COLUNA_SELECT:
            	return cliente.getStatus();
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
        Cliente cliente = this.clientes.recuperar(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
        	case COLUNA_ID:
        		cliente.setId((int) aValue);
        		break;
        	case COLUNA_DATE:
        		cliente.setDataProspeccao((Date.valueOf((String) aValue)));
        		break;
            case COLUNA_NOME:
                cliente.setNome(String.valueOf(aValue));
                break;
            case COLUNA_CPF:
                cliente.setCpfcnpj((String) aValue);
                break;
            case COLUNA_TEL:
            	cliente.setTelefone((String) aValue);
            	break;
            case COLUNA_EMAIL:
                cliente.setEmail((String) aValue);
                break;
            case COLUNA_ENDERECO:
                cliente.setEndereco((Endereco) null);
                break;
            case COLUNA_SELECT:
            	cliente.setStatus((boolean) aValue);
           	break;
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}