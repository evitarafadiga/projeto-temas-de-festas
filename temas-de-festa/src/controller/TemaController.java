package controller;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
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
			DateFormat df = DateFormat.getInstance();
			while ((line = br.readLine()) != null) {
				String[] tema = line.split(";");
				Tema data = new Tema(
						Integer.parseInt(tema[0]),
						null, 								// <----- TRATAR ESSA IMAGE
						Double.parseDouble(tema[1]),
						tema[2],
						df.parse(tema[3]),
						tema[4]);
				listaTema.inserir(data);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Erro ao carregar lista de tema");
			e.printStackTrace();
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
			System.out.println("Erro Salvamento");
		}
	}

	public int retornaTamanho() {
		return listaTema.tamanho();
	}

	public static void main(String[] args) {
		TemaController tc = new TemaController();

		System.out.println(tc.getListaTema().toString());
//		tc.saveListTema(tc.getListaTema());
	}

}
