package com.drypot;

import java.util.Arrays;
import java.util.TimeZone;

public class DumpTimeZone {
  public static void main(String[] args) {
    String[] ids = TimeZone.getAvailableIDs();
    Arrays.stream(ids).sorted().forEach(System.out::println);
  }
}
