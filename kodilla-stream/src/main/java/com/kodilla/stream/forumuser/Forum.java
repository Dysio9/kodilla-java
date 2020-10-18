package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUsers = new ArrayList<>();

    public Forum() {
        forumUsers.add(new ForumUser(1, "Felek", 'M', LocalDate.of(1988, 6, 10), 53));
        forumUsers.add(new ForumUser(2, "Ala", 'K', LocalDate.of(1998, 7, 18), 6));
        forumUsers.add(new ForumUser(3, "Boguś", 'M', LocalDate.of(1982, 2, 1), 150));
        forumUsers.add(new ForumUser(4, "Zylda", 'K', LocalDate.of(1972, 1, 11), 0));
        forumUsers.add(new ForumUser(5, "Kumi", 'K', LocalDate.of(1979, 9, 2), 689));
        forumUsers.add(new ForumUser(6, "Bunia", 'K', LocalDate.of(2000, 9, 28), 2));
        forumUsers.add(new ForumUser(7, "Staszek", 'M', LocalDate.of(2005, 11, 16), 33));
        forumUsers.add(new ForumUser(8, "Ziomek", 'M', LocalDate.of(1995, 10, 14), 0));
        forumUsers.add(new ForumUser(9, "Frytka", 'K', LocalDate.of(2003, 1, 30), 130));
    }

    public List<ForumUser> getForumUsers() {
        return new ArrayList<>(forumUsers);
    }
}
