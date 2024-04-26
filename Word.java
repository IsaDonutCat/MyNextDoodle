import doodlepad.*;

public class Word
{
	int id, diff, xPos, yPos;
	String phrase;
	Rectangle block;
	Text display;
	boolean selected = false;
	
	public Word(String phrase, int diff, int xPos, int yPos, int id)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.diff = diff;
		this.id = id;
		this.phrase = phrase;
		
		block = new Rectangle(xPos, yPos, 400, 190);
		block.setFillColor(Main.colors[4][0]);
		block.setMousePressedHandler(this::onPressed);
		
		display = new Text(phrase, xPos+20, yPos+20, 15);
		display.setMousePressedHandler(this::onPressed);
		
		System.out.println(id + " built at" + xPos + " and" + yPos);
	}
	
    public void onPressed(Shape shp, double x, double y, int button) {
        if (selected) 
        {
            block.setFillColor(Main.colors[4][0]);
            for (int d = 0; d < 4; d++)
            {
				if (Main.selected.get(d).equals(this))
				{
					Main.selected.remove(d);
					break;
				}
            }
            selected = false;
        } 
        else if (Main.selected.size() < 4)
        {
			Main.selected.add(this);
			block.setFillColor(Main.colors[5][0]);
			selected = true;
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
