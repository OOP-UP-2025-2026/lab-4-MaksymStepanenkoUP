package ua.opnu;

import java.awt.Point;

/**
 * Розширює {@link Point}, додаючи функціонал для операцій з 3 вимірами.
 * <p>
 */
public class Point3D extends Point {

    /** Координата точки z. */
    private double z;

    /**
     * Конструктор. Створює точку у координатах (0, 0, 0).
     */
    public Point3D() {
        super(0, 0);
        this.z = 0;
    }

    /**
     * Конструктор, який створює точку з указаними координатами.
     *
     * @param x координата X
     * @param y координата Y
     * @param z координата Z
     */
    public Point3D(final int x, final int y, final int z) {
        super(x, y);
        this.z = z;
    }

    /**
     * Встановлює нові координати у двовимірному просторі.
     * Координата Z встановлюється у 0.
     *
     * @param x координата X
     * @param y координата Y
     */
    public void setLocation(final int x, final int y) {
        super.x = x;
        super.y = y;
        this.z = 0;
    }

    /**
     * Встановлює нові координати у тривимірному просторі.
     *
     * @param x координата X
     * @param y координата Y
     * @param z координата Z
     */
    public void setLocation(final int x, final int y, final int z) {
        super.x = x;
        super.y = y;
        this.z = z;
    }

    /**
     * Обчислює відстань від цієї точки до заданої точки {@code p}.
     *
     * @param p інша точка {@code Point3D}
     * @return відстань між цими двома точками
     */
    public double distance(final Point3D p) {
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        double dz = z - p.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * Повертає координату X цієї точки.
     *
     * @return координата X
     */
    @Override
    public double getX() {
        return super.getX();
    }

    /**
     * Повертає координату Y.
     *
     * @return координата Y
     */
    @Override
    public double getY() {
        return super.getY();
    }

    /**
     * Повертає координату Z.
     *
     * @return координата Z
     */
    public double getZ() {
        return z;
    }

    /**
     * Обчислює відстань від цієї точки до початку координат (0, 0, 0).
     *
     * @return відстань до початку координат
     */
    public double distanceFromOrigin() {
        double x = getX();
        double y = getY();
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Повертає текстове представлення точки у форматі:
     * {@code Point3D[x=..., y=..., z=...]}.
     *
     * @return рядок з описом координат точки
     */
    @Override
    public String toString() {
        return getClass().getName() + "[x=" + x + ", y=" + y + ", z=" + z + "]";
    }
}
