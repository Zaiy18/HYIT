
#include <iostream>
#include <iomanip>
using namespace std;

// Time �ඨ��
class Time
{
public:
	Time(double _hour = 0.0, double _minute = 0.0, double _second = 0.0);  // ��Ĭ�ϲ����Ĺ��캯��
	Time(const Time &time);               // �������캯��
	void setHour(double _hour);           // ����Сʱ
	void setMinute(double _minute);       // ���÷���
	void setSecond(double _second);       // ������
	double getHour() const;               // ��ȡСʱ������Ϊconst��Ա����
	double getMinute() const;             // ��ȡ���ӣ�����Ϊconst��Ա����
	double getSecond() const;             // ��ȡ�룬����Ϊconst��Ա����
	void print() const;                   // ��ӡʱ����Ϣ������Ϊconst��Ա����
protected:
	double hour;                          // ʱ
	double minute;                        // ��
	double second;                        // ��
};

// Time���Ա����ʵ��
Time::Time(double _hour, double _minute, double _second)                   // ����ʵ��ʱ����Ĭ�ϲ���
{
	hour = _hour;
	minute = _minute;
	second = _second;
}

Time::Time(const Time &time)
{
	hour = time.hour;                     // ����ֱ�ӷ��ʱ������ݳ�Ա
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

double Time::getHour() const             // ����ʵ��ʱҲҪ��const
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