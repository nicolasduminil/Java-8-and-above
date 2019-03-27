package fr.simplex_software.fp.streams;

import fr.simplex_software.fp.streams.model.*;
import org.junit.*;

import java.math.*;
import java.time.*;
import java.util.*;

import static org.junit.Assert.*;

public class OrderOperationsImplTest
{
  private List<Order> orders = Arrays.asList(
    new Order(new Customer("Nicolas", "Duminil", "26 Allée des Sapins", "Soisy sous Motmorency", "Val d'Oise", "95230", "FR"), LocalDate.now(), new BigDecimal(300)),
    new Order(new Customer("Aleshia", "Tomkiewicz", "14 Taylor St", "St. Stephens Ward", "Kent", "CT2 7PP", "UK"), LocalDate.now(), new BigDecimal(1000)),
    new Order(new Customer("Evan", "Zigomalas", "5 Binney St", "Abbey Ward", "Buckinghamshire", "HP11 2AX", "UK"), LocalDate.now(), new BigDecimal(400)),
    new Order(new Customer("France", "Andrade", "8 Moor Place", "East Southbourne and Tuckton W", "Bournemouth", "BH6 3BE", "UK"), LocalDate.now(), new BigDecimal(710)),
    new Order(new Customer("Eric", "Rampy", "9472 Lind St", "Desborough", "Northamptonshire", "NN14 2GH", "UK"), LocalDate.now(), new BigDecimal(700)),
    new Order(new Customer("Corinne", "Jaret", "2150 Morley St", "Dee Ward", "Dumfries and Galloway", "DG8 7DE", "UK"), LocalDate.now(), new BigDecimal(300))
  );
  private OrderOperations orderOperations = new OrderOperationsImpl();

  @Test
  public void findOrdersByYearSortedByValue()
  {
    assertEquals (6, orderOperations.findOrdersByYearSortedByValue(orders, LocalDate.now()).size());
  }

  @Test
  public void findValuesOfOrdersFromCustomersLivingInGivenCity()
  {
    List<BigDecimal> values = orderOperations.findValuesOfOrdersFromCustomersLivingInGivenCity(orders, "St. Stephens Ward");
    assertFalse(values.isEmpty());
    assertEquals(1, values.size());
    assertEquals (0, values.get(0).compareTo(new BigDecimal(1000)));
  }

  @Test
  public void findHighestOrdersValue()
  {
    assertEquals (new BigDecimal(1000), orderOperations.findHighestOrdersValue(orders).orElse(null));
  }

  @Test
  public void findOrderWithLowestValue()
  {
    Optional<Order> order = orderOperations.findOrderWithLowestValue(orders);
    if (!order.isPresent())
      fail();
    assertEquals(new BigDecimal(300), order.get().getValue());
  }

  @Test
  public void findCustomersLivingInGivenCitySortedByName()
  {
    assertEquals("Evan", orderOperations.findCustomersLivingInGivenCitySortedByName(orders, "Abbey Ward").get(0).getFirstName());
  }

  @Test
  public void findCustomersUniqueCities()
  {
    assertEquals (6, orderOperations.findCustomersUniqueCities(orders).size());
  }

  @Test
  public void findCustomerNamesSorted()
  {
    assertEquals ("Andrade, Duminil, Jaret, Rampy, Tomkiewicz, Zigomalas", orderOperations.findCustomerNamesSorted(orders));
  }

  @Test
  public void areCustomersBasedInGivenCity()
  {
    assertTrue (orderOperations.areCustomersBasedInGivenCity(orders, "Abbey Ward"));
  }
}