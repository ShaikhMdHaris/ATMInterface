package com.company;

import java.util.Scanner;

class ConsoleColors {

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String BLUE = "\033[0;34m";

    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String CYAN_BOLD = "\033[1;36m";

    public static final String YELLOW_BRIGHT = "\033[0;93m";
}

class BankAccountAllInformation
{
    String nameOfAccountHolder, userNameOfAccountHolder, passwordOfAccountHolder, transactionHistory = "";
    float balanceOfAccountHolder = 0.0f;
    int transactionsOfAccountHolder = 0;

    public static void pause_exec(int sec){
        int sleep_in_sec = sec*1000;
        try {
            Thread.sleep(sleep_in_sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void withdrawFromBank()
    {
        System.out.print("\n--> Enter amount to withdraw from Account: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try
        {
            if ( balanceOfAccountHolder >= amount )
            {
                transactionsOfAccountHolder++;
                balanceOfAccountHolder -= amount;
                System.out.print(ConsoleColors.GREEN);
                System.out.println("\n---------------------");
                System.out.println("Withdraw Successfully");
                System.out.println("---------------------");
                System.out.print(ConsoleColors.RESET);
                pause_exec(3);

                String str ="(#) "+ amount + " Rs Withdrawed\n\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else
            {
                System.out.print(ConsoleColors.RED);
                System.out.println("\n-----------------------------------------");
                System.out.println("Your Account won't have this much Balance");
                System.out.println("-----------------------------------------");
                System.out.print(ConsoleColors.RESET);
                pause_exec(3);
            }
        }
        catch ( Exception e){
            System.out.print("");
        }
    }
    public void registerForBank()
    {
        AtmInterfaceMainPage.clr_console();
        System.out.print(ConsoleColors.YELLOW_BOLD);
        System.out.println("""
                
                __________              .__          __                 __  .__              \s
                \\______   \\ ____   ____ |__| _______/  |_____________ _/  |_|__| ____   ____ \s
                 |       _// __ \\ / ___\\|  |/  ___/\\   __\\_  __ \\__  \\\\   __\\  |/  _ \\ /    \\\s
                 |    |   \\  ___// /_/  >  |\\___ \\  |  |  |  | \\// __ \\|  | |  (  <_> )   |  \\
                 |____|_  /\\___  >___  /|__/____  > |__|  |__|  (____  /__| |__|\\____/|___|  /
                        \\/     \\/_____/         \\/                   \\/                    \\/\s
                \n\n""");
        System.out.print(ConsoleColors.RESET);
        Scanner sc = new Scanner(System.in);
        System.out.print(ConsoleColors.BLUE_BOLD);
        System.out.print("\n--> Enter Your Name: ");
        System.out.print(ConsoleColors.RESET);
        this.nameOfAccountHolder = sc.nextLine();
        System.out.print(ConsoleColors.BLUE_BOLD);
        System.out.print("\n--> Enter Your Username: ");
        System.out.print(ConsoleColors.RESET);
        this.userNameOfAccountHolder = sc.nextLine();
        System.out.print(ConsoleColors.BLUE_BOLD);
        System.out.print("\n--> Enter Your Password: ");
        System.out.print(ConsoleColors.RESET);
        this.passwordOfAccountHolder = sc.nextLine();
        System.out.print(ConsoleColors.BLUE_BOLD);
        System.out.print(ConsoleColors.GREEN);
        System.out.print("\n\n--> Registration completed, Enter to Continue...");
        System.out.print(ConsoleColors.RESET);
        sc.nextLine();
    }
    public void checkBalanceInOurAccount()
    {
        System.out.println("Total Balance in your Account is: ₹" + balanceOfAccountHolder);
        pause_exec(5);
    }
    public boolean loginInformation()
    {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while ( !isLogin )
        {
            AtmInterfaceMainPage.clr_console();
            System.out.print(ConsoleColors.YELLOW_BRIGHT);
            System.out.println("""
                    
                         _           _    _                   _    _              _    _                     ____                    \s
                        / \\   _   _ | |_ | |__    ___  _ __  | |_ (_)  ___  __ _ | |_ (_)  ___   _ __       |  _ \\  __ _   __ _   ___\s
                       / _ \\ | | | || __|| '_ \\  / _ \\| '_ \\ | __|| | / __|/ _` || __|| | / _ \\ | '_ \\      | |_) |/ _` | / _` | / _ \\
                      / ___ \\| |_| || |_ | | | ||  __/| | | || |_ | || (__| (_| || |_ | || (_) || | | |     |  __/| (_| || (_| ||  __/
                     /_/   \\_\\\\__,_| \\__||_| |_| \\___||_| |_| \\__||_| \\___|\\__,_| \\__||_| \\___/ |_| |_|     |_|    \\__,_| \\__, | \\___|
                                                                                                                          |___/      \s
                    \n\n""");
            System.out.print(ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE);
            System.out.print("\n($) Enter Your Username - ");
            System.out.print(ConsoleColors.RESET);
            String Username = sc.nextLine();
            if (Username.equals(userNameOfAccountHolder))
            {
                while (!isLogin){
                    System.out.print(ConsoleColors.BLUE);
                    System.out.print("\n($) Enter Your Password - ");
                    System.out.print(ConsoleColors.RESET);
                    String Password = sc.nextLine();
                    if ( Password.equals(passwordOfAccountHolder) )
                    {
                        System.out.print(ConsoleColors.GREEN_BOLD);
                        System.out.println("\n------------------");
                        System.out.println("Login successful!!");
                        System.out.println("------------------");
                        System.out.print(ConsoleColors.RESET);
                        isLogin = true;
                    }
                    else
                    {
                        System.out.print(ConsoleColors.RED_BOLD);
                        System.out.println("\n--------------------");
                        System.out.println("Incorrect Password!!");
                        System.out.println("--------------------");
                        System.out.print(ConsoleColors.RESET);
                    }
                }
            }
            else
            {
                System.out.print(ConsoleColors.RED_BOLD);
                System.out.println("\n--------------------");
                System.out.println("Username not found!!");
                System.out.println("--------------------");
                System.out.print(ConsoleColors.RESET);
            }
        }
        return isLogin;
    }
    public void transferFunds()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Account's Name you want to transfer: ");
        String receipent = sc.nextLine();
        System.out.print("\nEnter amount to transfer: ");
        float amount = sc.nextFloat();
        try
        {
            if ( balanceOfAccountHolder >= amount )
            {
                if ( amount <= 50000f )
                {
                    transactionsOfAccountHolder++;
                    balanceOfAccountHolder -= amount;
                    System.out.print(ConsoleColors.GREEN);
                    System.out.println("\n---------------------------------------------------------");
                    System.out.println("Successfully Transferred to " + receipent);
                    String str = "(#) "+ amount + " Rs transferred to " + receipent + "\n\n";
                    transactionHistory = transactionHistory.concat(str);
                    System.out.println("---------------------------------------------------------");
                    System.out.print(ConsoleColors.RESET);
                    pause_exec(3);
                }
                else
                {
                    System.out.print(ConsoleColors.RED);
                    System.out.println("\nSorry...Limit is 50000.00");
                    System.out.print(ConsoleColors.RESET);
                    pause_exec(3);
                }
            }
            else
            {
                System.out.print(ConsoleColors.RED);
                System.out.println("\n-----------------------------------------");
                System.out.println("Your Account won't have this much Balance");
                System.out.println("-----------------------------------------");
                System.out.print(ConsoleColors.RESET);
                pause_exec(3);
            }
        }
        catch ( Exception e)
        {
            System.out.print("");
        }
    }
    public void transHistoryOfOurBank()
    {
        if ( transactionsOfAccountHolder == 0 )
        {
            System.out.print(ConsoleColors.RED);
            System.out.println("\n--------------------------------");
            System.out.println("You Haven't Done Any Transaction");
            System.out.println("--------------------------------");
            System.out.print(ConsoleColors.RESET);
            pause_exec(3);
        }
        else
        {
            System.out.print(ConsoleColors.BLUE);
            System.out.println("--------------------------------\n");
            System.out.print(ConsoleColors.RESET);
            System.out.println(transactionHistory);
            System.out.print(ConsoleColors.BLUE);
            System.out.println("--------------------------------\n\n\n");
            System.out.print("Enter Anything to Continue...");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
        }
    }
    public void depositFromBank()
    {
        System.out.print("\n($) Enter amount to deposit: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try
        {
            if ( amount <= 100000f )
            {
                transactionsOfAccountHolder++;
                balanceOfAccountHolder += amount;
                System.out.print(ConsoleColors.GREEN);
                System.out.println("\n--------------------------------");
                System.out.println("Successfully Deposited");
                String str ="(#) "+ amount + " Rs deposited\n\n";
                transactionHistory = transactionHistory.concat(str);
                System.out.println("--------------------------------");
                System.out.print(ConsoleColors.RESET);
                pause_exec(3);
            }
            else {
                System.out.print(ConsoleColors.RED);
                System.out.println("\nSorry...Limit is 100000.00");
                System.out.print(ConsoleColors.RESET);
                pause_exec(3);
            }
        }
        catch ( Exception e)
        {
            System.out.print("");
        }
    }
}
class AtmInterfaceMainPage
{
    public static void clr_console(){
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
    public static void main(String[] args)
    {
        clr_console();
        System.out.print(ConsoleColors.GREEN);
        System.out.println("""


            :::    ::::::::::: ::::    ::::  
          :+: :+:      :+:     +:+:+: :+:+:+ 
         +:+   +:+     +:+     +:+ +:+:+ +:+ 
        +#++:++#++:    +#+     +#+  +:+  +#+ 
        +#+     +#+    +#+     +#+       +#+ 
        #+#     #+#    #+#     #+#       #+# 
        ###     ###    ###     ###       ### 
""");
        System.out.print(ConsoleColors.CYAN_BOLD);
        System.out.println("\n\n-----------------------");
        System.out.println("Options are given below");
        System.out.println("-----------------------");
        System.out.print(ConsoleColors.YELLOW_BOLD);
        System.out.println("\n1) Register For new Account");
        System.out.println("2) Exit Banking System\n\n");
        System.out.print(ConsoleColors.RESET);

        int choice = 0;
        {
            boolean runThis = true;
            int temp_value;
            while (runThis) {
                System.out.print("Selection (1/2): ");
                try {
                    Scanner sc = new Scanner(System.in);
                    temp_value = sc.nextInt();
                    if (temp_value <= 0 || temp_value >= 3){
                        throw new Exception();
                    }
                    else {
                        choice = temp_value;
                        runThis = false;
                    }
                } catch (Exception e){
                    System.out.print(ConsoleColors.RED);
                    System.out.println("\n-------------------");
                    System.out.println("Please Enter 1 or 2");
                    System.out.println("-------------------\n");
                    System.out.print(ConsoleColors.BLUE_BOLD);
                }
            }
        }
        System.out.print(ConsoleColors.RESET);

        if ( choice == 1 )
        {
            BankAccountAllInformation b = new BankAccountAllInformation();
            b.registerForBank();
            while(true)
            {
                clr_console();
                System.out.print(ConsoleColors.GREEN);
                System.out.println("""
                 ::: ::::::::::: ::::    ::::  
               :+: :+:   :+:     +:+:+: :+:+:+ 
              +:+   +:+  +:+     +:+ +:+:+ +:+ 
             +#++:++#++: +#+     +#+  +:+  +#+ 
             +#+     +#+ +#+     +#+       +#+ 
             #+#     #+# #+#     #+#       #+# 
             ###     ### ###     ###       ### 
""");
                System.out.print(ConsoleColors.CYAN_BOLD);
                System.out.println("\n\n-----------------------");
                System.out.println("Options are given below");
                System.out.println("-----------------------");
                System.out.print(ConsoleColors.RESET);
                System.out.print(ConsoleColors.BLUE);
                System.out.println("\n1) Login to Account");
                System.out.println("2) Exit from Bank\n");
                System.out.print(ConsoleColors.RESET);
                int ch = 0;
                {
                    boolean runThis = true;
                    int temp_value;
                    while (runThis) {
                        System.out.print("Selection (1/2): ");
                        try {
                            Scanner sc = new Scanner(System.in);
                            temp_value = sc.nextInt();
                            if (temp_value <= 0 || temp_value >= 3){
                                throw new Exception();
                            }
                            else {
                                ch = temp_value;
                                runThis = false;
                            }
                        } catch (Exception e){
                            System.out.print(ConsoleColors.RED);
                            System.out.println("\n-------------------");
                            System.out.println("Please Enter 1 or 2");
                            System.out.println("-------------------\n");
                            System.out.print(ConsoleColors.BLUE_BOLD);
                        }
                    }
                }
                System.out.print(ConsoleColors.RESET);
                if ( ch == 1 )
                {
                    if (b.loginInformation())
                    {
                        boolean isFinished = false;
                        while (!isFinished)
                        {
                            clr_console();
                            System.out.print(ConsoleColors.YELLOW_BOLD);
                            System.out.println("""
                                
                                    #                                                ###                                                       \s
                                   # #    ####   ####   ####  #    # #    # #####     #  #    # ##### ###### #####  ######   ##    ####  ######\s
                                  #   #  #    # #    # #    # #    # ##   #   #       #  ##   #   #   #      #    # #       #  #  #    # #     \s
                                 #     # #      #      #    # #    # # #  #   #       #  # #  #   #   #####  #    # #####  #    # #      ##### \s
                                 ####### #      #      #    # #    # #  # #   #       #  #  # #   #   #      #####  #      ###### #      #     \s
                                 #     # #    # #    # #    # #    # #   ##   #       #  #   ##   #   #      #   #  #      #    # #    # #     \s
                                 #     #  ####   ####   ####   ####  #    #   #      ### #    #   #   ###### #    # #      #    #  ####  ######\s
                                                                                                                                               \s
                                \n\n""");
                            System.out.print(ConsoleColors.RESET);

                            System.out.print(ConsoleColors.BLUE_BOLD);
                            System.out.println("1) Withdraw From "+b.nameOfAccountHolder+" account");
                            System.out.println("2) Deposit From "+b.nameOfAccountHolder+" account");
                            System.out.println("3) Transfer From "+b.nameOfAccountHolder+" account");
                            System.out.println("4) Check Balance of "+b.nameOfAccountHolder+" account");
                            System.out.println("5) Transaction History of "+b.nameOfAccountHolder+" account");
                            System.out.println("6) Exit\n\n");
                            int c = 0;
                            {
                                boolean runThis = true;
                                int temp_value;
                                while (runThis) {
                                    System.out.print(ConsoleColors.RESET);
                                    System.out.print("Selection (1/6): ");
                                    try {
                                        Scanner sc = new Scanner(System.in);
                                        temp_value = sc.nextInt();
                                        if (temp_value <= 0 || temp_value >= 7){
                                            throw new Exception();
                                        }
                                        else {
                                            c = temp_value;
                                            runThis = false;
                                        }
                                    } catch (Exception e){
                                        System.out.print(ConsoleColors.RED);
                                        System.out.println("\n-------------------");
                                        System.out.println("Please Enter 1 or 2");
                                        System.out.println("-------------------\n");
                                        System.out.print(ConsoleColors.BLUE_BOLD);
                                    }
                                }
                            }
                            switch (c) {
                                case 1 -> {
                                    clr_console();
                                    System.out.print(ConsoleColors.YELLOW_BOLD);
                                    System.out.println("""
                                                                            
                                                #                                                ###                                                       \s
                                               # #    ####   ####   ####  #    # #    # #####     #  #    # ##### ###### #####  ######   ##    ####  ######\s
                                              #   #  #    # #    # #    # #    # ##   #   #       #  ##   #   #   #      #    # #       #  #  #    # #     \s
                                             #     # #      #      #    # #    # # #  #   #       #  # #  #   #   #####  #    # #####  #    # #      ##### \s
                                             ####### #      #      #    # #    # #  # #   #       #  #  # #   #   #      #####  #      ###### #      #     \s
                                             #     # #    # #    # #    # #    # #   ##   #       #  #   ##   #   #      #   #  #      #    # #    # #     \s
                                             #     #  ####   ####   ####   ####  #    #   #      ### #    #   #   ###### #    # #      #    #  ####  ######\s
                                                                                                                                                           \s
                                            \n\n""");
                                    System.out.print(ConsoleColors.RESET);
                                    b.withdrawFromBank();
                                }
                                case 2 -> {
                                    clr_console();
                                    System.out.print(ConsoleColors.YELLOW_BOLD);
                                    System.out.println("""
                                                                            
                                                #                                                ###                                                       \s
                                               # #    ####   ####   ####  #    # #    # #####     #  #    # ##### ###### #####  ######   ##    ####  ######\s
                                              #   #  #    # #    # #    # #    # ##   #   #       #  ##   #   #   #      #    # #       #  #  #    # #     \s
                                             #     # #      #      #    # #    # # #  #   #       #  # #  #   #   #####  #    # #####  #    # #      ##### \s
                                             ####### #      #      #    # #    # #  # #   #       #  #  # #   #   #      #####  #      ###### #      #     \s
                                             #     # #    # #    # #    # #    # #   ##   #       #  #   ##   #   #      #   #  #      #    # #    # #     \s
                                             #     #  ####   ####   ####   ####  #    #   #      ### #    #   #   ###### #    # #      #    #  ####  ######\s
                                                                                                                                                           \s
                                            \n\n""");
                                    System.out.print(ConsoleColors.RESET);
                                    b.depositFromBank();
                                }
                                case 3 -> {
                                    clr_console();
                                    System.out.print(ConsoleColors.YELLOW_BOLD);
                                    System.out.println("""
                                                                            
                                                #                                                ###                                                       \s
                                               # #    ####   ####   ####  #    # #    # #####     #  #    # ##### ###### #####  ######   ##    ####  ######\s
                                              #   #  #    # #    # #    # #    # ##   #   #       #  ##   #   #   #      #    # #       #  #  #    # #     \s
                                             #     # #      #      #    # #    # # #  #   #       #  # #  #   #   #####  #    # #####  #    # #      ##### \s
                                             ####### #      #      #    # #    # #  # #   #       #  #  # #   #   #      #####  #      ###### #      #     \s
                                             #     # #    # #    # #    # #    # #   ##   #       #  #   ##   #   #      #   #  #      #    # #    # #     \s
                                             #     #  ####   ####   ####   ####  #    #   #      ### #    #   #   ###### #    # #      #    #  ####  ######\s
                                                                                                                                                           \s
                                            \n\n""");
                                    System.out.print(ConsoleColors.RESET);
                                    b.transferFunds();
                                }
                                case 4 -> {
                                    clr_console();
                                    System.out.print(ConsoleColors.YELLOW_BOLD);
                                    System.out.println("""
                                                                            
                                                #                                                ###                                                       \s
                                               # #    ####   ####   ####  #    # #    # #####     #  #    # ##### ###### #####  ######   ##    ####  ######\s
                                              #   #  #    # #    # #    # #    # ##   #   #       #  ##   #   #   #      #    # #       #  #  #    # #     \s
                                             #     # #      #      #    # #    # # #  #   #       #  # #  #   #   #####  #    # #####  #    # #      ##### \s
                                             ####### #      #      #    # #    # #  # #   #       #  #  # #   #   #      #####  #      ###### #      #     \s
                                             #     # #    # #    # #    # #    # #   ##   #       #  #   ##   #   #      #   #  #      #    # #    # #     \s
                                             #     #  ####   ####   ####   ####  #    #   #      ### #    #   #   ###### #    # #      #    #  ####  ######\s
                                                                                                                                                           \s
                                            \n\n""");
                                    System.out.print(ConsoleColors.RESET);
                                    b.checkBalanceInOurAccount();
                                }
                                case 5 -> {
                                    clr_console();
                                    System.out.print(ConsoleColors.YELLOW_BOLD);
                                    System.out.println("""
                                                                            
                                                #                                                ###                                                       \s
                                               # #    ####   ####   ####  #    # #    # #####     #  #    # ##### ###### #####  ######   ##    ####  ######\s
                                              #   #  #    # #    # #    # #    # ##   #   #       #  ##   #   #   #      #    # #       #  #  #    # #     \s
                                             #     # #      #      #    # #    # # #  #   #       #  # #  #   #   #####  #    # #####  #    # #      ##### \s
                                             ####### #      #      #    # #    # #  # #   #       #  #  # #   #   #      #####  #      ###### #      #     \s
                                             #     # #    # #    # #    # #    # #   ##   #       #  #   ##   #   #      #   #  #      #    # #    # #     \s
                                             #     #  ####   ####   ####   ####  #    #   #      ### #    #   #   ###### #    # #      #    #  ####  ######\s
                                                                                                                                                           \s
                                            \n\n""");
                                    System.out.print(ConsoleColors.RESET);
                                    b.transHistoryOfOurBank();
                                }
                                case 6 -> {
                                    clr_console();
                                    isFinished = true;
                                }
                            }
                        }
                    }
                }
                else
                {
                    clr_console();
                    System.exit(0);
                }
            }
        }
        else
        {
            clr_console();
            System.exit(0);
        }
    }
}
