package com.example.demo;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener /*implements ApplicationListener<TestEvent>*/ {

  @EventListener
  public void onApplicationEvent(TestEvent testEvent) {
    System.out.println("监听----------------------------------------------");
  }
}
