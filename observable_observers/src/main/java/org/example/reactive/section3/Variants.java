package org.example.reactive.section3;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {

  public static void main(String[] args) {
    Observable<String> source = Observable.just("Alex", "Justin", "Jack");
    Observable<String> source1 = Observable.empty();

    // method first on observable return a single observable
    source1.first("Name").subscribe(System.out::println);

    Single.just("Alex").subscribe(System.out::println);

    // method maybe that may have or not a value
    source1
      .firstElement()
      .subscribe(
        System.out::println,
        e -> e.printStackTrace(),
        () -> System.out.println("Completed")
      );

    // Completable Not emit data, just see if an action is successful or not.
    Completable completable = Completable.complete();

    completable.subscribe(() -> System.out.println("Completed"));

    Completable
      .fromRunnable(() -> System.out.println("Some process executing"))
      .subscribe(() -> System.out.println("Process executed successfully"));
  }
}
