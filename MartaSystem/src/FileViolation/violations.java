package FileViolation;

public enum violations {
    VIOLATIONS1("Eat On Buses and Trains"),
    VIOLATIONS2("Smoke"),
    VIOLATIONS3("Litter"),
    VIOLATIONS4("Drink On Buses and Trains"),
    VIOLATIONS5("Vandalize"),
    VIOLATIONS6("Write Graffiti"),
    VIOLATIONS7("Panhandle"),
    VIOLATIONS8("Solicit"),
    VIOLATIONS9("Carry Weapons"),
    VIOLATIONS10("Play sound devices without earphones"),
    VIOLATIONS11("Not pay your fare"),
    VIOLATIONS12("Bring animals on board"),
    VIOLATIONS13("Assault MARTA Employees");

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
