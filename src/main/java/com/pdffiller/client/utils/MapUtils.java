package com.pdffiller.client.utils;

import java.util.Map;

public class MapUtils {
  public static <K, V> Map<K, V> updateMap(Map<K, V> map, K key, V value){
    map.put(key,value);
    return map;
  }        
}
