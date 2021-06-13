//employee.cpp

#include "employee.h"
#include <iostream.h>

Employee::Employee(char* n,char* a, char* c, char* s, char* z)
{
  strncpy(name,n,20);
  name[19]='\0';
  strncpy(addr,a,40);
  addr[39]='\0';
  strncpy(city,c,20);
  city[19]='\0';
  strncpy(state,s,20);
  state[19]='\0';
  strncpy(zip,z,10);
  zip[9]='\0';
}

void Employee::ChangeName(char* n)
{
  strncpy(name,n,20);
  name[19]='\0';
}

void Employee::Display()
{
  cout <<name <<endl
       <<addr <<" " <<city <<endl
       <<state <<" "
       <<zip <<endl;
}
  char name[20];
  char addr[40];
  char city[20];
  char state[20];
  char zip[10];
