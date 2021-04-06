package controller.dataStructures.list;

public class No<T> {
	private T valor;
	private No<T> proximo;
	
	public No(T valor) {
		this.valor = valor;
		proximo = null;
	}
	
	public No<T> getProximo() {
		return this.proximo;
	}

	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}

	public T getValor() {
		return this.valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public String toString() {
		return this.valor.toString();
	}	
}