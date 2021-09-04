package org.example.repository;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import okhttp3.*;
import org.example.config.HttpConnect;
import org.example.model.Pet;
import org.example.repository.interfaces.PetRepository;
import org.example.util.PropertiesLoader;
import java.io.File;
import java.net.URI;

public class PetRepositoryImpl implements PetRepository {

  private final OkHttpClient OK_CLIENT = HttpConnect.getInstance();
  private final String URI_PET = PropertiesLoader.getProperties("uriPet");
  private final Gson GSON = new Gson();

  // 200 upload Image
  @SneakyThrows
  @Override
  public void uploadImage(File file, Integer petId) {
    file = new File("/Users/zeka/Dropbox/Mac/Desktop/logo-square.png");
    URI uri = URI.create(URI_PET + "/" + petId + "/uploadImage");
    RequestBody requestBody =
        new MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart(
                "file", file.getName(), RequestBody.create(MediaType.parse("image/png"), file))
            .build();
    Response response =
        OK_CLIENT
            .newCall(new Request.Builder().post(requestBody).url(HttpUrl.get(uri)).build())
            .execute();
    // System.out.println("uploadFile2 $  " + response.code());
    System.out.println("uploadFile2 $  " + response.body().string());
    response.close();
  }
  // 200 by id/api-key=abc
  @SneakyThrows
  @Override
  public void delete(Integer petId) {
    URI uri = URI.create(URI_PET + "/" + petId);
    Request request = new Request.Builder().url(HttpUrl.get(uri)).delete().build();
    Response response = OK_CLIENT.newCall(request).execute();
    // System.out.println("DELETE PET $ " + response.code());
    System.out.println("DELETE PET $ " + response.body().string());
    response.close();
  }
  // 200 find by status // available  / pending  / sold
  @SneakyThrows
  @Override
  public void findPetByStatus(String status) {
    URI uri = URI.create(URI_PET + "/findByStatus?status=" + status);
    Request request = new Request.Builder().url(HttpUrl.get(uri)).get().build();
    Response response = OK_CLIENT.newCall(request).execute();
    // System.out.println("findByStatus $ " + response.code());
    System.out.println("findByStatus $ " + response.body().string());
    response.close();
  }
  // 200  add a new pet// Pet object that needs to be added to the store
  @SneakyThrows
  @Override
  public Pet create(Pet pet) {
    URI uri = URI.create(URI_PET + "/");
    //    pet = new Pet();
    //    pet.setId(1);
    //    pet.setName("Pet1");
    //    pet.setStatus("200");
    //      pet.setCategory();
    //      pet.setPhotoUrls("200");
    //      pet.setTags("abcabc");

    // Gson gson = new Gson();
    // String toJson = GSON.toJson(pet);

    RequestBody requestBody =
        new Request.Builder()
            .url(HttpUrl.get(uri))
            .post(
                RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"), GSON.toJson(pet)))
            .header("Content-type", "application/json")
            .build()
            .body();
    Response response =
        OK_CLIENT
            .newCall(new Request.Builder().url(HttpUrl.get(uri)).post(requestBody).build())
            .execute();
    // System.out.println("Create pet $ " + response.code());
    System.out.println("Add pet(POST) pet $ " + response.body().string());
    response.close();
    return GSON.fromJson(response.body().string(), Pet.class);
  }
  // 200 update //id/name/status
  @SneakyThrows
  @Override
  public Integer update(Pet pet,String petName) {
    // https://petstore.swagger.io/v2/pet
    URI uri = URI.create(URI_PET);

    //    List<Tag> tagList = new ArrayList<>();
    //    String[] fotosList = new String[10];
    //
    //    Category category = new Category();
    //    category.setId(1);
    //    category.setName("Category1");
    //
    //    Tag tag = new Tag();
    //    tag.setId(1);
    //    tag.setName("Tag1");
    //
    //    pet = new Pet();
    //        pet.setId(2);
    //        pet.setName("Pet1");
    //        pet.setStatus("available");
    //    pet.setCategory(category);
    //    pet.setPhotoUrls(fotosList);
    //    pet.setTags(tagList);

    // Gson gson = new Gson();
    // String toJson = GSON.toJson(pet);

    RequestBody requestBody =
        new Request.Builder()
            .url(HttpUrl.get(uri))
            .post(
                RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"), GSON.toJson(pet)))
            .header("Content-type", "application/json")
            .build()
            .body();
    Response response =
        OK_CLIENT
            .newCall(new Request.Builder().url(HttpUrl.get(uri)).post(requestBody).build())
            .execute();
    // System.out.println("Update pet $ " + response.code());
    System.out.println("Update pet $ " + response.body().string());
    response.close();
    return response.code();
  }
  // 200  findPetById
  @SneakyThrows
  @Override
  public void get(Integer petId) {
    URI uri = URI.create(URI_PET + "/" + petId);
    Request request = new Request.Builder().url(HttpUrl.get(uri)).build();
    Response response = OK_CLIENT.newCall(request).execute();
    // System.out.println("findByIDPet $ " + response.code());
    System.out.println("findByIDPet $ " + response.body().string());
    response.close();
  }
  // update
  @SneakyThrows
  @Override
  public void updatePut(Pet pet) {
    // https://petstore.swagger.io/v2/pet
    URI uri = URI.create(URI_PET);

    //    List<Tag> tagList = new ArrayList<>();
    //    String[] fotosList = new String[10];
    //
    //    Category category = new Category();
    //    category.setId(1);
    //    category.setName("Category1");
    //
    //    Tag tag = new Tag();
    //    tag.setId(1);
    //    tag.setName("Tag1");
    //
    //    Pet pet = new Pet();
    //    pet.setId(1);
    //    pet.setName("Pet1");
    //    pet.setStatus("200");
    //    pet.setCategory(category);
    //    pet.setPhotoUrls(fotosList);
    //    pet.setTags(tagList);

    // Gson gson = new Gson();
    // String toJson = gson.toJson(pet);
    //
    RequestBody requestBody =
        new Request.Builder()
            .url(HttpUrl.get(uri))
            .put(
                RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"), GSON.toJson(pet)))
            //            .header("formData", "name")
            //            .header("formData", "status")
            //            .addHeader("name", "pet2")
            //            .addHeader("status", "200")
            .build()
            .body();
    Response response =
        OK_CLIENT
            .newCall(new Request.Builder().url(HttpUrl.get(uri)).post(requestBody).build())
            .execute();
    // Request request = new Request.Builder().url(HttpUrl.get(uri)).get().build();
    // Response response = OK_CLIENT.newCall(requestBody).execute();
    // System.out.println("Update by name and status pet $ " + response.code());
    System.out.println("update PUT $ " + response.code() + " - " + response.body().string());
    response.close();
  }
}
