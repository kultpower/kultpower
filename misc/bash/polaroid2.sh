#!/bin/bash
DEBUG=false


dir=$1
outputfile=$2

bilderAnzahl=10
border=3
rotate=6




containsElement () {
	local e
	for e in “${@:2}”; do [[ “$e” == “$1″ ]] && return 0; done
	return 1
}



numberOfFiles=0
for file in $dir/*.jpg ; do 
	files[$numberOfFiles]=$file
	numberOfFiles=$((numberOfFiles+1))
done


$DEBUG && echo "numberOfFiles: $numberOfFiles"
$DEBUG && echo "bilderAnzahl: $bilderAnzahl"

if test $numberOfFiles -lt $bilderAnzahl; then
  $DEBUG && echo "anpassen"
  bilderAnzahl=$numberOfFiles
fi

$DEBUG && echo "bilderAnzahl: $bilderAnzahl"



while [ ${#zufallsZahlen[@]} -lt $bilderAnzahl ]
do
  random=$((RANDOM%$numberOfFiles)) 
  if [[ " ${zufallsZahlen[@]} " =~ " ${random} " ]]; then
    $DEBUG && echo "$random ist schon vorhanden!!"
  else
      # whatever you want to do when arr doesn't contain value
	  $DEBUG && echo "$random war noch nicht vorhanden => zur Liste hinzugefügt"
	  zufallsZahlen[${#zufallsZahlen[@]}]=$random
  fi
done

$DEBUG && echo "zufallszahlen: ${zufallsZahlen[@]}"

counter=0
diffx=0


for ((i=0; i < ${#zufallsZahlen[@]}; i++))
do
  filex=${files[${zufallsZahlen[$i]}]}
  cmd[$i]="\( $filex -thumbnail 200x300 -bordercolor white -border $border -bordercolor grey60 -border 1 -bordercolor none -background none -rotate $rotate -repage +$diffx+0 \) "
  $DEBUG && echo "$cmd[$i]"
  diffx=$((diffx+50))   
done

#for file in $dir/*.jpg ; do 
#  if [[ " ${zufallsZahlen[@]} " =~ " ${counter} " ]]; then
#	$DEBUG && echo "$file JA"
#  	cmd[$counter]="\( $file -thumbnail 200x300 -bordercolor white -border $border -bordercolor grey60 -border 1 -bordercolor none -background none -rotate $rotate -repage +$diffx+0 \) "
#  	diffx=$((diffx+50)) 
#  else
#    $DEBUG && echo "$counter : Datei $file wird nicht verwendet"	
#  fi
#  counter=$((counter+1))  
#done

cmd2="convert ${cmd[@]} -border 1550x80 -flatten -trim +repage -background transparent \( +clone -shadow 90x4+4+4 \) +swap -background transparent -flatten $outputfile"
$DEBUG && echo ${cmd[@]}
eval $cmd2

