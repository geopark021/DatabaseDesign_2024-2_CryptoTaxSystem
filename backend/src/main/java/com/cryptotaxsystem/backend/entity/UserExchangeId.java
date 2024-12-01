package com.cryptotaxsystem.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserExchangeId implements Serializable {
    private Integer userId;
    private Integer exchangeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserExchangeId that = (UserExchangeId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(exchangeId, that.exchangeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, exchangeId);
    }
}
