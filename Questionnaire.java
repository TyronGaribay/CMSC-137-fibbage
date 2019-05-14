

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Questionnaire extends JPanel implements ActionListener{
	int correctAns;
	Quiz quiz;	
	int selected;
	boolean used;
	//questions
	JPanel qPanel = new JPanel();
	//text field
	JPanel bPanel = new JPanel();
	JLabel aLie = new JLabel("Your Lie:");
	JTextField tBluff = new JTextField(15);
	
	//answers
	JPanel aPanel = new JPanel();
	JRadioButton[] responses;
	ButtonGroup group=new ButtonGroup();
	//bottom
	JPanel botPanel=new JPanel();
	JButton submit=new JButton("Submit");
	JButton next=new JButton("Next");
	JButton finish=new JButton("Finish");
	

	public Questionnaire(String q, Quiz quiz){
		this.quiz=quiz;
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		aLie.setLabelFor(tBluff);
		//question
		qPanel.add(new JLabel(q));
		add(qPanel);
		bPanel.add(aLie);
		bPanel.add(tBluff);

		submit.addActionListener(this);
		bPanel.add(submit);
		add(bPanel);

		
		//answer	

	}

	public void actionPerformed(ActionEvent e){
		Object src=e.getSource();
		//submit button
		if(src.equals(submit)){
		
		 String bluff = tBluff.getText();
			 	quiz.addBluff(tBluff.getText());
				//System.out.println(tBluff.getText());
				//quiz.showChoices();
					
				
		}
	}

}

