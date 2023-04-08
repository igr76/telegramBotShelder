package main.java.com.example.test.record;

import lombok.*;
import lombok.experimental.FieldDefaults;
import main.java.com.example.test.entity.Report;
import java.io.Serializable;

/**
 * A DTO for the {@link Report} entity
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReportRecord implements Serializable {
    Long id;
    Long pet_id;
    byte[] photoPet;
    String diet;
    String reportAboutFeelings;
    String reportAboutHabits;
    String stateReport;
}