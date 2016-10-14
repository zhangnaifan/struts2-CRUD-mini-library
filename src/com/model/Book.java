package com.model;

import java.sql.Date;

public class Book
{
  private String ISBN;
  private String title;
  private int authorID;
  private String publisher;
  private Date date;
  private double price;
  
  public Date getDate()
  {
    return this.date;
  }
  
  public void setDate(Date date)
  {
    this.date = date;
  }
  
  public String getISBN()
  {
    return this.ISBN;
  }
  
  public void setISBN(String iSBN)
  {
    this.ISBN = iSBN;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public int getAuthorID()
  {
    return this.authorID;
  }
  
  public void setAuthorID(int authorID)
  {
    this.authorID = authorID;
  }
  
  public String getPublisher()
  {
    return this.publisher;
  }
  
  public void setPublisher(String publisher)
  {
    this.publisher = publisher;
  }
  
  public double getPrice()
  {
    return this.price;
  }
  
  public void setPrice(double price)
  {
    this.price = price;
  }
}
