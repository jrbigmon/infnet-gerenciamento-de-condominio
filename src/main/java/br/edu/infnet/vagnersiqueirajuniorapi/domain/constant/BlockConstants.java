package br.edu.infnet.vagnersiqueirajuniorapi.domain.constant;

public final class BlockConstants {
    public static final int MIN_FLOORS = 0;
    public static final int MAX_FLOORS = 100;
    public static final int MIN_APARTMENTS_PER_FLOOR = 1;
    public static final int MAX_APARTMENTS_PER_FLOOR = 40;
    public static final int MIN_APARTMENTS = 1;
    public static final int MAX_APARTMENTS = MAX_FLOORS * MAX_APARTMENTS_PER_FLOOR;

    private BlockConstants() {
    }
}
