package org.example.reactive.section3;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;

public class ObservableConnectable {

  public static void main(String[] args) throws InterruptedException {
    // Hot observable
    ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();

    source.connect();

    source.subscribe(System.out::println);

    Thread.sleep(10000);

    source.subscribe(System.out::println);

    Thread.sleep(10000);
  }
}
