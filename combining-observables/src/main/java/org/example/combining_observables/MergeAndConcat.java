package org.example.combining_observables;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class MergeAndConcat {

  public static void main(String[] args) throws InterruptedException {
    Observable<String> src1 = Observable.just("Ella", "Alexa", "Lily");
    Observable<String> src2 = Observable.just("Priya", "Chloe");

    src1.concatWith(src2);

    Observable<String> src3 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src3 : " + e);
    Observable<String> src4 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src4 : " + e);

    Observable<String> merge = Observable.merge(src1, src2);

    merge.subscribe(e -> System.out.println("Received : " + e));

    Thread.sleep(10000);

    Observable<String> src5 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src5 : " + e);
    Observable<String> src6 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src6 : " + e);

    Observable<String> concat = Observable.concat(src5, src6);

    concat.subscribe(e -> System.out.println("Received : " + e));

    Thread.sleep(20000);
  }
}
