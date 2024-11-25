package interviews.birdeye;

public class Main {

  public static void main(String[] args) {
    LFUCache cache = new LFUCache(3);

    System.out.println(cache.get(1));

    cache.put(1, 100);
    cache.put(2, 200);
    cache.put(3, 300);

    System.out.println(cache.get(1));
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));

    cache.put(2, 2000);
    cache.put(4, 400);

    System.out.println(cache.get(2));
    System.out.println(cache.get(3));
  }
}
