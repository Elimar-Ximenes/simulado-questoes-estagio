package projeto.simulados.main.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Monitor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    //@Column(nullable = false)
    private LocalDateTime dataSolicitacao;

    //@Column(nullable = false)
    private LocalDateTime dataDeAceitacao;

    @Column(length = 500)
    private String descricaoDisciplinasMonitoria;

    // Construtor padrão
    public Monitor() {
        
    }

    // Construtor com parâmetros (opcional)
    public Monitor(Student student, Teacher teacher, LocalDateTime dataSolicitacao, LocalDateTime dataDeAceitacao, String descricaoDisciplinasMonitoria) {
        this.student = student;
        this.teacher = teacher;
        this.dataSolicitacao = dataSolicitacao;
        this.dataDeAceitacao = dataDeAceitacao;
        this.descricaoDisciplinasMonitoria = descricaoDisciplinasMonitoria;
    }

    // Getters e setters
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

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDateTime getDataDeAceitacao() {
        return dataDeAceitacao;
    }

    public void setDataDeAceitacao(LocalDateTime dataDeAceitacao) {
        this.dataDeAceitacao = dataDeAceitacao;
    }

    public String getDescricaoDisciplinasMonitoria() {
        return descricaoDisciplinasMonitoria;
    }

    public void setDescricaoDisciplinasMonitoria(String descricaoDisciplinasMonitoria) {
        this.descricaoDisciplinasMonitoria = descricaoDisciplinasMonitoria;
    }
}
