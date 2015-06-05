import java.util.*;


public class LotoGenerator {
	private Integer drawnNumber=null;
	
	// 6/45, 7/39 
	//generate 1 loto game
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
	public int returnHits(ArrayList<Integer> listaOdigrani,ArrayList<Integer> listaIzvuceni)
	{
		int number=0;
		for(int i:listaOdigrani)
		{
			if(listaIzvuceni.contains(i))
			{
				number++;
			}
		}
		return number;
	}
}
