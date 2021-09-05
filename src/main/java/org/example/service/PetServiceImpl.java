package org.example.service;

import org.example.model.Category;
import org.example.model.Pet;
import org.example.repository.PetRepositoryImpl;
import org.example.service.interfaces.PetService;
import java.io.File;
import java.util.List;

public class PetServiceImpl implements PetService<Pet, Integer> {

  private final PetRepositoryImpl petRepository = new PetRepositoryImpl();

  @Override
  public Integer findPetByStatus(String status) {
    return petRepository.findPetByStatus(status);
  }

  @Override
  public Pet create(
      Integer id,
      String name,
      String status,
      Category category,
      List<Object> images,
      List<Object> tagList) {
    Pet pet = new Pet();
    pet.setId(Long.valueOf(id));
    pet.setName(name);
    pet.setCategory(category);
    pet.setTags(tagList);
    pet.setPhotoUrls(images);
    return petRepository.create(pet);
  }

  @Override
  public Integer uploadImage(File file, Integer petId) {
    return petRepository.uploadImage(file, petId);
  }

  @Override
  public Integer update(
      Integer id,
      String name,
      String status,
      Category category,
      List<Object> images,
      List<Object> tagList) {
    Pet pet = new Pet();
    pet.setId(Long.valueOf(id));
    pet.setName(name);
    pet.setCategory(category);
    pet.setTags(tagList);
    pet.setPhotoUrls(images);
    return petRepository.update(pet, name);
  }

  @Override
  public Integer updatePut(
      Integer id,
      String name,
      String status,
      Category category,
      List<Object> images,
      List<Object> tagList) {
    Pet pet = new Pet();
    pet.setId(Long.valueOf(id));
    pet.setName(name);
    pet.setCategory(category);
    pet.setTags(tagList);
    pet.setPhotoUrls(images);
    return petRepository.updatePut(pet);
  }

  @Override
  public Integer delete(Integer petId) {
    return petRepository.delete(String.valueOf(petId));
  }

  @Override
  public Pet findById(Integer petId) {
    return petRepository.get(String.valueOf(petId));
  }
}
