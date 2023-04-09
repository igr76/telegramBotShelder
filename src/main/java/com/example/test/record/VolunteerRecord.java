package main.java.com.example.test.record;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import main.java.com.example.test.entity.Volunteer;
import java.io.Serializable;
import main.java.com.example.test.entity.Shelter;
/**
 * A DTO for the {@link Volunteer} entity
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VolunteerRecord implements Serializable {
    Long id;
    String fullName;
    String phone;
    String infoVolunteer;
    String schedule;
    @JsonIgnore
    Shelter shelter;

    @Override
    public String toString() {
        return "Меня зовут " + fullName + ", мой телефон для связи " + phone +
                ", доступен : " + schedule + ".";
    }
}