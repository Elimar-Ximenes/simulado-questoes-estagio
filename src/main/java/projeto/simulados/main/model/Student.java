package projeto.simulados.main.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student", schema = "public")
public class Student extends User {

    @ManyToMany
    @JoinTable(name = "denounced_questions",
               joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "question_id"))
    private List<Question> denouncedQuestions;

    public Student() {
        super();
    }

    public Student(int user_id, String name, Login login, String function) {
        super(user_id, name, login, function);
    }

    public List<Question> getDenouncedQuestions() {
        return denouncedQuestions;
    }

    public void setDenouncedQuestions(List<Question> denouncedQuestions) {
        this.denouncedQuestions = denouncedQuestions;
    }

    @Override
    public String toString() {
        return super.toString() + " Student [denouncedQuestions=" + denouncedQuestions + "]";
    }
}
