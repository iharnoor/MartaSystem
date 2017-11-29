package FileViolation;

public enum violations {
    A, B, C, D, E;

    private violations() {
    }

    public String value() {
        return name();
    }

    public static violations fromValue(String v) {
        return valueOf(v);
    }
}
