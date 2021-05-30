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
import model.Tema;
import model.Cliente;
import model.Endereco;

public class TemaController {
	
	final Path path = Paths.get("C:\\ed\\tema.txt");
	Lista<Tema> listaTema = new Lista<Tema>();

	public Lista<Tema> getListaTema() {
		try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] tema = line.split(";");
				Tema data = new Tema(
						Integer.parseInt(tema[0]),
						null, 								// <----- TRATAR ESSA IMAGE
						Double.parseDouble(tema[2]),
						tema[3],
						new Date(tema[4]),
						tema[5]);
				listaTema.inserir(data);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return listaTema;
	}

	public Tema recuperar(int posicao) {
		return listaTema.recuperar(posicao);
	}

	public void saveListTema(Lista<Tema> lista) {
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
		return listaTema.tamanho();
	}

	public static void main(String[] args) {
		TemaController tc = new TemaController();

		System.out.println(tc.getListaTema().toString());
		tc.saveListTema(tc.getListaTema());
	}

}
