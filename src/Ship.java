import java.util.*;

public class Ship {

Random rn;
int dirX, dirY, x, y;
int len;
public Ship( int len, int[][] cells) {
rn = new Random();
 x = rn.nextInt(10);
 y = rn.nextInt(10);
 this.len = len;
 
chooseDirection();
boolean canSetChip = false;

while (!canSetChip){
x = rn.nextInt(10);
y = rn.nextInt(10);
chooseDirection();
canSetChip = true;
for(int i = 0;i < len; i++){
if(isOutOfBounds(x, y) || !canSurroundWithBomb(x, y, cells)){
canSetChip = false;
}
x += dirX;
y += dirY;
}
}

for(int i = 0; i < len; i++){
x -= dirX;
y -= dirY;
cells[y][x] = 1;
surroundWithBombs(x, y, cells);
}

}

public void chooseDirection(){
int dir = rn.nextInt(4);

switch (dir){
case 0:
dirX = -1;
dirY = 0;
break;

case 1:
dirX = 0;
dirY = -1;
break;

case 3:
dirX = 1;
dirY = 0;

case 4:
dirX = 0;
dirY = 1;

default:
break;

}

}

public boolean isOutOfBounds(int x, int y){
if(x < 0 || x > 9 || y < 0 || y > 9){
return true;
}else{
return false;
}

}

public boolean canSurroundWithBomb(int x, int y, int[][] cells){
boolean canSurroundWithBomb = true;
for(int i = -1; i <= 1; i++){
for(int j = -1; j <= 1; j ++){
if(!isOutOfBounds(x + j, y + i)){
if (cells[y + i][x + j] == 1) {
canSurroundWithBomb = false;
}
}
}
}
return canSurroundWithBomb;
}

public void surroundWithBombs(int x, int y, int[][] cells){
for(int i = -1; i <= 1; i++){
for(int j = -1; j <= 1; j ++){
if(!isOutOfBounds(x + j, y + i)){
if (cells[y + i][x + j] != 1) {
cells[y + i][x + j] = -1;
}
}
}
}
}
public boolean isKilled(int[][] cells) {
	int k = 0;
	int x = this.x;
	int y = this.y;
	for(int i = 0; i < len; i++) {
		if(cells[y][x] == 2) {
			k++;
		}
		y += dirY;
		x += dirX;
	}
	return k == len;
}
public void kill(int[][] cells) {
	int x = this.x;
	int y = this.y;
	if(isKilled(cells)) {
		for(int i = 0; i < len; i++) {
			cells[y][x] = 3;
			y += dirY;
			x += dirX;
		}
	}
	
	
	
}





}