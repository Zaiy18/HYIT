
#include <iostream>
#include <cstring>
#include <iomanip>
using namespace std;

// Birthday 类定义
class Birthday
{
public:
	Birthday(int _year, int _month, int _day);              // 构造函数
	void change(int _year, int _month, int _day);           // 修改生日信息
	int getYear();                                          // 获取年信息
	int getMonth();                                         // 获取月信息
	int getDay();                                           // 获取日信息
	void print();                                           // 打印生日信息
private:
	int year;                                               // 年
	int month;                                              // 月
	int day;                                                // 日
};

// Student 类定义
class Student
{
public:
	Student(char *_name, bool _sex, int _sno, int year, int month, int day, int _num);   // 构造函数
	~Student();                                             // 析构函数
	void input(double *s);                                  // 录入专业课成绩
	void change(int i, double s);                           // 修改专业课成绩
	double get(int i);                                      // 获取专业课成绩
	int getNum();                                           // 获取专业课门数
	double average();                                       // 计算专业课平均成绩
	int fail();                                             // 计算不及格专业课门数
	void print();                                           // 打印学生基本信息
private:
	char *name;                                             // 学生姓名
	bool sex;                                               // 性别
	int sno;                                                // 学号
	Birthday birth;                                         // 出生日期
	int num;                                                // 专业课门数
	double *score;                                          // 专业课成绩
};

// Birthday 成员函数实现
Birthday::Birthday(int _year, int _month, int _day)
{
	year = _year;
	month = _month;
	day = _day;
}
void Birthday::change(int _year, int _month, int _day)
{
	year = _year;
	month = _month;
	day = _day;
}
int Birthday::getYear()
{
	return year;
}
int Birthday::getMonth()
{
	return month;
}
int Birthday::getDay()
{
	return day;
}
void Birthday::print()
{
	cout<<setfill('0')<<setiosflags(ios::right);            // 设置填充字符和对齐方式
	cout<<year<<"/"<<setw(2)<<month<<"/"<<setw(2)<<day<<endl;
}

// Student 成员函数实现
Student::Student(char *_name, bool _sex, int _sno, int year, int month, int day, int _num): birth(year, month, day)
{
	int len = strlen(_name);
	name = new char[len+1];                                // 申请堆空间存放学生姓名
	strcpy(name, _name);
	sex = _sex;
	sno = _sno;
	num = _num;
	score = new double[num];                               // 申请堆空间存放专业课成绩
}
Student::~Student()
{
	if(name!=NULL)
		delete [] name;                                   // 释放堆空间
	if(score!=NULL)
		delete [] score;                                  // 释放堆空间
}
void Student::input(double *s)
{
	for(int i=0; i<num; ++i)
		score[i] = s[i];
}
void Student::change(int i, double s)
{
	score[i] = s;
}
double Student::get(int i)
{
	return score[i];
}
int Student::getNum()
{
	return num;
}
double Student::average()
{
	double sum = 0.0;
	for(int i=0; i<num; ++i)
		sum += score[i];
	return sum/num;
}
int Student::fail()
{
	int n = 0;
	for(int i=0; i<num; ++i)
		if(score[i]<60)
			++n;
	return n;
}
void Student::print()
{
	cout<<"学生姓名: "<<name<<endl;
	cout<<"性别: "<<(sex?"男":"女")<<endl;
	cout<<"学号: "<<sno<<endl;
	cout<<"出生日期: ";
	birth.print();                                            // 通过Birthday的成员函数打印出生日期
	cout<<"专业课成绩: ";
	for(int i=0; i<num; ++i)
		cout<<score[i]<<" ";
	cout<<endl;
}

int main()
{
	Student st("计算机1151", true, 1151, 2015, 9, 1, 10);    // 定义Student对象
	double s[] = {10,50,66,80,100,70,52,90,78,99};
	st.input(s);                                             // 录入成绩
	st.print();                                              // 打印学生信息
	cout<<"平均成绩: "<<st.average()<<endl;                  // 计算平均成绩
	cout<<"不及格门数: "<<st.fail()<<endl;                   // 计算不及格门数
	return 0;
}