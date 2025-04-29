package com.dundun213.kkobak.KKOBAKServer.Config;

import com.dundun213.kkobak.KKOBAKServer.Entity.QExerciseCategory;
import com.dundun213.kkobak.KKOBAKServer.Entity.QRecordSet;
import com.dundun213.kkobak.KKOBAKServer.Entity.QUser;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;

public class QuerydslConfig {

    static{
        QUser user = QUser.user;
        QRecordSet recordSet = QRecordSet.recordSet;
        QExerciseCategory exerciseCategory = QExerciseCategory.exerciseCategory;
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

}