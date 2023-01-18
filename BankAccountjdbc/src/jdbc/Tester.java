package jdbc;
import java.util.List;
import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		
		try (Scanner sc=new Scanner(System.in);){
			BankDal b=new BankDal();
			List<Account> li=b.getAccount();
			for(int i=0;i<li.size();i++) {
				System.out.println(li.get(i));
			}
			
			System.out.println("Enter id and amount to deposit");
			
			b.depositAccount(sc.nextInt(),sc.nextDouble());
			
			li=b.getAccount();
			for(int i=0;i<li.size();i++) {
				System.out.println(li.get(i));
			}
			
			System.out.println("Enter the id to delete");
			b.deleteAccount(sc.nextInt());
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
