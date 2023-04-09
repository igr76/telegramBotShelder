package main.java.com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.com.example.test.entity.Report;

/**
 * Репозиторий для питомцев
 */
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

   Report getReportByPet_id(Long id);

}
