
    import model.*;
    import service.LibraryServiceImp;
    import service.UserServiceImp;

    import java.util.*;
    import java.util.stream.Collectors;


    public class Main {


        public static void main(String[] args) {

            List<Book> books = createBooks();
            List<User> users = createUsers();

            // Adding users to queues.
            Queue<User> userQueue = new LinkedList<>(users);
            PriorityQueue<User> priorityQueue = new PriorityQueue<>(Comparator.comparing(User::getRole));

            priorityQueue.addAll(users);
            userQueue.addAll(users);

            LibraryServiceImp libraryServiceImp = new LibraryServiceImp();

            System.out.println(userQueue);
            System.out.println(priorityQueue);

            User librarian = users.stream().filter(user -> user.getRole() == Role.LIBRARIAN).findFirst().orElse(null);

            if (librarian != null) {
                // First Implementation
                System.out.println(libraryServiceImp.lendBook(priorityQueue, librarian, books.get(0)));
                System.out.println(libraryServiceImp.lendBook(priorityQueue, librarian, books.get(0)));

                System.out.println(libraryServiceImp.lendBook(userQueue, librarian, books.get(0)));
                System.out.println(libraryServiceImp.lendBook(userQueue, librarian, books.get(1)));

                User user1 = users.stream().filter(user -> user.getRole() == Role.SENIOR_STUDENT).findFirst().orElse(null);
                if (user1 != null) {
                    System.out.println(libraryServiceImp.lendBook(userQueue, user1, books.get(1)));
                }
            }

            UserServiceImp userServiceImp = new UserServiceImp();

            User user1 = users.stream().filter(user -> user.getName().equals("MIKE JAMES")).findFirst().orElse(null);
            if (user1 != null) {
                System.out.println(userServiceImp.makeRequest(books.get(0), user1));
            }

            try {
                System.out.println(userServiceImp.requestForBook("ESSENTIAL CHEMISTRY", "RAYMOND CHANG", 1));
            } catch (BookException e) {
                System.err.println(e.toString());
            }
        }

        private static List<Book> createBooks() {
            return List.of(
                    new Book("ESSENTIAL CHEMISTRY", "RAYMOND CHANG", Genre.CHEMISTRY, 5),
                    new Book("NEW SCHOOL MATHEMATICS", "PEARSON", Genre.MATHEMATICS, 5),
                    new Book("NEW SCHOOL BIOLOGY", "WYETH F.J", Genre.BIOLOGY, 3),
                    new Book("DEATH BUT LIVING", "JIM CAPELO", Genre.SCI_FI, 6),
                    new Book("THE GODS ARE ANGRY", "CHINUA ACHEBE", Genre.DRAMA, 2),
                    new Book("YOUR REIGN", "CHRIS MIKE", Genre.SCI_FI, 4)
            );
        }

        private static List<User> createUsers() {
            return List.of(
                    new User("LUCKY GRACE", "LIB001", "09087676541", Role.LIBRARIAN),
                    new User("MIKE JAMES", "LIB002", "08087623411", Role.SENIOR_STUDENT),
                    new User("DAVID UCHECHUKWU", "LIB003", "09076898546", Role.TEACHER),
                    new User("OKPARA CHIOMA", "LIB004", "08067896745", Role.JUNIOR_STUDENT)
            );
        }
    }

