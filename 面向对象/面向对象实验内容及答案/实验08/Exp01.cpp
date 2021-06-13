
class String
{
public:
	String();                             
	String(const char *content);         
	String(const String &cstr);           
	~String();                            
	void set(const char *content);        
	void get(char *&dest) const;          
	int length() const;                   
	void print() const;                   
	String& operator=(const String &cstr);
	char& operator[](int index);          
	String operator+(const String &cstr); 
	String operator+(const char *cstr);   
	String operator+(char ch);           
	String operator-();                   
	String& operator++();                 
	String operator++(int);               
	
	String& operator--();                
	String operator--(int);               
protected:
	char *str;                          
};

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


void String::get(char *&dest) const
{
	int len = strlen(str);
	dest = new char[len+1];
	strcpy(dest, str);
}

int String::length() const
{
	return strlen(str);
}


void String::print() const
{
	cout<<str<<endl;
}

// ÖØÔØ¸³ÖµÔËËã·û
String& String::operator=(const String &cstr)
{
	if(str!=NULL)
		delete [] str;                      
	str = new char[cstr.length()+1];     
	strcpy(str, cstr.str);
	return *this;
}


char& String::operator[](int index)
{
	return str[index];
}


String String::operator+(const String &cstr)
{
	String result;
	int len = length() + cstr.length();
	result.str = new char[len+1];
	strcpy(result.str, str);
	strcpy(result.str+length(), cstr.str);
	return result;
}


String String::operator+(const char *cstr)  
{
	String result;
	int len = length() + strlen(cstr);
	result.str = new char[len+1];
	strcpy(result.str, str);
	strcpy(result.str+length(), cstr);
	return result;
}


String String::operator+(char ch)
{
	String result;
	int len = length() + 1;
	result.str = new char[len+1];
	strcpy(result.str, str);
	result.str[length()] = ch;
	result.str[length()+1] = '\0';
	return result;
}

String String::operator-()
{
	String result;
	result.str = new char[length()+1];
	for(int i=0; i<length(); ++i)
		result.str[i] = str[length()-1-i];
	result.str[length()] = '\0'; 
	return result;
}

String& String::operator++()
{
	for(int i=0; i<length(); ++i)
		if(str[i]>='a'&&str[i]<='z')
			str[i] = str[i] - ('a' - 'A');
	return *this;                                
}


String String::operator++(int)
{
	String result(str);
	for(int i=0; i<length(); ++i)
		if(str[i]>='a'&&str[i]<='z')
			str[i] = str[i] - ('a' - 'A');
	return result;                             
}


String& String::operator--()
{
	for(int i=0; i<length(); ++i)
		if(str[i]>='A'&&str[i]<='Z')
			str[i] = str[i] + ('a' - 'A');
	return *this;                              
} 


String String::operator--(int)
{
	String result(str);
	for(int i=0; i<length(); ++i)
		if(str[i]>='A'&&str[i]<='Z')
			str[i] = str[i] + ('a' - 'A');
	return result;                            
}

