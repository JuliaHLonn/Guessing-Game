package se.iths.gamewithscoreboard;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterService {
    public double getAverageScore(List<Result> results){
        double sum = 0;
        for (Result result : results) {
            sum = sum + result.getResult();
        }
        return sum/results.size();
    }

}