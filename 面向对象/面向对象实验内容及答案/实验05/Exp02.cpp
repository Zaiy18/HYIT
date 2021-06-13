
#include <iostream>
#include <cstring>
using namespace std;

// Book �ඨ��
class Book
{
public:
	Book(char *_bookname, double _price, size_t _num);      // ���캯��
	Book(const Book &book);                  // �������캯��
	~Book();                                 // ��������
	void borrow(size_t bnum);                // �������
	void restore(size_t bnum);               // �������
	double getPrice() const;                 // ��ȡͼ��۸񣬶���Ϊconst��Ա����
	size_t getNum() const;                   // ��ȡͼ������������Ϊconst��Ա����
	static size_t getTotal();                // ��ȡͼ����ܴ�������������Ϊ��̬��Ա����
	void print() const;                      // ��ʾͼ����Ϣ������Ϊconst��Ա����
protected:
	char *bookname;                          // ����
	double price;                            // �۸�
	size_t num;                              // ͼ������
	static size_t total;                     // ͼ����ܴ�������
};

// ��̬���ݳ�Ա��ʼ����������ʵ�֣�������static�ؼ���
size_t Book::total = 0;

// Book���Ա����ʵ��
Book::Book(char *_bookname, double _price, size_t _num)
{
	bookname = new char[strlen(_bookname)+1];
	strcpy(bookname, _bookname);
	price = _price;
	num = _num;
	total += num;                            // �޸ľ�̬���ݳ�Ա
}

Book::Book(const Book &book)
{
	bookname = new char[strlen(book.bookname)+1];
	strcpy(bookname, book.bookname);
	price = book.price;
	num = book.num;
	total += num;                            // �޸ľ�̬���ݳ�Ա
}

Book::~Book()
{
	if(bookname!=NULL)
		delete [] bookname;
	total -= num;                            // �޸ľ�̬���ݳ�Ա
}

void Book::borrow(size_t bnum)
{
	num -= bnum;
	total -= bnum;                           // �޸ľ�̬���ݳ�Ա
}

void Book::restore(size_t bnum)
{
	num += bnum;
	total += bnum;                           // �޸ľ�̬���ݳ�Ա
}

double Book::getPrice() const
{
	return price;
}

size_t Book::getNum() const
{
	return num;
}

size_t Book::getTotal()                     // ��̬��Ա����������ʵ��ʱ������static�ؼ���
{
	return total;
}

void Book::print() const
{
	cout<<"����: "<<bookname<<endl;
	cout<<"�۸�: "<<price<<endl;
	cout<<"����: "<<num<<endl;
	cout<<"�ܴ�����: "<<total<<endl;
}

int main()
{
	cout<<"�ܴ�����: "<<Book::getTotal()<<endl;  // ͨ������ֱ�ӷ��ʾ�̬��Ա���� 
	Book b1("C++", 25, 20);
	cout<<"�ܴ�����: "<<Book::getTotal()<<endl;
	Book b2("Java", 30, 40);
	cout<<"�ܴ�����: "<<Book::getTotal()<<endl;
	b1.borrow(10);
	b1.print();
	b1.restore(5);
	b1.print();
	return 0;
}