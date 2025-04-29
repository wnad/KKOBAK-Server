package com.dundun213.kkobak.KKOBAKServer.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecordSet is a Querydsl query type for RecordSet
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecordSet extends EntityPathBase<RecordSet> {

    private static final long serialVersionUID = 1081710890L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecordSet recordSet = new QRecordSet("recordSet");

    public final QExerciseCategory category;

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> reps = createNumber("reps", Integer.class);

    public final NumberPath<Integer> setNumber = createNumber("setNumber", Integer.class);

    public final QUser user;

    public final NumberPath<Double> weight = createNumber("weight", Double.class);

    public QRecordSet(String variable) {
        this(RecordSet.class, forVariable(variable), INITS);
    }

    public QRecordSet(Path<? extends RecordSet> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecordSet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecordSet(PathMetadata metadata, PathInits inits) {
        this(RecordSet.class, metadata, inits);
    }

    public QRecordSet(Class<? extends RecordSet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QExerciseCategory(forProperty("category")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

