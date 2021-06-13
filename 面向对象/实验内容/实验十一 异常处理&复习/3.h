//employee.h

#ifndef EMPLOYEE
#define EMPLOYEE

class Employee{
public:
  Employee(char* n,char* a,char* c,char* s,char* z);
  void ChangeName(char* n);
  void Display();
protected:
  char name[20];
  char addr[40];
  char city[20];
  char state[20];
  char zip[10];
};

#endif
