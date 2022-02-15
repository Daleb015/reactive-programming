package org.example.reactive.section3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreatingObservable {

  public static void main(String[] args) throws InterruptedException {
    // Create()

    Observable<Integer> source = Observable.create(e -> {
      e.onNext(10);
      e.onNext(11);
      e.onNext(12);
      e.onComplete();
    });

    source.subscribe(System.out::println);

    // just()

    Observable<Integer> just = Observable.just(1, 2, 3);

    just.subscribe(System.out::println);

    // fromIterable()

    List<String> list = List.of("Ram", "Shyam", "Mike");

    @NonNull
    Observable<String> fromIterable = Observable.fromIterable(list);

    fromIterable.subscribe(System.out::println);

    // range

    Observable.range(3, 10).subscribe(s -> System.out.println("Received : " + s));

    // Interval
    // We need to sleep the main thread because interval by default is place on the schedulers threads.
    Observable.interval(1, TimeUnit.SECONDS).subscribe(System.out::println);

    Thread.sleep(10000);
  }
}
