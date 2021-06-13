
#include <iostream>
#include <cstring>
using namespace std;

class Employee
{
public:
    // 设置职工的基本信息
	void set(char *_name, bool _sex, int _age, int _wage, double _salary);
	// 修改职工姓名
	void changeName(char *_name);
	// 修改工资
	void changeSalary(double _salary);
	// 年薪计算
	double computSalary(double award);
	// 工龄增加
	void update();
	// 显示职工信息
	void print();
private:
	char name[20];       // 职工姓名
	bool sex;            // 职工性别
	int age;             // 职工年龄
	int wage;            // 职工工龄
	double salary;       // 职工工资
};

// 设置职工的基本信息
void Employee::set(char *_name, bool _sex, int _age, int _wage, double _salary)
{
	strcpy(name,_name);
	sex = _sex;
	age = _age;
	wage = _wage;
	salary = _salary;
}

// 修改职工姓名
void Employee::changeName(char *_name)
{
	strcpy(name,_name);
}

// 修改工资
void Employee::changeSalary(double _salary)
{
	salary = _salary;
}

// 年薪计算
double Employee::computSalary(double award)
{
	return 12*salary+award;
}

// 工龄增加
void Employee::update()
{
	wage++;
	age++;
}

// 显示职工信息
void Employee::print()
{
	cout<<"姓名: "<<name<<endl;
	cout<<"性别: "<<(sex?"男":"女")<<endl;
	cout<<"年龄: "<<age<<endl;
	cout<<"工龄: "<<wage<<endl;
	cout<<"工资: "<<salary<<endl;
}

int main()
{
	Employee em;                                     // 类对象定义
	em.set("张三",true,30,0,3000);                   // 类成员访问
	em.print();
	cout<<"年薪: "<<em.computSalary(10000)<<endl;
	em.update();
	em.changeSalary(4000);
	em.print();
	cout<<"年薪: "<<em.computSalary(10000)<<endl;
	return 0;
}