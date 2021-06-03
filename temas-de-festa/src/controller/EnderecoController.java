package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import controller.dataStructures.list.Lista;
import model.Endereco;

public class EnderecoController {
	final Path path = Paths.get("C:\\ed\\endereco.txt");
	static Lista<Endereco> lista = new Lista<Endereco>();

	public Lista<Endereco> getListaEndereco() {
		try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] end = line.split(";");
				Endereco data = new Endereco(
						Integer.parseInt(end[0]), //idCliente
						Integer.parseInt(end[1]), //idFesta
						end[2], //logradouro
						end[3], //cidade
						end[4], //estado
						Integer.parseInt(end[5]), //numero
						end[6], //complemento
						Boolean.parseBoolean(end[7]) //status
						);// Necessario fazer o link com endereço
				lista.inserir(data);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return lista;
	}

	public Endereco recuperar(int posicao) {
		return lista.recuperar(posicao);
	}
	public Endereco recuperarPorCliente(int idCliente) {
		for(int i=0; i < lista.tamanho();i++) {
			if(lista.recuperar(i).getIdCliente() == idCliente) {
				return lista.recuperar(i);
			}
		}
		return null;
	}
	
	public Endereco recuperarPorFesta(int idCliente, int idFesta) {
		for(int i=0; i < lista.tamanho();i++) {
			if((lista.recuperar(i).getIdFesta() == idFesta) && (lista.recuperar(i).getIdCliente() == idCliente)) {
				return lista.recuperar(i);
			}
		}
		return null;
	}
	
	public void saveListEndereco(Lista<Endereco> lista) {
		try {
			BufferedWriter bw = null;
			File file = new File(path.toString());
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(lista.montaTxt());
			bw.close();

		} catch (Exception e) {

		}
	}

	public int retornaTamanho() {
		return lista.tamanho();
	}

	public static void main(String[] args) {
		EnderecoController cc = new EnderecoController();
		System.out.println(cc.getListaEndereco().toString());
//		cc.saveListEndereco(cc.getListaEndereco());
		
	}
}