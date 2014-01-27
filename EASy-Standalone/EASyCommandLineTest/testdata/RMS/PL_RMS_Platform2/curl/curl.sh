#!/bin/sh
scriptdir=`dirname $0`
scriptdir=`readlink -m $scriptdir`
echo > $scriptdir/curl.out
for var in "$@"
do
echo "$var " >> $scriptdir/curl.out
done
