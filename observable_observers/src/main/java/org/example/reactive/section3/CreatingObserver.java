package org.example.reactive.section3;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {
    public static void main(String[] args) {

        Observable<String> source = Observable.just("Orange","black","Red");
        // First lambda is for onNext method
        // Next lambda is for onError method
        // last lambda is for onComplete
        source.subscribe(i -> System.out.println(i),Throwable::printStackTrace,() -> System.out.println("Completed"));

        System.out.println();

        // First lambda is for onNext method
        // Next lambda is for onError method
        source.subscribe(i -> System.out.println(i),Throwable::printStackTrace);

        System.out.println();

        // First lambda is for onNext method
        source.subscribe(i -> System.out.println(i),Throwable::printStackTrace);



    }
}
