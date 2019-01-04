package com.petrego.petrego.dao;

import com.petrego.petrego.JpaTestBase;
import com.petrego.petrego.domain.PetType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class PetRepositoryTest extends JpaTestBase {

    private static final String NAME = "Test Pet";
    private static final String EXISTINGPET = "Rocky";
    private static final Long EXISTINGOWNER = 1L;

    @Autowired
    private PetRepository petRepository;

    @Test
    public void givenPet_whenSave_thenPersisted() {
        // Given new pet
        Pet pet = new Pet();
        pet.setName(NAME);
        pet.setPetType(PetType.dog);

        // When save
        petRepository.save(pet);

        // Then pet information should be persisted
        Pet persistedPet = petRepository.findById(pet.getId()).get();
        assertNotNull(persistedPet);
    }
}
