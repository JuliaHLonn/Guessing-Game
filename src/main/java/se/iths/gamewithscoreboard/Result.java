package se.iths.gamewithscoreboard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
public class Result {
    private int result = 0;

    private String timeDate;
    @Id
    @GeneratedValue
    private Long id;

    public Result() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        timeDate = localDateTime.format(formatter);

    }

    public String getTimeDate() {
        return timeDate;
    }

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
