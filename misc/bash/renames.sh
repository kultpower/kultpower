

cd asm/cover
#Dateien umbenennen:
ls *.jpg | sed 's/ASM\(.*\)/mv & asm_\1/' | sh

cd ../..



cd videogames/cover
#Dateien umbenennen:
ls *.jpg | sed 's/Videogames\(.*\)/mv & videogames_\1/' | sh
cd ../..


cd powerplay/cover
#Dateien umbenennen:
ls *.jpg | sed 's/PowerPlay\(.*\)/mv & powerplay_\1/' | sh
cd ../..


cd amigajoker/cover
#Dateien umbenennen:
ls *.jpg | sed 's/amigajoker\([0-9].*\)/mv & amigajoker_\1/' | sh
cd ../..




