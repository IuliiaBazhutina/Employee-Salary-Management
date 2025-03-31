
public class DeductionsUtility {

    // Federal income tax rate 2025
    public static final double[][] INCOME_TAX_FED_RATE = {
        {0, 57375, 0.15}, // 15% on income up to $57,375
        {57375, 114750, 0.205}, // 20.5% on income over $57,375 and up to $114,750
        {114750, 177882, 0.26}, // 26% on income over $114,750 and up to $177,882
        {177882, 253414, 0.29}, // 29% on income over $177,882 and up to $253,414
        {253414, 100000000, 0.33} // 33% on income over $253,414
    };

    // Provincial income tax rate 2025
    public static final double[][] INCOME_TAX_PROV_RATE = {
        {0, 52886, 0.0505}, // 5.05% on income up to $52,886
        {52886, 105775, 0.0915}, // 9.15% on income over $52,886 and up to $105,775
        {105775, 150000, 0.1116}, // 11.16% on income over $105,775 and up to $150,000
        {150000, 220000, 0.1216}, // 12.16% on income over $150,000 and up to $220,000
        {220000, 100000000, 0.1316} // 13.16% on income over $220,000
    };

    // Emloyment insurance rate and maximum anual employee premium 2025
    public static final double EI_RATE = 0.0164; // 1.64% of earning 
    public static final double MAX_ANUAL_EMP_PREMIUM_EI = 1077.48; // the maximum amount that the employee must pay in EI premiums in a year

    // Canada Pension Plan rate and maximum anual contribution 2025
    public static final double CPP_RATE = 0.0595; // 5.95% of earning
    public static final double MAX_ANUAL_CONTR_CPP = 4034.10; // the maximum amount that the employee must pay in EI contribution in a year

    // Union dues
    public static final double UNION_DUES_PSAC = 0.009617; // 0.9617% of a member's salary
    public static final double UNION_DUES_PIPSC = 90.06; // $90.06 per month
    public static final double UNION_DUES_CUPE = 0.0085; // 0.85% of a member's salary
    
    
    // calculate Federal income tax per a month
    public static double calculateIncTaxFed(double grossSalary) {
        double salaryPerYear = grossSalary * 12; // predicted sum of salary for 12 months
        double taxPerYear = 0;
        // iterate through the income tax brackets and apply tax rates
        for (int i = 0; i < INCOME_TAX_FED_RATE.length; i++) {
            // Check if the annual salary is within the current tax bracket
            if (salaryPerYear <= INCOME_TAX_FED_RATE[i][1]) {
                // Calculate tax for the portion of salary within the current tax bracket
                taxPerYear += (salaryPerYear - INCOME_TAX_FED_RATE[i][0]) * INCOME_TAX_FED_RATE[i][2];
                break; // Exit the loop as we've finished the calculation
            } else {
                // Calculate tax for the entire salary within the current tax bracket
                taxPerYear += (INCOME_TAX_FED_RATE[i][1] - INCOME_TAX_FED_RATE[i][0]) * INCOME_TAX_FED_RATE[i][2];
            }
        }
        // Return the monthly tax by dividing the tax per year by 12
        return taxPerYear / 12;
    }

    
    // calculate Provintial income tax per a month
    public static double calculateIncTaxProv(double grossSalary) {
        double salaryPerYear = grossSalary * 12; // predicted sum of salary for 12 months
        double taxPerYear = 0;
        // iterate through the income tax brackets and apply tax rates
        for (int i = 0; i < INCOME_TAX_PROV_RATE.length; i++) {
            // Check if the annual salary is within the current tax bracket
            if (salaryPerYear <= INCOME_TAX_PROV_RATE[i][1]) {
                // Calculate tax for the portion of salary within the current tax bracket
                taxPerYear += (salaryPerYear - INCOME_TAX_PROV_RATE[i][0]) * INCOME_TAX_PROV_RATE[i][2];
                break; // Exit the loop as we've finished the calculation
            } else {
                // Calculate tax for the entire salary within the current tax bracket
                taxPerYear += (INCOME_TAX_PROV_RATE[i][1] - INCOME_TAX_PROV_RATE[i][0]) * INCOME_TAX_PROV_RATE[i][2];
            }
        }
        // Return the monthly tax by dividing the tax per year by 12
        return taxPerYear / 12;
    }

    
    // calculate EI 
    public static double calculateEI(double grossSalary) {
        // calculate the EI premium, but limit it to the maximum annual premium
        double premium = Math.min((grossSalary * EI_RATE), MAX_ANUAL_EMP_PREMIUM_EI);
        return premium;
    }

    
    // calculate CPP
    public static double calculateCPP(double grossSalary) {
        // calculate the CPP contribution, but limit it to the maximum annual contribution
        double contribution = Math.min((grossSalary * CPP_RATE), MAX_ANUAL_CONTR_CPP);
        return contribution;
    }

    
    // calculate Union dues depends on employee's Union
    public static double calculateUnionDue(Unions union, double grossSalary) {
        double due;
        switch(union.toString()){
            case "PSAC":  due = grossSalary * UNION_DUES_PSAC; 
                            break;
            case "PIPSC":  due = UNION_DUES_PIPSC; 
                            break;
            case "CUPE":  due = grossSalary * UNION_DUES_CUPE; 
                            break;
            default: due = 0;}
        return due;
    }

    
    // calculate total deductions
    public static double calculateDeductions(Unions union, double grossSalary) {
        double deductions = calculateIncTaxFed(grossSalary) + calculateIncTaxProv(grossSalary) + calculateEI(grossSalary) + calculateCPP(grossSalary) + calculateUnionDue(union, grossSalary);
        return deductions;
    }

    
    // return String with information about every deduction and total
    public static String displayDeductions(Unions union, double grossSalary) {
        String message = "";
        message += String.format("\n%-25s", "Federal Income tax:  ") + String.format("%10.2f", calculateIncTaxFed(grossSalary));
        message += String.format("\n%-25s", "Provincial Income tax:  ") + String.format("%10.2f", calculateIncTaxProv(grossSalary));
        message += String.format("\n%-25s", "EI premium:  ") + String.format("%10.2f", calculateEI(grossSalary));
        message += String.format("\n%-25s", "CPP contribution:  ") + String.format("%10.2f", calculateCPP(grossSalary));
        message += String.format("\n%-25s", "Union due:  ") + String.format("%10.2f", calculateUnionDue(union, grossSalary));
        message += "\n-----------------------------------";
        message += String.format("\n%-25s", "Deductions total:  ") + String.format("%10.2f", calculateDeductions(union, grossSalary));
        return message;
    }
}

