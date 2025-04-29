package com.dundun213.kkobak.KKOBAKServer.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Entity
@Table(name = "record_set",
        indexes = {
                @Index(name = "idx_user_date", columnList = "user_id, record_date"),
                @Index(name = "idx_user_date_category", columnList = "user_id, record_date, category_id")
        })
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Schema(description = "운동 세트 단위 기록 엔티티")
public class RecordSet extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "기록 고유 ID", example = "100")
    private Long id;

    @Comment("기록한 사용자")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Schema(description = "기록 사용자 정보")
    private User user;

    @Comment("운동한 날짜 (YYYY-MM-DD)")
    @Column(name = "record_date", nullable = false)
    @Schema(description = "운동 기록 날짜", example = "2025-04-24")
    private LocalDate date;

    @Comment("운동 종목 카테고리")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @Schema(description = "운동 종목 카테고리")
    private ExerciseCategory category;

    @Comment("세트 번호 (1부터 시작)")
    @Column(name = "set_number", nullable = false)
    @Schema(description = "세트 번호", example = "1")
    private Integer setNumber;

    @Comment("사용한 강도(kg, km)")
    @Column(nullable = false)
    @Schema(description = "세트별 사용 강도(kg, km)", example = "60.5")
    private Double weight;

    @Comment("반복 횟수")
    @Column(nullable = false)
    @Schema(description = "세트별 반복 횟수", example = "12")
    private Integer reps;
}
