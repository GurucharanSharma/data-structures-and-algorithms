package interviews.birdeye;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

  int lfuKey;
  int lfuCount;
  int capacity;
  Map<Integer, Integer> accessLookup;
  Map<Integer, Integer> cacheLookup;

  public LFUCache(int capacity) {
    lfuKey = -1;
    lfuCount = Integer.MAX_VALUE;
    this.capacity = capacity;
    this.accessLookup = new HashMap<>();
    this.cacheLookup = new HashMap<>();
  }

  public int get(int key) {
    if (cacheLookup.containsKey(key)) {
      int count = accessLookup.getOrDefault(key, 0) + 1;
      if (count + 1 < lfuCount) {
        lfuCount = count;
        lfuKey = key;
      }

      accessLookup.put(key, count);
      return cacheLookup.get(key);
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (lfuKey == -1) {
      lfuKey = key;
    }

    if (cacheLookup.size() < capacity) {
      cacheLookup.put(key, value);
      accessLookup.put(key, accessLookup.getOrDefault(key, 0));
    } else {
      int delKey = getLFUKey(); // TODO: Do this in O(1) time complexity
      accessLookup.remove(delKey);
      cacheLookup.remove(delKey);

      cacheLookup.put(key, value);
      accessLookup.put(key, accessLookup.getOrDefault(key, 0));
    }
  }

  ///// HELPER METHOD /////
  private int getLFUKey() {
    int key = -1;
    int min = Integer.MAX_VALUE;
    for (Map.Entry<Integer, Integer> entry : accessLookup.entrySet()) {
      if (entry.getValue() < min) {
        min = entry.getValue();
        key = entry.getKey();
      }
    }

    return key;
  }
}
