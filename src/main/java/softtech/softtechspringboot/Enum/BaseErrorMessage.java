package softtech.softtechspringboot.Enum;

public enum BaseErrorMessage {

    ITEM_NOT_FOUND("Item not found!"),
    UNIQUE_PHONE_NUMBER("Phone number cannot be the same!"),
    UNIQUE_EMAIL("Email cannot be the same!"),
    UNIQUE_USERNAME("Username cannot be the same!"),
    ;

    private final String message;

    BaseErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
