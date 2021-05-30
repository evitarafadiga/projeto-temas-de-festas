package controller;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import controller.dataStructures.list.Lista;
import model.Festa;
import model.Tema;
import model.Cliente;
import model.Endereco;

public class FestaController {
	
	final Path path = Paths.get("C:\\ed\\festa.txt");
	Lista<Festa> listaFesta = new Lista<Festa>();

	public Lista<Festa> getListaFesta() {
		try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] festa = line.split(";");
				Festa data = new Festa(
						Integer.parseInt(festa[0]),
						Integer.parseInt(festa[1]),
						new Endereco(),
						Double.parseDouble(festa[3]),
						Double.parseDouble(festa[4]),
						Double.parseDouble(festa[5]),
						festa[6],
						new Date(festa[7]),
						new Date(festa[8]));
				listaFesta.inserir(data);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return listaFesta;
	}

	public Festa recuperar(int posicao) {
		return listaFesta.recuperar(posicao);
	}

	public void saveListFesta(Lista<Festa> lista) {
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
		return listaFesta.tamanho();
	}

	public static void main(String[] args) {
		FestaController fc = new FestaController();
		System.out.println(fc.getListaFesta().toString());
		fc.saveListFesta(fc.getListaFesta());
	}

}
