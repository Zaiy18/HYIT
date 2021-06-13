
#include <iostream>
#include <cstring>
using namespace std;

// Book 类定义
class Book
{
public:
	Book(char *_bookname, double _price, size_t _num);      // 构造函数
	Book(const Book &book);                  // 拷贝构造函数
	~Book();                                 // 析构函数
	void borrow(size_t bnum);                // 借书操作
	void restore(size_t bnum);               // 还书操作
	double getPrice() const;                 // 获取图书价格，定义为const成员函数
	size_t getNum() const;                   // 获取图书数量，定义为const成员函数
	static size_t getTotal();                // 获取图书馆总存书数量，定义为静态成员函数
	void print() const;                      // 显示图书信息，定义为const成员函数
protected:
	char *bookname;                          // 书名
	double price;                            // 价格
	size_t num;                              // 图书数量
	static size_t total;                     // 图书馆总存书数量
};

// 静态数据成员初始化（在类外实现），不带static关键字
size_t Book::total = 0;

// Book类成员函数实现
Book::Book(char *_bookname, double _price, size_t _num)
{
	bookname = new char[strlen(_bookname)+1];
	strcpy(bookname, _bookname);
	price = _price;
	num = _num;
	total += num;                            // 修改静态数据成员
}

Book::Book(const Book &book)
{
	bookname = new char[strlen(book.bookname)+1];
	strcpy(bookname, book.bookname);
	price = book.price;
	num = book.num;
	total += num;                            // 修改静态数据成员
}

Book::~Book()
{
	if(bookname!=NULL)
		delete [] bookname;
	total -= num;                            // 修改静态数据成员
}

void Book::borrow(size_t bnum)
{
	num -= bnum;
	total -= bnum;                           // 修改静态数据成员
}

void Book::restore(size_t bnum)
{
	num += bnum;
	total += bnum;                           // 修改静态数据成员
}

double Book::getPrice() const
{
	return price;
}

size_t Book::getNum() const
{
	return num;
}

size_t Book::getTotal()                     // 静态成员函数在类外实现时，不带static关键字
{
	return total;
}

void Book::print() const
{
	cout<<"书名: "<<bookname<<endl;
	cout<<"价格: "<<price<<endl;
	cout<<"数量: "<<num<<endl;
	cout<<"总存书量: "<<total<<endl;
}

int main()
{
	cout<<"总存书量: "<<Book::getTotal()<<endl;  // 通过类名直接访问静态成员函数 
	Book b1("C++", 25, 20);
	cout<<"总存书量: "<<Book::getTotal()<<endl;
	Book b2("Java", 30, 40);
	cout<<"总存书量: "<<Book::getTotal()<<endl;
	b1.borrow(10);
	b1.print();
	b1.restore(5);
	b1.print();
	return 0;
}