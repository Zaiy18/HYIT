
template <class T>
class Matrix
{
public:
	Matrix(size_t _row = 5, size_t _column = 5);          
	Matrix(const Matrix<T> &matrix);                       
	~Matrix();                                             
	void init(T **mat);                                    
	size_t getRow() const;                                 
	size_t getColumn() const;                              
	void print() const;                                   
	Matrix<T>& operator=(const Matrix<T> &matrix);        
	Matrix<T> operator+(const Matrix<T> &matrix);         
	T& operator()(size_t rindex, size_t cindex);          
protected:
	T **content;                                                
	size_t row;                                            
	size_t column;                                       
template <class T>
Matrix<T>::Matrix(size_t _row, size_t _column): row(_row), column(_column)
{
	content = new T*[row];                             
	for(size_t i=0; i<row; ++i)
		content[i] = new T[column];                     
}


template <class T>
Matrix<T>::Matrix(const Matrix<T> &matrix): row(matrix.row), column(matrix.column)
{
	content = new T*[row];                                
	for(size_t i=0; i<row; ++i)
		content[i] = new T[column];                       
	for(size_t i=0; i<row; ++i)                           
		for(size_t j=0; j<column; ++j)
			content[i][j] = matrix.content[i][j];
}
template <class T>
Matrix<T>::~Matrix()
{
	for(size_t i=0; i<row; ++i)                          
		if(content[i]!=NULL)
			delete [] content[i];
	if(content!=NULL)                                    
		delete [] content;
}
template <class T>
void Matrix<T>::init(T **mat)
{
	for(size_t i=0; i<row; ++i)
		for(size_t j=0; j<column; ++j)
			content[i][j] = mat[i][j];
}


template <class T>
size_t Matrix<T>::getRow() const
{
	return row;
}


template <class T>
size_t Matrix<T>::getColumn() const
{
	return column;
}


template <class T>
void Matrix<T>::print() const
{
	cout<<setiosflags(ios::left);
	for(size_t i=0; i<row; ++i)
	{
		for(size_t j=0; j<column; ++j)
			cout<<setw(4)<<content[i][j];
		cout<<endl;
	}
}

template <class T>
Matrix<T>& Matrix<T>::operator=(const Matrix<T> &matrix)
{
	for(size_t i=0; i<row; ++i)                           
		if(content[i]!=NULL)
			delete [] content[i];
	if(content!=NULL)                                    
		delete [] content;

	row = matrix.row;
	column = matrix.column;

	content = new T*[row];                               
	for(size_t i=0; i<row; ++i)
		content[i] = new T[column];                       
	for(size_t i=0; i<row; ++i)                           
		for(size_t j=0; j<column; ++j)
			content[i][j] = matrix.content[i][j];
	return *this;                                   
}
template <class T>
Matrix<T> Matrix<T>::operator+(const Matrix<T> &matrix)
{
	Matrix<T> result(row, column);
	for(size_t i=0; i<row; ++i)
		for(size_t j=0; j<column; ++j)
			result.content[i][j] = content[i][j] + matrix.content[i][j];
	return result;
}
template <class T>
T& Matrix<T>::operator()(size_t rindex, size_t cindex)
{
	return content[rindex][cindex];
}


template <class T=int, class S=int>                   
class Pair
{
public:
	Pair() { }
	Pair(T _first, S _second): first(_first), second(_second) { }
	T first;
	S second;
};
template <class T>
Pair<int, int> search(const T *vec, int n, const T &data) 
{
	Pair<int, int> result;
	int i;

	for(i=0; i<n; ++i)
		if(vec[i]==data)
		{
			result.first = i;
			break;
		}
	if(i==n)         
		result.first = -1;

	for(i=n-1; i>=0; --i)
		if(vec[i]==data)
		{
			result.second = i;
			break;
		}
	if(i==-1)        
		result.second = -1;
	return result;
}
