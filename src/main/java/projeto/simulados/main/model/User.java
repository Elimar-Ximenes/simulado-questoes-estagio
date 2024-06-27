package projeto.simulados.main.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize = 1)
    @Column(nullable = false, unique = true, name = "id")
    private int user_id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private Login login;

    @Column(name = "function")
    private String function;

    public User() {
        super();
    }

    public User(int user_id, String name, Login login, String function) {
        super();
        this.user_id = user_id;
        this.name = name;
        this.login = login;
        this.function = function;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", name=" + name + ", login=" + login + ", function=" + function + "]";
    }
}
