package fr.simplex_software.fp.streams;

import fr.simplex_software.fp.streams.model.*;

import java.math.*;
import java.time.*;
import java.util.*;

public interface OrderOperations
{
  public List<Order> findOrdersByYearSortedByValue (List<Order> orders, LocalDate date);
  public List<BigDecimal> findValuesOfOrdersFromCustomersLivingInGivenCity (List<Order> orders, String city);
  public Optional<BigDecimal> findHighestOrdersValue (List<Order> orders);
  public Optional<Order> findOrderWithLowestValue (List<Order> orders);
  public List<Customer> findCustomersLivingInGivenCitySortedByName (List<Order> orders, String city);
  public List<String> findCustomersUniqueCities (List<Order> orders);
  public String findCustomerNamesSorted (List<Order> orders);
  public boolean areCustomersBasedInGivenCity (List<Order> orders, String city);
}
