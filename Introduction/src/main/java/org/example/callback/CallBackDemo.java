package org.example.callback;

public class CallBackDemo {

  public static void main(String[] args) {
    System.out.println("Main thread is running");

    Runnable r = new Runnable() {
      @Override
      public void run() {
        new CallBackDemo()
          .runningAsync(
            new CallBack() {
              @Override
              public void pushData(String data) {
                System.out.println("Callback data :" + data);
              }

              @Override
              public void pushComplete() {
                System.out.println("Callback done !");
              }

              @Override
              public void pushError(Exception exception) {
                System.out.println("Callback error called, Got an exception :" + exception);
              }
            }
          );
      }
    };

    Thread t = new Thread(r);
    t.start();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Main thread completed");
  }

  public void runningAsync(CallBack callBack) {
    System.out.println("I am running on separate thread");
    sleep(1000);
    callBack.pushData("Data1");
    callBack.pushData("Data2");
    callBack.pushData("Data3");

    callBack.pushError(new RuntimeException("oops"));
    callBack.pushComplete();
  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
