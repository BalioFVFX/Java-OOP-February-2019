public class Galaxy {
    private int[][] matrix;

    public Galaxy(int rows, int cols){
        this.matrix = new int[rows][cols];
        this.fillMatrix();
    }

    private void fillMatrix(){
        int value = 0;
        for (int row = 0; row < this.matrix.length; row++) {
            for (int col = 0; col < this.matrix[row].length; col++) {
                matrix[row][col] = value++;
            }
        }
    }

    public boolean isValid(int row, int col){
        if(row < 0 || col < 0 || row > this.matrix.length - 1 || col > this.matrix[0].length - 1){
            return false;
        }
        return true;
    }

    public void stepOn(int row, int col){
        this.matrix[row][col] = 0;
    }

    public int getRowLength(){
        return this.matrix.length;
    }

    public int getColLength(){
        return this.matrix[0].length;
    }

    public int getPointsAt(int row, int col){
        return this.matrix[row][col];
    }
}
