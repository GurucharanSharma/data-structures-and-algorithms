package interviews.wayfair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class OrderManagement {

  enum ProductCategory {
    Cheap, Moderate, Expensive, NONE
  }

  interface IOrder {

    String getName();

    void setName(String name);

    int getPrice();

    void setPrice(int price);
  }

  interface IOrderSystem {

    void addToCart(IOrder order);

    void removeFromCart(IOrder order);

    int calculateTotalAmount();

    Map<String, Integer> categoryDiscounts();

    Map<String, Integer> cartItems();
  }

  static class OrderSystem implements IOrderSystem {

    private final Map<String, Integer> categoryDiscountsLookup = new TreeMap<>();
    private final Map<String, Integer> cartItemsLookup = new TreeMap<>();
    private int totalPrice = 0;

    public void addToCart(IOrder order) {
      ProductCategory category = getProductCategory(order.getPrice());
      int discountedPrice = getDiscountedPrice(category, order.getPrice());
      int discount = order.getPrice() - discountedPrice;

      totalPrice += discountedPrice;
      cartItemsLookup.put(order.getName(), cartItemsLookup.getOrDefault(order.getName(), 0) + 1);
      categoryDiscountsLookup.put(category.name(), categoryDiscountsLookup.getOrDefault(category.name(), 0) + discount);
    }

    public void removeFromCart(IOrder order) {
      ProductCategory category = getProductCategory(order.getPrice());
      int discountedPrice = getDiscountedPrice(category, order.getPrice());
      int discount = order.getPrice() - discountedPrice;

      totalPrice -= discountedPrice;
      cartItemsLookup.put(order.getName(), cartItemsLookup.getOrDefault(order.getName(), 0) - 1);
      categoryDiscountsLookup.put(category.name(), categoryDiscountsLookup.getOrDefault(category.name(), 0) - discount);
    }

    public int calculateTotalAmount() {
      return totalPrice;
    }

    public Map<String, Integer> categoryDiscounts() {
      return categoryDiscountsLookup;
    }

    public Map<String, Integer> cartItems() {
      return cartItemsLookup;
    }

    private ProductCategory getProductCategory(int price) {
      if (price <= 10) {
        return ProductCategory.Cheap;
      } else if (price <= 20) {
        return ProductCategory.Moderate;
      } else {
        return ProductCategory.Expensive;
      }
    }

    private int getDiscountedPrice(ProductCategory category, int price) {
      if (category == ProductCategory.Cheap) {
        return price - (price * 10 / 100);
      } else if (category == ProductCategory.Moderate) {
        return price - (price * 20 / 100);
      } else if (category == ProductCategory.Expensive) {
        return price - (price * 30 / 100);
      } else {
        return price;
      }

    }
  }

  static class Order implements IOrder {

    private String name;
    private Integer price;

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getPrice() {
      return this.price;
    }

    public void setPrice(int price) {
      this.price = price;
    }
  }

  public static class Solution {

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter textWriter = new PrintWriter(System.out);

      IOrderSystem orderSystem = new OrderSystem();
      int oCount = Integer.parseInt(br.readLine().trim());
      for (int i = 1; i <= oCount; i++) {
        String[] a = br.readLine().trim().split(" ");
        IOrder e = new Order();
        e.setName(a[0]);
        e.setPrice(Integer.parseInt(a[1]));
        orderSystem.addToCart(e);
      }
      int totalAmount = orderSystem.calculateTotalAmount();
      textWriter.println("Total Amount: " + totalAmount);

      Map<String, Integer> categoryDiscounts = orderSystem.categoryDiscounts();
      for (Map.Entry<String, Integer> entry : categoryDiscounts.entrySet()) {
        if (entry.getValue() > 0) {
          textWriter.println(entry.getKey() + " Category Discount: " + entry.getValue());
        }
      }

      Map<String, Integer> cartItems = orderSystem.cartItems();
      for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
        textWriter.println(entry.getKey() + " (" + entry.getValue() + " items)");
      }

      textWriter.flush();
      textWriter.close();
    }
  }
}
