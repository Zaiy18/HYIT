
#include <iostream>
#include <cstring>
using namespace std;

class Employee
{
public:
    // 构造函数：职工基本信息的初始化
	Employee(char *_name, bool _sex, int _age, int _wage, double _salary);
	// 析构函数：释放系统资源
	~Employee();
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
	char *name;          // 职工姓名
	bool sex;            // 职工性别
	int age;             // 职工年龄
	int wage;            // 职工工龄
	double salary;       // 职工工资
};

// 构造函数：职工基本信息的初始化
Employee::Employee(char *_name, bool _sex, int _age, int _wage, double _salary)
{
	int len = strlen(_name);
	name = new char[len+1];      // 在堆上开辟数组空间
	strcpy(name,_name);
	sex = _sex;
	age = _age;
	wage = _wage;
	salary = _salary;
}

// 析构函数：释放系统资源
Employee::~Employee()
{
	if(name!=NULL)
		delete [] name;         // 释放数组空间
}

// 修改职工姓名
void Employee::changeName(char *_name)
{
	delete [] name;             // 释放现有数组空间
	int len = strlen(_name);
	name = new char[len+1];     // 开辟新数组空间
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
	Employee em("张三",true,30,0,3000);              // 类对象定义, 调用构造函数进行初始化
	em.print();
	cout<<"年薪: "<<em.computSalary(10000)<<endl;
	em.update();
	em.changeSalary(4000);
	em.print();
	cout<<"年薪: "<<em.computSalary(10000)<<endl;
	return 0;

	// 类对象生命期结束前调用析构函数进行清理工作
}