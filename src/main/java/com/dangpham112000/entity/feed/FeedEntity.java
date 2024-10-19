package com.dangpham112000.entity.feed;

import com.dangpham112000.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "java_feed_001")
public class FeedEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false)
        private Long id;

        @Column(nullable = false, length = 255)
        private String title;

        @Lob
        @Column(nullable = true)
        private String description;

        @ManyToOne(cascade = CascadeType.ALL, optional = false)
        @JoinColumn(name = "userId", nullable = false)
        private UserEntity user;
}
