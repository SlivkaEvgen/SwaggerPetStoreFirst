package org.example.repository;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import okhttp3.*;
import org.example.config.HttpConnect;
import org.example.model.Order;
import org.example.repository.interfaces.StoreRepository;
import org.example.util.PropertiesLoader;
import java.net.URI;

public class StoreRepositoryImpl implements StoreRepository<Order, Long> {

  private final OkHttpClient OK_CLIENT = HttpConnect.getInstance();
  private final String URI_STORE = PropertiesLoader.getProperties("uriStore");
  private final Gson GSON = new Gson();

  @SneakyThrows
  @Override
  public Long delete(Long orderId) {
    Request request =
        new Request.Builder()
            .url(HttpUrl.get(URI.create(URI_STORE + "/order/" + orderId)))
            .delete()
            .build();
    Response response = OK_CLIENT.newCall(request).execute();
    return (long) response.code();
  }

  @SneakyThrows
  @Override
  public Order findById(Long orderId) {
    Request request =
        new Request.Builder().url(HttpUrl.get(URI.create(URI_STORE + "/order/" + orderId))).build();
    Response response = OK_CLIENT.newCall(request).execute();
    assert response.body() != null;
    return GSON.fromJson(response.body().string(), Order.class);
  }

  @SneakyThrows
  @Override
  public Order create(Order order) {
    RequestBody requestBody =
        new Request.Builder()
            .url(HttpUrl.get(URI.create(URI_STORE + "/order")))
            .post(
                RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"), GSON.toJson(order)))
            .header("Content-type", "application/json")
            .build()
            .body();
    Response response =
        OK_CLIENT
            .newCall(
                new Request.Builder()
                    .url(HttpUrl.get(URI.create(URI_STORE + "/order")))
                    .post(requestBody)
                    .build())
            .execute();
    return GSON.fromJson(response.body().string(), Order.class);
  }

  @SneakyThrows
  @Override
  public void get() {
    Request request =
        new Request.Builder().url(HttpUrl.get(URI.create(URI_STORE + "/inventory"))).get().build();
    Response response = OK_CLIENT.newCall(request).execute();
    System.out.println(response.body().string() + "\n");
  }
}
