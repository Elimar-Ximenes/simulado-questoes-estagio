package projeto.simulados.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MultipleChoiceQuestion extends Question{
    
    @Column(name = "option1")
    private String option1;

    public String getOption1() {
        return this.option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return this.option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return this.option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return this.option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    @Column(name = "option2")
    private String option2;

    @Column(name = "option3")
    private String option3;

    @Column(name = "option4")
    private String option4;

    public MultipleChoiceQuestion() {
        super();
    }

    public MultipleChoiceQuestion(int question_id, String question,
     String option1, String option2, String option3, String option4) {
        super(question_id, question);
    }

    public MultipleChoiceQuestion(int question_id, String question, int option, Teacher teacher, Topic topic,
     Answer answer, String option1, String option2, String option3, String option4) {
        super(question_id, question, option, teacher, topic, answer);
    }

    public MultipleChoiceQuestion(String option1, String option2, String option3, String option4) {
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
    

    @Override
    public String toString() {
        return "{" +
            " option1='" + getOption1() + "'" +
            ", option2='" + getOption2() + "'" +
            ", option3='" + getOption3() + "'" +
            ", option4='" + getOption4() + "'" +
            "}";
    }

}
