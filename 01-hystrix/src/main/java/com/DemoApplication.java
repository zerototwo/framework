package com;

import com.example.demo.TestEvent;
import com.example.demo.TestListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

  @Autowired
  TestListener listener;

  public static void main(String[] args) {
    ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
    run.publishEvent(new TestEvent());


  }


}
