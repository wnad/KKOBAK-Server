package com.dundun213.kkobak.KKOBAKServer.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QExerciseCategory is a Querydsl query type for ExerciseCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExerciseCategory extends EntityPathBase<ExerciseCategory> {

    private static final long serialVersionUID = 1298179581L;

    public static final QExerciseCategory exerciseCategory = new QExerciseCategory("exerciseCategory");

    public final SetPath<com.dundun213.kkobak.KKOBAKServer.Enum.BodyPart, EnumPath<com.dundun213.kkobak.KKOBAKServer.Enum.BodyPart>> bodyParts = this.<com.dundun213.kkobak.KKOBAKServer.Enum.BodyPart, EnumPath<com.dundun213.kkobak.KKOBAKServer.Enum.BodyPart>>createSet("bodyParts", com.dundun213.kkobak.KKOBAKServer.Enum.BodyPart.class, EnumPath.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QExerciseCategory(String variable) {
        super(ExerciseCategory.class, forVariable(variable));
    }

    public QExerciseCategory(Path<? extends ExerciseCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExerciseCategory(PathMetadata metadata) {
        super(ExerciseCategory.class, metadata);
    }

}

