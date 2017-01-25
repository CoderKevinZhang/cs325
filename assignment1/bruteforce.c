#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

enum {
    input,
    output
};
int fd[2];

int main(int argc, char **argv) {

    if(argc < 2) {
        printf("Usage: ./brutforce [example.input]\n");
        return 0;
    }

    fd[input] = open(argv[1], O_RDONLY);

    close(fd[input]);

    return 0;
}

