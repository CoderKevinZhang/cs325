#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>

std::vector<std::pair<int,int> > points;

void readFile(char *fileName);

int main(int argc, char **argv) {

    if(argc < 2) {
        std::cout << "Usage: ./brutforce [example.input]\n";
        return 0;
    }

    readFile(argv[1]);

    return 0;
}

void readFile(char *fileName) {
    int a, b;
    std::ifstream input;

    input.open(fileName);

    while( input >> a >> b) {
        //std::cout << a << b << "\n";
        points.push_back(std::make_pair(a, b));
    }

    input.close();
}
