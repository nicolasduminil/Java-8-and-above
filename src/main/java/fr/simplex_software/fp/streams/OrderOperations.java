package fr.simplex_software.fp.streams;

import fr.simplex_software.fp.streams.model.*;

import java.math.*;
import java.time.*;
import java.util.*;
import java.util.function.*;

public interface OrderOperations
{
  List<Order> findOrdersByYearSortedByValue(List<Order> orders, LocalDate date);
  List<BigDecimal> findValuesOfOrdersFromCustomersLivingInGivenCity(List<Order> orders, String city);
  Optional<BigDecimal> findHighestOrdersValue(List<Order> orders);
  Optional<Order> findOrderWithLowestValue(List<Order> orders);
  List<Customer> findCustomersLivingInGivenCitySortedByName(List<Order> orders, String city);
  List<String> findCustomersUniqueCities(List<Order> orders);
  String findCustomerNamesSorted(List<Order> orders);
  boolean areCustomersBasedInGivenCity(List<Order> orders, String city);
  List<Order> getOrdersFilteredByFunction(List<Order> orders, Function<List<Order>, List<Order>> filter);
  Function<List<Order>, Customer> getFilterFunctionForOrders (List<Order> orders);
  Function<List<Order>, List<Order>> getCombinedFilter(Function<List<Order>, List<Order>> f1, Function<List<Order>, List<Order>> f2);
}
