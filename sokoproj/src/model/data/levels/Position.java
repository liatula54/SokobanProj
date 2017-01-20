package model.data.levels;

import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable ,Comparable<Position>{

	private static final long serialVersionUID = 1L;
	private int col;
	private int row;
	private int dim;
	
	//default c'tor
	public Position (){
	}
	
	// c'tor
	 public Position (int col, int row, int dim)
	{
		this.col = col;
		this.row = row;
		this.dim = dim;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int x) {
		this.col = x;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int y) {
		this.row = y;
	}
	
	public int getDim() {
		return dim;
	}
	
	public void setDim(int z) {
		this.dim = z;
	}
		
	@Override
	public boolean equals(Object obj) {
		Position pos=(Position)obj; 
		if(col==pos.getCol() && row==pos.getRow()&&dim==pos.getDim())
			return true;
		
		return false;
	}
	
	@Override
		public int hashCode() {
			return Objects.hash(col, row, dim);
		}
	
	
	@Override
	public int compareTo(Position o) {
		if(col == o.getCol())
		{
			if(row == o.getRow())
			{
				return 0;
			}
			else if(row < o.getRow())
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
		else if(col < o.getCol())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}


	
	
	
	
}






