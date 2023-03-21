package se.iths.gamewithscoreboard;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Player {


    @Id
    @GeneratedValue
    Long id;
    Double average;

    String userName;

    @OneToMany(targetEntity = Result.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "playerfk", referencedColumnName = "id")
    List<Result> resultList;

    public Player(String name) {
        this.userName = name;
    }

    public Player() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Double getAverage() {
        return average;
    }

    public void addToList(Result result){
        resultList.add(result);
    }
    public void setAverage() {
        this.average = new CounterService().getAverageScore(resultList);
    }
}
