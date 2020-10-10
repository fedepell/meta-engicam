#!/bin/bash

# Script that unites the up to 8 DTS binaries and merges them in an unique
# binary file. Depending on the hardware type (3 pins set in production) UBoot
# will then address the correct offset of the DTS to use for the kernel

# Output file name
OUTFNAME=gwcv4-dtbs.bin
# Output total size in KB
TOTAL_SIZEKB=512


# Files to be included (filenames)
DTB_FILES=(microgea-mx6ull-gwcv4-dts2.dtb microgea-mx6ull-gwcv4-dts1.dtb)
# Files offset in output file to be included (in same order as names)
DTB_OFFSET=(0 64)
# Size of each DTB (for future additional checks?)
DTB_SIZEKB=64


# Create file full of zeroes
dd if=/dev/zero of=${OUTFNAME} bs=1024 count=${TOTAL_SIZEKB}

# Add each file at correct offset
for cur in ${!DTB_FILES[@]}; do
   dd if=${DTB_FILES[$cur]} of=${OUTFNAME} bs=1024 seek=${DTB_OFFSET[$cur]} conv=notrunc,nocreat
done;
