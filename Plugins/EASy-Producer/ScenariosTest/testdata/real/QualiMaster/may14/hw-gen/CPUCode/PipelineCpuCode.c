#include "Maxfiles.h"
#include <MaxSLiCInterface.h>

int main(void)
{
    while(true) {
        int32_ *inData;
        int count = readDataFromNetwork(inData); // simplification, we need a loop or so
        int32_ *outData;
        outData = malloc(count); // just for now
        int pe1Enabled = readIntFromNetwork(); // just for now

        Pipeline(pe1Enabled, inData, outData);
        writeToNetwork(outData);
    }
}
