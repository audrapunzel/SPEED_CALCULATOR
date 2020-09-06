package th.su.ac.speed_calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText  mete = findViewById(R.id.editTextNumberDecimal);
                EditText time = findViewById(R.id.editTextNumberDecimal2);
                mete.setText("");
                time.setText("");

            }
        });

        Button calculate  = findViewById(R.id.button6);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText  mete = findViewById(R.id.editTextNumberDecimal);
                EditText time = findViewById(R.id.editTextNumberDecimal2);
                String m = mete.getText().toString();
                String t = time.getText().toString();
                if(m.length()==0 && t.length()==0){
                    Toast toast = Toast.makeText(MainActivity.this, R.string.tan,Toast.LENGTH_LONG);
                    toast.show ( );
                }
                else if( m.length()== 0 ){
                    Toast toast = Toast.makeText(MainActivity.this,"Distance are required",Toast.LENGTH_LONG);
                    toast.show ( );

                }
                else if( t.length()== 0 ){
                    Toast toast = Toast.makeText(MainActivity.this,"time are required",Toast.LENGTH_LONG);
                    toast.show ( );

                }
                else{
                    double mete1 = Double.parseDouble(m);
                    double time1 = Double.parseDouble(t);
                    if(time1==00){
                        Toast toast = Toast.makeText(MainActivity.this, R.string.timeno,Toast.LENGTH_LONG);
                        toast.show ( );
                    }
                    else{
                        double time2 = time1/3600;
                        double mete2 = mete1/1000;
                        double cal = mete2/time2;
                        String str = String.format(
                                Locale.getDefault(), "%.2f", cal
                        );
                        TextView res = findViewById(R.id.textView10);
                        res.setText(str);
                        if(cal >80 ) {
                            AlertDialog.Builder di = new AlertDialog.Builder(MainActivity.this);
                            di.setTitle("SPEED CALCULATOR");
                            di.setMessage(R.string.limit);
                            di.show();
                        }



                    }


                }



            }
            }
    );
    }
}