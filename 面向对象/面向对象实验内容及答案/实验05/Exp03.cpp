
#include <iostream>
#include <cmath>
using namespace std;

// Point 类定义
class Point
{
public:
	Point(double _x = 0.0, double _y = 0.0);          // 带默认参数的构造函数
	Point(const Point &point);                        // 拷贝构造函数
	void setX(double _x);                             // 设置横坐标
	void setY(double _y);                             // 设置纵坐标
	double getX() const;                              // 获取横坐标，定义为const成员函数
	double getY() const;                              // 获取纵坐标，定义为const成员函数
	void print() const;                               // 打印点的坐标信息，定义为const成员函数
	friend double pdistance(const Point &p1, const Point &p2); // 友元函数声明
	friend Point midpoint(const Point &p1, const Point &p2);   // 友元函数声明
protected:
	double x;
	double y;
};

// Point 类成员函数实现
Point::Point(double _x, double _y)                    // 在类外实现时不带默认参数
{
	x = _x;
	y = _y;
}

Point::Point(const Point &point)
{
	x = point.x;
	y = point.y;
}

void Point::setX(double _x)
{
	x = _x;
}

void Point::setY(double _y)
{
	y = _y;
}

double Point::getX() const
{
	return x;
}

double Point::getY() const
{
	return y;
}

void Point::print() const
{
	cout<<"("<<x<<", "<<y<<")"<<endl;
}

// 普通友元函数定义，计算两个Point对象的距离
double pdistance(const Point &p1, const Point &p2)
{
	return sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
}

// 普通友元函数定义，计算两个Point对象的中点
Point midpoint(const Point &p1, const Point &p2)
{
	Point mid;
	mid.setX((p1.x+p2.x)/2);
	mid.setY((p1.y+p2.y)/2);
	return mid;
}

int main()
{
	Point p1(1.0, 2.0);
	Point p2(4.0, 6.0);
	cout<<"距离: "<<pdistance(p1, p2)<<endl;
	cout<<"中点: ";
	midpoint(p1, p2).print();
	return 0;
}