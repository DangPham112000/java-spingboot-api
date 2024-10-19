package com.dangpham112000;

import com.dangpham112000.entity.feed.FeedEntity;
import com.dangpham112000.entity.user.UserEntity;
import com.dangpham112000.repository.FeedRepository;
import com.dangpham112000.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTest() {
        UserEntity user = new UserEntity();
        FeedEntity feed1 = new FeedEntity();
        FeedEntity feed2 = new FeedEntity();

        user.setUserName("thinhlol");
        user.setUserEmail("lolthinh@gmail.com");

        feed1.setTitle("thinhblog1");
        feed1.setDescription("desblog1");
        feed2.setTitle("thinhblog2");
        feed2.setDescription("desblog2");

        user.setFeedList(List.of(feed1, feed2));
        feed1.setUser(user);
        feed2.setUser(user);

        userRepository.save(user);
    }

}
