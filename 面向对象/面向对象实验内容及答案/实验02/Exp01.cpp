
#include <iostream>
#include <cstring>
using namespace std;

class Employee
{
public:
    // ���캯����ְ��������Ϣ�ĳ�ʼ��
	Employee(char *_name, bool _sex, int _age, int _wage, double _salary);
	// �����������ͷ�ϵͳ��Դ
	~Employee();
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
	char *name;          // ְ������
	bool sex;            // ְ���Ա�
	int age;             // ְ������
	int wage;            // ְ������
	double salary;       // ְ������
};

// ���캯����ְ��������Ϣ�ĳ�ʼ��
Employee::Employee(char *_name, bool _sex, int _age, int _wage, double _salary)
{
	int len = strlen(_name);
	name = new char[len+1];      // �ڶ��Ͽ�������ռ�
	strcpy(name,_name);
	sex = _sex;
	age = _age;
	wage = _wage;
	salary = _salary;
}

// �����������ͷ�ϵͳ��Դ
Employee::~Employee()
{
	if(name!=NULL)
		delete [] name;         // �ͷ�����ռ�
}

// �޸�ְ������
void Employee::changeName(char *_name)
{
	delete [] name;             // �ͷ���������ռ�
	int len = strlen(_name);
	name = new char[len+1];     // ����������ռ�
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
	Employee em("����",true,30,0,3000);              // �������, ���ù��캯�����г�ʼ��
	em.print();
	cout<<"��н: "<<em.computSalary(10000)<<endl;
	em.update();
	em.changeSalary(4000);
	em.print();
	cout<<"��н: "<<em.computSalary(10000)<<endl;
	return 0;

	// ����������ڽ���ǰ����������������������
}