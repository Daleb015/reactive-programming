package org.example.observer_pattern;

public interface SubjectLibrary {
  void subscribeObserver(Observer ob);
  void unsubscribeObserver(Observer ob);
  void notifyObserver();
}
