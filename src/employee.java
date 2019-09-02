import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class employee implements Comparator<employee> {

	private int eno = 0;
	private String ename;
	private int salary;
	private String desg;
	// String[] dept = {"IT","Account","Markting","HR"};
	private String dept;

	Scanner sc = new Scanner(System.in);

	ArrayList<ArrayList<Object>> em = new ArrayList<ArrayList<Object>>();

	public void addEmp() {
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
		// System.out.println(emp);
	}

	public void ViewAllEmp() {
		em.forEach(System.out::println);
	}

	void searchEmployee() {

		System.out.println("Entre Employee's Number");
		int no = sc.nextInt();
		for (int i = 0; i < em.size(); i++) {
			if ((int) ((ArrayList) em.get(i)).get(0) == no)
				System.out.println(((ArrayList) em.get(i)).get(1));
		}
	}

	public void removeEmp() {
		System.out.println("Entre Employee's Number to remove from Data");
		int no = sc.nextInt();
		no = no - 1;
		em.remove(no);
		System.out.println("Employee number " + (no + 1) + " deleted sucessfully!");

	}

	public void clearData() {
		System.out.println("are you sure you want to clear all the data. Press Y/N");
		char ch = sc.next().charAt(0);
		if (ch == 'Y' || ch == 'y') {
			em.clear();
			System.out.println("There is no Data left about Employees!");
		} else
			return;
	}

	public void updateSalary() {
		System.out.println("Entre Employee's Number whose salary needs to be updated");
		int no = sc.nextInt();
		for (int i = 0; i < em.size(); i++) {
			if ((int) ((ArrayList) em.get(i)).get(0) == no) {
				System.out
						.println("Employee numbers " + no + "'s current salary is : " + ((ArrayList) em.get(i)).get(2));
				// System.out.println("Enter updated salary : ");
			}
		}
		System.out.println("Enter updated salary : ");
		int sal = sc.nextInt();
		em.get(no - 1).set(2, sal);
		System.out.println("Salary updated successfully!");

	}

	public void deptWiseList() {
		System.out.println("Entre department name : ");
		String s = sc.next();
		for (int i = 0; i < em.size(); i++) {
			if ((String) ((ArrayList) em.get(i)).get(3) == "IT") {
				System.out.println("Department IT has :" + em.get(i));
			}
			if ((String) ((ArrayList) em.get(i)).get(3) == "Accounts") {
				System.out.println("Department Accounts has :" + em.get(i));
			}
			if ((String) ((ArrayList) em.get(i)).get(3) == "Marketing") {
				System.out.println("Department Marketing has :" + em.get(i));
			}
			if ((String) ((ArrayList) em.get(i)).get(3) == "HR") {
				System.out.println("Department HR has :" + em.get(i));
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void sortOnName() {
		/*
		 * for(int i = 0; i<em.size();i++) { em.get(i).sort((Comparator<? super Object>)
		 * em.get(i).get(1)); }
		 * 
		 * for(int i = em.size();i>=0;i--) { System.out.println(em.get(i)); }
		 */

		Collections.sort(em, new Comparator<ArrayList<Object>>() {
			@Override
			public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
				return ((String) o1.get(1)).compareTo((String) o2.get(1));
			}
		});
		em.forEach(System.out::println);
	}

	public void sortOnSal() {
		Collections.sort(em, new Comparator<ArrayList<Object>>() {
			@Override
			public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
				return ((Integer) o1.get(2)).compareTo((Integer) o2.get(2));
			}
		});
		em.forEach(System.out::println);

	}

	public void reverseOnName() {
		Collections.sort(em, new Comparator<ArrayList<Object>>() {
			@Override
			public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
				return ((String) o1.get(1)).compareTo((String) o2.get(1));
			}
		});
		Collections.reverse(em);
		/*Collections.sort(em, Collections.reverseOrder());*/
		em.forEach(System.out::println);

	}

	public void reverseOnSal() {
		Collections.sort(em, new Comparator<ArrayList<Object>>() {
			@Override
			public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
				return ((Integer) o1.get(2)).compareTo((Integer) o2.get(2));
			}
		});
		//Collections.sort(em, Collections.reverseOrder());
		Collections.reverse(em);
		em.forEach(System.out::println);
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
		System.out.println("press 8 to Sort");
		System.out.println("press 9 to exit");

		while (true) {
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				e.addEmp();
				break;
			case 2:
				e.ViewAllEmp();
				break;
			case 3:
				e.removeEmp();
				break;
			case 4:
				e.clearData();
				break;
			case 5:
				e.updateSalary();
				break;
			case 6:
				e.searchEmployee();
				break;
			case 7:
				e.deptWiseList();
				break;
			case 8: {
				int num;
				System.out.println("Press 1 to sort by Employee's Name");
				System.out.println("Press 2 to sort by Employee's salary");
				num = sc.nextInt();
				switch (num) {
				case 1: {
					int number;
					System.out.println("Press 1 to sort in ascending order");
					System.out.println("Press 2 to sort in descending order");
					number = sc.nextInt();
					switch (number) {
					case 1:
						e.sortOnName();
						break;
					case 2:
						e.reverseOnName();
						break;
					}
				}

					break;
				case 2: {
					int number;
					System.out.println("Press 1 to sort in ascending order");
					System.out.println("Press 2 to sort in descending order");
					number = sc.nextInt();
					switch (number) {
					case 1:
						e.sortOnSal();
						break;
					case 2:
						e.reverseOnSal();
						break;
					}

				}

					break;

				}
				break;
			}
			case 9:
				break;
			default:
				System.out.println("Please Choose correct Option");
				break;
			}
		}
	}

	@Override
	public int compare(employee o1, employee o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
