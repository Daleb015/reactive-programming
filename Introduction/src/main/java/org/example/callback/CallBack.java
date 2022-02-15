package org.example.callback;

public interface CallBack {
  void pushData(String data);
  void pushComplete();
  void pushError(Exception exception);
}
