package org.example.concurrency_parallelization;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalTime;

public class FlatMap {
    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pasta","Pizza","Fries","Curry","Chow Mein")
                .flatMap(e -> Observable.just(e)
                        .subscribeOn(Schedulers.computation())
                        .map(str -> compute(e))
                ).subscribe(System.out::println);

        Thread.sleep(7000);

    }

    private static String compute(String e) {
        return e + " : Printed by : "+Thread.currentThread().getName()+" at : "+ LocalTime.now();
    }
}
