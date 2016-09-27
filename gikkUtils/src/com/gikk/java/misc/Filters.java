package com.gikk.java.misc;


//Thanks Stuart Marks at StackOverflow for the following code snippet
public class Filters{
  public static <T> Predicate<T> distinct(Function<? super T,Object> keyExtractor) {
      Map<Object,Boolean> seen = new ConcurrentHashMap<>();
      return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
  }
}
