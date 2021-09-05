package org.example.client;

import okhttp3.internal.http2.ConnectionShutdownException;
import org.example.controller.ControllerImpl;

public class Main {

  public static void main(String[] args) throws ConnectionShutdownException, InterruptedException {

    new ControllerImpl().start();
  }
}
