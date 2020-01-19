import account.Account;
import product.Product;

import java.util.ArrayList;

public class BalanceSheet {

    private ArrayList<Account> accounts;

    public BalanceSheet() {
        accounts = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public int checkSize() {
        return this.accounts.size();
    }

    public long netWorthValue() {
        long result = 0;
        for (Account account : this.accounts) {
            for (Product product : account.getProducts()) {
                if (product.getType() == "asset") {
                    result += product.getGBPValue();
                }
                else if (product.getType() == "liability") {
                    result -= product.getGBPValue();
                }
                else {
                    return 0;
                }
            }
        }
        return result;
    }

    public long netWorthGBPValue() {
        long result = 0;
        for (Account account : this.accounts) {
            for (Product product : account.getProducts()) {
                if (product.getType() == "asset") {
                   double SWRA = (product.getGBPValue() - ((product.getRiskRating() * 0.05) * product.getGBPValue()));
                    result += (new Double(SWRA)).longValue();
                }
                else if (product.getType() == "liability") {
                   double SWRA = (product.getGBPValue() - ((product.getRiskRating() * 0.05) * product.getGBPValue()));
                    result -= (new Double(SWRA)).longValue();
                }
                else {
                    return 0;
                }
            }
        }
        return result;
    }
}