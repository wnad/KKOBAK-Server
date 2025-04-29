package com.dundun213.kkobak.KKOBAKServer.Entity;

import com.dundun213.kkobak.KKOBAKServer.Enum.BodyPart;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exercise_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "운동 종목(카테고리) 엔티티")
public class ExerciseCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("운동 종목 고유 ID")
    @Schema(description = "운동 종목 고유 ID", example = "1")
    private Long id;

    @Comment("운동 종목 이름 (예: 스쿼트, 벤치프레스 등)")
    @Column(nullable = false, unique = true)
    @Schema(description = "운동 종목 이름", example = "벤치프레스")
    private String name;

    @Comment("이 운동 종목이 속하는 부위 목록")
    @ElementCollection(targetClass = BodyPart.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "exercise_category_body_part",
            joinColumns = @JoinColumn(name = "exercise_category_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "body_part", nullable = false)
    @Schema(
            description = "운동 종목이 속하는 부위 목록",
            example = "[\"CHEST\", \"ARM\"]"
    )
    private Set<BodyPart> bodyParts = new HashSet<>();
}