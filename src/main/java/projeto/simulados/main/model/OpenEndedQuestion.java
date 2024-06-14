package projeto.simulados.main.model;
import javax.persistence.Entity;

@Entity
public class OpenEndedQuestion extends Question {
    public OpenEndedQuestion() {
        super();
    }

    public OpenEndedQuestion(int question_id, String question) {
        super(question_id, question);
    }

    public OpenEndedQuestion(int question_id, String question, int option, Teacher teacher, Topic topic, Answer answer) {
        super(question_id, question, option, teacher, topic, answer);
    }

}

