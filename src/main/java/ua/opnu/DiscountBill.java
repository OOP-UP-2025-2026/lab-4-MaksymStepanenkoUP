package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

/**
 * Розширення класу {@link GroceryBill}, яке підтримує нарахування
 * знижок постійним покупцям.
 * <p>
 * Зберігає кількість товарів зі знижкою та загальну суму знижок.
 */
public class DiscountBill extends GroceryBill {

    /** Кількість товарів зі знижкою, доданих до рахунку. */
    private int discountCount;

    /** Загальна сума знижки для поточного рахунку. */
    private double discountAmount;

    /** Вказує чи покупець є постійним. */
    private final boolean regularCustomer;

    /**
     * Конструктор з початковими значеннями.
     *
     * @param clerk касир
     * @param isRegularCustomer {@code true}, якщо клієнт постійний
     */
    public DiscountBill(final Employee clerk, final boolean isRegularCustomer) {
        super(clerk);
        this.regularCustomer = isRegularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    /**
     * Додає товар до рахунку й оновлює
     * інформацію про знижки для постійних покупців.
     *
     * @param i об’єкт {@link Item}, який додається до рахунку
     */
    @Override
    public void add(final Item i) {
        super.add(i);
        if (regularCustomer && i.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    /**
     * Повертає загальну суму рахунку з
     * урахуванням знижок для постійних покупців.
     *
     * @return загальна сума рахунку
     */
    @Override
    public double getTotal() {
        if (!regularCustomer) {
            return super.getTotal();
        } else {
            return super.getTotal() - discountAmount;
        }
    }

    /**
     * Повертає кількість товарів зі знижкою для постійного покупця.
     *
     * @return кількість товарів зі знижкою. 0 якщо покупець не постійний.
     */
    public int getDiscountCount() {
        if (regularCustomer) {
            return discountCount;
        } else {
            return 0;
        }
    }

    /**
     * Повертає загальну суму знижки для постійного покупця.
     *
     * @return сума знижки. 0.0 якщо покупець не постійний.
     */
    public double getDiscountAmount() {
        if (regularCustomer) {
            return discountAmount;
        } else {
            return 0.0;
        }
    }

    /**
     * Повертає відсоток знижки від загальної
     * вартості рахунку для постійного покупця.
     *
     * @return відсоток знижки. 0.0 якщо покупець не постійний.
     */
    public double getDiscountPercent() {
        if (regularCustomer) {
            return (discountAmount * 100) / super.getTotal();
        } else {
            return 0.0;
        }
    }
}
