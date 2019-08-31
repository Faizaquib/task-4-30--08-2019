import java.util.ArrayList;
import java.util.Scanner;
public class employee {

	private int eno=0;
	private String ename;
	private int salary;
	private String desg;
	//String[] dept = {"IT","Account","Markting","HR"};
	private String dept;
	
	Scanner sc = new Scanner(System.in);
	
	ArrayList<ArrayList<Object>> em = new ArrayList<ArrayList<Object>>();
	
	public void addEmp()
	{
		ArrayList<Object> emp = new ArrayList<>();
		eno++;
		System.out.println("Name :");
		ename = sc.next();
		System.out.println("Salary :");
		salary = sc.nextInt();
		System.out.println("Designation :");
		desg = sc.next();
		System.out.println("Department :");
		dept = sc.next();
		emp.add(eno);
		emp.add(ename);
		emp.add(salary);
		emp.add(desg);
		emp.add(dept);
		System.out.println("New Employee added Scucessfully!");
		em.add(emp);
		//System.out.println(emp);
	}
	
	public void ViewAllEmp()
	{
		em.forEach(System.out::println);
	}
	
	void searchEmployee() {
		
		System.out.println("Entre Employee's Number");
		int no = sc.nextInt();
		for(int i = 0;i<em.size();i++)
		{
			if((int)((ArrayList) em.get(i)).get(0)==no)
			System.out.println(((ArrayList) em.get(i)).get(1));
		}
	}
	public void removeEmp()
	{
		System.out.println("Entre Employee's Number to remove from Data");
		int no = sc.nextInt();
		no = no-1;
		em.remove(no);
		System.out.println("Employee number "+(no+1)+" deleted sucessfully!");
		
	}
	public void clearData()
	{
		em.clear();
		System.out.println("There is no Data left about Employees!");
	}
	
	public void updateSalary()
	{
		System.out.println("Entre Employee's Number whose salary needs to be updated");
		int no = sc.nextInt();
		for(int i = 0;i<em.size();i++)
		{
			if((int)((ArrayList) em.get(i)).get(0)==no)
			{
				System.out.println("Employee numbers "+no+"'s current salary is : "+((ArrayList) em.get(i)).get(2));
				//System.out.println("Enter updated salary : ");
			}
		}
		System.out.println("Enter updated salary : ");
		int sal = sc.nextInt();
		em.get(no-1).set(2, sal);
		System.out.println("Salary updated successfully!");
		
	}
	
	public void deptWiseList()
	{
		System.out.println("Entre department name : ");
		String s = sc.next();
		for(int i = 0;i<em.size();i++)
		{
			if((String)((ArrayList) em.get(i)).get(3)=="IT")
			{
				System.out.println("Department IT has :"+em.get(i));
			}
			if((String)((ArrayList) em.get(i)).get(3)=="Accounts")
			{
				System.out.println("Department Accounts has :"+em.get(i));
			}
			if((String)((ArrayList) em.get(i)).get(3)=="Marketing")
			{
				System.out.println("Department Marketing has :"+em.get(i));
			}
			if((String)((ArrayList) em.get(i)).get(3)=="HR")
			{
				System.out.println("Department HR has :"+em.get(i));
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		
	employee e = new employee();
	Scanner sc = new Scanner(System.in);
	
	System.out.println("press 1 to add new Employee");
	System.out.println("press 2 view all Employee");
	System.out.println("press 3 to remove an Employee");
	System.out.println("press 4 to clear Date of all Employes");
	System.out.println("press 5 to change salary Employee");
	System.out.println("press 6 to search for an  Employee");
	System.out.println("press 7 to view Department wise List");
	System.out.println("press 8 to exit");

	while(true)
	{
		int choice = sc.nextInt();
	switch(choice)
	{
	case 1: e.addEmp();
		break;
	case 2: e.ViewAllEmp();
		break;
	case 3: e.removeEmp();
		break;
	case 4: e.clearData();
		break;
	case 5: e.updateSalary();
		break;
	case 6: e.searchEmployee();
		break;
	case 7: e.deptWiseList();
		break;
	case 8: 
		break;
	default :System.out.println("Please Choose correct Option");
		break;
	}
	}
	}

	

}
