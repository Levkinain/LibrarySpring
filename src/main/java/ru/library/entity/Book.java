package ru.library.entity;

/**
 *
 */
public class Book {
    public static final String TABLE_NAME = "Books";
    public static final String INS = "ins";
    public static final String NAME_BOOK="nameBook";
    public static final String AUTHOR_BOOK="authorBook";
    private int ins;
    private String nameBook;
    private String authorBook;
    public  Book(){}
    public  Book(int ins, String nameBook, String authorBook){
        this.ins = ins;
        this.nameBook = nameBook;
        this.authorBook= authorBook;
    }

    public int getINS() {
        return ins;
    }
    public void setINS(int ins ) {
       this.ins = ins;
    }

    public String getNameBook() {
        return nameBook;
    }
    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }
    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book that = (Book) obj;
        if (ins != that.ins) return false;
        return true;
    }

    @Override
    public String toString() {
        return  User.class.getName()+ "[Ins = " + this.ins +  " Author: " +this.authorBook + " Name book: " +this.nameBook + " ]";
    }

    @Override
    public int hashCode(){
        //Здесь нужно переопределить метод
        return 0;
    }
}
