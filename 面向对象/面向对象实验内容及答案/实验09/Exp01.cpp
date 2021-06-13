
class String
{
public:
	String();                             
	String(const char *content);         
	String(const String &cstr);           
	~String();                           
	void set(const char *content);      
	int length() const;                 
	void print() const;                  
	
	String& operator=(const String &cstr)；
	String& operator=(const char *cstr);  
	char& operator[](int index);          
	operator char*();                   
	friend String operator+(const String &cstr1, const String &cstr2); 
	friend String operator+(const String &cstr1, const char *cstr2);   
	friend String operator+(const char *cstr1, const String &cstr2);   
	friend String& operator++(String &cstr);                           
	friend String operator++(String &cstr, int);                       
protected:
	char *str;                           


String::String()                              
{
	str = NULL;                          
}


String::String(const char *content)
{
	int len = strlen(content);
	str = new char[len+1];
	strcpy(str, content);
}


String::String(const String &cstr)
{
	str = new char[cstr.length()+1];       
	strcpy(str, cstr.str);
}

String::~String()
{
	if(str!=NULL)
		delete [] str;
}

void String::set(const char *content)
{
	if(str!=NULL)
		delete [] str;                  
	int len = strlen(content);
	str = new char[len+1];              
	strcpy(str, content);
}

// 获取字符串长度
int String::length() const
{
	return strlen(str);
}

void String::print() const
{
	cout<<str<<endl;
}

String& String::operator=(const String &cstr)
{
	if(str!=NULL)
		delete [] str;                      
	str = new char[cstr.length()+1];         
	strcpy(str, cstr.str);
	return *this;
}

String& String::operator=(const char *cstr)
{
	if(str!=NULL)
		delete [] str;                      
	str = new char[strlen(cstr)+1];         
	strcpy(str, cstr);
	return *this;
}


char& String::operator[](int index)
{
	return str[index];
}


String::operator char*()
{
	char *cstr = new char[strlen(str)+1];    
	strcpy(cstr, str);
	return cstr;                             
}


String operator+(const String &cstr1, const String &cstr2)
{
	String result;
	int len = cstr1.length() + cstr2.length();
	result.str = new char[len+1];
	strcpy(result.str, cstr1.str);
	strcpy(result.str+cstr1.length(), cstr2.str);
	return result;
}

// 重载加法运算符+，实现字符串和字符指针的拼接
String operator+(const String &cstr1, const char *cstr2)
{
	String result;
	int len = cstr1.length() + strlen(cstr2);
	result.str = new char[len+1];
	strcpy(result.str, cstr1.str);
	strcpy(result.str+cstr1.length(), cstr2);
	return result;
}
String operator+(const char *cstr1, const String &cstr2)
{
	String result;
	int len = strlen(cstr1) + cstr2.length();
	result.str = new char[len+1];
	strcpy(result.str, cstr1);
	strcpy(result.str+strlen(cstr1), cstr2.str);
	return result;
}


String& operator++(String &cstr)
{
	for(int i=0; i<cstr.length(); ++i)
		if(cstr[i]>='a'&&cstr[i]<='z')       
			cstr[i] = cstr[i] - ('a' - 'A');
	return cstr;                           
}


String operator++(String &cstr, int)
{
	String result(cstr);                    
	for(int i=0; i<cstr.length(); ++i)
		if(cstr[i]>='a'&&cstr[i]<='z')       
			cstr[i] = cstr[i] - ('a' - 'A');
	return result;                           
}

