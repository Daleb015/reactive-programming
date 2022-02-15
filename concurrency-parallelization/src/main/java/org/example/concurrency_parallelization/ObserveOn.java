package org.example.concurrency_parallelization;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Locale;

public class ObserveOn {

  public static void main(String[] args) {
    Observable
      .just("Pasta", "Pizza", "Fries", "Curry", "Chow Mein")
      .subscribeOn(Schedulers.computation())
      .map(e -> e.toUpperCase(Locale.ROOT))
      .doOnNext(e -> System.out.println(Thread.currentThread().getName()))
      .observeOn(Schedulers.io())
      .filter(e -> e.startsWith("P"))
      .subscribe(e -> print(e));
  }

  private static void print(String element) {
    System.out.println(element + " : Printed by : " + Thread.currentThread().getName());
  }
}
