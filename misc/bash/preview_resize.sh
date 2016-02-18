
mkdir -p h50
for img in `ls *.png`; do   convert -verbose -resize x50 -quality 85% $img ./h50/$img; done
mkdir -p h80
for img in `ls *.png`; do   convert -verbose -resize x80 -quality 85% $img ./h80/$img; done
mkdir -p h90
for img in `ls *.png`; do   convert -verbose -resize x90 -quality 85% $img ./h90/$img; done
mkdir -p h100
for img in `ls *.png`; do   convert -verbose -resize x100 -quality 85% $img ./h100/$img; done
mkdir -p h120
for img in `ls *.png`; do   convert -verbose -resize x100 -quality 85% $img ./h120/$img; done
mkdir -p h150
for img in `ls *.png`; do   convert -verbose -resize x150 -quality 85% $img ./h150/$img; done
mkdir -p h200
for img in `ls *.png`; do   convert -verbose -resize x200 -quality 85% $img ./h200/$img; done
mkdir -p h250
for img in `ls *.png`; do   convert -verbose -resize x250 -quality 85% $img ./h250/$img; done
mkdir -p h300
for img in `ls *.png`; do   convert -verbose -resize x300 -quality 85% $img ./h300/$img; done




for img in `ls asm.png`; do   convert -verbose -resize x50 -quality 85% $img ./h50/$img; done
for img in `ls asm.png`; do   convert -verbose -resize x80 -quality 85% $img ./h80/$img; done
for img in `ls asm.png`; do   convert -verbose -resize x90 -quality 85% $img ./h90/$img; done
for img in `ls asm.png`; do   convert -verbose -resize x100 -quality 85% $img ./h100/$img; done
for img in `ls asm.png`; do   convert -verbose -resize x100 -quality 85% $img ./h120/$img; done
for img in `ls asm.png`; do   convert -verbose -resize x150 -quality 85% $img ./h150/$img; done
for img in `ls asm.png`; do   convert -verbose -resize x200 -quality 85% $img ./h200/$img; done
for img in `ls asm.png`; do   convert -verbose -resize x250 -quality 85% $img ./h250/$img; done
for img in `ls asm.png`; do   convert -verbose -resize x300 -quality 85% $img ./h300/$img; done
