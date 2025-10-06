package ua.opnu;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

/**
 * Розширення класу {@link BankingAccount}, яке дозволяє відслідковувати
 * мінімальний та максимальний баланс рахунку протягом його існування.
 * <p>
 */
public class MinMaxAccount extends BankingAccount {

    /** Мінімальний баланс. */
    private int minBalance;

    /** Максимальний баланс. */
    private int maxBalance;
    /**
     * Конструктор з початковими значеннями.
     *
     * @param startup початкові дані рахунку
     */
    public MinMaxAccount(final Startup startup) {
        super(startup);
        int initialBalance = super.getBalance();
        this.minBalance = initialBalance;
        this.maxBalance = initialBalance;
    }

    /**
     * Змінює баланс об'єкта d.
     * <p>
     *
     * @param d об’єкт {@link Debit}, що описує суму списання
     */
    @Override
    public void debit(final Debit d) {
        super.debit(d);
        updateMinMax();
    }

    /**
     * Змінює баланс об'єкта c.
     * <p>
     *
     * @param c об’єкт {@link Credit}, що описує суму поповнення
     */
    @Override
    public void credit(final Credit c) {
        super.credit(c);
        updateMinMax();
    }

    /**
     * Знаходить мінімальне та максимальне значення балансу.
     */
    private void updateMinMax() {
        int currentBalance = super.getBalance();
        if (currentBalance < minBalance) {
            minBalance = currentBalance;
        }
        if (currentBalance > maxBalance) {
            maxBalance = currentBalance;
        }
    }

    /**
     * Повертає мінімальний баланс.
     *
     * @return мінімальний баланс
     */
    public int getMin() {
        return minBalance;
    }

    /**
     * Повертає максимальний баланс.
     *
     * @return максимальний баланс
     */
    public int getMax() {
        return maxBalance;
    }
}
