import java.io.Serializable;
import java.util.Objects;

public class UserExchangeId implements Serializable {
    private Integer userId;
    private Integer exchangeId;

    // 기본 생성자, equals() 및 hashCode() 메서드 구현
    public UserExchangeId() {}

    public UserExchangeId(Integer userId, Integer exchangeId) {
        this.userId = userId;
        this.exchangeId = exchangeId;
    }

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
