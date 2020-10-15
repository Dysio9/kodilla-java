package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumStatistics implements Statistics {
    Statistics statistics;
    private double meanCommentsPerUser;
    private double meanPostsPerUser;
    private double meanCommentsPerPost;

    public ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        if (statistics.usersNames().size() > 0) {
            this.meanCommentsPerUser = statistics.commentsCount() / (double)statistics.usersNames().size();
        } else this.meanCommentsPerUser = 0;
        if (statistics.usersNames().size() > 0) {
            this.meanPostsPerUser = statistics.postsCount() / (double)statistics.usersNames().size();
        } else this.meanPostsPerUser = 0;
        if (statistics.postsCount() > 0) {
            this.meanCommentsPerPost = statistics.commentsCount() / (double)statistics.postsCount();
        } else this.meanCommentsPerPost = 0;
    }

    @Override
    public List<String> usersNames() {
        return statistics.usersNames();
    }

    @Override
    public int postsCount() {
        return statistics.postsCount();
    }

    @Override
    public int commentsCount() {
        return statistics.commentsCount();
    }

    public double getMeanCommentsPerUser() {
        return meanCommentsPerUser;
    }

    public double getMeanPostsPerUser() {
        return meanPostsPerUser;
    }

    public double getMeanCommentsPerPost() {
        return meanCommentsPerPost;
    }
}
