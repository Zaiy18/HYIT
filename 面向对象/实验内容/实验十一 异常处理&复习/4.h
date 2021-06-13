//employ.h

#ifndef EMPLOY
#define EMPLOY

class Name{
public:
  Name(char* n);
  void Display();
  void ChangeName(char* n);
protected:
  char firstName[20];
  char lastName[20];
};

class Employ{
public:
  Employ(char* n,char* a,char* c,char* s,char* z);
  void ChangeName(char* n);
  void Display();
protected:
  Name name;
  char addr[40];
  char city[20];
  char state[20];
  char zip[10];
};

#endif

