package entities;

public class Aluno {

	private char[] gabarito = new char[10];
	private String nome;


	public Aluno(char[] gabarito, String nome) {
		this.gabarito = gabarito;
		this.nome = nome;
	}


	public char[] getGabarito() {
		return gabarito;
	}


	public void setGabarito(char[] gabarito) {
		this.gabarito = gabarito;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public boolean respostasIguais() {
		char primeiro = gabarito[0];
		for (int i = 1; i < gabarito.length; i++) {
			if (gabarito[i] != primeiro) return false;
		}
		return true;
	}

}
