import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.DecimalFormat;


public class AppFrame extends JFrame implements ActionListener{

    private int windowWidth =295;   // stores the windows width
    private int windowHeight = 450; // store the window height

    Font myFont = new Font("Apple Casual", Font.PLAIN,15); // creates a font variable that can be added to the texts
    Font textFieldFont = new Font("Apple Casual", Font.PLAIN,30); // creates a font variable that can be added to the texts
    Font equationLabelFont = new Font("Apple Casual", Font.PLAIN,13); // creates a font variable that can be added to the texts


    // Buttons
    JButton[] numberButtons = new JButton[10];  // outputs a number to the textfield

    JButton addButton = new JButton();          // button to add
    JButton subtractButton = new JButton();     // button to subtract
    JButton multiplyButton = new JButton();     // button to multiply
    JButton divideButton = new JButton();       // button to divide

    JButton decimalButton = new JButton();      // outputs a decimal to the textfield
    JButton equalsButton = new JButton();       // outputs the result
    JButton negativeButton = new JButton();     // makes the number negative

    JButton deleteButton = new JButton();       // deletes the last number entered
    JButton clearButton = new JButton();        // clears the calculator

    JTextField textField = new JTextField();    // main text field

    JLabel equationLabel = new JLabel();

    double num1=0, num2=0, result=0;            // variables to store the operands and the result
    char operator;                              // Store the operator to decide to operation later


    AppFrame(){
        this.setTitle("Calculator");                        // Sets the title of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // Exits when hitting the X
        this.setResizable(false);                       // Prevent or allow resizability
        this.setSize(windowWidth, windowHeight);                  // Set the size of the frame
        this.setLocationRelativeTo(null);                       // Spawns the window in the center of the screen

        ImageIcon image = new ImageIcon(getClass().getResource("/calculatorImage.png"));   // Create an image icon; use either file path or name
        this.setIconImage(image.getImage());                                                    // Changes the icon of the frame to ^

        this.getContentPane().setBackground(Color.BLACK); // Changes the background color of the frame

        // Buttons
        for(int i = 0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));    // creates the number button with the text of its number
            numberButtons[i].addActionListener(this);             // adds an action listener component to add interactability to the button
            numberButtons[i].setFocusable(false);       // removes the box that shows around the button when clicked
            numberButtons[i].setFont(myFont);                     // apply the font
            numberButtons[i].setForeground(Color.WHITE);          // apply font color
            numberButtons[i].setBackground(Color.GRAY);           // apply button color
        }

        numberButtons[1].setBounds(25,100,50,50);   // Sets the position and size
        numberButtons[2].setBounds(85,100,50,50);   // Sets the position and size
        numberButtons[3].setBounds(145,100,50,50);  // Sets the position and size

        addButton.setBounds(205,100,50,50); // Sets the position and size
        addButton.setText("+");                         // set the text of the button
        addButton.addActionListener(this);                   // adds an action listener component to add interactability to the button
        addButton.setFocusable(false);             // removes the box that shows around the button when clicked
        addButton.setFont(myFont);                           // apply the font
        addButton.setForeground(Color.WHITE);                   // apply font color
        addButton.setBackground(new Color(255,165,0));    // apply button color

        numberButtons[4].setBounds(25,160,50,50);   // Sets the position and size
        numberButtons[5].setBounds(85,160,50,50);   // Sets the position and size
        numberButtons[6].setBounds(145,160,50,50);  // Sets the position and size

        subtractButton.setBounds(205,160,50,50);    // Sets the position and size
        subtractButton.setText("-");                            // set the text of the button
        subtractButton.addActionListener(this);                      // adds an action listener component to add interactability to the button
        subtractButton.setFocusable(false);                // removes the box that shows around the button when clicked
        subtractButton.setFont(myFont);                              // apply the font
        subtractButton.setForeground(Color.WHITE);                   // apply font color
        subtractButton.setBackground(new Color(255,165,0));    // apply button color

        numberButtons[7].setBounds(25,220,50,50);   // Sets the position and size
        numberButtons[8].setBounds(85,220,50,50);   // Sets the position and size
        numberButtons[9].setBounds(145,220,50,50);  // Sets the position and size

        multiplyButton.setBounds(205,220,50,50);    // Sets the position and size
        multiplyButton.setText("*");                            // set the text of the button
        multiplyButton.addActionListener(this);                      // adds an action listener component to add interactability to the button
        multiplyButton.setFocusable(false);                // removes the box that shows around the button when clicked
        multiplyButton.setFont(myFont);                              // apply the font
        multiplyButton.setForeground(Color.WHITE);                   // apply font color
        multiplyButton.setBackground(new Color(255,165,0));    // apply button color

        decimalButton.setBounds(25,280,50,50);  // Sets the position and size
        decimalButton.setText(".");                         // set the text of the button
        decimalButton.addActionListener(this);                   // adds an action listener component to add interactability to the button
        decimalButton.setFocusable(false);             // removes the box that shows around the button when clicked
        decimalButton.setFont(myFont);                           // apply the font
        decimalButton.setForeground(Color.WHITE);                // apply font color
        decimalButton.setBackground(Color.GRAY);                 // apply button color

        numberButtons[0].setBounds(85,280,50,50);   // Sets the position and size

        equalsButton.setBounds(145,280,50,50);      // Sets the position and size
        equalsButton.setText("=");                              // set the text of the button
        equalsButton.addActionListener(this);                        // adds an action listener component to add interactability to the button
        equalsButton.setFocusable(false);                  // removes the box that shows around the button when clicked
        equalsButton.setFont(myFont);                                // apply the font
        equalsButton.setForeground(Color.WHITE);                 // apply font color
        equalsButton.setBackground(Color.GRAY);                  // apply button color

        divideButton.setBounds(205,280,50,50);  // Sets the position and size
        divideButton.setText("/");                          // set the text of the button
        divideButton.addActionListener(this);                    // adds an action listener component to add interactability to the button
        divideButton.setFocusable(false);              // removes the box that shows around the button when clicked
        divideButton.setFont(myFont);                            // apply the font
        divideButton.setForeground(Color.WHITE);                   // apply font color
        divideButton.setBackground(new Color(255,165,0));    // apply button color

        deleteButton.setBounds(25,340,110,50);  // Sets the position and size
        deleteButton.setText("DELETE");                     // set the text of the button
        deleteButton.addActionListener(this);                    // adds an action listener component to add interactability to the button
        deleteButton.setFocusable(false);              // removes the box that shows around the button when clicked
        deleteButton.setFont(myFont);                            // apply the font
        deleteButton.setForeground(Color.WHITE);                 // apply font color
        deleteButton.setBackground(Color.LIGHT_GRAY);            // apply button color

        clearButton.setBounds(145,340,50,50);   // Sets the position and size
        clearButton.setText("C");                           // set the text of the button
        clearButton.addActionListener(this);                     // adds an action listener component to add interactability to the button
        clearButton.setFocusable(false);               // removes the box that shows around the button when clicked
        clearButton.setFont(myFont);                             // apply the font
        clearButton.setForeground(Color.WHITE);                 // apply font color
        clearButton.setBackground(Color.LIGHT_GRAY);            // apply button color


        negativeButton.setBounds(205,340,50,50);    // Sets the position and size
        negativeButton.setText("(-)");                          // set the text of the button
        negativeButton.addActionListener(this);                      // adds an action listener component to add interactability to the button
        negativeButton.setFocusable(false);                // removes the box that shows around the button when clicked
        negativeButton.setFont(myFont);                              // apply the font
        negativeButton.setForeground(Color.WHITE);                 // apply font color
        negativeButton.setBackground(Color.LIGHT_GRAY);            // apply button color
        
        // TextField
        textField.setBounds(25,25,230,50);     // Sets the position and size
        textField.setEditable(false);                         // Stops you from being able type text into the textfield
        textField.setFont(textFieldFont);                       // apply the font
        textField.setHorizontalAlignment(SwingConstants.RIGHT); // Right align the text in the textfield
        textField.setText("0");                               // clear textField
        textField.setForeground(Color.WHITE);                 // apply font color
        textField.setBackground(Color.BLACK);            // apply button color
        textField.setBorder(null);                // removes the border

        // Equation Label
        equationLabel.setFont(equationLabelFont);
        equationLabel.setBounds(25,5, 230, 15);
        equationLabel.setText("");
        equationLabel.setForeground(Color.GRAY);
        equationLabel.setHorizontalAlignment(SwingConstants.RIGHT); // Right align the text in the label




        // Frame
        this.add(equationLabel);    // add to the frame
        this.add(textField);        // add to the frame

        this.add(numberButtons[0]); // add to the frame
        this.add(numberButtons[1]); // add to the frame
        this.add(numberButtons[2]); // add to the frame
        this.add(numberButtons[3]); // add to the frame
        this.add(numberButtons[4]); // add to the frame
        this.add(numberButtons[5]); // add to the frame
        this.add(numberButtons[6]); // add to the frame
        this.add(numberButtons[7]); // add to the frame
        this.add(numberButtons[8]); // add to the frame
        this.add(numberButtons[9]); // add to the frame

        this.add(addButton);        // add to the frame
        this.add(subtractButton);   // add to the frame
        this.add(multiplyButton);   // add to the frame
        this.add(divideButton);     // add to the frame

        this.add(negativeButton);   // add to the frame
        this.add(decimalButton);    // add to the frame
        this.add(clearButton);      // add to the frame

        this.add(deleteButton);     // add to the frame
        this.add(equalsButton);     // add to the frame

        this.setLayout(null);     // Sets the layout style of the frame
        this.setVisible(true);          // Set the visibility of the frame
    }

    String equationLabelStoredString = "";  // A string that temporarily store the value of the equationLabel after an operation is pressed

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                if(textField.getText().equals("0")){
                    textField.setText("");
                }
                textField.setText(textField.getText().concat(String.valueOf(i))); // Concats whatever number button is clicked to the textField
                equationLabel.setText(equationLabelStoredString+textField.getText());
            }
        }
        if(e.getSource() == decimalButton){
            textField.setText(textField.getText().concat(".")); // Concats a decimal
            equationLabel.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText()); // Takes the text in the textField and stores in num1 as a double
            operator = '+';                                 // set the operator
            textField.setText("0");                       // clear textField
            equationLabel.setText(equationLabel.getText().concat("+"));
            equationLabelStoredString = equationLabel.getText();
        }
        if(e.getSource() == subtractButton){
            num1 = Double.parseDouble(textField.getText()); // Takes the text in the textField and stores in num1 as a double
            operator = '-';                                 // set the operator
            textField.setText("0");                       // clear textField
            equationLabel.setText(equationLabel.getText().concat("-"));
            equationLabelStoredString = equationLabel.getText();
        }
        if(e.getSource() == multiplyButton){
            num1 = Double.parseDouble(textField.getText()); // Takes the text in the textField and stores in num1 as a double
            operator = '*';                                 // set the operator
            textField.setText("0");                       // clear textField
            equationLabel.setText(equationLabel.getText().concat("*"));
            equationLabelStoredString = equationLabel.getText();
        }
        if(e.getSource() == divideButton){
            num1 = Double.parseDouble(textField.getText()); // Takes the text in the textField and stores in num1 as a double
            operator = '/';                                 // set the operator
            textField.setText("0");                       // clear textField
            equationLabel.setText(equationLabel.getText().concat("/"));
            equationLabelStoredString = equationLabel.getText();
        }
        if(e.getSource() == equalsButton){
            num2 = Double.parseDouble(textField.getText()); // Takes the text in the textField and stores in num2 as a double

            switch(operator){
                case '+':
                    result = num1+num2; // Outputs the result
                    break;              // Breaks from switch
                case '-':
                    result = num1-num2; // Outputs the result
                    break;              // Breaks from switch
                case '*':
                    result = num1*num2; // Outputs the result
                    break;              // Breaks from switch
                case '/':
                    result = num1/num2; // Outputs the result
                    break;              // Breaks from switch
            }

            String resultString;
            resultString = formatNumberConvertToString(result);
            textField.setText(resultString);  // Sets textField to the value of result as a string
            num1 = result;                    // Sets the num1 equal to result to enable further calculations using the result
        }
        if(e.getSource() == clearButton){
            num1 = 0;                // clear num1
            num2 = 0;                // clear num2
            result = 0;              // clear result
            textField.setText("0");         // clear textField
            equationLabelStoredString = "";   // clear the stored equation label string
            equationLabel.setText("");   // clear the equation label
        }
        if(e.getSource() == deleteButton){
            String string = textField.getText();                            // store the textField text into string
            if(string.length() > 1){
                textField.setText("");                                        // clear textField
            }
            else{
                textField.setText("0");                                        // clear textField
            }
            for(int i = 0; i<string.length() - 1; i++){
                textField.setText(textField.getText()+string.charAt(i));    // iterate through the textfield to remove the last char
            }
            for(int i = 0; i<string.length() - 1; i++){
                equationLabel.setText(equationLabel.getText()+string.charAt(i));    // iterate through the textfield to remove the last char
            }
        }
        if(e.getSource() == negativeButton){
            double temp = Double.parseDouble(textField.getText());  // get the value of the textField into temp
            temp *= -1;                                             // multiply by -1
            String tempString;
            tempString = formatNumberConvertToString(temp);
            textField.setText(tempString);                // set the value of the textField equal to the result of the multiplication
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static String formatNumberConvertToString(double number){
        if (number == Math.floor(number)){
            return String.valueOf(number).replace(".0", "");
        }
        else {
            return String.valueOf(number);
        }
    }
}
