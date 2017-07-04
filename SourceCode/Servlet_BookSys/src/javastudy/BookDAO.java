package javastudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO {
	
	Connection conn;
	Statement st;
	String sql;
	public BookDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/book";
		String user="root";
		String pwd="123456";
		conn=DriverManager.getConnection(url,user,pwd);
		st=conn.createStatement(); 
	}
	//��
	public int addBook(Book book) throws SQLException{
		sql="insert into books (Name,Author,Price,Publisher) values(?,?,?,?) ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, book.getName());
		ps.setString(2, book.getAuthor());
		ps.setFloat(3, book.getPrice());
		ps.setString(4, book.getPublisher());
		return ps.executeUpdate();
	}	
	//ɾ
	public int deleteBook(int id) throws SQLException{
		sql="delete from books where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}
	//��
	public int modifyBook(int id,Book book) throws SQLException{
		sql="update books set name=?,author=?,price=?,publisher=? where id =?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, book.getName());
		ps.setString(2, book.getAuthor());
		ps.setFloat(3, book.getPrice());
		ps.setString(4, book.getPublisher());
		ps.setInt(5, id);
		return ps.executeUpdate();
	}
	//��
	public ArrayList<Book> getBooks() throws SQLException{
		sql="select * from books";
		ResultSet rs=st.executeQuery(sql);
		ArrayList<Book> al=new ArrayList<Book>();
		while(rs.next()){
			Book book=new Book();
			book.setId(rs.getInt(1));
			book.setName(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setPrice(rs.getFloat(4));
			book.setPublisher(rs.getString(5));
			al.add(book);
		}
		return al;
	}		
	public ArrayList<Book> getBookByName(String name) throws SQLException{
		sql="select * from books where name = ?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		ArrayList<Book> al=new ArrayList<Book>();
		while(rs.next()){
			Book book=new Book();
			book.setId(rs.getInt(1));
			book.setName(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setPrice(rs.getFloat(4));
			book.setPublisher(rs.getString(5));
			al.add(book);
		}
		return al;
	}
	public Book getBookById(int id) throws SQLException{
		sql="select * from books where id =?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		rs.next();

		Book book=new Book();
		book.setId(rs.getInt(1));
		book.setName(rs.getString(2));
		book.setAuthor(rs.getString(3));
		book.setPrice(rs.getFloat(4));
		book.setPublisher(rs.getString(5));

		return book;
	}

	
	
	
	
	
	
}
