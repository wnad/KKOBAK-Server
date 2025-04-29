package com.dundun213.kkobak.KKOBAKServer.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 920639826L;

    public static final QUser user = new QUser("user");

    public final EnumPath<com.dundun213.kkobak.KKOBAKServer.Enum.CalendarView> calendarViewType = createEnum("calendarViewType", com.dundun213.kkobak.KKOBAKServer.Enum.CalendarView.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isTodayColored = createBoolean("isTodayColored");

    public final BooleanPath isWeekendColored = createBoolean("isWeekendColored");

    public final StringPath name = createString("name");

    public final StringPath provider = createString("provider");

    public final StringPath providerId = createString("providerId");

    public final EnumPath<com.dundun213.kkobak.KKOBAKServer.Enum.UserRole> role = createEnum("role", com.dundun213.kkobak.KKOBAKServer.Enum.UserRole.class);

    public final StringPath todayColor = createString("todayColor");

    public final StringPath weekendColor = createString("weekendColor");

    public final EnumPath<java.time.DayOfWeek> weekStart = createEnum("weekStart", java.time.DayOfWeek.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

