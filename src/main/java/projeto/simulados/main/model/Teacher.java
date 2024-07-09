package projeto.simulados.main.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "teacher", schema = "public")
public class Teacher extends User {

    @OneToMany(mappedBy = "teacher")
    private List<Topic> topics;

    @OneToMany(mappedBy = "teacher")
    private List<Monitor> monitors;

    public Teacher() {
        super();
    }

    public Teacher(int user_id, String name, Login login, String function) {
        super(user_id, name, login, function);
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Monitor> getMonitors() {
        return monitors;
    }

    public void setMonitors(List<Monitor> monitors) {
        this.monitors = monitors;
    }

    @Override
    public String toString() {
        return super.toString() + " Teacher [topics=" + topics + ", monitors=" + monitors + "]";
    }
}
