// Expense Tracker project
// A simple console-based tracker with budget, expenses, and summaries.
import java.util.*;
class ExpenseTrackerV2
 {
   static Scanner sc=new Scanner(System.in);
   static int choice=0;
   static int budget=1000000; // default budget (so program doesn't warn at start)
   // Categories and amounts
   static ArrayList<String> category=new ArrayList<>();
   static ArrayList<Integer> amount=new ArrayList<>();
   // Method to set budget
    public static void budget()
     {
      System.out.print("Enter your Budget: ");
      budget=sc.nextInt();
       sc.nextLine();
       System.out.println("Budget set successfully!");
     }
   // Method to add category
    public static void addCategory()
    {
       System.out.print("Enter category: ");
       String categoryUser=sc.nextLine();
        category.add(categoryUser);
       amount.add(0);
       System.out.println("Category added!");
     }
   // Method to add expense
   public static void addExpense()
   {
     if(category.isEmpty()) {
       System.out.println("No category found!");
       return;
     }
     for(int i=0; i<category.size(); i++) {
       System.out.println((i+1)+". "+category.get(i));
     }
     System.out.print("Select category: ");
     int select=sc.nextInt();
     sc.nextLine();
     System.out.print("Enter amount: ");
     int amt=sc.nextInt();
     sc.nextLine();
     amount.set(select-1, amount.get(select-1)+amt);
     System.out.println("Amount added successfully!");
   }
   // Method to view all expenses
   public static void viewExpense()
   {
     if(category.isEmpty()) {
       System.out.println("No category found!");
       return;
     }
     for(int i=0; i<category.size(); i++) {
       System.out.println((i+1)+". "+category.get(i)+" - "+amount.get(i));
     }
   }
   // Method to show monthly summary (total + category-wise)
    public static void monthSummary()
    {
      if(category.isEmpty()) {
        System.out.println("No category found!");
        return;
      }
      System.out.println("\n--- Monthly Summary ---");
      int total=0;
      for(int i=0; i<category.size(); i++) {
        System.out.println((i+1)+". "+category.get(i)+" - "+amount.get(i));
        total+=amount.get(i);
      }
      System.out.println("Total expenses: "+total);
      if(total>budget) {
        System.out.println("⚠️ Budget Exceeded! (Budget: "+budget+", Spent: "+total+")");
      }
    }
   // Method to display biggest expense
   public static void biggestExpense()
   {
     if(category.isEmpty()) {
       System.out.println("No category found!");
       return;
     }
     int maxIdx=0;
     for(int i=0; i<category.size(); i++) {
       if(amount.get(i)>maxIdx) maxIdx=i;
     }
     System.out.println("Biggest Expense: ");
     System.out.println(category.get(maxIdx)+" - "+amount.get(maxIdx));
   }
   // Main menu-driven program
    public static void main(String[] args)
    {
      System.out.println("------- Expense Tracker -------");
       System.out.print("1. Add Expense\n2. Add Category\n3. View All Expenses\n4. Monthly Summary\n5. Biggest Expense\n6. Set Budget\n7. Exit");
      while(true) {
        System.out.print("\n\nEnter choice: ");
        choice=sc.nextInt();
        sc.nextLine();
      if(choice==1) addExpense();
      if(choice==2) addCategory();
      if(choice==3) viewExpense();
      if(choice==4) monthSummary();
      if(choice==5) biggestExpense();
      if(choice==6) budget();
      if(choice==7) {
        System.out.println("Exiting Expense Tracker... Bye👋");
        return;
      }
      if(choice<1||choice>7)
      System.out.println("Invalid Choice!");
      }
    }
 }