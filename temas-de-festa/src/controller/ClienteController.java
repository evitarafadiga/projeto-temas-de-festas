package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import controller.dataStructures.list.Lista;
import model.Cliente;
import model.Endereco;

public class ClienteController {
	
	final Path path = Paths.get(resourcePath());
	Lista<Cliente> lista = new Lista<Cliente>();

	public Lista<Cliente> getListaCliente() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] cliente = line.split(";");
				Cliente data = new Cliente(
						Integer.parseInt(cliente[0]), 
						new Date(cliente[1]),
						cliente[2], 
						cliente[3], 
						cliente[4], 
						cliente[5], 
						new Endereco());
				lista.inserir(data);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return lista;
	}

	public Cliente recuperar(int posicao) {
		return lista.recuperar(posicao);
	}

	public void saveListCliente(Lista<Cliente> lista) {
		try {
			BufferedWriter bw = null;
			File file = new File(path.toString());		
			if (!file.exists())
			    Files.createFile(file.toPath());
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(lista.montaTxt());
			bw.close();

		} catch (Exception e) {
			System.out.println("Erro de salvamento de arquivo.");
		}
	}

	public int retornaTamanho() {
		return lista.tamanho();
	}
	
	static String resourcePath() {
		String resourcePath = null; 
		switch (System.getProperty("os.name")) {
		            case "Linux":  resourcePath = System.getProperty("user.home")+"/ProjetoED/data/cliente";
		            return resourcePath;
		            
		            case "Windows":  resourcePath = "D:\\Desenvolvimento\\ProjetoED\\ProjetoED\\src\\data\\cliente.txt";
		            return resourcePath;
		            default:
		            return null;
		}
	}
	
	static void fileExists() {
		Path path = Path.of(resourcePath());
		boolean exists = Files.exists(path);
		System.out.println("exists = " + exists);
	}

	public static void main(String[] args) {
		ClienteController cc = new ClienteController();
		System.out.println(cc.getListaCliente().toString());
		cc.saveListCliente(cc.getListaCliente());
	}
}
