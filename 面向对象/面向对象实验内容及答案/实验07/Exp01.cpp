
#include <iostream>
#include <cstring>
#include <cmath>
using namespace std;

// Point 类定义
class Point
{
public:
	Point(double _x = 0.0, double _y = 0.0);                 // 构造函数
	void set(double _x, double _y);                          // 设置坐标
	double getX() const;                                     // 获取横坐标
	double getY() const;                                     // 获取纵坐标
	void print() const;                                      // 打印坐标
protected:
	double x;                                                // 横坐标
	double y;                                                // 纵坐标
};

// 抽象基类 Shape 定义
class Shape
{
public:
	Shape(const char *_color = "red");                       // 构造函数
	virtual ~Shape();                                        // 虚析构函数
	virtual void draw() const = 0;                           // 画图（纯虚函数）
	virtual double area() const = 0;                         // 计算面积（纯虚函数）
	virtual double perimeter() const = 0;                    // 计算周长（纯虚函数）
	void setColor(const char *_color);                       // 设置颜色
	const char* getColor() const;                            // 获取颜色
protected:
	char *color;                                             // 颜色
};

// 线段派生类 Line 定义
class Line: public Shape                                     // 公有继承
{
public:
	// 构造函数
	Line(const char *_name, double x1, double y1, double x2, double y2, const char *color = "red");
	virtual ~Line();                                         // 虚析构函数
	virtual void draw() const;                               // 画图（虚函数）
	virtual double area() const;                             // 计算面积（虚函数）
	virtual double perimeter() const;                        // 计算周长（虚函数）
	double length() const;                                   // 计算线段长度
	Point getStart() const;                                  // 获取线段起点
	Point getEnd() const;                                    // 获取线段终点
protected:
	Point start;                                             // 起点
	Point end;                                               // 终点
	char *name;                                              // 名字
};

// 圆派生类 Circle 定义
class Circle: public Shape                                   // 公有继承
{
public:
	// 构造函数
	Circle(const char *_name, double x, double y, double _radius, const char *color = "red", double _PI = 3.1415);
	virtual ~Circle();                                       // 虚析构函数
	virtual void draw() const;                               // 画图（虚函数）
	virtual double area() const;                             // 计算面积（虚函数）
	virtual double perimeter() const;                        // 计算周长（虚函数）
	double getRadius() const;                                // 获取半径
	Point getCenter() const;                                 // 获取圆心
protected:
	Point center;                                            // 圆心
	double radius;                                           // 半径
	const double PI;                                         // 圆周率PI
	char *name;                                              // 名字
};

// Point 类成员函数实现部分
Point::Point(double _x, double _y)
{
	x = _x;
	y = _y;
}

void Point::set(double _x, double _y)
{
	x = _x;
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

// Shape 类成员函数实现部分
Shape::Shape(const char *_color)
{
	color = new char[strlen(_color)+1];
	strcpy(color, _color);
}

Shape::~Shape()
{
	if(color!=NULL)
		delete [] color;
}

void Shape::setColor(const char *_color)
{
	delete [] color;                                         // 释放原有堆空间
	color = new char[strlen(_color)+1];                      // 重新开辟堆空间
	strcpy(color, _color);
}

const char* Shape::getColor() const
{
	return color;
}

// Line 类成员函数实现部分
Line::Line(const char *_name, double x1, double y1, double x2, double y2, const char *color)
	: Shape(color), start(x1, y1), end(x2, y2)              // 调用基类构造函数初始化基类成员
{
	name = new char[strlen(_name)+1];
	strcpy(name, _name);
}

Line::~Line()
{
	if(name!=NULL)
		delete [] name;
}

// 实现基类纯虚函数
void Line::draw() const
{
	cout<<"图形名称: "<<name<<endl;
	cout<<"图形类型: 线段"<<endl;
	cout<<"图形颜色: "<<color<<endl;
	cout<<"起点: ";
	start.print();
	cout<<"终点: ";
	end.print();
}

// 实现基类纯虚函数
double Line::area() const
{
	return 0;
}

// 实现基类纯虚函数
double Line::perimeter() const
{
	return length();
}

double Line::length() const
{
	return sqrt((start.getX()-end.getX())*(start.getX()-end.getX())+(start.getY()-end.getY())*(start.getY()-end.getY()));
}

Point Line::getStart() const
{
	return start;
}

Point Line::getEnd() const
{
	return end;
}

// Circle 类成员函数实现部分
Circle::Circle(const char *_name, double x, double y, double _radius, const char *color, double _PI)
	: Shape(color), center(x, y), PI(_PI)                   // 调用基类构造函数初始化基类成员
{
	name = new char[strlen(_name)+1];
	strcpy(name, _name);
	radius = _radius;
}

Circle::~Circle()
{
	if(name!=NULL)
		delete [] name;
}

// 实现基类纯虚函数
void Circle::draw() const
{
	cout<<"图形名称: "<<name<<endl;
	cout<<"图形类型: 圆"<<endl;
	cout<<"图形颜色: "<<color<<endl;
	cout<<"圆心: ";
	center.print();
	cout<<"半径: "<<radius<<endl;
}

// 实现基类纯虚函数
double Circle::area() const
{
	return PI*radius*radius;
}

// 实现基类纯虚函数
double Circle::perimeter() const
{
	return 2*PI*radius;
}

double Circle::getRadius() const
{
	return radius;
}

Point Circle::getCenter() const
{
	return center;
}

// 全局函数定义
void printShape(const Shape &shape)                        // 多态函数（参数为基类指针或引用）
{
	shape.draw();                                          // 调用纯虚函数（具有多态性）
	cout<<"图形面积: "<<shape.area()<<endl;                // 调用纯虚函数（具有多态性）
	cout<<"图形周长: "<<shape.perimeter()<<endl;           // 调用纯虚函数（具有多态性）
}

int main()
{
	Line line("Dynamic Line", 2.0, 2.0, 5.0, 6.0, "Yellow");
	Circle circle("Vivid Circle", 3.0, 3.0, 4.0, "Blue");

	printShape(line);                                     // 调用多态函数
	cout<<"线段长度: "<<line.length()<<endl;              // 调用派生类成员函数
	
	printShape(circle);                                   // 调用多态函数
	circle.setColor("Green");                             // 调用基类成员函数
	printShape(circle);                                   // 调用多态函数

	return 0;
}