package projeto.simulados.main.repository;

import projeto.simulados.main.dto.MonitorDetailsDTO;
import projeto.simulados.main.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MonitorRepository extends JpaRepository<Monitor, Integer> {
    
    @Query("SELECT m FROM Monitor m WHERE m.student.id = :studentId")
    List<Monitor> findByStudentId(@Param("studentId") int studentId);

    @Query("SELECT m FROM Monitor m WHERE m.teacher.id = :teacherId")
    List<Monitor> findByTeacherId(@Param("teacherId") int teacherId);

    @Query("SELECT m FROM Monitor m WHERE m.student.id = :studentId AND m.teacher.id = :teacherId")
    List<Monitor> findByStudentIdAndTeacherId(@Param("studentId") int studentId, @Param("teacherId") int teacherId);

    //---------------------------
    
    @Query("SELECT new projeto.simulados.main.dto.MonitorDetailsDTO(m.id, s.id, t.id, m.requestDate, m.acceptanceOrRejectionDate, m.subjectDescription, m.accepted) " +
           "FROM Monitor m " +
           "JOIN m.student s " +
           "JOIN m.teacher t " +
           "WHERE m.student.id = :studentId")
    List<MonitorDetailsDTO> findByStudentIdWithDetails(@Param("studentId") int studentId);
    
    
    @Query("SELECT new projeto.simulados.main.dto.MonitorDetailsDTO(m.id, s.id, t.id, m.requestDate, m.acceptanceOrRejectionDate, m.subjectDescription, m.accepted) " +
           "FROM Monitor m " +
           "JOIN m.student s " +
           "JOIN m.teacher t " +
           "WHERE m.teacher.id = :teacherId")
    List<MonitorDetailsDTO> findByTeacherIdWithDetails(@Param("teacherId") int teacherId);

    @Query("SELECT new projeto.simulados.main.dto.MonitorDetailsDTO(m.id, s.id, t.id, m.requestDate, m.acceptanceOrRejectionDate, m.subjectDescription, m.accepted) " +
           "FROM Monitor m " +
           "JOIN m.student s " +
           "JOIN m.teacher t " +
           "WHERE m.student.id = :studentId AND m.teacher.id = :teacherId")
    List<MonitorDetailsDTO> findByStudentAndTeacherIdWithDetails(@Param("studentId") int studentId, @Param("teacherId") int teacherId);


}
