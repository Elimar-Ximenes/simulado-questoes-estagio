package projeto.simulados.main.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

@Entity
public class Monitor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnore
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    @JsonIgnore
    private Teacher teacher;

    @Column(nullable = false)
    private LocalDateTime requestDate; //data solicitação monitoria

    //@Column(nullable = false)
    private LocalDateTime acceptanceOrRejectionDate; //Data de aceitação ou rejeição pelo professor

    @Column(length = 500)
    private String subjectDescription; //Descrição das disciplinas da Monitoria

    //@Column(nullable = false)
    private boolean accepted; //Resposta se foi aceita ou não

    // Default constructor
    public Monitor() {
    }

    // Constructor with parameters
    public Monitor(Student student, Teacher teacher, LocalDateTime requestDate, LocalDateTime acceptanceOrRejectionDate, String subjectDescription, boolean accepted) {
        this.student = student;
        this.teacher = teacher;
        this.requestDate = requestDate;
        this.acceptanceOrRejectionDate = acceptanceOrRejectionDate;
        this.subjectDescription = subjectDescription;
        this.accepted = accepted;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDateTime getAcceptanceOrRejectionDate() {
        return acceptanceOrRejectionDate;
    }

    public void setAcceptanceOrRejectionDate(LocalDateTime acceptanceOrRejectionDate) {
        this.acceptanceOrRejectionDate = acceptanceOrRejectionDate;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
