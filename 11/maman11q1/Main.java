package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static  ArrayList<Item> _items;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CashRegister reg = openCashRegister(sc);
        String action;
        _items = getItems();// Getting the list of items in the store.
        // Activate menu
        System.out.println("""
                Select the action you want to preform:
                - ADD_ITEM-Add Items
                - PAY-Pay
                - CASH - Check how much cash in the register
                - END-End program""");

        while(!(action =sc.nextLine()).equals("END")){
            if(action.equals("ADD_ITEM"))
                addItemToBill(reg, sc);
            else if(action.equals("PAY"))
                payCurrentBill(reg,sc);
            else if(action.equals("CASH"))
                System.out.println("The cash in the register is: "+reg.getCash());

            System.out.println("""
                Select the action you want to preform:
                - ADD_ITEM-Add Items 
                - PAY-Pay
                - CASH - Check how much cash in the register
                - END-End program""");
        }

    }

    private static CashRegister openCashRegister(Scanner sc) {
        System.out.println("""
                                Opening new cash register...
                                Enter initial amount: """);
        double cash = sc.nextDouble();
        sc.nextLine();//throw the /n in the buffer
        return  new CashRegister(cash);
    }

    // pay the bill and initialize the acccount
    private static void payCurrentBill(CashRegister reg, Scanner sc) {

        System.out.println("You're bill is: "+reg.getBillPrice());
        String receipt = reg.toString();
        System.out.println("Enter amount to pay: ");
        System.out.println("The surplus is: "+reg.pay(sc.nextDouble()));
        sc.nextLine();//throw the /n in the buffer
        System.out.println("-------------------Receipt---------------\n"+receipt);
        System.out.println("----------------End of recipt-----------");
    }

    // Add items to register bill
    private static void addItemToBill(CashRegister reg, Scanner sc) {
        boolean input = true; // As long as the user input continue.
        int item_quantity;
        String item_name;
        System.out.println("Enter purchased items");
        while(input){
            System.out.println("Enter item name:");
            item_name = sc.nextLine();
            System.out.println("Enter item quantity:");
            item_quantity =  sc.nextInt();
            sc.nextLine();//throw the /n in the buffer
            reg.AddItem(getItem(item_name),item_quantity);
            System.out.println("Continue?[y,n]:");
            if(sc.nextLine().equals("n"))
                input = false;
        }
    }
    // Get item by item name
    private static Item getItem(String name) {
        Item item;
        for(int i = 0; i< _items.size(); i++) {
            item = _items.get(i);
            if (item.getName().equals(name))
                return item;
        }
         return null;
    }

    // returns a list of items that are in the shop.
    private static ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();
        // adding the items
        items.add(new Item("Pasta",21));
        items.add(new Item("Milk",12));
        items.add(new Item("Rice",56.54));
        items.add(new Item("Avocado",12.9));
        items.add(new Item("Banana",24.3));
        items.add(new Item("Tuna",36.5));
        return items;
    }

}
