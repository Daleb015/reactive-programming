package org.example.concurrency_parallelization;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomScheduler {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(2);

    Scheduler scheduler = Schedulers.from(executor);

    Observable<String> src = Observable
      .just("Pasta", "Pizza", "Fries", "Curry", "Chow Mein")
      .subscribeOn(scheduler)
      .doFinally(executor::shutdown);

    src.subscribe(e -> compute());
    src.subscribe(e -> compute());
    src.subscribe(e -> compute());
    src.subscribe(e -> compute());
    src.subscribe(e -> compute());
    src.subscribe(e -> compute());
  }

  private static void compute() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("Computation done by : " + Thread.currentThread().getName());
  }
}
