

/*
        [6:47 PM, 4/8/2019] Posca: no encontre nada te escribo uno
        [6:48 PM, 4/8/2019] Posca: hace un programa para administrar una biblioteca que tenga n cantidad de libros
        [6:48 PM, 4/8/2019] Posca: el programa primero te tiene que preguntar cuantos libros hay
        [6:49 PM, 4/8/2019] Posca: dps te pide el titulo de cada libro
        [6:49 PM, 4/8/2019] Posca: y el anio en que se publico
        [6:49 PM, 4/8/2019] Posca: dps el programa te deja elegir entre 3 funciones
        [6:50 PM, 4/8/2019] Posca: retirar libro, devolver libro y salir
        [6:51 PM, 4/8/2019] Posca: retirar libro y devolver libro toman como parametro un numero entero que indica a que libro se refiere
        [6:51 PM, 4/8/2019] Posca: tener en cuenta que un libro no se puede retirar si no esta disponible
        [6:51 PM, 4/8/2019] Posca: ni devolver si ya fue devuelto
        [6:51 PM, 4/8/2019] Posca: salir termina la ejecucion del programa
        [6:51 PM, 4/8/2019] Posca: es oop basico eso
*/

import java.util.HashMap;
import java.util.Map;


class BookLibrary{
    private Integer numberOfBooks;
    private Map<Book,Integer> catalogue; // dictionary of books/ number of copies available affected by loans and returns
    private Map<Book,Integer> copiesPerBook; // total number of copies of the book, once set, isnt modified by loans, only by additions.

    public BookLibrary() {
        this.numberOfBooks = 0;
        this.catalogue = new HashMap<>();
        this.copiesPerBook = new HashMap<>();
    }

    public void addBook(Book book){
        this.numberOfBooks++;
        if (this.catalogue.containsKey(book) == Boolean.TRUE){
            this.catalogue.replace(book,this.catalogue.get(book),this.catalogue.get(book)+1);
            this.copiesPerBook.replace(book,this.copiesPerBook.get(book),this.copiesPerBook.get(book)+1);
            System.out.println("A new copy of the book: ["+book.toString()+"] has been added to the library");
        }else{
            this.catalogue.put(book,1);
            this.copiesPerBook.put(book,1);
            System.out.println("The book: ["+book.toString()+"] has been added to the library");
        }
    }

    public void withdrawBook(Book book) {
        if(this.catalogue.containsKey(book) == Boolean.TRUE){
            if(this.catalogue.get(book) > 0){
                this.catalogue.replace(book,catalogue.get(book),catalogue.get(book)-1);
                System.out.println("The book: ["+book.toString()+"] has been successfully withdrawn from library.");
                System.out.println("There are "+this.catalogue.get(book)+" copies left in the library of this book");
            }else{
                System.out.println("The book: ["+book.toString()+"] has no available copies left to be rented.");
            }
        }else{
            System.out.println("The book: ["+book.toString()+"] doesnt exist");
        }
    }

    public void returnBook(Book book){
        if(this.catalogue.containsKey(book) == Boolean.TRUE) {
            if (this.catalogue.get(book) == this.copiesPerBook.get(book)) {
                System.out.println("You cant return a book that wasnt previously withdrawn");
                System.out.println("There are "+this.catalogue.get(book)+" copies left in the library of this book");

            }else{
                this.catalogue.replace(book, this.catalogue.get(book),this.catalogue.get(book)+1);
                System.out.println("The Book: ["+book.toString()+"] was returned successfully");
                System.out.println("There are "+this.catalogue.get(book)+" copies left in the library of this book");
            }
        }
    }
}

class Book{
    private String name;
    private String author;
    private Integer isbn; //isbn without dashes


    public Book(String name, String author, Integer isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book Name: "+this.name+", by "+this.author+", with ISBN "+this.isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Book)){
            return false;
        }
        if (obj == this){
            return true;
        }
        return ((Book) obj).author.equals(this.author) && ((Book) obj).isbn.equals(this.isbn) && ((Book) obj).name.equals(this.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.author == null) ? 0 : this.author.hashCode());
        result = prime * result + ((this.isbn == null) ? 0 : this.isbn.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }
}


public class Main {

    public static void main(String[] args){
        //create a new library
        BookLibrary myLibrary = new BookLibrary();

        //lets add some books

        myLibrary.addBook(new Book("Harry Potter 1","JK Rowling",1));
        myLibrary.addBook(new Book("Harry Potter 1","JK Rowling",1));

        myLibrary.addBook(new Book("Harry Potter 2","JK Rowling",2));
        myLibrary.addBook(new Book("Harry Potter 3","JK Rowling",3));

        //lets withdraw a book

        myLibrary.withdrawBook(new Book("Harry Potter 1","JK Rowling",1));
        myLibrary.withdrawBook(new Book("Harry Potter 1","JK Rowling",1));
        myLibrary.withdrawBook(new Book("Harry Potter 1","JK Rowling",1));

        //lets return a book

        myLibrary.returnBook(new Book("Harry Potter 1","JK Rowling",1));

        //lets withdraw a nonexisting book

        myLibrary.withdrawBook(new Book("Harry Potter 4","JK Rowling", 4));





    }

}
