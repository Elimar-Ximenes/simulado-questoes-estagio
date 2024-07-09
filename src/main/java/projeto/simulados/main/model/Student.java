package projeto.simulados.main.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student", schema = "public")
public class Student extends User {

    @ManyToMany
    @JoinTable(name = "denounced_questions",
               joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "question_id"))
    private List<Question> denouncedQuestions;

    @OneToMany(mappedBy = "student")
    private List<Monitor> monitors;

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

    public List<Monitor> getMonitors() {
        return monitors;
    }

    public void setMonitors(List<Monitor> monitors) {
        this.monitors = monitors;
    }

    @Override
    public String toString() {
        return super.toString() + " Student [denouncedQuestions=" + denouncedQuestions + ", monitors=" + monitors + "]";
    }
}
