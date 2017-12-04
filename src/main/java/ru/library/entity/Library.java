package ru.library.entity;

public class Library {

    public static final String TABLE_NAME = "Library";
    public static final String BOOK = "lIns";
    public static final String USER = "user";
    public static final String ID = "id";

    private Book book;
    private User user;
    private int id;

    public Library(){}
    public Library(Book book,User user,int id){
        this.book = book;
        this.user = user;
        this.id =id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Library that = (Library) obj;
        if (!book.equals(that.book)|| !user.equals(that.user)||id!=that.id ) return false;
        return true;
    }

    @Override
    public String toString() {
        return  Library.class.getName()+"[ " + book.toString() + " " + user.toString() + " id: " +id + " ]";
    }

    @Override
    public int hashCode(){

        //Здесь нужно переопределить метод
        return 0;
    }

}
