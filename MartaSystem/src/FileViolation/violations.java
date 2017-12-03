package FileViolation;

public enum violations {
    VIOLATIONS1("Panhandling"),
    VIOLATIONS2("Soliciting"),
    VIOLATIONS3("Playing a Sound Device"),
    VIOLATIONS4("Having an Animal Onboard"),
    VIOLATIONS5("Carrying a Weapon"),
    VIOLATIONS6("Write Graffiti"),
    VIOLATIONS7("Vandalizing"),
    VIOLATIONS8("Writing Graffiti"),
    VIOLATIONS9("Littering"),
    VIOLATIONS10("Smoking"),
    VIOLATIONS11("Eating Or Drinking");

    private String violation;

    violations(String game) {
        this.violation = game;
    }

    public String violationtype() {
        return violation;
    }

    @Override
    public String toString() {
        return violation;
    }
}
