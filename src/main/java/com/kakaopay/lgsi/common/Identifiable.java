package com.kakaopay.lgsi.common;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> {
    T getId();
}