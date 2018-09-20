package amrita.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;



public class MainActivity extends AppCompatActivity {
    public TextView expression;
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button del;
    private Button plus;
    private Button minus;
    private Button multiply;
    private Button divide;
    private Button equalTo;
    private Button point;
    //private String  ex;
    private StringBuilder exb;
    private  boolean flag=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expression=(TextView) findViewById(R.id.resultEditTextId);
        zero =(Button) findViewById(R.id.zeroButtonId);
        one =(Button) findViewById(R.id.oneButtonId);
        two =(Button) findViewById(R.id.twoButtonId);
        three =(Button) findViewById(R.id.threeButtonId);
        four =(Button) findViewById(R.id.fourButtonId);
        five =(Button) findViewById(R.id.fiveButtonId);
        six =(Button) findViewById(R.id.sixButtonId);
        seven =(Button) findViewById(R.id.sevenButtonId);
        eight =(Button) findViewById(R.id.eightButtonId);
        nine =(Button) findViewById(R.id.nineButtonId);
        point =(Button) findViewById(R.id.pointButtonId);
        equalTo =(Button) findViewById(R.id.equaltoButtonId);
        del =(Button) findViewById(R.id.delButtonId);
        plus =(Button) findViewById(R.id.plusButtonId);
        minus =(Button) findViewById(R.id.minusButtonId);
        multiply =(Button) findViewById(R.id.multiplyButtonId);
        divide =(Button) findViewById(R.id.divideButtonId);
        exb=new StringBuilder();
        //  ex =new String();


        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "0");
                del.setText("DEL");
                flag=false;
                exb.append("0");
            }
        });

        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "1");
                del.setText("DEL");flag=false;
                exb.append("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "2");
                del.setText("DEL");flag=false;
                exb.append("2");

            }
        });

        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "3");
                del.setText("DEL");flag=false;
                flag=false;
                exb.append("3");

            }
        });

        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "4");
                del.setText("DEL");flag=false;
                exb.append("4");

            }
        });

        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "5");
                del.setText("DEL");flag=false;
                exb.append("5");

            }
        });

        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "6");
                del.setText("DEL");flag=false;
                exb.append("6");

            }
        });

        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "7");
                del.setText("DEL");flag=false;
                exb.append("7");

            }
        });

        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "8");
                del.setText("DEL");flag=false;
                exb.append("8");

            }
        });

        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "9");
                del.setText("DEL");flag=false;
                exb.append("9");

            }
        });

        point.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + ".");
                del.setText("DEL");flag=false;
                exb.append(".");

            }
        });

        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "+");
                del.setText("DEL");flag=false;
                exb.append("+");

            }
        });

        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "-");
                del.setText("DEL");flag=false;
                exb.append("-");

            }
        });

        multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "*");
                del.setText("DEL");flag=false;
                exb.append("*");

            }
        });

        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "/");
                del.setText("DEL");flag=false;
                exb.append("/");

            }
        });

        equalTo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String ex=expression.getText().toString();
                Expression exp = new Expression(ex);
                try {
                    if (ex.isEmpty() || ex == null || ex.equals("")) {
                        Toast.makeText(MainActivity.this, "empty expression", Toast.LENGTH_SHORT).show();
                    } else {
                        BigDecimal result = exp.eval();
                        expression.setText(result.toString());
                        del.setText("CLR");
                    }
                }
                catch (Exception e)
                {
                    try {
                        throw  new DivideByZero("can't divide by zero");
                    } catch (DivideByZero divideByZero) {
                        divideByZero.printStackTrace();
                    }
                }


            }
        });



        del.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(del.getText().toString().equals("DEL"))
                {
                    String ex = expression.getText().toString();
                    if (ex.isEmpty() || ex == null || ex.equals("")) {
                        Toast.makeText(MainActivity.this, "empty expression", Toast.LENGTH_SHORT).show();
                    }
                    else {expression.setText(ex.substring(0, ex.length()-1));}


                }

                if(del.getText().toString().equals("CLR"))
                { expression.setText(null);}
            }
        });



    }

    private class DivideByZero extends Throwable {
        public DivideByZero(String s)
        {super("can't divide by zero");
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            expression.setText(null);

        }
    }
}

