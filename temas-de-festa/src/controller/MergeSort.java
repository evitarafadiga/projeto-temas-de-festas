package controller;

import java.util.Arrays;
import java.util.Date;

import controller.dataStructures.list.Lista;
import model.Endereco;
import model.Festa;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		Festa[] lista = ms.getListaFesta();
		// teste
		for(Festa dado : lista) {
			System.out.println(dado.toString());
		}
	}

	public Festa[] getListaFesta() {
		Festa festa;

		FestaController fc = new FestaController();

		fc.getListaFesta();

		Festa[] lista = new Festa[fc.retornaTamanho()];

		for (int i = 0; i < fc.retornaTamanho(); i++) {
			festa = fc.recuperar(i);
				lista[i] = new Festa(
						festa.getCliente(), // cliente;
						festa.getTema(), //tema;
						festa.getEndereco(), //endereco;
						festa.getValor(), //valor;
						festa.getDespesas(), //despesas;
						festa.getDesconto(), //desconto;
						festa.getDescricaoDespesas(), //descricaoDespesas;
						festa.getHoraInicio(),//horaInicio;
						festa.getHoraFim(), //horaFim;
						festa.getSelect()//select;
				);
			}

    	mergeSort(lista, 0, lista.length-1);
		return lista;
	}

	public static void mergeSort(Festa[] a, int from, int to) {
		if (from == to) {
			return;
		}
		int mid = (from + to) / 2;

		mergeSort(a, from, mid);
		mergeSort(a, mid + 1, to);
		merge(a, from, mid, to);
	}

	public static void merge(Festa[] a, int from, int mid, int to) {
		int n = to - from + 1;
		Festa[] b = new Festa[n];
		int i1 = from;
		int i2 = mid + 1;
		int j = 0;

		while (i1 <= mid && i2 <= to) {
			if (a[i1].getHoraInicio().before(a[i2].getHoraInicio())) { //Necessário alterar para comparar datas
				b[j] = a[i1];
				i1++;
			} else {
				b[j] = a[i2];
				i2++;
			}
			j++;
		}
		while (i1 <= mid) {
			b[j] = a[i1];
			i1++;
			j++;
		}
		while (i2 <= to) {
			b[j] = a[i2];
			i2++;
			j++;
		}
		for (j = 0; j < n; j++) {
			a[from + j] = b[j];
		}
	}
}