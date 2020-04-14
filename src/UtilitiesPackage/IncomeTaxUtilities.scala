package UtilitiesPackage

import scala.io.Source

class IncomeTaxUtilities {

  def getTotalTaxExemptions():Double = {
    val file = System.getProperty("user.dir")+"\\tax_exemptions.txt"
    var exemptionMap = scala.collection.mutable.Map("" -> 0)
    var eightyCTotal, otherTotal, interestTotal, total_exemption:Int = 0

    for(line <- Source.fromFile(file).getLines) {
      exemptionMap = exemptionMap.addOne(line.split(":")(0) -> line.split(":")(1).toInt)
    }

    for (item <- exemptionMap.keySet){
      if (item.contains("80C")) eightyCTotal += exemptionMap(item)
      else if (item.contains("Home Loan Interest")) interestTotal += exemptionMap(item)
      else otherTotal += exemptionMap(item)
    }
    total_exemption = Math.min(eightyCTotal, 150000) + Math.min(interestTotal, 200000) + otherTotal
    total_exemption
  }
  
  def calculateTaxableIncome(income:Int):Double = {
    val tax_exemptions: Double = getTotalTaxExemptions()
    val taxable_income = income - tax_exemptions
    taxable_income
  }


  def calculateTaxAsPerOldRules(income:Int ):Double = {
    var tax : Double = 0.0;
    var total_tax : Double = 0.0
    var taxable_income : Double = calculateTaxableIncome(income)

    while (taxable_income > 250000){
      if (taxable_income > 1000000){
        tax = 0.30 * (taxable_income-1000000)
        taxable_income = taxable_income - (taxable_income -1000000);
        total_tax += tax
      }
      if (taxable_income > 500000) {
        tax = 0.20 * (taxable_income - 500000)
        taxable_income = taxable_income - (taxable_income - 500000);
        total_tax += tax
      }
      if (taxable_income > 250000){
        tax = 0.05 * (taxable_income-250000)
        taxable_income = taxable_income - (taxable_income - 250000);
        total_tax += tax
      }
    }
    return total_tax
  }


  def calculateTaxAsPerNewRules(income:Int ):Double = {
    var tax : Double = 0.0;
    var total_tax : Double = 0.0
    var taxable_income : Int = income;

    while (taxable_income > 250000){
      if (taxable_income > 1500000){
        tax = 0.30 * (taxable_income - 1500000)
        taxable_income = taxable_income - (taxable_income - 1500000);
        total_tax += tax
      }
      if (taxable_income > 1250000){
        tax = 0.25 * (taxable_income-1250000)
        taxable_income = taxable_income - (taxable_income - 1250000);
        total_tax += tax
      }
      if (taxable_income > 1000000){
        tax = 0.20 * (taxable_income-1000000)
        taxable_income = taxable_income - (taxable_income - 1000000);
        total_tax += tax
      }
      if (taxable_income > 750000){
        tax = 0.15 * (taxable_income-750000)
        taxable_income = taxable_income - (taxable_income - 750000);
        total_tax += tax
      }
      if (taxable_income > 500000){
        tax = 0.10 * (taxable_income-500000)
        taxable_income = taxable_income - (taxable_income - 500000);
        total_tax += tax
      }
      if (taxable_income > 250000){
        tax = 0.05 * (taxable_income-250000)
        taxable_income = taxable_income - (taxable_income - 250000);
        total_tax += tax
      }
    }
    return total_tax
  }


  def getInhandSalary(income:Int, tax:Double):Double = {
    var file = System.getProperty("user.dir")+"\\tax_exemptions.txt"
    var pf_amount : Double = 0.0
    for(line <- Source.fromFile(file).getLines) {
      if(line.split(":")(0).equalsIgnoreCase("PF")){
        pf_amount= line.split(":")(1).toDouble
      }
    }
    ((income-tax-pf_amount) / 12).round
  }

}
