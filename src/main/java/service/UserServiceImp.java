package service;

import model.Book;
import model.BookException;
import model.Library;
import model.User;

import java.util.Optional;

public class UserServiceImp {
    public boolean makeRequest(Book book, User user1) {


        public class UserServiceImp implements UserService {
            @Override
            public String makeRequest(Book book, User user) {
                if (book.getQuantity() >= 1) {
                    Library.priorityQueue.add(user);
                    Library.userQueue.add(user);
                    return user.getName() + " ," + " REQUEST IS SUCCESSFUL";
                } else {
                    return " BOOK IS TAKEN ";
                }
            }

            public Book requestForBook(String author, String title, int quantity) throws BookException {
                Optional<Book> optionalBook = Library.books.stream().filter(book1 -> {
                    boolean titleMatches = book1.getTitle().equalsIgnoreCase(title);
                    boolean authorMatches = book1.getAuthor().equalsIgnoreCase(author);
                    return titleMatches && authorMatches;
                }).findAny();

                if (optionalBook.isPresent()) {
                    Book book = optionalBook.get();
                    if (book.getQuantity() < quantity) {
                        throw new BookException(" INSUFFICIENT");
                    } else {
                        return book;
                    }
                } else {
                    throw new BookException("BOOK IS NOT AVAILABLE");
                }
            }
        }

    }