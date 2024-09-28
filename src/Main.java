import java.util.Scanner;
import java.util.SplittableRandom;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
	coreSystem coresystem = new coreSystem();
	coresystem.showPage();
	}
    }
class House{
    private String name;
    private String phone;
    private String address;
    private int money;
    private String state;

    public House(String name, String phone, String address, int money, String state) {
	this.name = name;
	this.phone = phone;
	this.address = address;
	this.money = money;
	this.state = state;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public int getMoney() {
	return money;
    }

    public void setMoney(int money) {
	this.money = money;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }
}
class coreSystem {
    boolean loop = true;
    House [] details=new House[1];
    int count = 0;
    public void showPage(){
	Scanner scanner = new Scanner(System.in);
	do {
	    System.out.println("新的一轮选项开启:");
	    System.out.println("------------房屋出租系统---------------");
	    System.out.println("\t\t\t" + "1:新增房源");
	    System.out.println("\t\t\t" + "2:查找房源");
	    System.out.println("\t\t\t" + "3:删除房源");
	    System.out.println("\t\t\t" + "4:修改房源");
	    System.out.println("\t\t\t" + "5:房源列表");
	    System.out.println("\t\t\t" + "6:退\t出");
	    System.out.println("请输入你要进入哪个选项(1-6)");
	    int user_input = scanner.nextInt();
	    switch (user_input) {
		case 1: {
		    System.out.println("-------------添加房源------------");
		    increaseHouse();
		    System.out.println("\n\n\n\n\n-------------添加完成------------");
		    break;
		}
		case 2: {
		    System.out.println("-------------查找房源------------");
		    select();
		    break;
		}
		case 3: {
		    System.out.println("-------------删除房源------------");
		    delect();
		    System.out.println("\n\n\n\n-------------删除完成------------");
		    break;
		}
		case 4: {
		    System.out.println("-------------修改房源------------");
		    modify();
		    System.out.println("\n\n\n\n-------------修改完成------------");
		    break;
		}
		case 5: {
		    System.out.println("-------------房源列表------------");
		    houseList();
		    System.out.println("\n\n\n\n\"-------------房源列表完成------------\"");
		    break;
		}
		case 6: {
		    System.out.println("-------------退出------------");
		    exit();
		    break;
		}
		default:
		    System.out.println("您输入了错误的数字，请重新输入:");
	    }
	} while (loop);
    }
    public void increaseHouse(){
	System.out.println("请输入房主、电话、地址、月租和状态，用空格分隔:");
	Scanner scanner = new Scanner(System.in);
	String name = scanner.next();
	String phoneNumber = scanner.next();
	String address = scanner.next();
	int money = scanner.nextInt();
	String state = scanner.next();
	House house = new House(name,phoneNumber,address,money,state);
	if (count == 0) {
	    details[0] = house;
	}
	else {
	    House[] newArr = new House[count + 1];
	    for (int i = 0; i < count; i++) {
		newArr[i] = details[i];
	    }
	    newArr[count] = house;
	    details = newArr;
	}
	count++;
    }//数组的扩容

    public void select() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("请输入你要查找房源的id:");
	int id = scanner.nextInt();
	if (id > details.length)
	    System.out.println("查找失败，没有此房源!");
	else
	    System.out.println("姓名:"+details[id - 1].getName()+"\n"+"电话"+details[id-1].getPhone()+"\n"+"地址:"+details[id-1].getAddress()+"\n"+"租金:"+details[id-1].getMoney()+"\n"+"状态:"+details[id-1].getState());
    }


    public void delect() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("请输入你要删除房源的id:");
	int id = scanner.nextInt();
	if (id > details.length)
	    System.out.println("删除失败,没有此房源");
	else {
	    System.out.println("确认是否删除(Y/N):请小心选择:");
	    String confirm = scanner.next();
	    if (confirm.equals("Y")) {
		for (int i = id; i < details.length; i++) {
		    details[i - 1] = details[i];
		}
		House[] newArr = new House[details.length - 1];
		for (int i = 0; i < newArr.length; i++) {
		    newArr[i] = details[i];
		}
		details = newArr;//数组的减容
		count--;
	    } else {
		System.out.println("不删除房源啦!");
	    }
	}
    }



    public void modify() {
	System.out.println("请输入房主、电话、地址、月租和状态，用空格分隔:");
	Scanner scanner = new Scanner(System.in);
	System.out.println("请输入你要修改房源的id:");
	int id = scanner.nextInt();
	if (id > details.length)
	    System.out.println("修改失败,没有此房源");
	else {
	    System.out.println("请输入你想修改房源哪一项:");
	    String whichOne=scanner.next();
	    switch (whichOne){
		case "姓名":
		{System.out.println("请输入你要修改成什么名字");
		    String modifyName=scanner.next();
		    details[id-1].setName(modifyName);
		break;}
		case "电话":{
		    System.out.println("请输入你要修改成什么电话");
			String modifyphone=scanner.next();
			details[id-1].setPhone(modifyphone);
		    break;
		}
		case "地址":{
		    System.out.println("请输入你要修改成什么地址");
			String modifyaddres=scanner.next();
			details[id-1].setAddress(modifyaddres);
			break;
		}
		case "状态":{
		    System.out.println("请输入你要修改成什么状态");
			String modifystate=scanner.next();
			details[id-1].setState(modifystate);
			break;
		}
		default:{
		    {System.out.println("请输入你要修改成多少钱");
			int modifymoney=scanner.nextInt();
			details[id-1].setMoney(modifymoney);}
		}

	    }


	}
    }



    public void houseList() {
	System.out.println("编号\t\t姓名\t\t电话\t\t地址\t\t租金\t\t状态\t\t");
	for (int i = 0; i < details.length; i++) {
	    System.out.println((i+1)+"\t\t"+details[i].getName()+"\t\t"+details[i].getPhone()+"\t\t"+details[i].getAddress()+"\t\t"+details[i].getMoney()+"\t\t"+details[i].getState());
	}
    }


    public void exit() {
	System.out.println("你确定要退出嘛(Y/N)");
	Scanner scanner = new Scanner(System.in);
	String confirm = scanner.next();
	if (confirm.equals("Y"))
	    loop = false;
	else
	    System.out.println("退出失败，请重新退出!");
    }

}
