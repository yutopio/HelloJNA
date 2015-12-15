#include <cstring>
#include <iostream>
#include <string>

using namespace std;

extern "C"
void println(const char * const msg) {
  cout << msg << endl;
}

extern "C"
int getInt() {
  int value;
  cin >> value;
  return value;
}

extern "C"
const char * const toString(int bit) {
  string str = std::to_string(bit);
  char *cstr = new char[str.length() + 1];
  strcpy(cstr, str.c_str());
  return cstr;
}

extern "C"
void deleteArray(const char * const pt) {
  delete[] pt;
}
