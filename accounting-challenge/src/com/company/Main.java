package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main<getCustomerData> {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );
    public static void main(String[] args) {
        //Update this

        List<Customer> customers = new ArrayList<>();
        List<Integer> id = new ArrayList<>();

        List<Customer> positiveCustomers = null;
        List<Customer> negativeCustomers = null;


        for (String[] custData : customerData) {
            int currID = Integer.parseInt(custData[0]);
            if (id.contains(currID)) {
                for (Customer cust : customers) {
                    if (cust.getId() == currID) {
                        // Update Existing customer account record
                        Customer exCustomer = customers.get(customers.indexOf(cust));
                        AccountRecord accountRecord = new AccountRecord();
                        accountRecord.setCharge(Integer.parseInt(custData[2]));
                        accountRecord.setChargeDate(custData[3]);
                        exCustomer.getCharges().add(accountRecord);
                    }
                }
            } else {
                id.add(currID);

                // Create customer
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(custData[0]));
                customer.setName(custData[1]);

                //Create accountRecord
                AccountRecord accountRecord = new AccountRecord();
                accountRecord.setCharge(Integer.parseInt(custData[2]));
                accountRecord.setChargeDate(custData[3]);

                customer.getCharges().add(accountRecord);

                //Add Customer
                customers.add(customer);
            }
             positiveCustomers = new ArrayList<>();
             negativeCustomers = new ArrayList<>();

            for (Customer cust: customers) {
                if (cust.getBalance() >= 0) {
                    positiveCustomers.add(cust);
                } else {
                    negativeCustomers.add(cust);
                }
            }
        }
        System.out.println("Printing out all positive accounts");
        System.out.println(positiveCustomers);
        System.out.println();

        System.out.println("Printing out all negative accounts");
        System.out.println(negativeCustomers);
        System.out.println();



    }
}
