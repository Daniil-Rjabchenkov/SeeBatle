import java.awt.*;

public class Field {
	int leftIndent, topIndent, fieldSize, cellSize;
	boolean isComputerField;
	int[][] cells;
	Ship[] ships;

	Field(int topIndent, int leftIndent, int fieldSize, int cellSize, boolean isComputerField) {
		this.topIndent = topIndent;
		this.leftIndent = leftIndent;
		this.cellSize = cellSize;
		this.fieldSize = fieldSize;
		this.isComputerField = isComputerField;
		cells = new int[fieldSize][fieldSize];
		createShips();

	}

	public void createShips() {
		ships = new Ship[10];

//Однопалубники
		ships[0] = new Ship(1, cells);
		ships[1] = new Ship(1, cells);
		ships[2] = new Ship(1, cells);
		ships[3] = new Ship(1, cells);

//Двухпалубники
		ships[4] = new Ship(2, cells);
		ships[5] = new Ship(2, cells);
		ships[6] = new Ship(2, cells);

//Трёхпалубники
		ships[7] = new Ship(3, cells);
		ships[8] = new Ship(3, cells);

//Четырёхпалубники
		ships[9] = new Ship(4, cells);
	}

	public void paintField(Graphics g) {
		for (int i = 0; i < fieldSize; i++) {
			for (int j = 0; j < fieldSize; j++) {
				if (isComputerField = true) {

					if (cells[i][j] == 1) {
						g.setColor(Color.RED);
						g.fillRect(leftIndent + j * cellSize, topIndent + i * cellSize, cellSize, cellSize);
					}
				}
				if (cells[i][j] == 2) {
					g.setColor(Color.YELLOW);
					g.fillRect(leftIndent + j * cellSize, topIndent + i * cellSize, cellSize, cellSize);
				}
				if (cells[i][j] == 3) {
					g.setColor(Color.MAGENTA);
					g.fillRect(leftIndent + j * cellSize, topIndent + i * cellSize, cellSize, cellSize);

				} 
					 if(cells[i][j] == -2){ g.setColor(Color.BLACK); g.fillOval(leftIndent + j
					 *  cellSize, topIndent + i * cellSize, cellSize, cellSize); }
					 

			}
		}

		for (int i = 0; i < fieldSize + 1; i++) {
			g.setColor(Color.BLACK);
			g.drawLine(leftIndent, topIndent + i * cellSize, leftIndent + fieldSize * cellSize,
					topIndent + i * cellSize);
			g.drawLine(leftIndent + i * cellSize, topIndent, leftIndent + i * cellSize,
					topIndent + fieldSize * cellSize);
		}

	}

	public int shoot(int x, int y) {
		if (cells[y][x] == 1) {
			cells[y][x] = 2;
			searchKilledShip();
			return 1;

		} else if (cells[y][x] == 2 || cells[y][x] == 3 || cells[y][x] == -2) {
			return 1;
		}
	else {
			cells[y][x] = -2;
			return 0;
		}
	}

	public void searchKilledShip() {
		for (int i = 0; i < 10; i++) {
			ships[i].kill(cells);
		}
	}

}