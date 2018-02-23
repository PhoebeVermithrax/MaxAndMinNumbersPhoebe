/*
 * Created by: Phoebe Vermithrax
 * Created on: 21-Feb-2018
 * Created for: ICS4U
 * Daily Assignment – Day #11
 * This program generates random numbers within the list box, and tells the user what is the min and max value is.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;

import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MaxAndMinNumbers {

	public int GetMinValue(int[] tmpArrayOfIntegers)
	{
		//State the variables.		
		int minValue = 99; // The minimum of 99.
		int index = 0;
		
		//Loop through the numbers of the array, so long as they are less than the array length.
		for (index = 0; index < tmpArrayOfIntegers.length; index++)
		{
			//If the index is less than the minValue, 
			if (tmpArrayOfIntegers[index] < minValue)
			{
				//Assign the index of the array to the maxValue.
				minValue = tmpArrayOfIntegers[index];
			}
		}
		
		//Return the minValue.
		return minValue;
	}
	
	public int GetMaxValue(int[] tmpArrayOfIntegers)
	{
		//State the variables.
		int maxValue = -1; //Has to be lower than 0, as if all the random numbers are 0, then the max would be 0.
		int index;
		
		//Loop through the numbers of the array, so long as they are less than the array length.
		for (index = 0; index < tmpArrayOfIntegers.length; index++)
		{
			//If the index is greater than the maxValue, 
			if (tmpArrayOfIntegers[index] > maxValue)
			{
				//Assign the index of the array to the maxValue.
				maxValue = tmpArrayOfIntegers[index];
			}
		}
		
		//return the maxValue.
		return maxValue;
	}
	
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MaxAndMinNumbers window = new MaxAndMinNumbers();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Max And Min Numbers");
		
		List lstNumbers = new List(shell, SWT.BORDER);
		lstNumbers.setBounds(232, 23, 161, 205);
		
		Label lblMinIntro = new Label(shell, SWT.NONE);
		lblMinIntro.setBounds(22, 174, 40, 15);
		lblMinIntro.setText("Min: ");
		
		Label lblMinAns = new Label(shell, SWT.NONE);
		lblMinAns.setBounds(68, 174, 55, 15);
		lblMinAns.setText("New Label");
		//Make invisible.
		lblMinAns.setVisible(false);
		
		Label lblMaxIntro = new Label(shell, SWT.NONE);
		lblMaxIntro.setBounds(22, 195, 40, 15);
		lblMaxIntro.setText("Max:");
		
		Label lblMaxAns = new Label(shell, SWT.NONE);
		lblMaxAns.setBounds(68, 195, 55, 15);
		lblMaxAns.setText("New Label");
		//Make invisible.
		lblMaxAns.setVisible(false);
		
		Button btnGenNum = new Button(shell, SWT.NONE);
		btnGenNum.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//State the local variables.
				final int MAX_ARRAY_SIZE = 10; // the array is supposed to have 10 spaces.
				final int MAX_RANDOM_NUMBER = 99; //The maximum number that is generated.
				int counter, randomNumber, maxValue, minValue;
				
				//create an array with the array size.
				int[] arrayOfIntegers = new int[MAX_ARRAY_SIZE];
				
				//Generate random numbers.
				Random randomNumberGenerator = new Random();
				
				//Clear the listbox.
				lstNumbers.removeAll();
				 
				//Initialize the counter, and loop through the numbers in the array until it is less than the maximum.
				for (counter = 0; counter < MAX_ARRAY_SIZE; counter++)
				{
					//Generate a random number.
					//randomNumber = ((int) (Math.random()*MAX_RANDOM_NUMBER)+1);
					randomNumber = randomNumberGenerator.nextInt(MAX_RANDOM_NUMBER + 1);
					
					//Assign the random number to the counter position in the array.
					arrayOfIntegers[counter] = randomNumber;
					
					//Add the numbers to the listbox.
					lstNumbers.add("" + randomNumber);
						
				}
				
				//Get the max value of the array by calling the procedure, GetMaxValue.
				maxValue = GetMaxValue(arrayOfIntegers);
				
				//Get the min Value of the array by calling the procedure, GetMinValue.
				minValue = GetMinValue(arrayOfIntegers);
				
				//Display the maxValue to the label.
				lblMaxAns.setVisible(true);
				lblMaxAns.setText("" + maxValue);
				
				//Display the minValue to the label.
				lblMinAns.setVisible(true);
				lblMinAns.setText("" + minValue);
			}
		});
		btnGenNum.setBounds(22, 23, 113, 80);
		btnGenNum.setText("Generate Numbers");

	}
}
