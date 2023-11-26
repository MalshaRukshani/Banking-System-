package classes;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankingSystemTest {

    @Test
    public void testLoanCal() {
        BankingSystem b = new BankingSystem();
        b.loan = 500000;
        b.months = 38;
        assertEquals(219.2, b.loanCal(), 219.3);
    }

    @Test
    public void testDeposit1() {
        BankingSystem b = new BankingSystem();
        b.accountList.add(new Account(30000, "Malsha"));
        String input = "Malsha";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(30000.0, b.checkBalance(), 30000.0);
    }

    @Test
    public void testDeposit2() {
        BankingSystem b = new BankingSystem();
        b.accountList.add(new Account(50000, "Dinusha"));
        String input = "Kawidu";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(-1, b.checkBalance(), -1);
    }
}
