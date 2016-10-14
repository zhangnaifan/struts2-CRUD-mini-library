package com.action;

import com.db.Dao;
import com.model.Author;
import com.model.Book;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BooksAction
  	extends ActionSupport{
  private static final long serialVersionUID = 1L;
  private Dao dao = null;
  private Author author = null;
  private List<Book> books = null;
  private Book book = null;
  private String info = null;
  
  public Author getAuthor(){
    return this.author;
  }

  public void setAuthor(Author author){
    this.author = author;
  }
  
  public Book getBook(){
    return this.book;
   }
  
  public void setBook(Book book){
    this.book = book;
  }
  
  public List<Book> getBooks(){
    return this.books;
  }
  
  public void setBooks(List<Book> books){
    this.books = books;
  }
  
  public String getInfo(){
    return this.info;
  }
  
  public void setInfo(String info)
  {
    this.info = info;
  }
  
  public String execute()
  {
    init();
    return "success";
  }
  
  public void init()
  {
    try
    {
      setInfo("Cannot find any books from " + this.author.getName() + "!");
      
      this.dao = new Dao();
      
      ResultSet rsBooks = this.dao.executeQuery(
        "select * from book a join author b where a.AuthorID=b.AuthorID and b.Name='" 
      + this.author.getName() + "';");
      
      this.books = new ArrayList<Book>();
      while (rsBooks.next())
      {
        setInfo("Books from " + this.author.getName() + " are shown below:");
        Book temp = new Book();
        temp.setISBN(rsBooks.getString(1));
        temp.setTitle(rsBooks.getString(2));
        temp.setAuthorID(rsBooks.getInt(3));
        temp.setPublisher(rsBooks.getString(4));
        temp.setDate(rsBooks.getDate(5));
        temp.setPrice(rsBooks.getDouble(6));
        this.books.add(temp);
      }
    }
    catch (Exception e)
    {
      this.books = null;
      setInfo("Error occurs when visiting the database!");
    }
    finally
    {
      this.dao.close();
    }
  }
  
  public String delete()
  {
    init();
    
    String sql = "delete from book where ISBN='" + this.book.getISBN() + "';";
    try
    {
      this.dao = new Dao();
      this.dao.executeUpdate(sql);
    }
    catch (Exception e)
    {
      setInfo("Sorry, we cannot delete ths book!\n");
    }
    finally
    {
      this.dao.close();
    }
    Predicate<Book> condition = new Predicate<Book>()
    {
      public boolean test(Book arg0)
      {
        return arg0.getISBN().equals(BooksAction.this.book.getISBN());
      }
    };
    this.books.removeIf(condition);
    setInfo("Deletion success!");
    
    return "success";
  }
  
//  public String showAndUpdate()
//    throws SQLException
//  {
//	  System.out.println("here");
//    this.dao = new Dao();
//    ResultSet rs = this.dao.executeQuery(
//      "select * from book where ISBN='" 
//    + this.book.getISBN() 
//    + "';");
//    if (rs.next())
//    {
//      this.book.setTitle(rs.getString(2));
//      this.book.setAuthorID(rs.getInt(3));
//      this.book.setPublisher(rs.getString(4));
//      this.book.setDate(rs.getDate(5));
//      this.book.setPrice(rs.getDouble(6));
//    }
//    
//    rs = dao.executeQuery("SELECT * FROM author WHERE authorid = "
//    		+ author.getId()
//    		+ ";");
//    if (rs.next()){
//    	author.setName(rs.getString(2));
//    	author.setAge(rs.getInt(3));
//    	author.setCountry(rs.getString(4));
//    }
//    
//    this.dao.close();
//    return "success";
//  }
  
  public String showAndUpdate() throws SQLException{
	    this.dao = new Dao();
	    ResultSet rs = this.dao.executeQuery(
	      "select * from book where ISBN='" 
	    + this.book.getISBN() 
	    + "';");
	    if (rs.next())
	    {
	      this.book.setTitle(rs.getString(2));
	      this.book.setAuthorID(rs.getInt(3));
	      this.book.setPublisher(rs.getString(4));
	      this.book.setDate(rs.getDate(5));
	      this.book.setPrice(rs.getDouble(6));   
	    }
	    
	    rs = dao.executeQuery("SELECT * FROM author WHERE authorid = "
	    		+ author.getId()
	    		+ ";");
	    if (rs.next()){
	    	author.setName(rs.getString(2));
	    	author.setAge(rs.getInt(3));
	    	author.setCountry(rs.getString(4));
	    }
	    
	    this.dao.close();
	    return "success";
  }
  
  public String update()
  {
	//update the author
	dao = new Dao();
	dao.executeUpdate("UPDATE author SET Name='"
			+ author.getName()
			+ "', Age="
			+ author.getAge()
			+ ", Country='"
			+ author.getCountry()
			+ "' WHERE authorID="
			+ author.getId()
			+ ";");
 
	//update the book

    dao.executeUpdate("UPDATE book SET AuthorID = " + 
      this.book.getAuthorID() + 
      ", Publisher = '" + this.book.getPublisher() + 
      "', PublishDate = '" + this.book.getDate() + 
      "', Price = " + this.book.getPrice() + 
      " WHERE ISBN = '" + this.book.getISBN() + "';");
    
    info = new String();
    setInfo("Updation Sucess");
    
	try {
		ResultSet rs = dao.executeQuery(
		        "select * from book a join author b where a.AuthorID=b.AuthorID and b.Name='" 
        		+ this.author.getName() 
        		+ "';");
		books = new ArrayList<Book>();
	    while (rs.next()){
	    	Book temp = new Book();
	        temp.setISBN(rs.getString(1));
	        temp.setTitle(rs.getString(2));
	        temp.setAuthorID(rs.getInt(3));
	        temp.setPublisher(rs.getString(4));
	        temp.setDate(rs.getDate(5));
	        temp.setPrice(rs.getDouble(6));
	        this.books.add(temp);
	    }
	} catch (SQLException e) {}
    
    dao.close();
    
    return "success";
  }
  
  public String popCreate()
  {
    return "success";
  }
  
  public String create()
    throws SQLException
  {
    this.dao = new Dao();
    
    ResultSet rs = this.dao.executeQuery("SELECT * FROM author where AuthorID=" + 
      this.book.getAuthorID() + ";");
    if (!rs.next())
    {
      this.dao.close();
      return "NEW_AUTHOR";
    }
    rs = this.dao.executeQuery("SELECT * FROM book where ISBN='" + 
      this.book.getISBN() + "';");
    if (rs.next())
    {
      this.dao.close();
      return "CREATE_FAIL";
    }
    this.dao.execute("INSERT INTO book(ISBN,title,AuthorID,Publisher,PublishDate,Price) VALUES('" + 
    
      this.book.getISBN() + 
      "', '" + this.book.getTitle() + 
      "', " + this.book.getAuthorID() + 
      ", '" + this.book.getPublisher() + 
      "', '" + this.book.getDate() + 
      "', " + this.book.getPrice() + ");");
    
    this.dao.close();
    return "success";
  }
  
  public String createAuthor()
  {
    this.dao = new Dao();
    
    this.dao.execute("INSERT INTO author(AuthorID,Name,Age,Country) VALUES(" + 
    
      this.author.getId() + 
      ", '" + this.author.getName() + 
      "', " + this.author.getAge() + 
      ", '" + this.author.getCountry() + "');");
    
    this.dao.execute("INSERT INTO book(ISBN,title,AuthorID,Publisher,PublishDate,Price) VALUES('" + 
    
      this.book.getISBN() + 
      "', '" + this.book.getTitle() + 
      "', " + this.book.getAuthorID() + 
      ", '" + this.book.getPublisher() + 
      "', '" + this.book.getDate() + 
      "', " + this.book.getPrice() + ");");
    
    this.dao.close();
    return "success";
  }
}
