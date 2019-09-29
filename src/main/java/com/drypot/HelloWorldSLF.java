package com.drypot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldSLF {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(HelloWorldSLF.class);
    logger.info("Hello World");
  }
}
