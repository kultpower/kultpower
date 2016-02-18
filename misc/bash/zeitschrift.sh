#!/bin/bash
if [ $# -eq 0 ]; then
    echo "No arguments provided"
    exit 1
fi

cd $1/cover;
mkdir -p 100
for img in `ls *.jpg`; do   convert -verbose -resize 100x141! -quality 85% $img ./100/$img; done
mkdir -p 150
for img in `ls *.jpg`; do   convert -verbose -resize 150x211! -quality 85% $img ./150/$img; done
mkdir -p 200
for img in `ls *.jpg`; do   convert -verbose -resize 200x282! -quality 85% $img ./200/$img; done
mkdir -p 250
for img in `ls *.jpg`; do   convert -verbose -resize 250x352! -quality 85% $img ./250/$img; done
mkdir -p 300
for img in `ls *.jpg`; do   convert -verbose -resize 300x423! -quality 85% $img ./300/$img; done
cd ../..