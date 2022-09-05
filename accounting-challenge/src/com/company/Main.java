package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

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


        for(String[] customerRecord : customerData) {

            int currID = Integer.parseInt(customerRecord[0]);

            if (id.contains(currID)) {
                for (Customer cust : customers) {
                    if (cust.getId() == currID) {
                        //update existing information
                        Customer customer = customers.get(customers.indexOf(cust));
                        AccountRecord accountRecord = new AccountRecord();
                        accountRecord.setCharge(Integer.parseInt(customerRecord[2]));
                        accountRecord.setChargeDate(customerRecord[3]);
                        customer.getCharges().add(accountRecord);

                    }

                }
            } else {
                id.add(currID);

                // Create Customer
                Customer customer = new Customer();
                id.add(Integer.parseInt(customerRecord[0]));
                customer.setName(customerRecord[1]);


                AccountRecord accountRecord = new AccountRecord();
                accountRecord.setCharge(Integer.parseInt(customerRecord[2]));
                accountRecord.setChargeDate(customerRecord[3]);

                customer.getCharges().add(accountRecord);

                customers.add(customer);


            }



        }


    }
}
