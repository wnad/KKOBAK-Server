package com.dundun213.kkobak.KKOBAKServer.Enum;

public interface Constant<T extends Enum> {

    String getLabel();

    T findByLabel(String label);
}
