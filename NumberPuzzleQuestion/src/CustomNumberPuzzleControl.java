import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		emptyCellId=game.getEmptyCellId();
		//Your logic here
		int upId=emptyCellId-4,downId=emptyCellId+4,rightId=emptyCellId+1,leftId=emptyCellId-1;
		if(upId>=0 && buttonClicked==buttons[upId])
		{ swapButton(buttons[emptyCellId],buttonClicked);
		  emptyCellId=upId;
		}
		else if(downId<=15  && buttonClicked==buttons[downId])
		{ swapButton(buttons[emptyCellId],buttonClicked);
		  emptyCellId=downId;
		}
		else if(leftId>=0 && leftId%4!=3 && buttonClicked==buttons[leftId] )
		{ swapButton(buttons[emptyCellId],buttonClicked);
		  emptyCellId=leftId;
		}
		else if(rightId<=15 && rightId%4!=0 && buttonClicked==buttons[rightId])
		{ swapButton(buttons[emptyCellId],buttonClicked);
		  emptyCellId=rightId;
		}
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		//Your logic here
		for(int i=0;i<15;i++) {
			int k=0;
			int a = getRandomNumber();
			a=a%16;
			if(a==0)
				a++;
			for(int j=0;j<arr.length;j++)
			{	if(a==arr[j])
				{i--;
				k=1; 
				break;}
			}
			if(k==1)
				continue;;
			arr[i]=a;

		}
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		//boolean winner = false;
		
		// Your Logic here
		int arr[]=getIntegerArrayOfButtonIds(buttons);
		for (int i=0;i<arr.length-1;i++) {
	        if (arr[i]>arr[i+1])
	            return false;
	    }
		return true;
	}
}