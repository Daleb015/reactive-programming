package org.example.buffering_throttling_switching;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Window {
    public static void main(String[] args) throws InterruptedException {

//        Observable.range(1,30)
//                .buffer(4)
//               // .buffer(4, HashSet::new)
//                .subscribe(System.out::println);

        Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);

        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .window(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(8000);
    }
}
