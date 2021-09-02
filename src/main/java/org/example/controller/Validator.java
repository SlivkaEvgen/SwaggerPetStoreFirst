package org.example.controller;

public class Validator {

  public boolean validNumber(String hasNumbers) {
    return hasNumbers.matches("\\d+");
  }

  public boolean validString(String hasLetters) {
    return !hasLetters.matches("\\d+");
  }
}
