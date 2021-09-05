package org.example.controller;

import okhttp3.internal.http2.ConnectionShutdownException;
//ok
public interface Controller {

  void start() throws ConnectionShutdownException, InterruptedException;

  void stop();
}
