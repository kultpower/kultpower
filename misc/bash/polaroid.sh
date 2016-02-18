
border=4
dir=$1
echo $dir
IMG1="$(ls $dir/*.jpg | sed -n ""$((RANDOM%$(ls $dir/*.jpg | wc -l)+1))p"")"
IMG2="$(ls $dir/*.jpg | sed -n ""$((RANDOM%$(ls $dir/*.jpg | wc -l)+1))p"")"
IMG3="$(ls $dir/*.jpg | sed -n ""$((RANDOM%$(ls $dir/*.jpg | wc -l)+1))p"")"
IMG4="$(ls $dir/*.jpg | sed -n ""$((RANDOM%$(ls $dir/*.jpg | wc -l)+1))p"")"
IMG5="$(ls $dir/*.jpg | sed -n ""$((RANDOM%$(ls $dir/*.jpg | wc -l)+1))p"")"
IMG6="$(ls $dir/*.jpg | sed -n ""$((RANDOM%$(ls $dir/*.jpg | wc -l)+1))p"")"
IMG7="$(ls $dir/*.jpg | sed -n ""$((RANDOM%$(ls $dir/*.jpg | wc -l)+1))p"")"
IMG8="$(ls $dir/*.jpg | sed -n ""$((RANDOM%$(ls $dir/*.jpg | wc -l)+1))p"")"
IMG9="$(ls $dir/*.jpg | sed -n ""$((RANDOM%$(ls $dir/*.jpg | wc -l)+1))p"")"
IMG10="$(ls $dir/*.jpg | sed -n ""$((RANDOM%$(ls $dir/*.jpg | wc -l)+1))p"")"


convert \
     \( $IMG1 -thumbnail 300x200 -bordercolor white -border $border \
    -bordercolor grey60 -border 1 -bordercolor none \
    -background none -rotate 6 -repage -0+0 \
	 \) \
    \
    \( $IMG2 -thumbnail 300x200 -bordercolor white -border $border \
       -bordercolor grey60 -border 1 -bordercolor none \
       -background none -rotate 6 -repage +50+0 \
    \) \
    \
    \( $IMG3 -thumbnail 300x200 -bordercolor white -border $border \
       -bordercolor grey60 -border 1 -bordercolor none \
       -background none -rotate 6 -repage +100+1 \
    \) \
    \
    \( $IMG4 -thumbnail 300x200 -bordercolor white -border $border \
      -bordercolor grey60 -border 1 -bordercolor none \
      -background none -rotate 6 -repage +150+1 \
    \) \
    \
    \( $IMG5 -thumbnail 300x200 -bordercolor white -border $border \
      -bordercolor grey60 -border 1 -bordercolor none \
      -background none -rotate 6 -repage +200+1 \
    \) \
    \
    \( $IMG6 -thumbnail 300x200 -bordercolor white -border $border \
      -bordercolor grey60 -border 1 -bordercolor none \
      -background none -rotate 6 -repage +250+1 \
    \) \
    \
    \( $IMG7 -thumbnail 300x200 -bordercolor white -border $border \
      -bordercolor grey60 -border 1 -bordercolor none \
      -background none -rotate 6 -repage +300+1 \
    \) \
    \
    \( $IMG8 -thumbnail 300x200 -bordercolor white -border $border \
      -bordercolor grey60 -border 1 -bordercolor none \
      -background none -rotate 6 -repage +350+1 \
    \) \
    \
    \( $IMG9 -thumbnail 300x200 -bordercolor white -border $border \
      -bordercolor grey60 -border 1 -bordercolor none \
      -background none -rotate 6 -repage +400+1 \
    \) \
    \( $IMG10 -thumbnail 300x200 -bordercolor white -border $border \
      -bordercolor grey60 -border 1 -bordercolor none \
      -background none -rotate 6 -repage +450+1 \
    \) \
      -border 1550x80 -flatten -trim +repage -background transparent \
    \( +clone -shadow 90x4+4+4 \) +swap -background transparent -flatten \
	./$2

