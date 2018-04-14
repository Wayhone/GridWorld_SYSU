import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class Calculator extends JFrame{
	JPanel panel;
	JTextField result, op, EqualText, a, b;
	JButton add, sub, mul, div, equal;

	public Calculator() {
		setBounds(300, 200, 400, 200);		// Size
		setTitle("XW_Calculator");			// Title

		// expression 
		a = new JTextField(15);
		a.setHorizontalAlignment(JTextField.CENTER);

		op = new JTextField();
		op.setEditable(false);
		op.setHorizontalAlignment(JTextField.CENTER);

		b = new JTextField(15);
		b.setHorizontalAlignment(JTextField.CENTER);

		EqualText = new JTextField();
		EqualText.setEditable(false);
		EqualText.setText("=");
		EqualText.setHorizontalAlignment(JTextField.CENTER);

		result = new JTextField(15);
		result.setHorizontalAlignment(JTextField.CENTER);
		result.setEditable(false);

		// op button
		add = new JButton("+");
		sub = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		equal = new JButton("=");

		// set panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,5));

		panel.add(a);  
        panel.add(op);  
        panel.add(b);  
        panel.add(EqualText);
        panel.add(result);
		panel.add(add);  
        panel.add(sub);  
        panel.add(mul);  
        panel.add(div);
        panel.add(equal);

        add(panel);

        EqualEvent();

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void EqualEvent(){
		SetOp(add);  
        SetOp(sub);  
        SetOp(mul);  
        SetOp(div);

        // ensure read only digit 0 to 9 and '.' 
        a.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                char ch = e.getKeyChar();                 
                if(ch!='.' && (ch<'0'|| ch>'9')) 
                	e.consume();   
            }  
        });   

        b.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                char ch = e.getKeyChar();                 
                if(ch!='.' && (ch<'0'|| ch>'9')) 
                	e.consume();  
            }  
        });  

        // calculate
        equal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg) {
    			String str1 = a.getText().trim();
	        	String str2 = b.getText().trim();
	        	double num1 = Double.parseDouble(str1);
	        	double num2 = Double.parseDouble(str2);

	        	String operator = op.getText();
	        	if (operator.equals("")) return;
	        	
	        	if (operator.equals("/")) 
        		{
        			if (num2 == 0.0) result.setText("NAN");
        				else result.setText(String.valueOf(num1/num2));
        		}
	        	else {
	        		double res = 0.00;
	        		if (operator.equals("+")) res = num1 + num2;
		        		else if (operator.equals("-")) res = num1 - num2;
		        			else if (operator.equals("*")) res = num1 * num2;
	        		result.setText(String.valueOf(res));
	    		}
			}

        });
	}

	public void SetOp(JButton button){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				op.setText(button.getText());
			}
		});		
	}

	public static void main(String[] args) {
		new Calculator();
	}
} 
