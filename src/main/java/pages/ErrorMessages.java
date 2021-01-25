package pages;

public enum ErrorMessages {
    EXPECTED_EMAIL_ERROR("This email address is not available for sign up, try something else"),
    EXPECTED_PASSWORD_ERROR("Your password isn’t strong enough, try making it longer."),
    EXPECTED_PHONE_ERROR("That doesn’t look right, please re-enter your phone number."),
    EXPECTED_BIRTH_DATE_ERROR("That doesn’t look right, please re-enter your birthday."),

    EMAIL_ERROR_MESSAGE("Inconsistency in the email error message"),
    PASSWORD_ERROR_MESSAGE("Inconsistency in the password error message"),
    PHONE_ERROR_MESSAGE("Inconsistency in the phone error message"),
    BIRTH_DATE_ERROR_MESSAGE("Inconsistency in the birth date error message");

    private final String errMessage;

    ErrorMessages(String message){
        this.errMessage = message;
    }

    public String getErrMessage() {
        return this.errMessage;
    }
}
