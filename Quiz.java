//package JavaSwingQuiz;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class Quiz extends JFrame{
	JPanel p=new JPanel();
	CardLayout cards=new CardLayout();

	//answers
	//JPanel aPanel = new JPanel();
	int numQs;
	int wrongs=0;
	int total=0;
	
	String[][] answers={
		{"Cube","Sphere","Liquified","Diamond"},
		{"Bling","Backrub","Look Up","Genius"},
		{"Rebels","Monkeys","Cats","Yakuzas"},
		{"Sammy","Ham","Mr. Pickles","Tarzan"},
		{"Scurry","Sleuth","Prickle","Pack"},
		{"Dentist","Killer","Inventor","Handyman"},
		{"Football","Chess","Swimming","Poker"},
		{"Teacher","Plumber","Bouncer","Store Clerk"},
		{"Michael","Andrew","Jackson","Jordan"},
		{"Sodas","Babies","Meat","Names"},
		{"Oranges","Bread","Guitars","Insults"},
		{"The moon","College","The electric chair","Hollywood"},
		{"Birds","Cows","Elderly people","The US President"},
		{"Place","Pets","Vacancy","to Drugs"},
		{"Hot Coal","Jesus Christ","A couch","Babies"},
		{"Anthony Starks","Tony Starks","Tony Stark","Tony Stark Jr."},
		{"I'm pregnant","Bad Hair Day","Justice","Stupidity"},
	};
		
	RadioQuestion questions[]={
		
		new RadioQuestion(
			"The shape of wombat poop.",
			answers[0],
			0,this
		),
		new RadioQuestion(
			"The original name for the search engine that became Google.",
			answers[1],
			1,this
		),
		new RadioQuestion(
			"Tashirojima is an island off of Japan that is complete overrun by _____.",
			answers[2],
			2,this
		),
		new RadioQuestion(
			"The name of the first chimp sent into space.",
			answers[3],
			1,this
		),
		new RadioQuestion(
			"The name for a group of porcupines.",
			answers[4],
			2,this
		),
		new RadioQuestion(
			"The electric chair was invented by a professional _____ named Alfred Southwick.",
			answers[5],
			0,this
		),
		new RadioQuestion(
			"Leo Granit Kraft is a world champion in an unusual sport that combines boxing and _____.",
			answers[6],
			1,this
		),
		new RadioQuestion(
			"As a young student in Buenos Aires, Pope Francis worked as a _____.",
			answers[7],
			2,this
		),
		new RadioQuestion(
			"Michael J. Fox's middle name.",
			answers[8],
			1,this
		),
		new RadioQuestion(
			"A study published in the journal Anthrozoo reported that cows produce 5% more milk when they are given _____.",
			answers[9],
			3,this
		),
		new RadioQuestion(
			"Every year residents in Ivrea, Italy reenact a historicalbattle of their region, and instead of replica weapons, they use _____.",
			answers[10],
			0,this
		),
		new RadioQuestion(
			"	In school, Syvester Stallone was voted by his teachers as Most Likely to Go To ______.",
			answers[11],
			2,this
		),
		new RadioQuestion(
			"Advanced Comfort Technology makes waterbeds for _____.",
			answers[12],
			1,this
		),
		new RadioQuestion(
			"Located near the town of Stanley, there's a small village in England called No _____.",
			answers[13],
			0,this
		),
		new RadioQuestion(
			"El Colacho is a Spanish festival where people dress up like the devil and jump over _____.",
			answers[14],
			3,this
		),
		new RadioQuestion(
			"What is Iron Man's real name?",
			answers[15],
			2,this
		)
		,
		new RadioQuestion(
			"~~8-0 is the obscure emoticon that stands for _____.",
			answers[16],
			1,this
		)
	};

	public static void main(String args[]){
		new Quiz();
	}
	
	public Quiz(){
		super("Fibbage137");
		setResizable(true);
		setSize(650,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p.setLayout(cards);		

		/*JLabel aLie = new JLabel("Your Lie:");
		JTextField tBluff = new JTextField(15);
		aLie.setLabelFor(tBluff);
		//question
	*/	
		numQs=questions.length;
		for(int i=0;i<numQs;i++){
			p.add(questions[i],"q"+i);	
		
		}
		Random r=new Random();
		int i=r.nextInt(numQs);
		cards.show(p,"q"+i);
		add(p);
		setVisible(true);
	}
	public void askInput(){
		
		
	} 
	
	public void next(){
		if((total+wrongs)==numQs){
			showSummary();
		}else{
			Random r=new Random();
			boolean found=false;
			int i=0;
			while(!found){
				i=r.nextInt(numQs);
				if(!questions[i].used){
					found=true;
				}
			}
			cards.show(p,"q"+i);
		}
	}
	
	/*public void addBluff(String b){
		System.out.println(b);
		//return null;
		
	}*/	
	
	public void showSummary(){
		JOptionPane.showMessageDialog(null,"That's it! Here is your summary:"+
			
			"\ntotal: \t\t"+(int)((total)*1000)+"Points"
		);
		System.exit(0);
	}
}
