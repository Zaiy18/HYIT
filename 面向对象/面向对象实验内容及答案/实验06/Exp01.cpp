
#include <iostream>
#include <cstring>
using namespace std;

// Person 基类定义
class Person
{
public:                                          // public成员函数
	// 基类构造函数
	Person(char *_name, bool _sex, int _age, double _height, double _weight);  
	~Person();                                   // 基类析构函数
	void grow();                                 // 年龄增长
	void set(double _height, double _weight);    // 设置身高和体重
	int getAge() const;                          // 获取年龄
	double getHeight() const;                    // 获取身高
	double getWeight() const;                    // 获取体重
	void print() const;                          // 打印人的信息
protected:                                       // protected数据成员
	char *name;                                  // 姓名
	bool sex;                                    // 性别
	int age;                                     // 年龄
	double height;                               // 身高
	double weight;                               // 体重
};

// Student 派生类定义
class Student: public Person                     // public 继承
{
public:                                          // public成员函数
	// 派生类构造函数
	Student(char *_name, bool _sex, int _age, double _height, double _weight, int _sid, char *_major);
	~Student();                                  // 派生类析构函数
	int getID() const;                           // 获取学号
	void print() const;                          // 打印学生信息（覆盖成员函数）
protected:                                       // protected数据成员
	int sid;                                     // 学号
	char *major;                                 // 专业
};

// Person基类成员函数实现
Person::Person(char *_name, bool _sex, int _age, double _height, double _weight)
{
	name = new char[strlen(_name)+1];
	strcpy(name, _name);
	sex = _sex;
	age = _age;
	height = _height;
	weight = _weight;
}

Person::~Person()
{
	if(name!=NULL)
		delete [] name;
}

void Person::grow()
{
	++age;
}

void Person::set(double _height, double _weight)
{
	height = _height;
	weight = _weight;
}

int Person::getAge() const
{
	return age;
}

double Person::getHeight() const
{
	return height;
}

double Person::getWeight() const
{
	return weight;
}

void Person::print() const
{
	cout<<"姓名: "<<name<<endl;
	cout<<"性别: "<<(sex?"男":"女")<<endl;
	cout<<"年龄: "<<age<<endl;
	cout<<"身高: "<<height<<endl;
	cout<<"体重: "<<weight<<endl;
}

// Student派生类成员函数实现
Student::Student(char *_name, bool _sex, int _age, double _height, double _weight, int _sid, char *_major)
	:Person(_name, _sex, _age, _height, _weight) // 调用基类构造函数初始化基类数据成员             
{
	sid = _sid;
	major = new char[strlen(_major)+1];
	strcpy(major, _major);
}

Student::~Student()
{
	if(major!=NULL)
		delete [] major;
}

int Student::getID() const
{
	return sid;
}

void Student::print() const
{
	Person::print();                            // 调用基类被覆盖的成员函数
	cout<<"学号: "<<sid<<endl;
	cout<<"专业: "<<major<<endl;
}

int main()
{
	Student st("Hennessy",true,28,170,100,1151,"计算机");
	st.set(172,120);                            // 调用基类的public成员函数
	st.print();                                 // 调用派生类的public成员函数
	return 0;
}