# TaxHRACalculator
To calculate TAX and HRA as per your salary in India for year 2020-2021

Import This as a project in intelliJ idea (Scala)

This will help to decide which income tax slab is better for an Individual in India Also It will help to calculate HRA amount you can avail for tax benefits

Use 1 : Calculation of Incometax for year 2020-2021 run IncometaxCalculator.scala file

Information needed from user side : Fixed salary : This doesn't include PF of employer and graduity (It includes employee's contribution to PF)

Property file needs below information : (You can add additional row in simillar format for any extra deduction you are availing ) Std Deduction:50000 HRA:0 PF(80C):0 PPF(80C):0 Home Loan Principal(80C):0 Home Loan Interest:0 Medical Insurance:0 NPS:0 extra:0

Use 2 : Calculation of HRA amount for tax exemption In property file, hra_info.txt, you have to add information in below sequence Name,basic_salary,rent_paid,hra_received

Mark,500000,150000,200000 Steve,350000,120000,250000

You can have multiple entries like this in separate lines (Use this amount in first scenario where you need HRA amount for tax calculation)
