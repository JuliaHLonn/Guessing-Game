package se.iths.gamewithscoreboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository <Player, Long> {

Player findByuserName(String name);


}
