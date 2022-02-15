package org.example.subjects_replaying_caching;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class DemoSubjects {

  public static void main(String[] args) {
    PublishSubject<String> subject = PublishSubject.create();

    subject.subscribe(System.out::println);
    subject.subscribe(e -> System.out.println("Observer 2 " + e));

    subject.onNext("Hello");
    subject.onNext("BasicsStrong");
    subject.onComplete();
    subject.onNext("BasicsStrong");
  }
}
