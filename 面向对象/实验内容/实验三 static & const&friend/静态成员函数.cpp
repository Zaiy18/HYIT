#include<iostream>
using namespace std;
#include<cstring>
class student
{
private:
	char *name;
public:
	student(char *_name)
	{
		name=new char[strlen(_name)+1];
		strcpy(name,_name);
		++count;
	}
	~student()
	{
		if(name!=NULL)
			delete []name;
		--count;
	}
	static int count;
	static int getcount() 
	{
		return count;
	}
};
 int student::count=0;
int main()
{
	cout<<student::count <<endl;
	student s2("lisi");
		cout<<student::getcount()<<endl;
		student s1("zhangsan");
	cout<<student::count <<endl;

}