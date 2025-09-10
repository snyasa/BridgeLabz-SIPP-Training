import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class SaleDashboards {
    public static void main(String[] args) {
        Map<String, List<Store>> cityToStoresMap = new HashMap<>();

        Stream<Store> allStores = cityToStoresMap.values()
                .stream()
                .flatMap(List::stream);

        
        Stream<Map.Entry<Customer, List<Order>>> customerOrders = allStores
                .flatMap(store -> store.getCustomerOrders().entrySet().stream());

        
        Stream<Map.Entry<Customer, List<Order>>> filteredCustomers = customerOrders
                .filter(e -> e.getValue().stream()
                        .filter(o -> o.getDate().isAfter(LocalDate.now().minusDays(60)))
                        .count() >= 3);

      
        Map<Customer, List<String>> result = filteredCustomers
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .flatMap(o -> o.getItems().stream())
                                .collect(Collectors.toList()),
                        (l1, l2) -> {
                            l1.addAll(l2);
                            return l1;
                        }
                ));
    }
}

class Store {
    private Map<Customer, List<Order>> customerOrders;
    public Map<Customer, List<Order>> getCustomerOrders() { return customerOrders; }
}

class Customer {
    private String name;
    public String getName() { return name; }
}

class Order {
    private LocalDate date;
    private List<String> items;
    public LocalDate getDate() { return date; }
    public List<String> getItems() { return items; }
}