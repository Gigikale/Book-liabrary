package service;

import model.Book;
import model.Library;
import model.Role;
import model.User;

import java.util.PriorityQueue;
import java.util.Queue;

public class LibraryServiceImp {
    public String lendBook(PriorityQueue<User> library, User user, Book book) {
        if (user.getRole() != Role.LIBRARIAN) {
            return "UNAUTHORIZED USER";
        } else if (book.getQuantity()>=1) {
            User priorityUser = Library.priorityQueue.poll();
            book.setQuantity(book.getQuantity() -1);
            return book.getTitle() + " HAS BEEN COLLECTED BY" + priorityUser;
        } else {
            return "BOOK IS TAKEN";
        }
    }

    @Override
    public String lendBook(Queue<User> library, User user, Book book) {
        if (user.getRole() != Role.LIBRARIAN) {
            return "UNAUTHORIZED USER";
        } else if (book.getQuantity()>=1) {
            User queueUser = Library.userQueue.poll();
            book.setQuantity(book.getQuantity() -1);
            return book.getTitle() + " HAS BEEN COLLECTED BY" + queueUser;
        } else {
            return "BOOK IS TAKEN";
        }
    }
}

