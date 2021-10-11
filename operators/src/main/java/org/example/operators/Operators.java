package org.example.operators;

import io.reactivex.rxjava3.core.Observable;

import java.awt.image.ImageObserver;

public class Operators {
    public static void main(String[] args) {

        Observable.just(60,57,89,90,23,100,98)
                .filter(e -> e>75)
                .sorted()
                .subscribe(System.out::println);



    }
}
