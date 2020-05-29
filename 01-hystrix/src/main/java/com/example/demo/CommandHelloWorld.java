package com.example.demo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.ExecutionException;

public class CommandHelloWorld extends HystrixCommand<String> {

  private final String name;

  public CommandHelloWorld(String name) {

    super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    this.name = name;
  }


  @Override
  protected String run() throws Exception {

    return "Hello"+ name+"!";
  }


  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Observable<String> world = new CommandHelloWorld("World").observe();

    String single = world.toBlocking().single();
    System.out.println(single);
    world.subscribe(new

                        Observer<String>() {

                          @Override
      public void onCompleted() {

      }


                          @Override
      public void onError(Throwable throwable) {

      }


                          @Override
      public void onNext(String s) {
        System.out.println("onNext: " + s);

      }


                        });




  }


}
