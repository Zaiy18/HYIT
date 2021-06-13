
#include <iostream>
#include <cstring>
using namespace std;

class Employee
{
public:
    // ����ְ���Ļ�����Ϣ
	void set(char *_name, bool _sex, int _age, int _wage, double _salary);
	// �޸�ְ������
	void changeName(char *_name);
	// �޸Ĺ���
	void changeSalary(double _salary);
	// ��н����
	double computSalary(double award);
	// ��������
	void update();
	// ��ʾְ����Ϣ
	void print();
private:
	char name[20];       // ְ������
	bool sex;            // ְ���Ա�
	int age;             // ְ������
	int wage;            // ְ������
	double salary;       // ְ������
};

// ����ְ���Ļ�����Ϣ
void Employee::set(char *_name, bool _sex, int _age, int _wage, double _salary)
{
	strcpy(name,_name);
	sex = _sex;
	age = _age;
	wage = _wage;
	salary = _salary;
}

// �޸�ְ������
void Employee::changeName(char *_name)
{
	strcpy(name,_name);
}

// �޸Ĺ���
void Employee::changeSalary(double _salary)
{
	salary = _salary;
}

// ��н����
double Employee::computSalary(double award)
{
	return 12*salary+award;
}

// ��������
void Employee::update()
{
	wage++;
	age++;
}

// ��ʾְ����Ϣ
void Employee::print()
{
	cout<<"����: "<<name<<endl;
	cout<<"�Ա�: "<<(sex?"��":"Ů")<<endl;
	cout<<"����: "<<age<<endl;
	cout<<"����: "<<wage<<endl;
	cout<<"����: "<<salary<<endl;
}

int main()
{
	Employee em;                                     // �������
	em.set("����",true,30,0,3000);                   // ���Ա����
	em.print();
	cout<<"��н: "<<em.computSalary(10000)<<endl;
	em.update();
	em.changeSalary(4000);
	em.print();
	cout<<"��н: "<<em.computSalary(10000)<<endl;
	return 0;
}