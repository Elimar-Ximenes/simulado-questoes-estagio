package projeto.simulados.main.model;

public enum QuestionType {
	OPENQUESTION(1), MULTIPLECHOOSEQUESTION(2), TRUEORFALSEQUESTION(3);

	private final int value;

	QuestionType(int valorOpcao) {
		this.value = valorOpcao;
	}

	public int getValor() {
		return value;
	}

	//Atualizado este parte do código para poder converter retorno de Enum em Int
	public static QuestionType valueOf(int value) {
        for (QuestionType type : values()) {
            if (type.getValor() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid QuestionType value: " + value);
    }

}
