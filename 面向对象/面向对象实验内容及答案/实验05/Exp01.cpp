
#include <iostream>
#include <iomanip>
using namespace std;

// Time 类定义
class Time
{
public:
	Time(double _hour = 0.0, double _minute = 0.0, double _second = 0.0);  // 带默认参数的构造函数
	Time(const Time &time);               // 拷贝构造函数
	void setHour(double _hour);           // 设置小时
	void setMinute(double _minute);       // 设置分钟
	void setSecond(double _second);       // 设置秒
	double getHour() const;               // 获取小时，定义为const成员函数
	double getMinute() const;             // 获取分钟，定义为const成员函数
	double getSecond() const;             // 获取秒，定义为const成员函数
	void print() const;                   // 打印时间信息，定义为const成员函数
protected:
	double hour;                          // 时
	double minute;                        // 分
	double second;                        // 秒
};

// Time类成员函数实现
Time::Time(double _hour, double _minute, double _second)                   // 类外实现时不带默认参数
{
	hour = _hour;
	minute = _minute;
	second = _second;
}

Time::Time(const Time &time)
{
	hour = time.hour;                     // 可以直接访问保护数据成员
	minute = time.minute;
	second = time.second;
}

void Time::setHour(double _hour)
{
	hour = _hour;
}

void Time::setMinute(double _minute)
{
	minute = _minute;
}

void Time::setSecond(double _second)
{
	second = _second;
}

double Time::getHour() const             // 类外实现时也要带const
{
	return hour;
}

double Time::getMinute() const
{
	return minute;
}

double Time::getSecond() const
{
	return second;
}

void Time::print() const
{
	cout<<setfill('0')<<setiosflags(ios::right);
	cout<<setw(2)<<hour<<":"<<setw(2)<<minute<<":"<<setw(2)<<second<<endl;
}

int main()
{
	Time time(9, 8, 7);
	time.print();
	time.setHour(10);
	time.print();
	return 0;
}