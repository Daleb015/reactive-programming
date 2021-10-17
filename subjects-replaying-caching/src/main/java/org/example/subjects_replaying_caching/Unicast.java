package org.example.subjects_replaying_caching;

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

public class Unicast {
    public static void main(String[] args) {
        Subject<String> subject = UnicastSubject.create();

        subject.subscribe(e -> System.out.println("Subscriber 1 : "+e));

        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        //subject.subscribe(e -> System.out.println("Subscriber 2 : "+e));

        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();
    }
}
