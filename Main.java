import doodlepad.*;
import java.util.ArrayList;

public class Main {
	
	static Pad board = new Pad(1920, 1080);
	
	//references
	static String[] words = {"a","b","c","d",  "e","f","g","h",  "j","k","l","m",  "n","o","p", "q"}; 
	static int[] xPos = {130, 550, 970, 1390}; //outside margins 130, between gaps 20, block width 400
	static int[] yPos = {0, 210, 420, 630}; //outside margines 130, between gaps, 20, block height 190
	public static int[][] colors = {{243,230,105},{100,186,78},{111,166,255},{158,90,201}, {223,223,223}, {190,190,190}};
	static int guessed = 0;
	static int tries = 4;
	
	//submit button
	submitButton submit = new submitButton();
	
	//choices just to keep track of 
	static ArrayList<Word> choices = new ArrayList<Word>();
	static ArrayList<Word> selected = new ArrayList<Word>();
	
	public static void main (String[] args)
	{
		createList();
	}
	
	public static void createList()
	{
		ArrayList<Integer[]> xYPos = new ArrayList<Integer[]>();
		for (int a = 0; a < 4; a++)
		{
			for (int b = guessed; b < 4; b++)
			{
				Integer[] temp = new Integer[2];
				temp[0] = xPos[a];
				System.out.println(temp[0]);
				temp[1] = yPos[b];
				xYPos.add(temp);
				System.out.println(temp[1]);
			}
		}
		
		for (int c = 0; c < 16; c++)
		{
			int ranInd  = (int) (Math.random() * xYPos.size());
			choices.add(new Word(words[c], c/4, xYPos.get(ranInd)[0], xYPos.get(ranInd)[1], c));
			xYPos.remove(ranInd);
		}
	}
	
	public static void displayText(String phrase)
	{
		/*int tempInd = board.addLayer(); 
		Rectangle bg = new Rectangle(900, 60, 120, 60, board.getLayer(tempInd));
		bg.setFillColor(colors[4][0]);
		Text message = new Text(phrase, 900, 60, board.getLayer(tempInd));
		try{
			Thread.sleep(5000);}
		catch (Exception e){
			e.printStackTrace();}
		board.removeLayer(tempInd);*/
	}
}
