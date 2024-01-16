package model;

import java.util.*;

public class Library {
    public static List<Book> books = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static Queue<User> userQueue = new LinkedList<>();
    public static PriorityQueue<User> priorityQueue = new PriorityQueue<>(new UserComparator());

}

