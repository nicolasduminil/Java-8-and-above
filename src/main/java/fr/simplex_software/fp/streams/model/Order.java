package fr.simplex_software.fp.streams.model;

import java.math.*;
import java.time.*;

public class Order
{
  private Customer customer;
  private LocalDate date;
  private BigDecimal value;

  public Order()
  {
  }

  public Order(Customer customer, LocalDate date, BigDecimal value)
  {
    this.customer = customer;
    this.date = date;
    this.value = value;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  public LocalDate getDate()
  {
    return date;
  }

  public void setDate(LocalDate date)
  {
    this.date = date;
  }

  public BigDecimal getValue()
  {
    return value;
  }

  public void setValue(BigDecimal value)
  {
    this.value = value;
  }
}
