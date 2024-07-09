package projeto.simulados.main.dto;

import java.time.LocalDateTime;

public class MonitorDetailsDTO {
    private int id;
    private int studentId;
    private int teacherId;
    private LocalDateTime requestDate;
    private LocalDateTime acceptanceOrRejectionDate;
    private String subjectDescription;
    private boolean accepted;
    private String studentName;
    private String teacherName;

    public MonitorDetailsDTO(int id, int studentId, int teacherId, LocalDateTime requestDate, LocalDateTime acceptanceOrRejectionDate, String subjectDescription, boolean accepted, String studentName, String teacherName) {
        this.id = id;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.requestDate = requestDate;
        this.acceptanceOrRejectionDate = acceptanceOrRejectionDate;
        this.subjectDescription = subjectDescription;
        this.accepted = accepted;
        this.studentName = studentName;
        this.teacherName = teacherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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
    
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
