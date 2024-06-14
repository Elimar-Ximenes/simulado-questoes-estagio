package projeto.simulados.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TrueOrFalseQuestion extends Question {
    @Column(name = "choice")
    private boolean choice;

    public TrueOrFalseQuestion() {
        super();
    }


    public TrueOrFalseQuestion(boolean choice) {
        this.choice = choice;
    }

    public boolean isChoice() {
        return this.choice;
    }

    public boolean getChoice() {
        return this.choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
    }
    

    @Override
    public String toString() {
        return "{" +
            " choice='" + isChoice() + "'" +
            "}";
    }
    
}

