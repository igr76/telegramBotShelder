package com.example.test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import main.java.com.example.test.entity.AdoptiveParent;
import main.java.com.example.test.entity.Pet;
import main.java.com.example.test.entity.Shelter;
import main.java.com.example.test.mapper.PetMapper;
import main.java.com.example.test.record.PetRecord;
import main.java.com.example.test.repository.AdoptiveParentRepo;
import main.java.com.example.test.repository.PetRepository;
import main.java.com.example.test.service.TestPeriodService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class TestPeriodServiceTest {

    @Mock
    PetRepository petRepository;
    @Mock
    AdoptiveParentRepo adoptiveParentRepo;
    @Mock
    PetMapper petMapper;
    @InjectMocks
    TestPeriodService out;
    PetMapper mapper = new PetMapperImpl();

    @Test
    public void getPetsDoesntHaveParentTest() {
        Pet pet = getTestPet();

        lenient().when(petRepository.findPetByAdoptiveParentIsNull()).thenReturn(List.of(pet));
        lenient().when(petMapper.toRecordList(anyCollection())).thenReturn(mapper.toRecordList(List.of(pet)));

        Collection<PetRecord> actual = out.getPetsDoesntHaveParent();
        Collection<PetRecord> excepted = mapper.toRecordList(List.of(pet));
        assertEquals(actual.size(), 1);
        assertTrue(actual.containsAll(excepted));
    }

    @Test
    public void getPetsDoesntHaveParentEmptyTest() {

        lenient().when(petRepository.findPetByAdoptiveParentIsNull()).thenReturn(List.of());
        lenient().when(petMapper.toRecordList(anyCollection())).thenReturn(List.of());

        Collection<PetRecord> actual = out.getPetsDoesntHaveParent();
        assertTrue(actual.isEmpty());
    }

    /**
     * пет для теста
     * @return
     */
    private Pet getTestPet() {
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setFullName("Шарик Бобикович");
        pet.setAge("3");
        pet.setDescription("двортерьер");
        pet.setFileSize(1024);
        pet.setShelter(getTestShelter());
        pet.setPhoto(null);
        pet.setMediaType("");
        pet.setReports(List.of());
        pet.setAdoptiveParent(null);
        return pet;
    }

    /**
     * коллекция петов
     * @return
     */
    private List<Pet> getTestPetList() {
        List<Pet> pets = new ArrayList<>();

        Pet pet = new Pet();
        pet.setId(2L);
        pet.setFullName("Бобик");
        pet.setAge("5");
        pet.setDescription("двортерьер");
        pet.setFileSize(1024);
        pet.setShelter(getTestShelter());
        pet.setPhoto(null);
        pet.setMediaType("");
        pet.setReports(List.of());
        pet.setAdoptiveParent(getTestAdoptiveParent());

        pets.add(pet);
        pets.add(getTestPet());
        return pets;
    }

    /**
     * шелтер для теста
     * @return
     */
    private static Shelter getTestShelter() {
        Shelter shelter = new Shelter();
        shelter.setId(1L);
        return shelter;
    }

    private AdoptiveParent getTestAdoptiveParent() {
        AdoptiveParent parent = new AdoptiveParent();
        parent.setId(1L);
        parent.setFullName("Иванов Иван Иванович");
        return parent;
    }
}