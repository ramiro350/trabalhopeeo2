package entities;

public class Disciplina {
	private String disciplina;
	private char[] gabaritooficial = new char[10];

	public Disciplina() {
	}




	public Disciplina(String disciplina, char[] gabaritooficial) {
		super();
		this.disciplina = disciplina;
		this.gabaritooficial = gabaritooficial;
	}


	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}



	public char[] getGabaritooficial() {
		return gabaritooficial;
	}




	public void setGabaritooficial(char[] gabaritooficial) {
		this.gabaritooficial = gabaritooficial;
	}




	public String toString() {
		return disciplina;
	}




}