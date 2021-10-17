package org.example.flowable_backpressure;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

public class BackPressureFlowable {
    public static void main(String[] args) {
        Flowable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produces item is : "+e+" : "+ Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {

                    Subscription s;
                    AtomicInteger count = new AtomicInteger(0);

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.s = s;
                        System.out.println("Asking for 20 items");
                        s.request(20);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("The subscriber consumed : "+integer);
                        if (count.getAndIncrement() % 20 == 0){
                            System.out.println("Asking for next 20 items ");
                            s.request(20);
                        }

                        sleep(100);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completeed");
                    }
                });


       // sleep(10000000);
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
