import doodlepad.*;
import java.util.ArrayList;

public class submitButton
{
	private static RoundRect submit;
	private static Text submitText;
	public submitButton()
	{
		/*submit = new RoundRect(1220, 780, 120, 150, 60, 60);
		submitText = new Text("Submit", 1230, 7800);
		submit.setMousePressedHandler(this::onPressed );
		submitText.setMousePressedHandler(this::onPressed );8*/
	}
	
	public void onPressed(Shape shp, double x, double y, int button)
	{
		ArrayList<Word> hold = Main.selected;
		
		if (hold.size()==4)
		{
			if (hold.get(0).sameDiff(hold.get(1)) && hold.get(0).sameDiff(hold.get(2)) && hold.get(0).sameDiff(hold.get(3)))
			{
				Main.displayText("Correct");
			}
		}
	}
}
