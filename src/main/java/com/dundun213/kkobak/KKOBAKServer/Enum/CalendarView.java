package com.dundun213.kkobak.KKOBAKServer.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum CalendarView implements Constant<CalendarView> {

    MONTHLY("월간"), WEEKLY("주간");

    private final String label;

    @JsonValue
    @Override
    public String getLabel(){return label; }

    @JsonCreator
    @Override
    public CalendarView findByLabel(String label){
        return Arrays.stream(values())
                .filter(value->value.label.equals(label))
                .findAny()
                .orElse(null);
    }

}
