package org.example.service;

import org.example.model.Category;
import org.example.model.Pet;
import org.example.model.Tag;
import org.example.repository.PetRepositoryImpl;
import org.example.service.interfaces.PetService;
import java.io.File;
import java.util.List;

public class PetServiceImpl implements PetService {

  private final PetRepositoryImpl petRepository = new PetRepositoryImpl();

  @Override
  public void uploadImage(File file, Integer petId) {
    petRepository.uploadImage(file, petId);
  }

  @Override
  public void findPetByStatus(String status) {
    petRepository.findPetByStatus(status);
  }

  @Override
  public void create(
      Integer id,
      String name,
      String status,
      Category category,
      List<String> images,
      List<Tag> tagList) {
    Pet pet = new Pet();
    pet.setId(id);
    pet.setName(name);
    pet.setStatus(status); // available, pending, sold
    pet.setCategory(category);
    pet.setTags(tagList);
    pet.setPhotoUrls(images);
    petRepository.create(pet);
  }

  @Override
  public void update(
      Integer id,
      String name,
      String status,
      Category category,
      List<String> images,
      List<Tag> tagList) {
    Pet pet = new Pet();
    pet.setId(id);
    pet.setName(name);
    pet.setStatus(status); // available, pending, sold
    pet.setCategory(category);
    pet.setTags(tagList);
    pet.setPhotoUrls(images);
    petRepository.update(pet);
  }

  @Override
  public void get(Integer petId) {
    petRepository.get(petId);
  }

  @Override
  public void updatePut(
      Integer id,
      String name,
      String status,
      Category category,
      List<String> images,
      List<Tag> tagList) {
    Pet pet = new Pet();
    pet.setId(id);
    pet.setName(name);
    pet.setStatus(status); // available, pending, sold
    pet.setCategory(category);
    pet.setTags(tagList);
    pet.setPhotoUrls(images);
    petRepository.updatePut(pet);
  }

  @Override
  public void delete(Integer petId) {
    petRepository.delete(petId);
  }
}
