package org.example.repository;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import okhttp3.*;
import org.example.model.User;
import org.example.repository.interfaces.UserRepository;
import org.example.util.PropertiesLoader;
import java.net.URI;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

  private final OkHttpClient OK_CLIENT = new OkHttpClient();
  private final Gson GSON = new Gson();
  private final String URI_USER = PropertiesLoader.getProperties("uriUser");

  @SneakyThrows
  @Override
  public void loginUser(String username, String password) {
    Request request =
        new Request.Builder()
            .url(
                HttpUrl.get(
                    URI.create(URI_USER + "/login?username=" + username + "&password=" + password)))
            .build();
    Response response = OK_CLIENT.newCall(request).execute();
    // System.out.println("LOGIN $ " + response.code());
    System.out.println("LOGIN body $ " + response.body().string());
    response.close();
  }

  @SneakyThrows
  @Override
  public void logOutUser() {
    Request request =
        new Request.Builder().url(HttpUrl.get(URI.create(URI_USER + "/logout"))).get().build();
    Response response = OK_CLIENT.newCall(request).execute();
    // System.out.println("LOGOUT $ " + response.code());
    System.out.println("LOGOUT $ " + response.body().string());
    response.close();
  }

  @SneakyThrows
  @Override
  public void create(User user) { // POST
    RequestBody requestBody =
        new Request.Builder()
            .url(HttpUrl.get(URI.create(URI_USER)))
            .post(
                RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"), GSON.toJson(user)))
            .header("Content-type", "application/json")
            .build()
            .body();
    Response response =
        OK_CLIENT
            .newCall(
                new Request.Builder()
                    .url(HttpUrl.get(URI.create(URI_USER)))
                    .post(requestBody)
                    .build())
            .execute();
    // System.out.println("CREATE $ " + response.code());
    System.out.println("CREATE $ " + response.body().string());
    response.close();
  }

  @SneakyThrows
  @Override
  public void get(String userName) {
    Request request =
        new Request.Builder().url(HttpUrl.get(URI.create(URI_USER + "/" + userName))).get().build();
    Response response = OK_CLIENT.newCall(request).execute();
    System.out.println("GET $ " + response.body().string());
    // return response.body().string();
  }

  @SneakyThrows
  @Override
  public void createListUsers(List<User> usersList) {
    RequestBody requestBody =
        new Request.Builder()
            .url(HttpUrl.get(URI.create(URI_USER + "/createWithList")))
            .post(
                RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"), GSON.toJson(usersList)))
            .header("Content-type", "application/json")
            .build()
            .body();
    Response response =
        OK_CLIENT
            .newCall(
                new Request.Builder()
                    .url(HttpUrl.get(URI.create(URI_USER + "/createWithList")))
                    .post(requestBody)
                    .build())
            .execute();
    // System.out.println("CREATE LIST $ " + response.code());
    System.out.println("CREATE LIST $ " + response.body().string());
    response.close();
  }

  @SneakyThrows
  @Override
  public void update(User user) {
    URI uri = URI.create(URI_USER + "/" + user.getUsername());
    RequestBody requestBody =
        new Request.Builder()
            .url(HttpUrl.get(uri))
            .put(
                RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"), GSON.toJson(user)))
            .header("Content-type", "application/json")
            .build()
            .body();
    Response response =
        OK_CLIENT
            .newCall(new Request.Builder().url(HttpUrl.get(uri)).put(requestBody).build())
            .execute();
    System.out.println("UPDATE $ " + response.code());
    response.close();
  }

  @SneakyThrows
  @Override
  public void delete(String userName) {
    Request request =
        new Request.Builder()
            .url(HttpUrl.get(URI.create(URI_USER + "/" + userName)))
            .delete()
            .build();
    Response response = OK_CLIENT.newCall(request).execute();
    // System.out.println("DELETE $ " + response.code());
    System.out.println(response.body().string());
    response.close();
  }
}
