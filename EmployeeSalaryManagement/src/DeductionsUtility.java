
public class DeductionsUtility {

    public static final double[][] INCOME_TAX_FED_RATE = {
        {0, 57375, 0.15}, // 15% on income up to $57,375
        {57375, 114750, 0.205}, // 20.5% on income over $57,375 and up to $114,750
        {114750, 177882, 0.26}, // 26% on income over $114,750 and up to $177,882
        {177882, 253414, 0.29}, // 29% on income over $177,882 and up to $253,414
        {253414, 100000000, 0.33} // 33% on income over $253,414
    };
    public static final double[][] INCOME_TAX_PROV_RATE = {
        {0, 52886, 0.0505}, // 5.05% on income up to $52,886
        {52886, 105775, 0.0915}, // 9.15% on income over $52,886 and up to $105,775
        {105775, 150000, 0.1116}, // 11.16% on income over $105,775 and up to $150,000
        {150000, 220000, 0.1216}, // 12.16% on income over $150,000 and up to $220,000
        {220000, 100000000, 0.1316} // 13.16% on income over $220,000
    };

    public static final double EI_RATE = 0.0164; // 1.64% 
    public static final double CPP_RATE = 0.0595; // 5.95%
    public static final double UNION_DUES = 73.18; // $73.18 per month (ACFO-ACAF) since April 1, 2025

    public static double calculateIncTaxFed(double grossSalary) {
        
        double salaryPerYear = grossSalary * 12; // predicted sum of salary for 12 months
        double taxPerYear = 0;

        for (int i = 0; i < INCOME_TAX_FED_RATE.length; i++) {

            if (salaryPerYear <= INCOME_TAX_FED_RATE[i][1]) {
                taxPerYear += (salaryPerYear - INCOME_TAX_FED_RATE[i][0]) * INCOME_TAX_FED_RATE[i][2];
                break;
            } 
            else {
                taxPerYear += (INCOME_TAX_FED_RATE[i][1] - INCOME_TAX_FED_RATE[i][0]) * INCOME_TAX_FED_RATE[i][2];
            }

        }

        return taxPerYear / 12;
    }
    
        public static double calculateIncTaxProv(double grossSalary) {
        
        double salaryPerYear = grossSalary * 12; // predicted sum of salary for 12 months
        double taxPerYear = 0;

        for (int i = 0; i < INCOME_TAX_PROV_RATE.length; i++) {

            if (salaryPerYear <= INCOME_TAX_PROV_RATE[i][1]) {
                taxPerYear += (salaryPerYear - INCOME_TAX_PROV_RATE[i][0]) * INCOME_TAX_PROV_RATE[i][2];
                break;
            } 
            else {
                taxPerYear += (INCOME_TAX_PROV_RATE[i][1] - INCOME_TAX_PROV_RATE[i][0]) * INCOME_TAX_PROV_RATE[i][2];
            }

        }

        return taxPerYear / 12;
    }
}
