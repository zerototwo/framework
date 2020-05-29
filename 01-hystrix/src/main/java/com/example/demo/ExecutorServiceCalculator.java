package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCalculator implements Calculator {

  private int parallism;
  private ExecutorService pool;

  public ExecutorServiceCalculator() {

    parallism = Runtime.getRuntime().availableProcessors();
    pool = Executors.newFixedThreadPool(parallism);

  }

  private static class SumTask implements Callable<Long>{

    private long[] numbers;
    private int  from;
    private int to;

    public SumTask(long[] numbers, int from, int to) {

      this.numbers = numbers;
      this.from = from;
      this.to = to;
    }


    @Override
    public Long call() throws Exception {
      long total  = 0;
      for (int i = from; i <= to; i++) {

        total += numbers[i];

      }
      return total;

    }


  }

  @Override
  public long sumUp(long[] numbers) {
    List<Future<Long>> results = new ArrayList<>();

    int part = numbers.length / parallism;
    for (int i = 0; i < parallism; i++) {

      int from = i*part;

    }



    return 0;
  }


}
