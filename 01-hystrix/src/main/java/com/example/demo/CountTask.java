package com.example.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {

  private static final int THRESHOLD = 2;
  private int start;
  private int end;

  public CountTask(int start, int end) {
    this.start = start;
    this.end = end;
  }


  @Override
  protected Integer compute() {

    int sum = 0;
    boolean canComppute = (end - start)<=THRESHOLD;

    if (canComppute){
      for (int i = start; i <= end; i++) {
        sum += i;
      }

    }else {
      int middle = (start+end)/2;
      CountTask leftTask = new CountTask(start,middle);
      CountTask rigtTask = new CountTask(middle+1,end);

      leftTask.fork();
      rigtTask.fork();

      Integer left = leftTask.join();
      Integer right = rigtTask.join();

      sum = left + right;

    }

    return sum;
  }


  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ForkJoinPool forkJoinPool =  new ForkJoinPool();
    CountTask countTask = new CountTask(1, 200);
    ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(countTask);
    System.out.println(forkJoinTask.get());
  }


}
