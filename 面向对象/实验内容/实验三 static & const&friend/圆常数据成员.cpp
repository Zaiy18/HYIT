#include<iostream>
using namespace std;
class circle
{
private:
	double r;
public:
	circle(double _r):r(_r),pi(3.14)
	{}
	double area()
	{
		return pi*r*r;
	}
	const double pi;

};
int main()
{
	circle c(2);
	cout<<c.area()<<endl;
}