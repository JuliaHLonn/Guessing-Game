package se.iths.gamewithscoreboard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Result {
    int result = 0;

    @Id
    @GeneratedValue
    private Long id;


    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
