package main.java.com.example.test.record;

import lombok.*;
import lombok.experimental.FieldDefaults;
import main.java.com.example.test.entity.Shelter;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import main.java.com.example.test.record.PetRecord;
import main.java.com.example.test.record.VolunteerRecord;
/**
 * A DTO for the {@link Shelter} entity
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShelterRecord implements Serializable {
    Long id;
    String aboutShelter;
    String shelterSafetyEquipment;
    String ruleOfMeeting;
    List<String> listOfDoc;
    String recOfTransportation;
    String homeImprovementForYoungPet;
    String homeImprovementForPet;
    String homeImprovementForPetWithDisabilities;
    String cynologistAdvice;
    List<String> cynologist;
    List<String> listOfReasonForRejection;
    Set<PetRecord> pets;
    Set<VolunteerRecord> volunteers;
    byte[] locationMap;
}