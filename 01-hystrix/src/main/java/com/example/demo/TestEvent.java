package com.example.demo;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {
  public TestEvent() {
    super(new Object());
  }
}
