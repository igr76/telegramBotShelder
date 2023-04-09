package main.java.com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.com.example.test.entity.Shelter;

/**
 * Репозиторий для приюта
 */
@Repository
public interface ShelterRepo extends JpaRepository<Shelter, Long> {

}
