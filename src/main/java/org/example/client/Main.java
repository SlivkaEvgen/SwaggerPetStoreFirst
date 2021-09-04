package org.example.client;

import org.example.controller.ControllerImpl;
import org.example.repository.PetRepositoryImpl;
import org.example.repository.StoreRepositoryImpl;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    // URI = URI.create("https://petstore.swagger.io/v2/user");
    // UserRepositoryImpl = new UserRepositoryImpl();
    PetRepositoryImpl petRepositoryImpl = new PetRepositoryImpl();
    StoreRepositoryImpl storeRepository = new StoreRepositoryImpl();
    new ControllerImpl().start();
    //     Pet pet = new Pet();
    //      pet.setId(0);
    //      pet.setName("doggie");
    //      pet.setStatus("available");
    // List<User> usersList = new ArrayList<>();
    //    User user = new User();
    //    user.setId(0);
    //    user.setUsername("User1");
    //    user.setFirstName("User");
    //    user.setFirstName("User");
    //    user.setUserStatus(200);
    //    user.setPassword("abcabc");
    //    user.setEmail("mail@ma");
    //    user.setPhone("0233236743");
    // usersList.add(user);
    /////////////   USER
    //  new ControllerImpl().start();
    // 200 login
    // userRepositoryImpl.loginUser( "user1", "abc123");

    // 200 create
    // userRepositoryImpl.create(user);

    // 200 logout
    // userRepositoryImpl.logOutUser();

    // 200 get
    // String userByName = userRepositoryImpl.get();
    // System.out.println("GET $ " + userRepositoryImpl.get("User1"));

    // 200 create list
    // userRepositoryImpl.createListUsers(usersList);

    // 200 update by Username
    //  user.setUsername("User3");
    // userRepositoryImpl.update(user);

    // 200 delete
    //   userRepositoryImpl.delete(uri,"User3");

    //////////////////////////////////////
    //   //   PET
    // System.out.println("   PET   \n");
    // File file = new File("/Users/zeka/Dropbox/Mac/Desktop/logo-square.png");

    // 200  add a new pet// Pet object that needs to be added to the store
    // petRepositoryImpl.create(pet);
    // 200 updateImage
    // petRepositoryImpl.uploadImage(file,2);
    // 200 findByStatus - available
    // petRepositoryImpl.findPetByStatus("available");
    // 200 findPetById
    // petRepositoryImpl.get(2);
    // 200 update in the store with form-data- pet// by id/name/status
    // petRepositoryImpl.update(pet);
    // 200 update PUT
    // petRepositoryImpl.updatePut(pet);
    // 200 deleteById
    // petRepositoryImpl.delete(2);

    ////////// STORE
    //      Order order = new Order();
    //      order.setId(1L);
    //      order.setStatus("placed");
    //      order.setComplete(true);
    //      order.setPetId(2L);
    //      order.setQuantity(0L);
    //      order.setShipDate("2021-08-30T13:58:48.140Z");
    // 200 inventories
    // storeRepository.returnsPetInventoriesByStatus();
    // 200 placeAnOrderForAPet
    // storeRepository.placeAnOrderForAPet(order);
    // 200 delete by id
    // storeRepository.deleteOrderById(2);
    // 200 find by ID order
    // storeRepository.findOrderById(2);

  }
}
