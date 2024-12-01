package com.cryptotaxsystem.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserWalletId implements Serializable {
    private Integer userId;
    private Integer walletId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWalletId that = (UserWalletId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(walletId, that.walletId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, walletId);
    }
}
