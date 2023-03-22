package se.iths.gamewithscoreboard;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Player {


    @Id
    @GeneratedValue
    private Long id;
    private Double average;

    private String userName;

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
        if(average == null)
            return 0.0;
        return average;
    }

    public void addToList(Result result){
        resultList.add(result);
    }
    public void setAverage() {
        this.average = new CounterService().getAverageScore(resultList);
    }
}
