package main.java.com.example.test.record;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import main.java.com.example.test.record.PetRecord;
import java.util.List;
import main.java.com.example.test.entity.AdoptiveParent;
/**
 * A DTO for the {@link AdoptiveParent} entity
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdoptiveParentRecord implements Serializable {

    @JsonIgnore
    Long id;

    @NotNull(message = "Обязательно нужно заполнить поле")
    @Size(message = "Длина не должна быть меньше 5 знаков и не больше 30", min = 5, max = 30)
    String fullName;
    @NotNull(message = "Обязательно нужно заполнить поле")
    @Size(message = "Длина не должна быть меньше 5 знаков и не больше 30", min = 5, max = 30)
    String phone;

    @JsonIgnore
    boolean isParent;

    @JsonIgnore
    String state;

    @JsonIgnore
    Long chatId;
    @JsonIgnore
    List<PetRecord> pets;


}