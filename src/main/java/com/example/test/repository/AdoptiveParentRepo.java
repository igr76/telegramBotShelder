package main.java.com.example.test.repository;

import main.java.com.example.test.entity.AdoptiveParent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для усыновителей
 */
//@Repository
public interface AdoptiveParentRepo extends JpaRepository<AdoptiveParent, Long> {
    AdoptiveParent getAdoptiveParentByFullName(String fullName);
    AdoptiveParent getAdoptiveParentByPhone(String phone);
    AdoptiveParent getAdoptiveParentByChatId(Long chatId);




}
