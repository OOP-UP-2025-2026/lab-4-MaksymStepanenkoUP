package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

/**
 * Клас {@code DiscountBill2} яке підтримує нарахування
 *  * знижок постійним покупцям.
 * <p>
 * Реалізовано за принципом композиції. Об’єкт {@link GroceryBill}
 * використовується всередині цього класу.
 * </p>
 */
public class DiscountBill2 {

    /** Об'єкт, який містить дані звичайного покупця. */
    private final GroceryBill bill;

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
    public DiscountBill2(final Employee clerk,
                         final boolean isRegularCustomer) {
        this.bill = new GroceryBill(clerk);
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
    public void add(final Item i) {
        bill.add(i);
        if (regularCustomer) {
            if (i.getDiscount() > 0.0) {
                discountCount = discountCount + 1;
                discountAmount = discountAmount + i.getDiscount();
            }
        }
    }

    /**
     * Повертає загальну суму рахунку з
     * урахуванням знижок для постійних покупців.
     *
     * @return загальна сума рахунку
     */
    public double getTotal() {
        if (!regularCustomer) {
            return bill.getTotal();
        } else {
            return bill.getTotal() - discountAmount;
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
            double total = bill.getTotal();
            if (total > 0.0) {
                return (discountAmount * 100) / total;
            } else {
                return 0.0;
            }
        } else {
            return 0.0;
        }
    }

    /**
     * Повертає clerk.
     *
     * @return об’єкт {@link Employee}, який створив рахунок
     */
    public Employee getClerk() {
        return bill.getClerk();
    }
}
