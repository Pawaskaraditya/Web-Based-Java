package com.tester;

import java.util.List;
import java.util.Scanner;
import com.pojo.*;
import com.dal.*;
import com.util.DBUtil;

public class TestCrudProd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DBUtil.openConnection();
			System.out.println("1:show all Produc 2:add new Product 3:Update Product 4:Delete Product ");
			ProductDALImpl prodDal=new ProductDALImpl();
			int ch=0;
			
			Scanner sc=new Scanner(System.in);
			
			do {
				System.out.println("Enter Choice");
				ch=sc.nextInt();
				switch(ch) {
				case 1:
					List<Product> prodList=prodDal.getAllProducts();
					prodList.forEach(p->System.out.println(p));
					break;
					
				case 2:
					System.out.println("Enter the prod id,name,company,price");
					Product pdo=new Product(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
					
					int i=prodDal.addProduct(pdo);
					if(i>0) {
						System.out.println("Product inserted");
					}
					break;
				case 3:
					System.out.println("Edit:prod id,Product name ,company,price");
					pdo=new Product(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
					
					 i=prodDal.updateProduct(pdo);
					if(i>0)
					{
						System.out.println("Updated");
					}
					break;
				case 4:
					System.out.println("Enter BookId to Delete");
					int id=sc.nextInt();
					i=prodDal.deleteProduct(id);
					if(i>0) {
						System.out.println("Deleted");
					}
					else {
						System.out.println("Not Found...");
					}
				}
			}while(ch!=5);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
