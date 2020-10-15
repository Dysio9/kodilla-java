package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @InjectMocks
    ForumStatistics forumStatistics;

    @Mock
    Statistics statisticsMock;

    @ParameterizedTest
    @CsvSource({"50,50,100,1", "50,0,100,0", "50,50,0,1", "50,100,50,2", "50,50,100,1", "0,50,100,0", "100,50,100,0.5"})
    void testForumStatisticsPostsPerUser(int noOfUsers, int noOfPosts, int noOfComments, double expectedPostsPerUser) {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(noOfUsers));
        when(statisticsMock.postsCount()).thenReturn(noOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(noOfComments);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(expectedPostsPerUser, forumStatistics.getMeanPostsPerUser());
    }

    @ParameterizedTest
    @CsvSource({"50,50,100,2", "50,0,100,2", "50,50,0,0", "50,100,50,1", "50,50,100,2", "0,50,100,0", "100,50,100,1"})
    void testForumStatisticsCommentPerUser(int noOfUsers, int noOfPosts, int noOfComments, double expectedCommentsPerUser) {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(noOfUsers));
        when(statisticsMock.postsCount()).thenReturn(noOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(noOfComments);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(expectedCommentsPerUser, forumStatistics.getMeanCommentsPerUser());
    }

    @ParameterizedTest
    @CsvSource({"50,50,100,2", "50,0,100,0", "50,50,0,0", "50,100,50,0.5", "50,50,100,2", "0,50,100,2", "100,50,100,2"})
    void testForumStatisticsCommentPerPost(int noOfUsers, int noOfPosts, int noOfComments, double expectedCommentsPerPost) {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(noOfUsers));
        when(statisticsMock.postsCount()).thenReturn(noOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(noOfComments);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(expectedCommentsPerPost, forumStatistics.getMeanCommentsPerPost());
    }

    private List<String> generateListOfUsers(int userQuantity) {
        List<String> userNames = new ArrayList<>();
        for (int i = 1; i <= userQuantity; i++) {
            userNames.add("User" + i);
        }
        return userNames;
    }
}
