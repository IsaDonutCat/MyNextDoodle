import org.w3c.dom.Text;

import doodlepad.*;

public class Word
{
	int id, diff, xPos, yPos;
	String phrase;
	RoundRect block;
	Text display;
	boolean selectThis = false;
	public int[][] colors = {{243,230,105},{100,186,78},{111,166,255},{158,90,201}, {223,223,223}, {190,190,190}};

	
	public Word(String inphrase, int indiff, int inxPos, int inyPos, int inid)
	{
		this.xPos = inxPos;
		this.yPos = inyPos;
		this.diff = indiff;
		this.id = inid;
		this.phrase = inphrase;
		
		block = new RoundRect(inxPos, inyPos, 400, 190, 15, 15);
		block.setFillColor(Main.colors[4][0]);
		block.setStrokeWidth(0);
		System.out.println("created blcok " + id);
		block.setMousePressedHandler(this::onPressed);
		
		display = new Text(phrase, xPos+20, yPos+20, 15);
		display.setMousePressedHandler(this::onPressed);
		
		System.out.println(id + " built at" + inxPos + " and" + inyPos);
	}
	
    public void onPressed(Shape shp, double x, double y, int button) {
        if (selectThis) 
        {
            block.setFillColor(Main.colors[4][0]);
            for (int d = 0; d < 4; d++)
            {
				if (Main.selected.get(d).equals(this))
				{
					Main.selected.remove(d);			
					System.out.println(this.id + "deselected");

					break;
				}
            }
            selectThis = false;
        } 
        else if (Main.selected.size() < 4) 
        {
			Main.selected.add(this);
			block.setFillColor(Main.colors[5][0]);
			selectThis = true;
			System.out.println(this.id + "selected");
		}
	}
	public int getDiff()
	{
		return diff;
	}
	
	public boolean sameDiff(Word other)
	{
		return this.diff == other.getDiff();
	}
	
	public int getId()
	{
		return id;
	}
	
	public boolean equals(Word other)
	{
		return other.getId() == this.id;
	}
}
