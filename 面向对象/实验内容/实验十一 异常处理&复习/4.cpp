//employ.cpp

#include <iostream.h>
#include "employ.h"

Name::Name(char* n)
{
  ChangeName(n);
}

void Name::Display()
{
  cout <<firstName <<" " <<lastName <<endl;
}

void Name::ChangeName(char* n)
{
  char* p=n;
  int i;
  for(i=0; i<19; i++){
    if(*p==' '||*p=='\0')
      break;
    firstName[i]=*p++;
  }
  firstName[i]='\0';
  if(*p=='\0'){
    lastName[0]='\0';
    return;
  }
  while(*p==' ') p++;
  for(i=0; i<19; i++){
    if(*p==' '||*p=='\0')
      break;
    lastName[i]=*p++;
  }
  lastName[i]='\0';
}

Employ::Employ(char* n,char* a,char* c,char* s,char* z) :name(n)
{
  strncpy(addr,a,40);
  addr[39]='\0';
  strncpy(city,c,20);
  city[19]='\0';
  strncpy(state,s,20);
  state[19]='\0';
  strncpy(zip,z,10);
  zip[9]='\0';
}

void Employ::ChangeName(char* n)
{
  name.ChangeName(n);
}

void Employ::Display()
{
  name.Display();
  cout <<addr <<" " <<city <<endl
       <<state <<" "
       <<zip <<endl;
}

