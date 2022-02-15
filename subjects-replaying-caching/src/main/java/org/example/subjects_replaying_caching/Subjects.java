package org.example.subjects_replaying_caching;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class Subjects {

  public static void main(String[] args) throws InterruptedException {
    Observable<Integer> src1 = Observable.just(5, 10, 15, 20).subscribeOn(Schedulers.computation());
    Observable<Integer> src2 = Observable
      .just(50, 100, 150, 200)
      .subscribeOn(Schedulers.computation());

    //        src1.subscribe(e -> System.out.println(e));
    //        src2.subscribe(e -> System.out.println(e));

    PublishSubject<Object> subject = PublishSubject.create();

    subject.subscribe(e -> System.out.println(e));

    src1.subscribe(subject);
    src2.subscribe(subject);

    Thread.sleep(9000);
  }
}
