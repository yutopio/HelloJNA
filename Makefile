NAME = HelloWorld
LIB_NAME = libmynative

CXX_SRCS = $(NAME).cpp
OBJS = $(NAME).class $(LIB_NAME).so
CXXFLAGS =  -W -Wall -Wextra -pedantic -fPIC -O2 -std=c++0x

all: $(OBJS)
$(NAME): $(OBJS)

.SUFFIXES: .java .class

.java.class:
	javac -cp jna-4.2.1.jar $<

$(LIB_NAME).so:
	$(CXX) -shared $(CXXFLAGS) -o $(LIB_NAME).so $(NAME).cpp

.PHONY: clean
clean:
	$(RM) *.class *.so
