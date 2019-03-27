package fr.simplex_software.fp.streams;

import fr.simplex_software.fp.streams.model.*;

import java.math.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class OrderOperationsImpl implements OrderOperations
{
  @Override
  public List<Order> findOrdersByYearSortedByValue(List<Order> orders, LocalDate date)
  {
    return orders.stream().filter(order -> order.getDate().getYear() == date.getYear()).sorted(Comparator.comparing(Order::getValue)).collect(Collectors.toList());
  }

  @Override
  public List<BigDecimal> findValuesOfOrdersFromCustomersLivingInGivenCity(List<Order> orders, String city)
  {
    return orders.stream().filter(order -> order.getCustomer().getCity().equals(city)).map(Order::getValue).collect(Collectors.toList());
  }

  @Override
  public Optional<BigDecimal> findHighestOrdersValue(List<Order> orders)
  {
    return orders.stream().map(Order::getValue).reduce(BigDecimal::max);
  }

  @Override
  public Optional<Order> findOrderWithLowestValue(List<Order> orders)
  {
    return orders.stream().reduce((o1, o2) -> o1.getValue().compareTo(o2.getValue()) <  0 ? o1 : o2);
  }

  @Override
  public List<Customer> findCustomersLivingInGivenCitySortedByName(List<Order> orders, String city)
  {
    return orders.stream().map(Order::getCustomer).filter(customer -> customer.getCity().equals(city)).sorted(Comparator.comparing(Customer::getLastName)).collect(Collectors.toList());
  }

  @Override
  public List<String> findCustomersUniqueCities(List<Order> orders)
  {
    return orders.stream().map(order -> order.getCustomer().getCity()).distinct().collect(Collectors.toList());
  }

  @Override
  public String findCustomerNamesSorted(List<Order> orders)
  {
    return orders.stream().map(order -> order.getCustomer().getLastName()).distinct().sorted().collect(joining(", "));
  }

  @Override
  public boolean areCustomersBasedInGivenCity(List<Order> orders, String city)
  {
    return orders.stream().map(order -> order.getCustomer().getCity()).anyMatch(c -> c.equals(city));
  }
}
