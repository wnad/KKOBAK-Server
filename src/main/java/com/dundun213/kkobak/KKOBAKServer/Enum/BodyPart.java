package com.dundun213.kkobak.KKOBAKServer.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum BodyPart implements Constant<BodyPart>{

    CHEST("가슴"), BACK("등"), CORE("코어"), SHOULDER("어깨"), ARM("팔"), LEG("하체");

    private final String label;

    @JsonValue
    @Override
    public String getLabel(){return label; }

    @JsonCreator
    @Override
    public BodyPart findByLabel(String label){
        return Arrays.stream(values())
                .filter(value->value.label.equals(label))
                .findAny()
                .orElse(null);
    }

}
