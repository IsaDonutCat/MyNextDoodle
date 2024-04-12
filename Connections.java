import doodlepad.*;
import java.util.ArrayList;

public class Connections 
{
	public static Pad board = new Pad(900,300);
	public static int[][] colors = {{243,230,105},{100,186,78},{111,166,255},{158,90,201}, {223,222,224}};
	public static String[] words = {"a","b","c","d","e","f","g","h","j","k","l","m","n","o","p", "q"};
	public static void main (String[] args)
	{
		//1st row is for yellow, 2nd row is for green, 3rd row is for blue, 
		//4th row is for purple and 5th is for the grey

		//create the positions for 16 words/rectangles
		ArrayList<Integer[]> positions = new ArrayList<Integer[]>();
		int[] xPoses = {35, 245, 455, 665};
		int[] yPoses = {35, 95, 155, 215};
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				Integer[] temp = {xPoses[i], yPoses[j]};
				positions.add(temp);
			}
		}
		
		int ind;
		ArrayList<Word> blockWords = new ArrayList<Word>();
		System.out.println(positions.size() + " " + words.length);
		int size;
		for (int k = 0; k < 16; k++)
		{
			size = positions.size();
			ind =(int) (Math.random()* size);
			blockWords.add(new Word(words[k], k % 4, positions.get(ind)[0], positions.get(ind)[1]));
			positions.remove(ind);
		}
		
		
	}
}

class Word
{
	public String phrase;
	private int diff;
	
	public int[][] colors = {{243,230,105},{100,186,78},{111,166,255},{158,90,201}, {223,222,224}};

	public Word(String inWord, int inDiff, int x, int y)
	{	
		Rectangle background = new Rectangle(x,y, 200, 50);
		background.setFillColor(colors[inDiff][0], colors[inDiff][1], colors[inDiff][2], 50);
		background.setStrokeWidth(0);
		phrase = inWord;
		diff = inDiff;
	}
	
	public int getDiff()
	{
		return diff;
	}
	
	public boolean equals(Word other)
	{
		return other.phrase.equals(phrase);
	}
	
	public String toString()
	{return phrase;}
}
