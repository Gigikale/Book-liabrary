package model;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    public int compare(User o1, User o2) {
        if (o1.getRole() == Role.TEACHER && o2.getRole() == Role.SENIOR_STUDENT) {
            return -1;
        } else if (o1.getRole() == Role.TEACHER && o2.getRole() == Role.JUNIOR_STUDENT) {
            return -1;
        }else  if (o1.getRole() == Role.SENIOR_STUDENT && o2.getRole() == Role.JUNIOR_STUDENT) {
            return  -1;
        } else if (o1.getRole() == o2.getRole()) {
            return  0;
        } else {
            return 1;
        }
    }
}


