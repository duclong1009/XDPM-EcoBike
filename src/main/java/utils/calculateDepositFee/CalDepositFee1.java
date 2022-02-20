package utils.calculateDepositFee;

public class CalDepositFee1 implements CalculateDepositFee {

    @Override
    public int calculateDepositFee(int fees, int categoryId) {
        int depositF =  (int) (0.4 * fees);
        if(categoryId ==4 ) {
            depositF = (int) (1.5 * depositF);
        }
        return depositF;
    }

}
