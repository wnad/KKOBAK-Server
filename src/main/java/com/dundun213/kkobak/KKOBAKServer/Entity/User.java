package com.dundun213.kkobak.KKOBAKServer.Entity;

import com.dundun213.kkobak.KKOBAKServer.Enum.CalendarView;
import com.dundun213.kkobak.KKOBAKServer.Enum.UserRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.DayOfWeek;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "회원 고유 ID", example = "1")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(description = "유저 역할", example = "USER")
    private UserRole role;

    @Comment("소셜 로그인 제공자: GOOGLE, KAKAO, NAVER 등")
    @Column(nullable = false)
    @Schema(description = "소셜 로그인 제공자", example = "GOOGLE")
    private String provider;

    @Comment("소셜 로그인 고유 ID (sub, id 등)")
    @Column(nullable = false)
    @Schema(description = "소셜 로그인 고유 ID", example = "117845612345678901234")
    private String providerId;

    @Comment("유저이름")
    @Column(nullable = false)
    @Schema(description = "유저 이름", example = "홍길동")
    private String name;

    @Column(nullable = false, unique = true)
    @Schema(description = "이메일", example = "user@example.com")
    private String email;

    @Comment("캘린더 뷰: MONTHLY 또는 WEEKLY")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(
            description = "캘린더 뷰 타입",
            allowableValues = {"MONTHLY","WEEKLY"},
            example = "MONTHLY"
    )
    private CalendarView calendarViewType = CalendarView.MONTHLY;

    @Comment("캘린더 주 시작 요일: MONDAY ~ SUNDAY")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(
            description = "캘린더 주 시작 요일",
            allowableValues = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"},
            example = "MONDAY"
    )
    private DayOfWeek weekStart = DayOfWeek.MONDAY;

    @Comment("주말 날짜 색상 (HEX 문자열)")
    @Schema(description = "주말 날짜 색상", example = "#FFCCCC")
    private String weekendColor = "#FFCCCC";

    @Comment("주말 날짜 색상 ON / OFF")
    @Schema(description = "주말 날짜 색상 표시 여부", example = "true")
    private Boolean isWeekendColored = true;

    @Comment("오늘 날짜 강조 색상")
    @Schema(description = "오늘 날짜 강조 색상", example = "#FFEB3B")
    private String todayColor = "#FFEB3B";

    @Comment("오늘 날짜 색상 ON / OFF")
    @Schema(description = "오늘 날짜 강조 표시 여부", example = "true")
    private Boolean isTodayColored = true;


    public String getName() {
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

}
