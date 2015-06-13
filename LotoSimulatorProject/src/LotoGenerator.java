import java.util.*;


public class LotoGenerator {
	private Integer drawnNumber=null;
	
	// example loto game 6/45 , 7/39 (numberOfDraws=6, LotoTypeNumber=45)
	public ArrayList<Integer> generateLotoList(int numberOfDraws,int LotoTypeNumber) 
	{
		ArrayList<Integer> lotoList=new ArrayList<Integer>();
		int i=1;
		do{
			drawnNumber=generateNumber(1,LotoTypeNumber);
			if(lotoList.contains(drawnNumber)==false)
			{
				lotoList.add(drawnNumber);
				i++;
			}
		}
		while(i<=numberOfDraws);
		return lotoList;
	}
	
	//random number generator
	private int generateNumber(int low,int high)
	{
		Random r = new Random();
		int R = r.nextInt(high+1-low) + low;
		return R;
	}
	
	//compare 2 integer lists, how many same elements
	public int returnHits(ArrayList<Integer> listOfPlayedNumbers,ArrayList<Integer> listOfDrawnNumbers)
	{
		int number=0;
		for(int i:listOfPlayedNumbers)
		{
			if(listOfDrawnNumbers.contains(i))
			{
				number++;
			}
		}
		return number;
	}
}
