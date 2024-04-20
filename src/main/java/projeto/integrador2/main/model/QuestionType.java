package projeto.integrador2.main.model;

public enum QuestionType {
	OPENQUESTION(1), MULTIPLECHOOSEQUESTION(2), TRUEORFALSEQUESTION(3);

	private final int value;

	QuestionType(int valorOpcao) {
		value = valorOpcao;
	}

	public int getValor() {
		return value;
	}

}
